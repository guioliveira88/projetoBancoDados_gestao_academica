package GestaoAcademica;

public abstract class Pessoa {

	protected String nome;
	private String cpf;
	private int idade;
	
	public Pessoa() {
		
	}

	public Pessoa(String nome) {
	this.nome = nome;	
	}
	public Pessoa(String nome,String cpf,int idade) {
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
	
		
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	@Override
	public String toString() {
		return "nome=" + nome + ", cpf=" + cpf + ", idade=" + idade ;
	}

	public void Cadastrar() {
		// TODO Auto-generated method stub
		
	}
	 
}
