package br.ufscar.dc.medtime;
/**
 * Created by Joao 12/11/2015
 */

import android.os.Bundle;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AdminMedicamentoActivity extends Activity {


    private ImageView imgAvatar;

    private Button btnCadastrarMedicamento;
    private Button btnMeusMedicamentos;
    private Button btnVoltar;
    private Bundle params;
    private TextView tvNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_medicamento);
        try{
            Intent intent = getIntent();
            params = intent.getExtras();
        }catch (Exception e){
            e.printStackTrace();
        }
        tvNome = (TextView) findViewById(R.id.tvWelcomeMed);
        tvNome.setText("Olá " + params.getString("nome"));
        this.imgAvatar = (ImageView) findViewById(R.id.imageAvatar);
        if (params != null) {
            escolherAvatar(params.getString("sexo"));
        }
        btnCadastrarMedicamento = (Button) findViewById(R.id.btnCadastrarMedicamento);
        btnCadastrarMedicamento.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(AdminMedicamentoActivity.this, CadastrarMedicamentoActivity.class);
                intent.putExtras(params);
                startActivity(intent);
            }
        });

        btnMeusMedicamentos = (Button) findViewById(R.id.btnMeusMedicamentos);
        btnMeusMedicamentos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(AdminMedicamentoActivity.this, MeusMedicamentosActivity.class);
                intent.putExtras(params);
                //intent.putExtra("user_id", params.getString("matricula"));
                startActivity(intent);
            }
        });

        btnVoltar = (Button) findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(AdminMedicamentoActivity.this, AdminSelectActivity.class);
                intent.putExtras(params);
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

    public void escolherAvatar(String sexo) {
        if (sexo.equals("masculino")) {
            imgAvatar.setImageResource(getResources().getIdentifier("masc", "drawable", getPackageName()));
        }
    }



}
