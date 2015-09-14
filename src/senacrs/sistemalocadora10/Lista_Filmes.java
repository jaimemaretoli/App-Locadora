package senacrs.sistemalocadora10;

import android.support.v4.widget.SimpleCursorAdapter.ViewBinder;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Lista_Filmes extends ActionBarActivity implements View.OnClickListener{

	private Button btnAdicionarFilmes; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_lista_filmes);
	
		btnAdicionarFilmes = (Button)findViewById(R.id.btnAdicionarLocacao);
		
		btnAdicionarFilmes.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.lista__filmes, menu);
		return true;
	}
	
	public void onClick(View v){
		if (v == btnAdicionarFilmes){
			Intent it = new Intent(this, Adicionar_Filmes.class);
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
