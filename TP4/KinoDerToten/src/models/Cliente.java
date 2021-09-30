package models;

public class Cliente extends Pessoa  {
	private int fidelidade;

	Cliente(String n, String c, int i, Unidade u, String e, int f){
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
	
	public int getFidelidade() {
		return fidelidade;
	}
	public void setFidelidade(int fidelidade) {
		this.fidelidade = fidelidade;
	}
	
	
	public String retornaMensalidade(Cliente c) {
		String custo="";
			
		int i = c.getFidelidade();
		
		if(i==0) {
			custo = "60.00";
		}
		
		return custo;
	}
}