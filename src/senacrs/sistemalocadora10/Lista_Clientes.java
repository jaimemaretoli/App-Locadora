package senacrs.sistemalocadora10;

import dataBase.DataBase;
import dominio.Entidade_Clientes;
import dominio.Repositorio_Clientes;
import android.support.v4.widget.SimpleCursorAdapter.ViewBinder;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.*;
import android.widget.*;


public class Lista_Clientes extends ActionBarActivity implements View.OnClickListener {

	private DataBase dataBase;
	private SQLiteDatabase conn;
	private Repositorio_Clientes repositorioClientes;
	private Button btnAdicionarCliente;
	private EditText edtCliente;
	private ListView lstClientes;
	private ArrayAdapter<Entidade_Clientes> adpClientes;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_lista_clientes);
		
		btnAdicionarCliente = (Button)findViewById(R.id.btnAdicionarClientes);
		edtCliente = (EditText)findViewById(R.id.edtCliente);
		lstClientes = (ListView)findViewById(R.id.lstClientes);
		
		btnAdicionarCliente.setOnClickListener(this);
		
		try{
			dataBase = new DataBase(this); //Crio os parametros
			conn = dataBase.getReadableDatabase(); //Cria e le o Banco
			
			repositorioClientes = new Repositorio_Clientes(conn);
			
			adpClientes = repositorioClientes.buscaClientes(this);
			lstClientes.setAdapter(adpClientes);
			
			FiltraDados filtraDados = new FiltraDados(adpClientes);
			edtCliente.addTextChangedListener(filtraDados);
			
		} catch (SQLException ex){
			AlertDialog.Builder dlg = new AlertDialog.Builder(this);
			dlg.setMessage("Erro ao criar o banco: " + ex.getMessage());
			dlg.setNeutralButton("OK", null);
			dlg.show();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.lista__clientes, menu);
		return true;
	}

	 public void onClick(View v){
		
		 System.out.println("Entro 2");
		 
		 adpClientes = repositorioClientes.buscaClientes(this);
		 lstClientes.setAdapter(adpClientes);
		 
		 if (v == btnAdicionarCliente){
			Intent it = new Intent(this, Adicionar_Clientes.class);
			startActivityForResult(it, 0);	
		}
	}
	 
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
		}
	
	public class FiltraDados implements TextWatcher{
		
		private ArrayAdapter<Entidade_Clientes> arrayAdapter;
		
		private FiltraDados (ArrayAdapter<Entidade_Clientes> arrayAdapter){
			this.arrayAdapter = arrayAdapter;
		}
		
		@Override
		public void afterTextChanged(Editable arg0) {
		}
		
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			arrayAdapter.getFilter().filter(s);	
		}
		
		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {	
		}
	}
	
}

	
	