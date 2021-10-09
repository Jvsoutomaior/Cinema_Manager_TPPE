package models;

/**
 * <b>Funcionário</b> é uma das duas classes que herdam de <b>Pessoa</b>
 * @author Yago Milagres Passos
 *
 */
public class Funcionario extends Pessoa {
	protected String turno;
	protected String salario;
	
	/**
	 * Construtor de Funcionário
	 * @param n -> nome
	 * @param c -> cpf
	 * @param i -> data de nascimento
	 * @param u -> unidade
	 * @param e -> email
	 * @param t -> turno
	 * @param s -> salario
	 */
	public Funcionario(String n, String c, String i, Unidade u, String e, String t, String s){
		nome = n;
		cpf = c;
		dataNasc = i;
		unidade = u;
		email = e;
		turno = t;
		salario = s;
	}
	
	/**
	 * metodo de acesso
	 * @return turno
	 */
	public String getTurno() {
		return turno;
	}
	/**
	 * metodo de acesso
	 * @param turno -> turno
	 */
	public void setTurno(String turno) {
		this.turno = turno;
	}
	/**
	 * metodo de acesso
	 * @return salario
	 */
	public String getSalario() {
		return salario;
	}
	/**
	 * metodo de acesso
	 * @param salario -> salario
	 */
	public void setSalario(String salario) {
		this.salario = salario;
	}
	
	
}
