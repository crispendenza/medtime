package br.ufscar.dc.medtime;

import android.app.Activity;
<<<<<<< HEAD
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.File;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.ufscar.dc.medtime.controle.MedicamentoControle;
import br.ufscar.dc.medtime.model.Medicamento;


public class CadastrarMedicamentoActivity extends Activity {
    private Button btnCadastrar;
    private Button btnCancelar;
    private EditText edtNome;
    private EditText edtLab;
    private EditText edtValor;
    private Spinner spnTipo;
    private MedicamentoControle medControle;
    private Medicamento medicamento;
    private AlertDialog.Builder alert;
    private Context context;
    private Bundle params;
    private ImageView ivMedPic;
    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
    private static Uri fileUri;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_medicamento);
        ivMedPic = (ImageView) findViewById(R.id.imageAvatar);
        ivMedPic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                fileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE); // create a file to save the image
                intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri); // set the image file name
                Log.i("fileUri", fileUri.toString());
                // start the image capture Intent
                startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
            }
        });
            context = this;
        try{
            Intent intent = getIntent();
            params = intent.getExtras();
        }catch (Exception e){
            e.printStackTrace();
        }
        btnCadastrar = (Button)findViewById(R.id.btnCadastrarMedicamento);
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    salvar();
                    Toast.makeText(getApplicationContext(), "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(CadastrarMedicamentoActivity.this,AdminMedicamentoActivity.class);
                    intent.putExtras(params);
                    startActivity(intent);

                } catch (SQLException e) {
                    exibeDialogo("Falha no Cadastro Verifique os Campos!");
                    e.printStackTrace();
                } catch (NumberFormatException e){
                    exibeDialogo("Existem campos sem preencher");
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        btnCancelar = (Button)findViewById(R.id.btnVoltarCadastroMed);
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
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
        this.medicamento = new Medicamento();
        carregarDados();
        medicamento.setNome(edtNome.getText().toString());
        medicamento.setLaboratorio(edtLab.getText().toString());
        medicamento.setValor(Float.parseFloat(edtValor.getText().toString()));
        medicamento.setTipo(spnTipo.getSelectedItem().toString());
        Log.i("Dados", "ID: " + medicamento.getId() + "\nNome: " + medicamento.getNome() +"\nLab: " + medicamento.getLaboratorio() + "\nValor: " + medicamento.getValor() + "\nTipo: " + medicamento.getTipo() );

        if(!(medicamento.getLaboratorio().equals("") || medicamento.getNome().equals(""))){
            medControle = MedicamentoControle.getInstance(context);
            medControle.insert(medicamento);
        }else{
            exibeDialogo("Falha no Cadastro. Verifique os Campos!");
        }
    }

    public void carregarDados() {
        Log.i("MEM", "cadastrarMedicamentoActivity.carregarDados()");
        this.edtNome = (EditText) findViewById(R.id.edtNomeMedicamento);
        this.edtLab = (EditText) findViewById(R.id.edtLaboratorioMedicamento);
        this.edtValor = (EditText) findViewById(R.id.edtValorMedicamento);
        this.spnTipo = (Spinner) findViewById(R.id.spnCategoriaMedicamento);
        medicamento.setTipo(spnTipo.getSelectedItem().toString());
    }

    /* Manipulador Camera */

    public static final int MEDIA_TYPE_IMAGE = 1;
    public static final int MEDIA_TYPE_VIDEO = 2;

    /** Create a file Uri for saving an image or video */

    private static Uri getOutputMediaFileUri(int type){
        return Uri.fromFile(getOutputMediaFile(type));
    }

    /** Create a File for saving an image or video */
    private static File getOutputMediaFile(int type){
        // To be safe, you should check that the SDCard is mounted
        // using Environment.getExternalStorageState() before doing this.

        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "medtime");
        // This location works best if you want the created images to be shared
        // between applications and persist after your app has been uninstalled.

        // Create the storage directory if it does not exist
        if (! mediaStorageDir.exists()){
            if (! mediaStorageDir.mkdirs()){
                Log.d("medtime", "Não foi possivel criar diretório");
                return null;
            }
        }

        // Create a media file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File mediaFile;
        if (type == MEDIA_TYPE_IMAGE){
            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                    "IMG_"+ timeStamp + ".jpg");
        } else if(type == MEDIA_TYPE_VIDEO) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                    "VID_"+ timeStamp + ".mp4");
        } else {
            return null;
        }

        return mediaFile;
=======
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;



public class CadastrarMedicamentoActivity extends Activity {
    private Button btnCadastrarMedicamento;
    private EditText edtIdMedicamento;
    private EditText edtNomeMedicamento;
    private EditText edtLaboratorioMedicamento;
    private EditText edtValorMedicamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_medicamento);
>>>>>>> 8c37b46ae70314dbc59ebcac4e41f59542122670
    }

}
