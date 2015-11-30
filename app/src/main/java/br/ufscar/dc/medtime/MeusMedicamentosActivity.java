package br.ufscar.dc.medtime;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.SQLException;
import android.os.Bundle;

import android.app.ListActivity;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import br.ufscar.dc.medtime.Adapter.MedicamentoAdapter;
import br.ufscar.dc.medtime.controle.MedicamentoControle;
import br.ufscar.dc.medtime.model.Medicamento;

public class MeusMedicamentosActivity extends ListActivity {

    private MedicamentoAdapter medicamentoAdapter;
    private Medicamento medicamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_meus_medicamentos);
        MedicamentoControle medicamentoControle = MedicamentoControle.getInstance();

        try {
            medicamentoAdapter = new MedicamentoAdapter(medicamentoControle.findAll(),
                    getLayoutInflater());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        setListAdapter(medicamentoAdapter);
    }

    protected void onListItemClick(ListView um, View v, int position, long id) {
        super.onListItemClick(um, v, position, id);
        // Pega o item naquela posicao
        this.medicamento = (Medicamento) this.medicamentoAdapter.getItem(position);
        Log.i("MEDICAMENTO", medicamento.getNome());
        final EditText edt = new EditText(this);
        edt.setInputType(InputType.TYPE_CLASS_TEXT
                | InputType.TYPE_CLASS_TEXT);
        showInputDialog("Editar:", this, edt,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        MedicamentoControle medControll = MedicamentoControle
                                .getInstance();
                        try {
                            medicamento.setNome(edt.getText().toString());
                            medControll.updatePassword(medicamento);
                            Toast.makeText(getApplicationContext(),
                                    "Alteração realizada com sucesso",
                                    Toast.LENGTH_SHORT).show();
                        } catch (SQLException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        } catch (Exception e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                });
    }

    public static void showInputDialog(String message, final Context context,
        EditText edt, DialogInterface.OnClickListener okClick) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
        alertDialog.setMessage(message);
        alertDialog.setView(edt);
        alertDialog.setPositiveButton("OK", okClick);
        alertDialog.setTitle("Editar Medicamento");
        alertDialog.show();
    }
}
