package pacote;

public class Cliente extends Pessoa  {
	private Fidelidade fidelidade;

	Cliente(String n, String c, int i, Unidade u, String e, Fidelidade f){
		nome = n;
		cpf = c;
		idade = i;
		unidade = u;
		email = e;
		fidelidade = f;
	}
	
	public String toString() {
		return nome;
	}
	
	public Fidelidade getFidelidade() {
		return fidelidade;
	}
	public void setFidelidade(Fidelidade fidelidade) {
		this.fidelidade = fidelidade;
	}
	

}