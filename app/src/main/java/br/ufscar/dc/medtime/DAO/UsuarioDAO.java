package br.ufscar.dc.medtime.DAO;
/**
 * Created by Cristian on 05/11/2015.
 */
import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import br.ufscar.dc.medtime.model.Usuario;

public class UsuarioDAO extends DataBase {

	private final String TABLE = "usuario";

	public UsuarioDAO(Context context) {
		super(context);
	}

	public void insert(Usuario usuario) throws Exception {
		ContentValues values = new ContentValues();
		values.put("nome", usuario.getNome());
		values.put("senha", usuario.getSenha());
		values.put("matricula", usuario.getMatricula());
		values.put("idade", usuario.getIdade());
		values.put("funcao", usuario.getFuncao());		
		values.put("rua", usuario.getRua());
		values.put("bairro", usuario.getBairro());
		values.put("numero", usuario.getNum());
		values.put("cidade", usuario.getCidade());
		values.put("estado", usuario.getEstado());
		values.put("admin", usuario.getAdmin());
		values.put("sexo", usuario.getSexo());
		values.put("senha", usuario.getSenha());
		values.put("numEmergencia", usuario.getNumEmergencia());
		getDatabase().insert(TABLE, null, values);
	}

	public void update(Usuario usuario) throws Exception {
		ContentValues values = new ContentValues();
		values.put("rua", usuario.getRua());
		values.put("bairro", usuario.getBairro());
		values.put("numero", usuario.getNum());
		values.put("cidade", usuario.getCidade());
		values.put("estado", usuario.getEstado());
		values.put("numEmergencia", usuario.getNumEmergencia());
		getDatabase().update(TABLE, values, "matricula = ?",
				new String[] { "" + usuario.getMatricula() });
	}
	//ok
	public Usuario findById(String matricula) {
		String sql = "SELECT * FROM " + TABLE + " WHERE matricula = ?";
		String[] selectionArgs = new String[] { "" + matricula };
		Cursor cursor = getDatabase().rawQuery(sql, selectionArgs);
		cursor.moveToFirst();
		return montaUsuario(cursor);
	}
	//ok
	public ArrayList<Usuario> findAll() throws Exception {
		ArrayList<Usuario> retorno = new ArrayList<Usuario>();
		String sql = "SELECT * FROM " + TABLE;
		Cursor cursor = getDatabase().rawQuery(sql, null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			retorno.add(montaUsuario(cursor));
			cursor.moveToNext();
		}
		return retorno;
	}

	public Usuario montaUsuario(Cursor cursor) {
		if (cursor.getCount() == 0) {
			return null;
		}
		Usuario usuario = new Usuario();
		usuario.setNome(cursor.getString(cursor.getColumnIndex("nome")));
		usuario.setFuncao(cursor.getString(cursor.getColumnIndex("funcao")));
		usuario.setMatricula(cursor.getString(cursor
				.getColumnIndex("matricula")));
		usuario.setIdade(cursor.getInt(cursor.getColumnIndex("idade")));
		usuario.setSexo(cursor.getString(cursor.getColumnIndex("sexo")));
		usuario.setRua(cursor.getString(cursor.getColumnIndex("rua")));
		usuario.setBairro(cursor.getString(cursor.getColumnIndex("bairro")));
		usuario.setNum(cursor.getInt(cursor.getColumnIndex("numero")));
		usuario.setCidade(cursor.getString(cursor.getColumnIndex("cidade")));
		usuario.setEstado(cursor.getString(cursor.getColumnIndex("estado")));
		usuario.setAdmin(cursor.getString(cursor.getColumnIndex("admin")));
		usuario.setSenha(cursor.getString(cursor.getColumnIndex("senha")));
		usuario.setNumEmergencia(cursor.getString(cursor.getColumnIndex("numEmergencia")));
		return usuario;
	}

	public Usuario findByLogin(String matricula, String senha) {
		String sql = "SELECT * FROM " + TABLE
				+ " WHERE matricula = ? AND senha = ?";
		String[] selectionArgs = new String[] { matricula, senha };
		Cursor cursor = getDatabase().rawQuery(sql, selectionArgs);
		cursor.moveToFirst();
		return montaUsuario(cursor);
	}

	public void updatePasswd(Usuario usuario) throws Exception {
		ContentValues values = new ContentValues();

		values.put("senha", usuario.getSenha());

		getDatabase().update(TABLE, values, "matricula = ?",
				new String[] { "" + usuario.getMatricula() });
	}

}
