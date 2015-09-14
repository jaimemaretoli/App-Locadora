package senacrs.sistemalocadora10;

import android.R.transition;
import android.support.v4.widget.SimpleCursorAdapter.ViewBinder;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Lista_Locacao_Filme extends ActionBarActivity implements View.OnClickListener{

	private Button btnAdicionarLocacao;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_lista_locacao_filme);
		
		btnAdicionarLocacao = (Button)findViewById(R.id.btnAdicionarLocacao);
		
		btnAdicionarLocacao.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.lista__locacao__filme, menu);
		return true;
	}

	public void onClick(View v){
		if (v == btnAdicionarLocacao){
			Intent it = new Intent(this, Adicionar_Locacao.class);
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
