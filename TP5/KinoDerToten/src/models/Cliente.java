package models;

/**
 * A Classe <b>CLiente</b> é uma classe que herda de <b>Pessoa</b>
 * @author Yago Milagres Passos
 * @since out 2021
 * @version 1.0
 */
public class Cliente extends Pessoa  {
	private int fidelidade;

	/**
	 * Construtor da classe Cliente
	 * @param n -> nome
	 * @param c -> cpf
	 * @param i -> Data de Nascimento
	 * @param u -> unidade
	 * @param e -> email
	 * @param f -> fidelidade
	 */
	public Cliente(String n, String c, String i, Unidade u, String e, int f){
		nome = n;
		cpf = c;
		dataNasc = i;
		unidade = u;
		email = e;
		fidelidade = f;
	}
	
	public String toString() {
		return nome;
	}
	
	/**
	 * metodo de acesso
	 * @return fidelidade
	 */
	public int getFidelidade() {
		return fidelidade;
	}
	/**
	 * metodo de acesso
	 * @param fidelidade -> fidelidade
	 */
	public void setFidelidade(int fidelidade) {
		this.fidelidade = fidelidade;
	}
	
	/**
	 * O método <b>retornaMensalidade</b> caiu em desuso com a atualização do diagrama de classes
	 * @deprecated
	 * @param c -> cliente
	 * @return custo
	 */
	public String retornaMensalidade(Cliente c) {
		String custo="";
			
		int i = c.getFidelidade();
		
		if(i==0) {
			custo = "60.00";
		}
		
		return custo;
	}
}