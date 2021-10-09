package models;

/**
 * Classe <b>Unidade</b> é a mais presente em atributos de outras classes.
 * @author Yago Milagres Passos
 *
 */
public class Unidade {
	protected String regiao;
	protected String endereco;
	protected String shopping;
	
	/**
	 * Construtor da classe <b>Unidade</b>
	 * @param r -> regiao
	 * @param e -> endereco
	 * @param s -> shopping
	 */
	public Unidade(String r, String e, String s){
		regiao = r;
		endereco = e;
		shopping = s;
	}
	
	public String toString() {
		return shopping;
	}
	
	/**
	 * metodo de acesso
	 * @return regiao
	 */
	public String getRegiao() {
		return regiao;
	}
	/**
	 * metodo de acesso
	 * @param regiao ->regiao
	 */
	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}
	/**
	 * metodo de acesso
	 * @return endereco
	 */
	public String getEndereco() {
		return endereco;
	}
	/**
	 * metodo de acesso
	 * @param endereco -> endereco
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	/**
	 * metodo de acesso
	 * @return shopping
	 */
	public String getShopping() {
		return shopping;
	}
	/**
	 * metodo de acesso
	 * @param shopping -> shopping
	 */
	public void setShopping(String shopping) {
		this.shopping = shopping;
	}
	
	
}