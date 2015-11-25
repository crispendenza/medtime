package br.ufscar.dc.medtime;
/**
 * Created by Cristian on 05/11/2015.
 */
import android.os.Bundle;

import br.ufscar.dc.medtime.R;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AdminActivity extends Activity {
	  
     
    private ImageView imgAvatar;
    private Button btnCadastrarUsuario;
    private Button btnSair;
    private Button btnPerfil;
    private Bundle  params;
    private Button btnCadastrarProduto;
    private Button btnListarUsuario;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_admin);
		Intent intent = getIntent();
		params = intent.getExtras();
		this.imgAvatar = (ImageView) findViewById(R.id.imageAvatar);
		if(params!=null){
			escolherAvatar(params.getString("sexo"));
		}	
		
		btnCadastrarUsuario = (Button) findViewById(R.id.btnCadastroUsuario);
	    btnCadastrarUsuario.setOnClickListener(new View.OnClickListener() {   
	        public void onClick(View v) { 
	        	Intent intent = new Intent(AdminActivity.this,CadastroActivity.class);
				startActivity(intent);
	        }
	    }); 
	    btnListarUsuario= (Button) findViewById(R.id.btnListarUsuario);
	    btnListarUsuario.setOnClickListener(new View.OnClickListener() {   
	        public void onClick(View v) { 
	        	Intent intent = new Intent(AdminActivity.this, ListUsuarioActivity.class);
				startActivity(intent);
	        }
	    });
	    
	    btnCadastrarProduto= (Button) findViewById(R.id.btnCadastroProduto);
		 btnCadastrarProduto.setOnClickListener(new View.OnClickListener() {   
		        public void onClick(View v) { 
		        	Intent intent = new Intent(AdminActivity.this,ProdutosActivity.class);
					startActivity(intent);
		        }
		    });
	

	    btnPerfil = (Button)findViewById(R.id.btnPerfilAdmin);
		btnPerfil.setOnClickListener(new View.OnClickListener() {   
	        public void onClick(View v) { 
	        		Intent intent = new Intent(AdminActivity.this,PerfilActivity.class);
    				intent.putExtras(retornarParametros());
    				startActivity(intent);
    				

	        }
	    });
		btnSair = (Button) findViewById(R.id.btnSair);
	    btnSair.setOnClickListener(new View.OnClickListener() {   
	        public void onClick(View v) { 
	        	Intent intent = new Intent(AdminActivity.this,MainActivity.class);
				startActivity(intent);
	        }
	    });

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.admin, menu);
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
