package models;

public class Unidade {
	protected String regiao;
	protected String endereco;
	protected String shopping;
	
	
	Unidade(String r, String e, String s){
		regiao = r;
		endereco = e;
		shopping = s;
	}
	
	public String toString() {
		return shopping;
	}
	
	
	public String getRegiao() {
		return regiao;
	}
	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getShopping() {
		return shopping;
	}
	public void setShopping(String shopping) {
		this.shopping = shopping;
	}
	
	
}