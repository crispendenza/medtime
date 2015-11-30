package br.ufscar.dc.medtime;
/**
 * Created by Cristian on 05/11/2015.
 */
import br.ufscar.dc.medtime.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import br.ufscar.dc.medtime.controle.UsuarioControle;
import br.ufscar.dc.medtime.model.Usuario;

public class CadastroActivity extends Activity {
	private Button btnCadastrar;
	private Button btnCancelar;
	private EditText edtNome;
	private EditText edtMatricula;	
	private EditText edtRua;
	private EditText edtBairro;
	private EditText edtNumero;
	private EditText edtCidade;
	private EditText edtEstado;
	private EditText edtPassword;
	private EditText edtNumEmergencia;
	private RadioGroup edtFuncao;
	private RadioGroup sexo;
	private UsuarioControle userControll;
	private Usuario user;
	private AlertDialog.Builder alert;
	private Context context;
	private Bundle params;



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cadastro);
		context = this;
		Intent intent = getIntent();
		params = intent.getExtras();
		final Boolean novo = Boolean.parseBoolean(intent.getStringExtra("novo"));
		btnCadastrar = (Button)findViewById(R.id.btnCadastrarUusuario);
		        btnCadastrar.setOnClickListener(new View.OnClickListener() {   
			        public void onClick(View v) { 
			        	try {
							salvar();
							Toast.makeText(getApplicationContext(), "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show();
							if (!novo) {
								Intent intent = new Intent(CadastroActivity.this, AdminUserActivity.class);
								intent.putExtras(params);
								startActivity(intent);
							}
							else {
								Intent intent = new Intent(CadastroActivity.this, AdminSelectActivity.class);
								Bundle params_ = new Bundle();
								params_.putString("matricula", user.getMatricula());
								params_.putString("nome", user.getNome());
								params_.putString("sexo", user.getSexo());
								intent.putExtras(params_);
								startActivity(intent);
							}
							
						} catch (SQLException e) {
							exibeDialogo("Falha no Cadastro Verifique os Campos!"); 
							e.printStackTrace();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			        }
			    }); 

		        btnCancelar = (Button)findViewById(R.id.btnCancelar);
		        btnCancelar.setOnClickListener(new View.OnClickListener() {   
			        public void onClick(View v) { finish(); }});
		        

	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cadastro, menu);
		return true;
	}
	 public void exibeDialogo(String mensagem) {  
		    alert = new AlertDialog.Builder(context);  
		    alert.setPositiveButton("OK", null);  
		    alert.setMessage(mensagem);  
		    alert.create().show();  

	 }
	public void salvar() throws Exception{
		this.user = new Usuario();
		carregarDados();
		user.setMatricula(edtMatricula.getText().toString());
		user.setNome(edtNome.getText().toString());
		//user.setFuncao(edtFuncao.getContext().toString());
		user.setRua(edtRua.getText().toString());
		user.setBairro(edtBairro.getText().toString());
		user.setNum(Integer.parseInt(edtNumero.getText().toString()));
		user.setCidade(edtCidade.getText().toString());
		user.setEstado(edtEstado.getText().toString());
		user.setSenha(edtPassword.getText().toString());
		user.setNumEmergencia(edtNumEmergencia.getText().toString());
		Log.i("Dados", user.getNome()+"\nMatricula: "+user.getMatricula()+"\nFuncao: "+user.getFuncao()+"\nRua: "+user.getRua()+"\nBairro: "+user.getBairro()+"\nCidade: "+user.getCidade()+"\nEstado: "+user.getEstado()+"\nNumero: "+user.getNum()+"\nSexo: "+user.getSexo()+"\nAdmin?: "+user.getAdmin()+"\nSenha: "+user.getSenha()+"\nNum emergencia"+user.getNumEmergencia());
		if(!user.equals(null)){
				userControll = UsuarioControle.getInstance(context);
				userControll.insert(user);		
		}else{
			exibeDialogo("Falha no Cadastro Verifique os Campos!"); 
		}
	}
	
	/* carrega dados digitados pelo usuario na activity_cadastro.xml na memoria */	
	public void carregarDados(){
		Log.i("CarregaDados", "Carregando Dados");
		this.edtMatricula = (EditText) findViewById(R.id.edtMatricula);
		this.edtNome = (EditText) findViewById(R.id.edtNome);
/*				this.edtFuncao = (RadioGroup) findViewById(R.id.radioFuncao);
		switch (edtFuncao.getCheckedRadioButtonId()){
		case R.id.radioMedico:
			user.setFuncao("Medico");
			break;
		case R.id.radioPaciente:
			user.setFuncao("Paciente");
			break;
		}*/
		
		this.sexo = (RadioGroup) findViewById(R.id.radioSex);
		switch (sexo.getCheckedRadioButtonId()) {
	    case R.id.radioFem:
	        user.setSexo("feminino");
	        break;
	    case R.id.radioMasc:
	    	 user.setSexo("masculino");
	    	 Log.i("Entrou", user.getSexo());
	        break;
		}
		
		this.edtRua = (EditText) findViewById(R.id.edtRua);
		this.edtBairro = (EditText) findViewById(R.id.edtBairro);
		this.edtCidade = (EditText) findViewById(R.id.edtCidade);
		this.edtEstado = (EditText) findViewById(R.id.edtEstado);
		this.edtNumero = (EditText) findViewById(R.id.edtNum);		
		this.edtPassword = (EditText) findViewById(R.id.edtPassword);
		this.edtNumEmergencia = (EditText) findViewById(R.id.edtNumEmergencia);
		this.user.setAdmin("true");
		this.user.setFuncao("Paciente");

	}

}
