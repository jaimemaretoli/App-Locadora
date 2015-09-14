package senacrs.sistemalocadora10;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Lista_Funcionarios extends ActionBarActivity implements View.OnClickListener{

	private Button btnAdicionarFuncionario;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_lista_funcionarios);
		
		btnAdicionarFuncionario = (Button)findViewById(R.id.btnAdicionarLocacao);
		
		btnAdicionarFuncionario.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.lista__funcionarios, menu);
		return true;
	}

	public void onClick(View v){
		if (v == btnAdicionarFuncionario){
			Intent it = new Intent(this, Adicionar_Funcionarios.class);
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
}
