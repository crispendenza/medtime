package br.ufscar.dc.medtime;
/**
 * Created by Cristian on 05/11/2015.
 */
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.database.SQLException;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import br.ufscar.dc.medtime.Adapter.UsuarioAdapter;
import br.ufscar.dc.medtime.controle.UsuarioControle;
import br.ufscar.dc.medtime.model.Usuario;

public class ListUsuarioActivity extends ListActivity {
	private UsuarioAdapter usuarioAdapter;
	private Usuario user;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		UsuarioControle controller = UsuarioControle.getInstance();

		try {
			usuarioAdapter = new UsuarioAdapter(controller.findAll(),
					getLayoutInflater());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setListAdapter(usuarioAdapter);

	}

	protected void onListItemClick(ListView um, View v, int position, long id) {
		super.onListItemClick(um, v, position, id);
		// Pega o item naquela posicao
		this.user = (Usuario) this.usuarioAdapter.getItem(position);
		Log.i("PDM mudança senha", user.getMatricula());
		final EditText edt = new EditText(this);
		edt.setInputType(InputType.TYPE_CLASS_TEXT
				| InputType.TYPE_TEXT_VARIATION_PASSWORD);
		showInputDialog("Digite a nova senha:", this, edt,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						UsuarioControle userControll = UsuarioControle
								.getInstance();
						try {
							user.setSenha(edt.getText().toString());
							userControll.updatePassword(user);
							Toast.makeText(getApplicationContext(),
									"Alteração realizada com sucesso",
									Toast.LENGTH_SHORT).show();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
	}

	public static void showInputDialog(String message, final Context context,
			EditText edt, OnClickListener okClick) {
		AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
		alertDialog.setMessage(message);
		alertDialog.setView(edt);
		alertDialog.setPositiveButton("Ok", okClick);
		alertDialog.setTitle("Editar senha");
		alertDialog.show();
	}

}
