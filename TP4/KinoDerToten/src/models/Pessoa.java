package models;

public abstract class Pessoa {
	protected String nome;
	protected String cpf;
	protected String dataNasc;
	protected Unidade unidade; // Unidade em que a pessoa foi cadastrada
	protected String email;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getDataNasc() {
		return getDataNasc();
	}
	public void setDataNasc(String dataNasc) {
		this.dataNasc = getDataNasc();
	}
	public Unidade getUnidade() {
		return unidade;
	}
	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}





}