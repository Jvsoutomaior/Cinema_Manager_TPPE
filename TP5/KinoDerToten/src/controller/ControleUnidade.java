package controller;

import models.*;

/**
 * Classe <b>ControleUnidade</b>
 * @author YagoMilagresPassos
 *
 */
public class ControleUnidade {
	private Unidade[] u;
	private int qtdUnidades;
	
	/**
	 * Construtor da classe <b>ControleUnidade</b>
	 * @param d -> instancia de ControleDados
	 */
	public ControleUnidade(ControleDados d) {
		u = d.getUnidades();
		qtdUnidades = d.getQtdUnidades();
		
	}

	/**
	 * O método <b>getShoppingUnidade</b> preenche um array de string com os shoppings das unidades cadastradas no sistema. Ele serve para preencher uma JList na classe 
	 * <b>TelaUnidade</b>
	 * @return array de string
	 */
	public String[] getShoppingUnidade() {
		String[] s = new String[qtdUnidades];
		for(int i=0; i<qtdUnidades; i++) {
			s[i] = u[i].getShopping();
		}
		
		return s;
	} 
	
	
}
