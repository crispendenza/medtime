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
<<<<<<< HEAD
	private final String TABLE = "medicamento";
=======
	private final String TABLE = "produto";
>>>>>>> 8c37b46ae70314dbc59ebcac4e41f59542122670

	public MedicamentoDAO(Context context) {
		super(context);
	}

<<<<<<< HEAD

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
=======
	public void insert(Medicamento produto) {

		ContentValues values = new ContentValues();
		values.put("nomeProduto", produto.getNomeProduto());
		values.put("valor", produto.getValor());
		values.put("codigoProduto", produto.getCodigoProduto());
		getDatabase().insert(TABLE, null, values);
		Log.i("Valores", values.toString());
		Log.w("Banco Inserido", "DB criado com sucesso!");
	}

	public void update(Medicamento produto) throws Exception {
		ContentValues values = new ContentValues();
		values.put("nomeProduto", produto.getNomeProduto());
		values.put("codigoProduto", produto.getCodigoProduto());
		values.put("valor", produto.getValor());

		getDatabase().update(TABLE, values, "id = ?",
				new String[] { "" + produto.getCodigoProduto() });
	}

>>>>>>> 8c37b46ae70314dbc59ebcac4e41f59542122670
	public ArrayList<Medicamento> findAll() throws Exception {
		ArrayList<Medicamento> retorno = new ArrayList<Medicamento>();
		String sql = "SELECT * FROM " + TABLE;
		Cursor cursor = getDatabase().rawQuery(sql, null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
<<<<<<< HEAD
			retorno.add(montaMedicamento(cursor));
=======
			retorno.add(montaProduto(cursor));
>>>>>>> 8c37b46ae70314dbc59ebcac4e41f59542122670
			cursor.moveToNext();
		}
		return retorno;
	}

<<<<<<< HEAD

	public ArrayList<Integer> find() throws Exception {
		ArrayList<Integer> retorno = new ArrayList<Integer>();
		String sql = "SELECT id FROM " + TABLE;
		Cursor cursor = getDatabase().rawQuery(sql, null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			retorno.add(cursor.getInt(cursor
					.getColumnIndex("id")));
=======
	public Medicamento montaProduto(Cursor cursor) {
		if (cursor.getCount() == 0) {
			return null;
		}
		Medicamento produto = new Medicamento();
		produto.setCodigoProduto(cursor.getString(cursor
				.getColumnIndex("codigoProduto")));
		produto.setNomeProduto(cursor.getString(cursor
				.getColumnIndex("nomeProduto")));
		produto.setValor(cursor.getFloat(cursor.getColumnIndex("valor")));

		return produto;

	}

	public Medicamento findByCodigo(String codigo) {
		String sql = "SELECT * FROM " + TABLE + " WHERE codigoProduto = ?";
		String[] selectionArgs = new String[] { codigo };
		Cursor cursor = getDatabase().rawQuery(sql, selectionArgs);
		cursor.moveToFirst();

		return montaProduto(cursor);
	}
	public ArrayList<String> findCodigo() throws Exception {
		ArrayList<String> retorno = new ArrayList<String>();
		String sql = "SELECT codigoProduto FROM " + TABLE;
		Cursor cursor = getDatabase().rawQuery(sql, null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			retorno.add(cursor.getString(cursor
					.getColumnIndex("codigoProduto")));
>>>>>>> 8c37b46ae70314dbc59ebcac4e41f59542122670
			cursor.moveToNext();
		}
		return retorno;
	}
<<<<<<< HEAD

	public void updatePasswd(Medicamento medicamento) throws Exception {
		ContentValues values = new ContentValues();
		values.put("nome", medicamento.getNome());
		getDatabase().update(TABLE, values, "nome = ?",
				new String[] { "" + medicamento.getNome()});
	}

=======
	
>>>>>>> 8c37b46ae70314dbc59ebcac4e41f59542122670
}
