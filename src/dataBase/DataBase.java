package dataBase;

import android.content.Context;
import android.database.sqlite.*;

public class DataBase extends SQLiteOpenHelper{

	public DataBase(Context context){
		
		super(context, "AGENDA", null, 1);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db){
		
		db.execSQL(ScriptSQL.getCreateCliente());
	}
	
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
		
		
	}
}