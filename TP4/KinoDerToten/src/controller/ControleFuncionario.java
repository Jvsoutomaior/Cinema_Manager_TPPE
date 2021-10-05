package controller;

import models.*;

public class ControleFuncionario {
	private Funcionario[] f;
	private int qtdFuncionarios;
	
	public ControleFuncionario(ControleDados d) {
		f = d.getFuncionarios();
		qtdFuncionarios = d.getQtdFuncionarios();
		
	}
	
	public String[] getNomeFuncionario() {
		String[] s = new String[qtdFuncionarios];
		for(int i = 0; i < qtdFuncionarios; i++) {
			s[i] = f[i].getNome();
		}
		
		return s;
	}
	
	
}
