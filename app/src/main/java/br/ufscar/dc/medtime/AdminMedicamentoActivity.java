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

public class AdminMedicamentoActivity extends Activity {


    private ImageView imgAvatar;
    private Button btnGerenciarAlarme;
    private Button btnCadastrarMedicamento;
    private Button btnVoltar;
    private Button btnGerenciarMedicamento;
    private Bundle params;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_medicamento);
        Intent intent = getIntent();
        params = intent.getExtras();
        this.imgAvatar = (ImageView) findViewById(R.id.imageAvatar);
        if (params != null) {
            escolherAvatar(params.getString("sexo"));
        }
        btnCadastrarMedicamento = (Button) findViewById(R.id.btnCadastrarMedicamento);
        btnCadastrarMedicamento.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(AdminMedicamentoActivity.this, CadastrarMedicamentoActivity.class);
                startActivity(intent);
            }
        });


        btnGerenciarAlarme = (Button) findViewById(R.id.btnGerenciarAlarme);
        btnGerenciarAlarme.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(AdminMedicamentoActivity.this, AdminSelectActivity.class);
                startActivity(intent);
            }
        });


        btnVoltar = (Button) findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
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
