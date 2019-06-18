package Model;

public class Responsavel {
	private int id;
	private String nome;
	
	
	public Responsavel(String nome) {
		this.nome=nome;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String toString() {
	    return this.nome;
	}
}