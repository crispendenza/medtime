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


	public static void setInstance(MedicamentoControle instance) {
		MedicamentoControle.instance = instance;
	}

	public Medicamento getProduto() {
		return produto;
	}

	public void setProduto(Medicamento produto) {
		this.produto = produto;
	}
	

}
