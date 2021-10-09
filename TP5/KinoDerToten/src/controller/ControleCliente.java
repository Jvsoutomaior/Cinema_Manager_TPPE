package controller;

import models.*;

/**
 * A classe <b>ControleCliente</b> conversa com a classe <b>TelaCliente</b> e <b>TelaDetalheCliente</b>.
 * Ela serve para as classes das <i>views</i> conversarem com as classes <b>Cliente</b> e <b>Dados</b> dos <i>models</i>
 * @author yagom
 *
 */
public class ControleCliente {
	private Cliente[] c;
	private int qtdClientes;
	
	/**
	 * Construtor da classe <b>ControleCliente</b>
	 * @param d -> recebe instancia de ControleDados
	 */
	public ControleCliente(ControleDados d) {
		c = d.getClientes();
		qtdClientes = d.getQtdClientes();
		
	}
	
	/**
	 * Esse método serve para preencher a JList na classe <b>TelaCliente</b> com os nomes dos clientes cadastrados no sistema
	 * Ele cria um array de String s, e preenche esse array com o nome dos clientes.
	 * @return array com nome de clientes.
	 */
	public String[] getNomeCliente() {
		String[] s = new String[qtdClientes];
		for(int i = 0; i < qtdClientes; i++) {
			s[i] = c[i].getNome();
		}
		
		return s;
	}
	
}
