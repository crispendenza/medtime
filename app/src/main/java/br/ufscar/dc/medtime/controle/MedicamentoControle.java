package br.ufscar.dc.medtime.controle;
/**
 * Created by Cristian on 05/11/2015.
 */
import java.util.ArrayList;

import android.content.Context;
import android.util.Log;
import br.ufscar.dc.medtime.DAO.MedicamentoDAO;
import br.ufscar.dc.medtime.model.Medicamento;

public class MedicamentoControle {
<<<<<<< HEAD
	private static MedicamentoDAO medicamentoDAO;
	private static MedicamentoControle instance;
	private Medicamento medicamento;
	
	public static MedicamentoControle getInstance(Context context) {
		if (instance == null) {
			instance = new MedicamentoControle();
			medicamentoDAO = new MedicamentoDAO(context);
		}
		return instance;
	}

	public void insert(Medicamento medicamento) throws Exception {
		Log.i("PDMInsert","Inserindo medicamento");
		medicamentoDAO.insert(medicamento);
	}

	public void update(Medicamento medicamento) throws Exception {
		medicamentoDAO.update(medicamento);
	}

	public void findByid(int id) throws Exception {
		this.medicamento = medicamentoDAO.findById(id);
	}

	public ArrayList<Integer> find() throws Exception {
		return medicamentoDAO.find();
	}

	public ArrayList<Medicamento> findAll() throws Exception {
		return medicamentoDAO.findAll();
	}

	public static MedicamentoDAO getMedicamentoDAO() {
		return medicamentoDAO;
	}

	public static void setMedicamentoDAO(MedicamentoDAO medicamentoDAO) {
		MedicamentoControle.medicamentoDAO = medicamentoDAO;
	}

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	public static MedicamentoControle getInstance() {
		return instance;
	}
=======
	private static MedicamentoDAO produtoDAO;
	private static MedicamentoControle instance;
	private Medicamento produto;
	
	private MedicamentoControle(){
	}

	public static MedicamentoControle getInstance(Context context) {
		if (instance == null) {
			instance = new MedicamentoControle();
			produtoDAO = new MedicamentoDAO(context);
			Log.d("PDM", "produtoDAO (createInstance):" + produtoDAO);
		}
		Log.d("PDM", "produtoDAO:" + produtoDAO);
		return instance;
	}

	public void insert(Medicamento produto) throws Exception {
		produtoDAO.insert(produto);

	}

	public void update(Medicamento produto) throws Exception {
		produtoDAO.update(produto);
	}

	public void findByid(String id) throws Exception {
		this.produto = produtoDAO.findByCodigo(id);
	}
	public ArrayList<String> find() throws Exception {
		return produtoDAO.findCodigo();
	}

	public ArrayList<Medicamento> findAll() throws Exception {
		return produtoDAO.findAll();
	}

	public static MedicamentoDAO getProdutoDAO() {
		return produtoDAO;
	}

	public static void setProdutoDAO(MedicamentoDAO produtoDAO) {
		MedicamentoControle.produtoDAO = produtoDAO;
	}

>>>>>>> 8c37b46ae70314dbc59ebcac4e41f59542122670

	public static void setInstance(MedicamentoControle instance) {
		MedicamentoControle.instance = instance;
	}

<<<<<<< HEAD
	public void updatePassword(Medicamento medicamento) throws Exception {
		medicamentoDAO.updatePasswd(medicamento);

	}
=======
	public Medicamento getProduto() {
		return produto;
	}

	public void setProduto(Medicamento produto) {
		this.produto = produto;
	}
	

>>>>>>> 8c37b46ae70314dbc59ebcac4e41f59542122670
}
