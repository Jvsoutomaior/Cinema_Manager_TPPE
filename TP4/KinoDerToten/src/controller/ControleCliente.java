package controller;

import models.*;

public class ControleCliente {
	private Cliente[] c;
	private int qtdClientes;
	
	public ControleCliente(ControleDados d) {
		c = d.getClientes();
		qtdClientes = d.getQtdClientes();
		
	}
	
	public String[] getNomeCliente() {
		String[] s = new String[qtdClientes];
		for(int i = 0; i < qtdClientes; i++) {
			s[i] = c[i].getNome();
		}
		
		return s;
	}
	
}
