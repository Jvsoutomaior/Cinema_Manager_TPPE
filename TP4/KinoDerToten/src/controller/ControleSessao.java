package controller;

import models.*;

public class ControleSessao {
	private Sessao[] sess;
	private int qtdSessoes;
	
	public ControleSessao(ControleDados d) {
		sess = d.getSessoes();
		qtdSessoes = d.getQtdSessoes();
	}
	
	public String[] getTituloFilmeDaSessao() {
		String[] s = new String[qtdSessoes];
		
		for(int i=0; i<qtdSessoes; i++) {
			s[i] = sess[i].getFilme().getTitulo();
		}
		
		return s;
	} 
	
	public String[] getHorarioSessao() {
		String[] s = new String[qtdSessoes];
		
		for(int i=0; i<qtdSessoes; i++) {
			s[i] = sess[i].getHorario();
		}
		
		return s;
	} 
	
	public String[] getUnidadeSessao() {
		String[] s = new String[qtdSessoes];
		
		for(int i=0; i<qtdSessoes; i++) {
			s[i] = sess[i].getUnidade().getShopping();
		}
		
		return s;
	}
	
	public String[] displaySessaoOnJList() {
		String[] sList = new String[qtdSessoes];
		
		for(int i=0; i<qtdSessoes; i++) {
			sList[i] = getTituloFilmeDaSessao()[i] + " - " + getHorarioSessao()[i] + " - " + getUnidadeSessao()[i];
		}
		
		return sList;
	}
}
