package br.ufscar.dc.medtime;

import android.app.Activity;
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
    }

}
