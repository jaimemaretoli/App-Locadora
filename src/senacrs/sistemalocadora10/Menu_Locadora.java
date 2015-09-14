package senacrs.sistemalocadora10;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class Menu_Locadora extends ActionBarActivity implements View.OnClickListener{

	private Button btnClientes;
	private Button btnFuncionarios;
	private Button btnFilmes;
	private Button btnLocacao;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_menu_locadora);
		
		btnClientes = (Button)findViewById(R.id.btnClientes);
        btnFuncionarios = (Button)findViewById(R.id.btnFuncionarios);
        btnFilmes = (Button)findViewById(R.id.btnFilmes);
        btnLocacao = (Button)findViewById(R.id.btnLocacao);
        
        btnClientes.setOnClickListener(this);
        btnFilmes.setOnClickListener(this);
		btnFuncionarios.setOnClickListener(this);
		btnLocacao.setOnClickListener(this);
	}
	
	public void onClick(View v){
		if(v == btnClientes){
			Intent it = new Intent(this, Lista_Clientes.class);
			startActivityForResult(it, 0);
		} else if (v == btnFilmes){
			Intent it = new Intent(this, Lista_Filmes.class);
			startActivityForResult(it, 0);
		} else if (v == btnFuncionarios){
			Intent it = new Intent(this, Lista_Funcionarios.class);
			startActivityForResult(it, 0);
		} else if (v == btnLocacao){
			Intent it = new Intent(this, Lista_Locacao_Filme.class);
			startActivityForResult(it, 0);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
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
}
