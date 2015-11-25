package br.ufscar.dc.medtime.Adapter;
/**
 * Created by Cristian on 05/11/2015.
 */
import java.util.ArrayList;

import br.ufscar.dc.medtime.R;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import br.ufscar.dc.medtime.model.Usuario;

public class UsuarioAdapter extends BaseAdapter {
	private ArrayList<Usuario> usuarios;
	private LayoutInflater inflater;

	public UsuarioAdapter(ArrayList<Usuario> usuarios, LayoutInflater inflater) {
		this.usuarios = usuarios;
		this.inflater = inflater;

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return usuarios.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return usuarios.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		Usuario user = usuarios.get(arg0);
		View v = inflater.inflate(R.layout.my_layout, null);
		
		TextView nomeProd = (TextView) v.findViewById(R.id.nomeUsuario);
		TextView descProd = (TextView) v.findViewById(R.id.matriculaUsuario);
		ImageView image = (ImageView) v.findViewById(R.id.imageAvatarUsuario);
		nomeProd.setText(user.getNome());
		descProd.setText(user.getMatricula());
		if (user.getSexo().equals("masculino")) {
			image.setImageResource(R.drawable.masc);
		}
		return v;
	}

}
