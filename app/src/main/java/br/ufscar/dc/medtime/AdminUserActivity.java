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

public class AdminUserActivity extends Activity {


    private ImageView imgAvatar;
    private Button btnCadastrarUsuario;
    private Button btnVoltar;
    private Bundle params;
    private Button btnListarUsuario;
    private TextView tvNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_user);
        Intent intent = getIntent();
        params = intent.getExtras();
        tvNome = (TextView) findViewById(R.id.tvWelcomeGerenciar);
        tvNome.setText("Olá " + params.getString("nome"));

        this.imgAvatar = (ImageView) findViewById(R.id.imageAvatar);
        if (params != null) {
            escolherAvatar(params.getString("sexo"));
        }

        btnCadastrarUsuario = (Button) findViewById(R.id.btnCadastroUsuario);
        btnCadastrarUsuario.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(AdminUserActivity.this, CadastroActivity.class);
                intent.putExtras(params);
                startActivity(intent);
            }
        });
        btnListarUsuario = (Button) findViewById(R.id.btnListarUsuario);
        btnListarUsuario.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(AdminUserActivity.this, ListUsuarioActivity.class);
                startActivity(intent);

            }
        });

        btnVoltar = (Button) findViewById(R.id.btnSair);
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
