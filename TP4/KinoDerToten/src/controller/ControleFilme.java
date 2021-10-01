package controller;

import models.*;

public class ControleFilme {
	private Filme[] f;
	private int qtdFilmes;
	
	
	public ControleFilme(ControleDados d) {
		f = d.getFilmes();
		qtdFilmes = d.getQtdFilmes();
		
	}

	public String[] getTituloFilme() {
		String[] s = new String[qtdFilmes];
		for(int i=0; i<qtdFilmes; i++) {
			s[i] = f[i].getTitulo();
		}
		
		return s;
	} 
}
 