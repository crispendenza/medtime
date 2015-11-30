package br.ufscar.dc.medtime;
/**
 * Created by Joao on 12/11/2015.
 */

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
<<<<<<< HEAD
import android.util.Log;
=======
>>>>>>> 8c37b46ae70314dbc59ebcac4e41f59542122670
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
<<<<<<< HEAD
import android.widget.TextView;

public class AdminSelectActivity extends Activity {
=======

public class AdminSelectActivity extends Activity {


>>>>>>> 8c37b46ae70314dbc59ebcac4e41f59542122670
    private ImageView imgAvatar;
    private Button btnGerenciarUsuario;
    private Button btnSair;
    private Button btnPerfil;
    private Bundle params;
    private Button btnGerenciarMedicamento;
<<<<<<< HEAD
    private TextView tvNome;
=======
>>>>>>> 8c37b46ae70314dbc59ebcac4e41f59542122670

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_select);
        Intent intent = getIntent();
        params = intent.getExtras();
        this.imgAvatar = (ImageView) findViewById(R.id.imageAvatar);
<<<<<<< HEAD
        tvNome = (TextView) findViewById(R.id.tvWelcomeSelect);
        tvNome.setText("Olá " + params.getString("nome"));
        if (params != null) {
            escolherAvatar(params.getString("sexo"));
        }
        Log.i("PARAMS", params.getString("sexo"));
        Log.i("PARAMS", params.getString("nome"));
        Log.i("PARAMS", params.getString("matricula"));

=======
        if (params != null) {
            escolherAvatar(params.getString("sexo"));
        }
>>>>>>> 8c37b46ae70314dbc59ebcac4e41f59542122670

        btnGerenciarUsuario = (Button) findViewById(R.id.btnGerenciarUsuario);
        btnGerenciarUsuario.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(AdminSelectActivity.this, AdminUserActivity.class);
<<<<<<< HEAD
                intent.putExtras(params);
=======
>>>>>>> 8c37b46ae70314dbc59ebcac4e41f59542122670
                startActivity(intent);
            }
        });
        btnGerenciarMedicamento = (Button) findViewById(R.id.btnGerenciarMedicamento);
        btnGerenciarMedicamento.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(AdminSelectActivity.this, AdminMedicamentoActivity.class);
<<<<<<< HEAD
                intent.putExtras(params);
=======
>>>>>>> 8c37b46ae70314dbc59ebcac4e41f59542122670
                startActivity(intent);
            }
        });

        btnPerfil = (Button) findViewById(R.id.btnPerfilAdmin);
        btnPerfil.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(AdminSelectActivity.this, PerfilActivity.class);
<<<<<<< HEAD
                intent.putExtras(params);
                startActivity(intent);
=======
                intent.putExtras(retornarParametros());
                startActivity(intent);


>>>>>>> 8c37b46ae70314dbc59ebcac4e41f59542122670
            }
        });
        btnSair = (Button) findViewById(R.id.btnSair);
        btnSair.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
<<<<<<< HEAD
                Intent intent = new Intent(AdminSelectActivity.this, MainActivity.class);
                startActivity(intent);
=======
                finish();
>>>>>>> 8c37b46ae70314dbc59ebcac4e41f59542122670
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
<<<<<<< HEAD
=======

    public Bundle retornarParametros() {
        Bundle params1 = new Bundle();
        params1.putString("matricula", params.getString("matricula"));
        params1.putString("nome", params.getString("nome"));
        return params1;
    }


>>>>>>> 8c37b46ae70314dbc59ebcac4e41f59542122670
}
