package br.ufscar.dc.medtime;
/**
 * Created by Cristian on 05/11/2015.
 */

import br.ufscar.dc.medtime.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import br.ufscar.dc.medtime.controle.UsuarioControle;
import br.ufscar.dc.medtime.model.Usuario;
import br.ufscar.dc.medtime.DAO.UsuarioDAO;

public class MainActivity extends Activity {

    private EditText editMatricula, editSenha;
    private Button btnLogin;
    private Button btnEmergency;
    private Context context;
    private UsuarioControle usuarioController;
    private AlertDialog.Builder alert;
    private Usuario usuario = new Usuario();
    private boolean adm;
    private AlertDialog alerta;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().getDecorView().setBackgroundColor(Color.WHITE);
        context = this;
        usuarioController = UsuarioControle.getInstance(context);
        Log.i("PDMController", usuarioController.toString());
        editMatricula = (EditText) findViewById(R.id.edtLogin);
        editSenha = (EditText) findViewById(R.id.edtPasswd);

        try {
            testaInicializacao();

        } catch (Exception e) {
            exibeDialogo("Erro inicializando banco de dados" + e);
            e.printStackTrace();
        }
        btnLogin = (Button) findViewById(R.id.btnLogar);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (validar()) {
                    Log.i("Passou aqui", "Chegou a activity" + adm);
                    if (adm) {
                        Intent intent = new Intent(MainActivity.this,
                                br.ufscar.dc.medtime.AdminSelectActivity.class);
                        intent.putExtras(retornarParametros());
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(MainActivity.this,
                                br.ufscar.dc.medtime.AdminSelectActivity.class);
                        intent.putExtras(retornarParametros());
                        startActivity(intent);
                    }

                }
            }
        });

        btnEmergency = (Button) findViewById(R.id.btnEmergenciaHome);
        btnEmergency.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    emergencyCall();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    private void emergencyCall() throws Exception {
        //Lista de itens
        ArrayList<String> itens = new ArrayList<String>();
        final ArrayList<Usuario> usuariosAtivos = usuarioController.findAll();

        //adiciona no array
        for (Usuario u : usuariosAtivos){
            itens.add(u.getNome());
        }

        //adapter utilizando um layout customizado (TextView)
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.emergency_call, itens);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Você é:");
        //define o diálogo como uma lista, passa o adapter.
        builder.setSingleChoiceItems(adapter, 0, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                //Toast.makeText(MainActivity.this, "posição selecionada=" + arg1, Toast.LENGTH_SHORT).show();
                //Toast.makeText(MainActivity.this, "Ligando para " + usuariosAtivos.get(arg1).getNumEmergencia(), Toast.LENGTH_SHORT).show();
                alerta.dismiss();
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + usuariosAtivos.get(arg1).getNumEmergencia()));
                startActivity(intent);
            }
        });

        alerta = builder.create(); alerta.show();
    }






    /**
     * @throws Exception
     */
    public void testaInicializacao() throws Exception {
        if (usuarioController.findAll().isEmpty()) {
            Log.i("PDMInicializa", usuarioController.findAll().toString());

            usuario.setMatricula("admin");
            usuario.setNome("Cristian Pendenza");
            usuario.setSenha("123");
            usuario.setFuncao("Paciente");
            usuario.setRua("Padre Faustino");
            usuario.setIdade(18);
            usuario.setBairro("Jardim Bandeirantes");
            usuario.setCidade("São Carlos");
            usuario.setNum(90);
            usuario.setEstado("SP");
            usuario.setAdmin("true");
            usuario.setSexo("masculino");
            usuario.setNumEmergencia("14981268600");
            usuarioController.insert(usuario);
            Log.i("PDM", "matricula usuario" + usuario.getMatricula());
        }
    }

    /**
     *
     */
    public void exibeDialogo(String mensagem) {
        alert = new AlertDialog.Builder(context);
        alert.setPositiveButton("OK", null);
        alert.setMessage(mensagem);
        alert.create().show();
    }

    public Boolean validar() {
        String usuario = editMatricula.getText().toString();
        String senha = editSenha.getText().toString();

        try {
            boolean isValid = usuarioController.validaLogin(usuario, senha);
            this.adm = usuarioController.validaAdm();

            if (isValid) {
                Toast.makeText(getApplicationContext(), "Usuario e senha validados com sucesso!", Toast.LENGTH_SHORT).show();
                return true;
            } else {
                exibeDialogo("Verifique usuario e senha!");
                return false;
            }
        } catch (Exception e) {
            exibeDialogo("Erro validando usuario e senha");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public Bundle retornarParametros() {
        Bundle params = new Bundle();
        params.putString("matricula", usuarioController.getUser().getMatricula());
        params.putString("nome", usuarioController.getUser().getNome());
        params.putString("sexo", usuarioController.getUser().getSexo());
        return params;
    }

}
