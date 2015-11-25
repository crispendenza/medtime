package br.ufscar.dc.medtime;
/**
 * Created by Cristian on 05/11/2015.
 */
import br.ufscar.dc.medtime.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class UsuarioActivity extends Activity {  
    private ImageView imgAvatar;
    private TextView nome;
    private Button btnPerfil;
    private Bundle params;    
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_usuario);
		Intent intent = getIntent();
		params = intent.getExtras();
		this.imgAvatar = (ImageView) findViewById(R.id.imageViewAvatar);
		this.nome = (TextView) findViewById(R.id.textViewNome);
		if(params!=null){
			nome.setText(params.getString("nome"));
			escolherAvatar(params.getString("sexo"));
		}	
		btnPerfil = (Button)findViewById(R.id.btnMeuPerfil);
		btnPerfil.setOnClickListener(new View.OnClickListener() {   
	        public void onClick(View v) { 
	        		Intent intent = new Intent(UsuarioActivity.this,PerfilActivity.class);
    				intent.putExtras(retornarParametros());
    				startActivity(intent);
    				

	        }
	    }); 
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.usuario, menu);
		return true;
	}
	public void escolherAvatar(String sexo){
		if(sexo.equals("masculino")){
			imgAvatar.setImageResource(getResources().getIdentifier("masc", "drawable", getPackageName()));
		}
	}  
	public Bundle retornarParametros(){
    	Bundle params1 = new Bundle();
		params1.putString("matricula", params.getString("matricula"));
		params1.putString("nome", params.getString("nome"));
		return params1;
    }

}
