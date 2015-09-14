package dominio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.*;
import android.widget.ArrayAdapter;

public class Repositorio_Clientes {

	private SQLiteDatabase conn;
	
	public Repositorio_Clientes (SQLiteDatabase conn) {
		
		this.conn = conn;
		
	}
	
	public void inserir (Entidade_Clientes clientes) {
		
		System.out.println("ENTRO05");
		
		String consulta ="INSERT INTO CLIENTES (NOME, EMAIL, TELEFONE, DATA_NASCIMENTO, OBS) VALUES ('" + clientes.getNome() + "', "
				+ "' " + clientes.getEmail() + " ', ' " + clientes.getTelefone() + " ', ' " + clientes.getData_nascimento() + " ', "
				+ " ' " + clientes.getObs() + " ');" ;
		
		System.out.println(consulta);
		
		conn.execSQL(consulta);
	}
	
	public void testeInserirContatos(){
		
		for(int i = 0; i < 10; i++){
			
			ContentValues values = new ContentValues();
			
			values.put("TELEFONE", i + "0000000");
			
			conn.insertOrThrow("CONTATO", null, values);
		}
		
	}
	
	public ArrayAdapter<Entidade_Clientes> buscaClientes(Context context){
		
		ArrayAdapter<Entidade_Clientes> adpClientes = new ArrayAdapter<Entidade_Clientes>(context, android.R.layout.simple_list_item_1);

		Cursor cursor = conn.query("CLIENTES", null, null, null, null, null, null);

		if (cursor.moveToFirst()){
			cursor.moveToFirst();
			
			do {
				
				Entidade_Clientes clientes = new Entidade_Clientes();
				
				clientes.setId_cliente(cursor.getLong(cursor.getColumnIndex(Entidade_Clientes.ID_CLIENTE)));
				clientes.setNome(cursor.getString(cursor.getColumnIndex(Entidade_Clientes.NOME)));
				clientes.setEmail(cursor.getString(cursor.getColumnIndex(Entidade_Clientes.EMAIL)));
				clientes.setTelefone(cursor.getString(cursor.getColumnIndex(Entidade_Clientes.TELEFONE)));
				clientes.setData_nascimento(cursor.getString(cursor.getColumnIndex(Entidade_Clientes.DATA_NASCIMENTO)));
				clientes.setObs(cursor.getString(cursor.getColumnIndex(Entidade_Clientes.OBS)));
				
				adpClientes.add(clientes);
				
			} while (cursor.moveToNext());	
		}
		

		return adpClientes;
	}
	
}