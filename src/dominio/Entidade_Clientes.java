package dominio;

public class Entidade_Clientes {

	public static String ID_CLIENTE = "ID_CLIENTE";
	public static String NOME = "NOME";
	public static String EMAIL = "EMAIL";
	public static String TELEFONE = "TELEFONE";
	public static String DATA_NASCIMENTO = "DATA_NASCIMENTO";
	public static String OBS = "OBS";
	
	private long id_cliente;
	private String nome;
	private String email;
	private String telefone;
	private String data_nascimento;
	private String obs;
	
	// Construtor
	public Entidade_Clientes(){
		
	}
	
	public long getId_cliente() {return id_cliente;}
	public void setId_cliente(long id_cliente) {this.id_cliente = id_cliente;}
	
	public String getNome() {return nome;}
	public void setNome (String nome) {this.nome = nome;}
	
	public String getEmail() {return email;}
	public void setEmail (String email) {this.email = email;}
	
	public String getTelefone() {return telefone;}
	public void setTelefone (String telefone) {this.telefone = telefone;}
	
	public String getData_nascimento() {return data_nascimento;}
	public void setData_nascimento (String data_nascimento) {this.data_nascimento = data_nascimento;}
	
	public String getObs() {return obs;}
	public void setObs (String obs) {this.obs = obs;}
	
	@Override
	public String toString(){
		
		return nome + " - " + telefone;
	}
	
}
