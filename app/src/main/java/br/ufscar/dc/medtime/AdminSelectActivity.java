package br.ufscar.dc.medtime;
/**
 * Created by Joao on 12/11/2015.
 */

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AdminSelectActivity extends Activity {


    private ImageView imgAvatar;
    private Button btnGerenciarUsuario;
    private Button btnSair;
    private Button btnPerfil;
    private Bundle params;
    private Button btnGerenciarMedicamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_select);
        Intent intent = getIntent();
        params = intent.getExtras();
        this.imgAvatar = (ImageView) findViewById(R.id.imageAvatar);
        if (params != null) {
            escolherAvatar(params.getString("sexo"));
        }

        btnGerenciarUsuario = (Button) findViewById(R.id.btnGerenciarUsuario);
        btnGerenciarUsuario.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(AdminSelectActivity.this, AdminUserActivity.class);
                startActivity(intent);
            }
        });
        btnGerenciarMedicamento = (Button) findViewById(R.id.btnGerenciarMedicamento);
        btnGerenciarMedicamento.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(AdminSelectActivity.this, AdminMedicamentoActivity.class);
                startActivity(intent);
            }
        });

        btnPerfil = (Button) findViewById(R.id.btnPerfilAdmin);
        btnPerfil.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(AdminSelectActivity.this, PerfilActivity.class);
                intent.putExtras(retornarParametros());
                startActivity(intent);


            }
        });
        btnSair = (Button) findViewById(R.id.btnSair);
        btnSair.setOnClickListener(new View.OnClickListener() {
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

    public Bundle retornarParametros() {
        Bundle params1 = new Bundle();
        params1.putString("matricula", params.getString("matricula"));
        params1.putString("nome", params.getString("nome"));
        return params1;
    }


}
