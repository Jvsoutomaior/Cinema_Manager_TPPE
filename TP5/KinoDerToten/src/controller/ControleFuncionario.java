package controller;

import models.*;

/**
 * Classe <b>ControleFuncionario</b>
 * @author yagom
 *
 */
public class ControleFuncionario {
	private Funcionario[] f;
	private int qtdFuncionarios;
	
	/**
	 * Construtor de ControleFuncionario
	 * @param d -> instancia de ControleDados
	 */
	public ControleFuncionario(ControleDados d) {
		f = d.getFuncionarios();
		qtdFuncionarios = d.getQtdFuncionarios();
		
	}
	
	/**
	 * O método <b>getNomeFuncionario</b> preenche um array de string com todos os nomes dos Funcionarios cadastrados no sistema. Serve para preencher uma JList na classe
	 * <b>TelaFuncinario</b>
	 * @return array de string
	 */
	public String[] getNomeFuncionario() {
		String[] s = new String[qtdFuncionarios];
		for(int i = 0; i < qtdFuncionarios; i++) {
			s[i] = f[i].getNome();
		}
		
		return s;
	}
	
	
}
