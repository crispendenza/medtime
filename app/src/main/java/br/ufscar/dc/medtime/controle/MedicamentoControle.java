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

	public static void setInstance(MedicamentoControle instance) {
		MedicamentoControle.instance = instance;
	}

	public void updatePassword(Medicamento medicamento) throws Exception {
		medicamentoDAO.updatePasswd(medicamento);

	}
}
