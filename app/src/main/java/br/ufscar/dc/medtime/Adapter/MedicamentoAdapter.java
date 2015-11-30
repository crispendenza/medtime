package br.ufscar.dc.medtime.Adapter;
/**
 * Created by Cristian on 05/11/2015.
 */

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import br.ufscar.dc.medtime.R;
import br.ufscar.dc.medtime.model.Medicamento;
import br.ufscar.dc.medtime.model.Usuario;

public class MedicamentoAdapter extends BaseAdapter {
	private ArrayList<Medicamento> medicamentos;
	private LayoutInflater inflater;

	public MedicamentoAdapter(ArrayList<Medicamento> medicamentos, LayoutInflater inflater) {
		this.medicamentos = medicamentos;
		this.inflater = inflater;

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return medicamentos.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return medicamentos.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		Medicamento medicamento = medicamentos.get(arg0);
		View v = inflater.inflate(R.layout.activity_meus_medicamentos, null);

		TextView nomeMed = (TextView) v.findViewById(R.id.tvNomeMedListar);
		TextView labMed = (TextView) v.findViewById(R.id.tvLabMedListar);
		ImageView image = (ImageView) v.findViewById(R.id.imageMed);
		nomeMed.setText(medicamento.getNome());
		labMed.setText(medicamento.getLaboratorio());
		/*if (medicamento.getSexo().equals("masculino")) {
			image.setImageResource(R.drawable.masc);
		}*/
		return v;
	}

}
