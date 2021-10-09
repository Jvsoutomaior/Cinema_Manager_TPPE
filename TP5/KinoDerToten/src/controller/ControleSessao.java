package controller;

import models.*;

/**
 * Classe <b>ControleSessao</b>.
 * @author Yago Milagres Passos
 *
 */
public class ControleSessao {
	private Sessao[] sess;
	private int qtdSessoes;
	
	/**
	 * Construtor da Classe <b>ControleSessao</b>.
	 * @param d -> instancia de ControleDados
	 */
	public ControleSessao(ControleDados d) {
		sess = d.getSessoes();
		qtdSessoes = d.getQtdSessoes();
	}
	
	/**
	 * O m�todo <b>TituloFilmeDaSessao</b> preenche um array de String com os t�tulos dos filmes selecionados em todas Sess�es cadastradas.
	 * Ele serve para preencher o array de String do m�todo <b>displaySessaoOnJlist</b> da classe <b>ControleSessao</b>
	 * @return array de string
	 */
	public String[] getTituloFilmeDaSessao() {
		String[] s = new String[qtdSessoes];
		
		for(int i=0; i<qtdSessoes; i++) {
			s[i] = sess[i].getFilme().getTitulo();
		}
		
		return s;
	} 
	
	/**
	 * O m�todo <b>TituloHorarioSessao</b> preenche um array de String com os horarios de todas Sess�es cadastradas.
	 * Ele serve para preencher o array de String do m�todo <b>displaySessaoOnJlist</b> da classe <b>ControleSessao</b>
	 * @return array de string
	 */
	public String[] getHorarioSessao() {
		String[] s = new String[qtdSessoes];
		
		for(int i=0; i<qtdSessoes; i++) {
			s[i] = sess[i].getHorario();
		}
		
		return s;
	} 
	
	/**
	 * O m�todo <b>TituloUnidadeSessao</b> preenche um array de String com o shopping das unidades de todas Sess�es cadastradas.
	 * Ele serve para preencher o array de String do m�todo <b>displaySessaoOnJlist</b> da classe <b>ControleSessao</b>
	 * @return array de string
	 */
	public String[] getUnidadeSessao() {
		String[] s = new String[qtdSessoes];
		
		for(int i=0; i<qtdSessoes; i++) {
			s[i] = sess[i].getUnidade().getShopping();
		}
		
		return s;
	}
	
	/**
	 * O m�todo <b>displaySessaoOnJList</b> junta as Strings dos m�todos <b>getTituloFilmeDaSessao</b>, <b>getHorarioSessao</b> e <b>getUnidadeSessao</b> e os junta
	 * em um novvo array para preencher Uma JList na Classe <b>TelaSessao</b> 
	 * @return array de strings
	 */
	public String[] displaySessaoOnJList() {
		String[] sList = new String[qtdSessoes];
		
		for(int i=0; i<qtdSessoes; i++) {
			sList[i] = getTituloFilmeDaSessao()[i] + " - " + getHorarioSessao()[i] + " - " + getUnidadeSessao()[i];
		}
		
		return sList;
	}
}
