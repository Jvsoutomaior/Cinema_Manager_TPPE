package controller;

import models.*;

public class ControleDados {
	private Dados d = new Dados();
	
	
	
	public ControleDados() {
		d.preencheDataBase();
	}
	
	public Dados getDados() {
		return d;
	}
	
	public void setDados(Dados d) {
		this.d = d;
	}
	
	public Filme[] getFilmes() {
		return this.d.getFilmes();
	}
	
	public int getQtdFilmes() {
		return this.d.getQtdFilmes();
	}
	
	
	public boolean inserirEditarFilme(String[] dadoNovo) {
		//if(!dadosFilmes[3].matches("[0-9]+") || !dadosFilmes[4].matches("[0-9]+") || 
				//!dadosFilmes[5].matches("[0-9]+") || !dadosProfs[6].matches("[0-9]+")) {
		//	return false;
	//	} else {
				Filme f = new Filme(dadoNovo[1], dadoNovo[2], Integer.parseInt(dadoNovo[3]), dadoNovo[4], Integer.parseInt(dadoNovo[5]), dadoNovo[6]);
				d.inserirEditarFilme(f, Integer.parseInt(dadoNovo[0]));
				return true;
		//}
	}

	public boolean removerFilme(int pos) {
		int i;
		int qtd = d.getQtdFilmes();
		
		for (i = pos; i<qtd-1; i++) {
			d.getFilmes()[i] = d.getFilmes()[i+1];
		}
		d.setQtdFilmes(qtd-1);
		
		return true;
	}
}
