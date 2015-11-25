package br.ufscar.dc.medtime.controle;
/**
 * Created by Cristian on 05/11/2015.
 */
import java.util.ArrayList;

import android.content.Context;
import android.util.Log;
import br.ufscar.dc.medtime.DAO.UsuarioDAO;
import br.ufscar.dc.medtime.model.Usuario;

public class UsuarioControle {
	private static UsuarioDAO usuarioDAO;
	private static UsuarioControle instance;
	private Usuario user;

	public static UsuarioControle getInstance(Context context) {
		if (instance == null) {
			instance = new UsuarioControle();
			usuarioDAO = new UsuarioDAO(context);
		}
		return instance;
	}

	public void insert(Usuario usuario) throws Exception {
		Log.i("PDMInsert","Inserindo usuario");
		//Log.i("Dados", usuario.toString());
		
		usuarioDAO.insert(usuario);
		
	}

	public void update(Usuario usuario) throws Exception {
		usuarioDAO.update(usuario);
	}

	public void findByid(String matricula) throws Exception {
		this.user = usuarioDAO.findById(matricula);
	}

	public ArrayList<Usuario> findAll() throws Exception {
		return usuarioDAO.findAll();
		
	}

	public boolean validaLogin(String matricula, String senha) throws Exception {

		this.user = usuarioDAO.findByLogin(matricula, senha);
		Log.i("Valida", "Estou testando");
		if (user == null || user.getMatricula() == null
				|| user.getSenha() == null) {
			return false;
		}
		String informado = matricula + senha;
		String esperado = user.getMatricula() + user.getSenha();
		if (informado.equals(esperado)) {
			return true;
		}
		return false;

	}

	public Usuario getUser() {
		return user;
	}

	public static UsuarioControle getInstance() {
		return instance;
	}

	public static void setInstance(UsuarioControle instance) {
		UsuarioControle.instance = instance;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public boolean validaAdm() {
		Log.i("Admin", user.getAdmin());
		if (this.user.getAdmin().equals("true")) {
			return true;
		}
		return false;
	}

	public void updatePassword(Usuario usuario) throws Exception {
		usuarioDAO.updatePasswd(usuario);

	}

}
