package models;

/**
 * A Classe <b>Pessoa</b> é uma classe abstrata para criar outras classes de <i>models</i> no projeto
 * @author Yago Milagres Passos
 * @since out 2021
 * @version 1.0
 */
public abstract class Pessoa {
	protected String nome;
	protected String cpf;
	protected String dataNasc;
	protected Unidade unidade; // Unidade em que a pessoa foi cadastrada
	protected String email;
	
	/**
	 * metodo de acesso
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * metodo de acesso
	 * @param nome -> nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * metodo de acesso
	 * @return cpf
	 */
	public String getCpf() {
		return cpf;
	}
	/**
	 * metodo de acesso
	 * @param cpf -> cpf
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	/**
	 * metodo de acesso
	 * @return dataNasc
	 */
	public String getDataNasc() {
		return dataNasc;
	}
	/**
	 * metodo de acesso
	 * @param dataNasc -> dataNasc
	 */
	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}
	/**
	 * metodo de acesso
	 * @return unidade
	 */
	public Unidade getUnidade() {
		return unidade;
	}
	/**
	 * metodo de acesso
	 * @param unidade -> unidade
	 */
	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}
	/**
	 * metodo de acesso
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * metodo de acesso
	 * @param email -> email
	 */
	public void setEmail(String email) {
		this.email = email;
	}





}