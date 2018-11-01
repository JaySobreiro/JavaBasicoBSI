
public class Contato {

	private int id;
	private String nome;
	private String fone;
	private String email;
	
	public Contato() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString() {
		
		return  "\nID: " + this.id  + "\nNome: " + this.nome + 
				"\nFone: " + this.fone + "\nE-mail: " + this.email;
	}

}





