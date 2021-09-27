package pacote;

public class Funcionario extends Pessoa {
	protected String turno;
	protected String salario;
	
	Funcionario(String n, String c, int i, Unidade u, String e, String t, String s){
		nome = n;
		cpf = c;
		idade = i;
		unidade = u;
		email = e;
		turno = t;
		salario = s;
	}
	
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	public String getSalario() {
		return salario;
	}
	public void setSalario(String salario) {
		this.salario = salario;
	}
	
	
}
