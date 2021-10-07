package controller;

import models.*;

public class ControleDados {
	private Dados d = new Dados();
	
	
	
	public ControleDados() {
		d.preencheDataBase();
	}
	
	public Dados getDados() {
		return d;
	}
	public void setDados(Dados d) {
		this.d = d;
	}
	
	public Filme[] getFilmes() {
		return this.d.getFilmes();
	}
	public int getQtdFilmes() {
		return this.d.getQtdFilmes();
	}
	
	public Sessao[] getSessoes() {
		return this.d.getSessoes();
	}
	public int getQtdSessoes() {
		return this.d.getQtdSessoes();
	}
	
	public Unidade[] getUnidades() {
		return this.d.getUnidades();
	}
	public int getQtdUnidades() {
		return this.d.getQtdUnidades();
	}
	
	public Cliente[] getClientes() {
		return this.d.getClientes();
	}
	public int getQtdClientes() {
		return this.d.getQtdClientes();
	}
	
	public Funcionario[] getFuncionarios() {
		return this.d.getFuncionarios();
	}
	public int getQtdFuncionarios() {
		return this.d.getQtdFuncionarios();
	}
	
	
	
	public Filme getFilmeFromTitulo(String s) {
		//Filme film = ControleDados.getDados().getFilmes()[0];
		Filme film = d.getFilmes()[0];
		String aux;
		
		for(int i=0; i<getQtdFilmes(); i++) {
			aux = d.getFilmes()[i].getTitulo();
			if(s.compareTo(aux)==0) {
				//film = ControleDados.getDados().getFilmes()[i];
				film = d.getFilmes()[i];				
			}
		}
		return film;
	}
	
	public Unidade getUnidadeFromShopping(String s) {
		Unidade uni = d.getUnidades()[0];
		String aux;
		
		for(int i=0; i<getQtdUnidades(); i++) {
			aux = d.getUnidades()[i].getShopping();
			if(s.compareTo(aux)==0) {
				uni = d.getUnidades()[i];
				
			}
		}
		return uni;
	}	
	
	public boolean retornaBool(String s) {
		if(s=="1") return true;
		else return false;
	}
	
	public boolean inserirEditarFilme(String[] dadoNovo) {
		//if(!dadosFilmes[3].matches("[0-9]+") || !dadosFilmes[4].matches("[0-9]+") || 
			//!dadosFilmes[5].matches("[0-9]+") || !dadosProfs[6].matches("[0-9]+")) {
			//return false;
	//	} else {
			Filme f = new Filme(dadoNovo[1], dadoNovo[2], Integer.parseInt(dadoNovo[3]),  dadoNovo[4], Integer.parseInt(dadoNovo[5]), dadoNovo[6]);
			d.inserirEditarFilme(f, Integer.parseInt(dadoNovo[0]));
			return true;
		//}
	}

	public boolean removerFilme(int pos) {
		int i;
		int qtd = d.getQtdFilmes();
		
		for (i = pos; i<qtd-1; i++) {
			d.getFilmes()[i] = d.getFilmes()[i+1];
		}
		d.setQtdFilmes(qtd-1);
		
		return true;
	}

	public boolean inserirEditarSessao(String[] dadoNovo) {
		Sessao sess = new Sessao(getFilmeFromTitulo(dadoNovo[1]), dadoNovo[2], getUnidadeFromShopping(dadoNovo[3]), Integer.parseInt(dadoNovo[4]), retornaBool(dadoNovo[5]));
		d.inserirEditarSessao(sess, Integer.parseInt(dadoNovo[0]));
		return true;
	}
	public boolean removerSessao(int pos) {
		int i;
		int qtd = d.getQtdSessoes();
		
		for (i = pos; i<qtd-1; i++) {
			d.getSessoes()[i] = d.getSessoes()[i+1];
		}
		d.setQtdSessoes(qtd-1);
		
		return true;
	}

	public boolean inserirEditarCliente(String[] dadoNovo) {
		Cliente c = new Cliente(dadoNovo[1], dadoNovo[2], dadoNovo[3], getUnidadeFromShopping(dadoNovo[4]), dadoNovo[5], Integer.parseInt(dadoNovo[6]));
		d.inserirEditarCliente(c, Integer.parseInt(dadoNovo[0]));
		return true;
	}
	public boolean removerCliente(int pos) {
		int i;
		int qtd = d.getQtdClientes();
		
		for (i = pos; i<qtd-1; i++) {
			d.getClientes()[i] = d.getClientes()[i+1];
		}
		d.setQtdClientes(qtd-1);
		
		return true;
	}
	
	public boolean inserirEditarFuncionario(String[] dadoNovo) {
		Funcionario f = new Funcionario(dadoNovo[1], dadoNovo[2], dadoNovo[3], getUnidadeFromShopping(dadoNovo[4]), dadoNovo[5], dadoNovo[6], dadoNovo[7]);
		d.inserirEditarFuncionario(f, Integer.parseInt(dadoNovo[0]));
		return true;
	}
	public boolean removerFuncionario(int pos) {
		int i;
		int qtd = d.getQtdFuncionarios();
		
		for (i = pos; i<qtd-1; i++) {
			d.getFuncionarios()[i] = d.getFuncionarios()[i+1];
		}
		d.setQtdFuncionarios(qtd-1);
		
		return true;
	}

	public boolean inserirEditarUnidade(String[] dadoNovo) {
		Unidade u = new Unidade(dadoNovo[1], dadoNovo[2], dadoNovo[3]);
		d.inserirEditarUnidade(u, Integer.parseInt(dadoNovo[0]));
		return true;
	}
	public boolean removerUnidade(int pos) {
		int i;
		int qtd = d.getQtdUnidades();
		
		for (i = pos; i<qtd-1; i++) {
			d.getUnidades()[i] = d.getUnidades()[i+1];
		}
		d.setQtdUnidades(qtd-1);
		
		return true;
	}
}
