package br.ufscar.dc.medtime.DAO;
/**
 * Created by Cristian on 05/11/2015.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataBase extends SQLiteOpenHelper {
	private final static int VERSAO = 1;
	private final static String NOME = "medTimev1";
	private static final String CREATE = "CREATE TABLE usuario (matricula varchar(6) PRIMARY KEY UNIQUE, nome VARCHAR( 45 ), senha varchar (12), idade integer, funcao varchar (20), rua varchar (20), bairro varchar (20), numero integer, cidade varchar (30), estado varchar(20), admin varchar (5), sexo varchar (10));";
	private static final String MEDICAMENTO = "CREATE TABLE produto (codigoProduto varchar(6) PRIMARY KEY , nomeProduto VARCHAR( 45 ), valor real, quantidate integer);";
	
	protected SQLiteDatabase database;

	public DataBase(Context context) {
		super(context, NOME, null, VERSAO);

		/* zera o banco de dados medtime  */
		context.deleteDatabase(NOME);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		
		db.execSQL(CREATE);
		db.execSQL(MEDICAMENTO);		

		Log.d("PDM", "CREATED!");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		onCreate(db);
	}

	public SQLiteDatabase getDatabase() {
		if (database == null) {
			database = getWritableDatabase();
			Log.i("", database.toString());
		}
		return database;
	}


}
