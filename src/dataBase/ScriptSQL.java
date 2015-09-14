package dataBase;

public class ScriptSQL {

	public static String getCreateCliente(){
		
		StringBuilder sqlBulder = new StringBuilder(); //Facilita a junção
		sqlBulder.append("CREATE TABLE IF NOT EXISTS CLIENTES ( ");
		sqlBulder.append("ID_CLIENTE INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, ");
		sqlBulder.append("NOME VARCHAR(200), ");
		sqlBulder.append("EMAIL VARCHAR(255), ");
		sqlBulder.append("TELEFONE VARCHAR(14), ");
		sqlBulder.append("DATA_NASCIMENTO VARCHAR(15), ");
		sqlBulder.append("OBS VARCHAR(55) );");
		
		return sqlBulder.toString();
	}
}
