package senacrs.sistemalocadora10;

import java.security.PublicKey;

import dataBase.DataBase;
import dominio.Entidade_Clientes;
import dominio.Repositorio_Clientes;
import dominio.Repositorio_Clientes;
import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.*;
import android.widget.Button;
import android.widget.EditText;

public class Adicionar_Clientes extends ActionBarActivity implements View.OnClickListener {

	private Button btnAdicionar;
	private EditText edtCodigo;
	private EditText edtNome;
	private EditText edtEmail;
	private EditText edtTelefone;
	private EditText edtData;
	private EditText edtObs;
	
	// Criando as referencias a base de dados
	private DataBase DataBase;
	private SQLiteDatabase conn;
	private Repositorio_Clientes Repositorio_Clientes;
	private Entidade_Clientes Entidade_Clientes;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_adicionar_clientes);
		
		btnAdicionar = (Button)findViewById(R.id.btnAdicionar);
		edtCodigo = (EditText)findViewById(R.id.edtCodigo);
		edtNome = (EditText)findViewById(R.id.edtNome);
		edtEmail = (EditText)findViewById(R.id.edtEmail);
		edtTelefone = (EditText)findViewById(R.id.edtTelefone);
		edtData = (EditText)findViewById(R.id.edtData);
		edtObs = (EditText)findViewById(R.id.edtObs);
		
		btnAdicionar.setOnClickListener(this);
		
		// Criando parametro para testar a conexao
		 try {
			DataBase = new DataBase(this);
			conn = DataBase.getWritableDatabase();

			Repositorio_Clientes = new Repositorio_Clientes(conn);
		 } catch (SQLException ex) {
			AlertDialog.Builder dlg = new AlertDialog.Builder(this);
			dlg.setMessage("Erro ao conectar com o BD! " + ex.getMessage());
			dlg.setNeutralButton("OK", null);
			dlg.show();
		} 
	}
	
	public void inserir(){
		try{
			Entidade_Clientes = new Entidade_Clientes();
			// RECUPERA OS VALORES DOS CAMPOS
			Entidade_Clientes.setNome(edtNome.getText().toString());
			Entidade_Clientes.setEmail(edtEmail.getText().toString());
			Entidade_Clientes.setTelefone(edtTelefone.getText().toString());
			Entidade_Clientes.setData_nascimento(edtData.getText().toString());
			Entidade_Clientes.setObs(edtObs.getText().toString());
			
			Repositorio_Clientes.inserir(Entidade_Clientes);
			
		}catch(Exception ex){
			AlertDialog.Builder dlg = new AlertDialog.Builder(this);
			dlg.setMessage("Erro ao inserir no BD! " + ex.getMessage());
			dlg.setNeutralButton("OK", null);
			dlg.show();
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.adicionar__clientes, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		
		inserir();
		
		AlertDialog.Builder dlg = new AlertDialog.Builder(this);
		dlg.setMessage("INSERIU");
		dlg.setNeutralButton("OK", null);
		dlg.show();
		finish();
		
	}
}
