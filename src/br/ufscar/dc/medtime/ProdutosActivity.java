package br.ufscar.dc.medtime;
/**
 * Created by Cristian on 05/11/2015.
 */
import br.ufscar.dc.medtime.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import br.ufscar.dc.medtime.controle.MedicamentoControle;
import br.ufscar.dc.medtime.model.Medicamento;

public class ProdutosActivity extends Activity {
	private Button btnCadastrar;
	private AlertDialog.Builder alert;
	private Context context;
	private Medicamento produto;
	private EditText edtnome;
	private EditText edtcodigo;
	private EditText edtvalor;
	private MedicamentoControle produtoControll;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_produtos);
		context = this;
		btnCadastrar = (Button)findViewById(R.id.btnCadastrarProduto);
        btnCadastrar.setOnClickListener(new View.OnClickListener() {   
	        public void onClick(View v) { 
	        	try {
	        		
					salvar();
					Log.i("teste", "Testando o produto");
					Toast.makeText(getApplicationContext(), "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show();
					Intent intent = new Intent(ProdutosActivity.this,AdminActivity.class);
    				startActivity(intent);
					
				} catch (Exception e) {
					Toast.makeText(getApplicationContext(), "Verifique os campos!", Toast.LENGTH_SHORT).show(); 
					e.printStackTrace();
				}
	        }
	    });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.produtos, menu);
		return true;
	}
	 public void exibeDialogo(String mensagem) {  
		    alert = new AlertDialog.Builder(context);  
		    alert.setPositiveButton("OK", null);  
		    alert.setMessage(mensagem);  
		    alert.create().show();  
	 }
	 public void salvar() throws Exception{
			this.produto = new Medicamento();
			carregarDados();
			produto.setNomeProduto(edtnome.getText().toString());
			produto.setCodigoProduto(edtcodigo.getText().toString());
			produto.setValor(Float.parseFloat(edtvalor.getText().toString()));
			if(!produto.equals(null)){
				produtoControll = MedicamentoControle.getInstance(context);
				produtoControll.insert(produto);	
			}else{
				Toast.makeText(getApplicationContext(), "Verifique os campos!", Toast.LENGTH_SHORT).show(); 
			}
		}
	 public void carregarDados(){
		
			this.edtnome = (EditText) findViewById(R.id.edtNomeProduto);
			this.edtcodigo = (EditText) findViewById(R.id.edtCodigo);
			this.edtvalor = (EditText) findViewById(R.id.edtValor);
			Log.i("CarregaDados", edtnome.getText().toString());
		}

}
