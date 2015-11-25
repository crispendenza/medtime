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
	private final String TABLE = "produto";

	public MedicamentoDAO(Context context) {
		super(context);
	}

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

	public ArrayList<Medicamento> findAll() throws Exception {
		ArrayList<Medicamento> retorno = new ArrayList<Medicamento>();
		String sql = "SELECT * FROM " + TABLE;
		Cursor cursor = getDatabase().rawQuery(sql, null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			retorno.add(montaProduto(cursor));
			cursor.moveToNext();
		}
		return retorno;
	}

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
			cursor.moveToNext();
		}
		return retorno;
	}
	
}
