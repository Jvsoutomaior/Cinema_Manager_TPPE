package controller;

import models.*;

/**
 * Classe <b>ControleFilme</b>
 * @author Yago Milagres Passos
 *
 */
public class ControleFilme {
	private Filme[] f;
	private int qtdFilmes;
	
	/**
	 * Construtor da classe <b>ControleFIlme</b>
	 * @param d -> instancia de ControleDados
	 */
	public ControleFilme(ControleDados d) {
		f = d.getFilmes();
		qtdFilmes = d.getQtdFilmes();
		
	}

	/**
	 * O método <b>getTituloFilme</b> preenche um array de String com todos os títulos de filmes cadastrados no sistema. Serve pra preencher a JList na classe <b>TelaFilme</b>
	 * @return array de string
	 */
	public String[] getTituloFilme() {
		String[] s = new String[qtdFilmes];
		for(int i=0; i<qtdFilmes; i++) {
			s[i] = f[i].getTitulo();
		}
		
		return s;
	} 
	

	
}
 