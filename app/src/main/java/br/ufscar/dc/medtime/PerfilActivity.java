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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import br.ufscar.dc.medtime.controle.UsuarioControle;
import br.ufscar.dc.medtime.model.Usuario;

public class PerfilActivity extends Activity {
	private Button btnAlterar;
	private Button btnVoltar;
	private TextView tvNome;
	private TextView tvFuncao;
	private TextView tvMatricula;
	private EditText edtRua;
	private EditText edtBairro;
	private EditText edtNumero;
	private EditText edtCidade;
	private EditText edtEstado;
	private EditText edtNumEmergencia;
	private UsuarioControle userControl;
	private ImageView img;
	private String matricula;
	private Context context;
	private AlertDialog.Builder alert;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_perfil);
		this.context = this;
		userControl = UsuarioControle.getInstance(context);
		Intent intent = getIntent();
		Bundle params = intent.getExtras();
		try {
			preencher(params.getString("matricula"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btnAlterar = (Button) findViewById(R.id.btnAlterar);
		btnAlterar.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				try {
					alterar();
					Toast.makeText(getApplicationContext(), "Cadastro Alterado com sucesso!", Toast.LENGTH_SHORT).show();
					preencher(matricula);
				} catch (SQLException e) {
					Log.i("PDM", "teste" + e);
					Toast.makeText(getBaseContext(), "Verifique os campos" + e, Toast.LENGTH_SHORT).show();
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnVoltar = (Button) findViewById(R.id.btnVoltarPerfil);
		btnVoltar.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) { finish(); }});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.perfil, menu);
		return true;
	}

	private void preencher(String matricula) throws Exception {
		inicializar();
		userControl.findByid(matricula);
		Usuario user = userControl.getUser();
		Log.i("PDM", user.getNome() + user.getMatricula() + user.getNum());
		this.matricula = user.getMatricula();
		tvNome.setText(user.getNome());
		tvMatricula.setText(user.getMatricula());
		tvFuncao.setText(user.getFuncao());
		edtRua.setText(user.getRua());
		edtBairro.setText(user.getBairro());
		edtCidade.setText(user.getCidade());
		edtEstado.setText(user.getEstado());
		edtNumero.setText(user.getNum().toString());
		edtNumEmergencia.setText(user.getNumEmergencia());
		escolherAvatar(user.getSexo());

	}

	private void inicializar() {
		this.tvNome = (TextView) findViewById(R.id.tVNome);
		this.tvMatricula = (TextView) findViewById(R.id.tvMatricula);
		this.tvFuncao = (TextView) findViewById(R.id.tvFuncao);
		this.edtRua = (EditText) findViewById(R.id.edtRuaAlterar);
		this.edtBairro = (EditText) findViewById(R.id.edtBairroAlterar);
		this.edtCidade = (EditText) findViewById(R.id.edtCidadeAlterar);
		this.edtEstado = (EditText) findViewById(R.id.edtEstadoAlterar);
		this.edtNumero = (EditText) findViewById(R.id.edtNumeroAlterar);
		this.edtNumEmergencia = (EditText) findViewById(R.id.edtNumEmergenciaAlterar);
		this.img = (ImageView) findViewById(R.id.imageAvatar);

	}

	public void escolherAvatar(String sexo) {
		if (sexo.equals("masculino")) {
			img.setImageResource(getResources().getIdentifier("masc",
					"drawable", getPackageName()));
		}
	}

	public void alterar() throws Exception {
		Usuario usuario = new Usuario();
		inicializar();
		usuario.setMatricula(tvMatricula.getText().toString());
		usuario.setNome(tvNome.getText().toString());
		usuario.setFuncao(tvFuncao.getText().toString());
		usuario.setRua(edtRua.getText().toString());
		usuario.setBairro(edtBairro.getText().toString());
		usuario.setNum(Integer.parseInt(edtNumero.getText().toString()));
		usuario.setCidade(edtCidade.getText().toString());
		usuario.setEstado(edtEstado.getText().toString());
		usuario.setNumEmergencia(edtNumEmergencia.getText().toString());

		if (!usuario.equals(null)) {
			userControl.update(usuario);
			this.matricula = usuario.getMatricula();
		}
	}
}
