package controller;

import models.*;

public class ControleUnidade {
	private Unidade[] u;
	private int qtdUnidades;
	
	
	public ControleUnidade(ControleDados d) {
		u = d.getUnidades();
		qtdUnidades = d.getQtdUnidades();
		
	}

	public String[] getShoppingUnidade() {
		String[] s = new String[qtdUnidades];
		for(int i=0; i<qtdUnidades; i++) {
			s[i] = u[i].getShopping();
		}
		
		return s;
	} 
}
