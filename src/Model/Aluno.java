package Model;

public class Aluno {
	private String cpf;
	private String nome;
	private Responsavel responsavel;
	
	
	
	public Aluno(String cpf, String nome, Responsavel responsavel) {
		
		this.cpf = cpf;
		this.nome = nome;
		this.responsavel = responsavel;
		
		
	}


	public String getCpf() {
		return cpf;
	}


	public String getNome() {
		return nome;
	}


	public Responsavel getResponsavel() {
		return responsavel;
	}


	
	
	public String toString() {
    return this.nome;
	}
	
}
