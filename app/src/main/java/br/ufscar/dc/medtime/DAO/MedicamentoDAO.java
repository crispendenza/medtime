package br.ufscar.dc.medtime.DAO;
/**
 * Created by Cristian on 05/11/2015.
 */
import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import br.ufscar.dc.medtime.model.Medicamento;

public class MedicamentoDAO extends DataBase {
	private final String TABLE = "medicamento";

	public MedicamentoDAO(Context context) {
		super(context);
	}


	public void insert(Medicamento medicamento) throws Exception{
		ContentValues values = new ContentValues();
		values.put("nome", medicamento.getNome());
		//values.put("user_id", usuario.get)
		values.put("laboratorio", medicamento.getLaboratorio());
		values.put("valor", medicamento.getValor());
		values.put("tipo", medicamento.getTipo());
		getDatabase().insert(TABLE, null, values);
		Log.i("Valores", values.toString());
	}

	public void update(Medicamento medicamento) throws Exception {
		ContentValues values = new ContentValues();

		values.put("nome", medicamento.getNome());
		values.put("laboratorio", medicamento.getLaboratorio());
		values.put("valor", medicamento.getValor());
		values.put("tipo", medicamento.getTipo());
		getDatabase().update(TABLE, values, "id = ?",
				new String[]{"" + medicamento.getId()});
	}

	public Medicamento montaMedicamento(Cursor cursor) {
		if (cursor.getCount() == 0) {
			return null;
		}
		Medicamento medicamento = new Medicamento();
		medicamento.setId(cursor.getInt(cursor
				.getColumnIndex("id")));
		medicamento.setNome(cursor.getString(cursor
				.getColumnIndex("nome")));
		medicamento.setLaboratorio(cursor.getString(cursor
				.getColumnIndex("laboratorio")));
		medicamento.setValor(cursor.getFloat(cursor.getColumnIndex("valor")));
		medicamento.setTipo(cursor.getString(cursor
				.getColumnIndex("tipo")));
		return medicamento;
	}
	//ok
	public Medicamento findById(int id) {
		String sql = "SELECT * FROM " + TABLE + " WHERE id = ?";
		String[] selectionArgs = new String[] { Integer.toString(id) };
		Cursor cursor = getDatabase().rawQuery(sql, selectionArgs);
		cursor.moveToFirst();
		return montaMedicamento(cursor);
	}
	//ok
	public ArrayList<Medicamento> findAll() throws Exception {
		ArrayList<Medicamento> retorno = new ArrayList<Medicamento>();
		String sql = "SELECT * FROM " + TABLE;
		Cursor cursor = getDatabase().rawQuery(sql, null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			retorno.add(montaMedicamento(cursor));
			cursor.moveToNext();
		}
		return retorno;
	}


	public ArrayList<Integer> find() throws Exception {
		ArrayList<Integer> retorno = new ArrayList<Integer>();
		String sql = "SELECT id FROM " + TABLE;
		Cursor cursor = getDatabase().rawQuery(sql, null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			retorno.add(cursor.getInt(cursor
					.getColumnIndex("id")));
			cursor.moveToNext();
		}
		return retorno;
	}

	public void updatePasswd(Medicamento medicamento) throws Exception {
		ContentValues values = new ContentValues();
		values.put("nome", medicamento.getNome());
		getDatabase().update(TABLE, values, "nome = ?",
				new String[] { "" + medicamento.getNome()});
	}

}
