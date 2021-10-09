package controller;

import models.*;

/**
 * A classe mais importante do package <i>controller</i>
 * <b>ControleDados</b> tem métodos de várias instancias de classes de todo o projeto/
 * @author yagom
 *
 */
public class ControleDados {
	private Dados d = new Dados();
	
	
	/**
	 * Esse construtor da classe <b>ControleDados</b> utiliza o método da classe <b>Dados</b> para preencher o programa com instâncias
	 */
	public ControleDados() {
		d.preencheDataBase();
	}
	/**
	 * metodo de acesso getDados
	 * @return d 
	 */
	public Dados getDados() {
		return d;
	}
	/**
	 * metodo de acesso setDados
	 * @param d -> dados
	 */
	public void setDados(Dados d) {
		this.d = d;
	}
	/**
	 * metodo de acesso
	 * @return filmes
	 */
	public Filme[] getFilmes() {
		return this.d.getFilmes();
	}
	/**
	 * metodo de acesso
	 * @return qtdFilmes
	 */
	public int getQtdFilmes() {
		return this.d.getQtdFilmes();
	}
	/**
	 * metodo de acesso
	 * @return sessoes
	 */
	public Sessao[] getSessoes() {
		return this.d.getSessoes();
	}
	/**
	 * metodo de acesso
	 * @return qtdSessoes
	 */
	public int getQtdSessoes() {
		return this.d.getQtdSessoes();
	}
	/**
	 * metodo de acesso
	 * @return unidades
	 */
	public Unidade[] getUnidades() {
		return this.d.getUnidades();
	}
	/**
	 * metodo de acesso
	 * @return qtdUnidades
	 */
	public int getQtdUnidades() {
		return this.d.getQtdUnidades();
	}
	/**
	 * metodo de acesso
	 * @return clientes
	 */
	public Cliente[] getClientes() {
		return this.d.getClientes();
	}
	/**
	 * metodo de acesso
	 * @return qtdClientes
	 */
	public int getQtdClientes() {
		return this.d.getQtdClientes();
	}
	/**
	 * metodo de acesso
	 * @return funcionarios
	 */
	public Funcionario[] getFuncionarios() {
		return this.d.getFuncionarios();
	}
	/**
	 * metodo de acesso
	 * @return qtdFuncionarios
	 */
	public int getQtdFuncionarios() {
		return this.d.getQtdFuncionarios();
	}
	
	
	/**
	 * O método <b>getFilmeFromTitulo</b> recebe uma String s, e compara essa String com todos os titulos dos filmes cadastrados no sistema.
	 * Ao achar um titulo igual à string recebida, ele salva e retorna esse filme que pareou.
	 * @param s -> String de algum titulo de filme
	 * @return instancia de filme
	 */
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
	
	/**
	 * O método <b>getUnidadeFromShopping</b> recebe uma String s, e compara essa String com todos os Shoppings das unidades cadastradas no sistema.
	 * Ao achar um Shopping igual à string recebida, ele salva e retorna essa unidade que pareou.
	 * @param s -> string de alguma shopping de unidade
	 * @return instancia de unidade
	 */
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
	
	/**
	 * REtorna valor bool caso strin == 1
	 * @param s -> String
	 * @return true or false
	 */
	public boolean retornaBool(String s) {
		if(s=="1") return true;
		else return false;
	}
	
	/**
	 *<b> inserirEditarFilme</b> é uma sobrecarga de um método da classe <b>Dados</b>
	 *Primeiro de tudo: Ele impede que o usuário insira algo diferente de um numero inteiro no argumento dadNovo[3] e dadoNovo[5]. que correspondem a Duração do filme
	 *e a classificação indicativa do mesmo.
	 *Caso nao tenha problema nessa primeira parte, ele chama o construtor de <b>Filme</b>, e chama tambem o método <b>inserirEditarFilme</b> da classe <b>Dados</b>,
	 *assim ele atualiza ou adiciona um filme dependendo do que foi selecionado pelo usuário
	 * @param dadoNovo -> valor cadastrado pelo usuario
	 * @return true ou false, para validação nas views.
	 */
	public boolean inserirEditarFilme(String[] dadoNovo) {
		if(!dadoNovo[3].matches("[0-9]+") || !dadoNovo[5].matches("[0-9]+")) {
			return false;
		} else {
			Filme f = new Filme(dadoNovo[1], dadoNovo[2], Integer.parseInt(dadoNovo[3]),  dadoNovo[4], Integer.parseInt(dadoNovo[5]), dadoNovo[6]);
			d.inserirEditarFilme(f, Integer.parseInt(dadoNovo[0]));
			return true;
		}
	}

	/**
	 * <b>removerFilme</b> verifica se o filme já está adicionado a alguma sessão. Se estiver, ele não permite a remoção.
	 * Caso contrário, ele diminui a quantidade de filmes cadastrados no sistema e subistitui o filme removido pelo próximo filme da lista, em um for.
	 * @param pos -> indica a posicao que o usuario removeu
	 * @return true or false
	 */
	public boolean removerFilme(int pos) {
		int i, j;
		int qtd = d.getQtdFilmes();
		String aux;
		String filmeRemovido = d.getFilmes()[pos].getTitulo();
		
		for(j=0; j < getQtdSessoes(); j++) {
			aux = d.getSessoes()[j].getFilme().getTitulo();
			if (filmeRemovido.compareTo(aux)==0)
				return false;
		}
		
		for (i = pos; i<qtd-1; i++) {
			d.getFilmes()[i] = d.getFilmes()[i+1];
		}
		d.setQtdFilmes(qtd-1);
		
		return true;
	}

	/**
	 * <b>inserirEditarSessao</b> Chama o construtor de sessão e seu método sobrecarregado da classe <b>Dados</b>.
	 * @param dadoNovo -> valor cadastrado pelo usuario
	 * @return true
	 */
	public boolean inserirEditarSessao(String[] dadoNovo) {
		Sessao sess = new Sessao(getFilmeFromTitulo(dadoNovo[1]), dadoNovo[2], getUnidadeFromShopping(dadoNovo[3]), Integer.parseInt(dadoNovo[4]), retornaBool(dadoNovo[5]));
		d.inserirEditarSessao(sess, Integer.parseInt(dadoNovo[0]));
		return true;
	}
	/**
	 * removerSessao simplesmente diminui o array de sessoes, e subistitui o valor excluido pelo próximo dentro de um <i>for</i>.
	 * @param pos -> indica a posicao que o usuario removeu
	 * @return true
	 */
	public boolean removerSessao(int pos) {
		int i;
		int qtd = d.getQtdSessoes();
		
		for (i = pos; i<qtd-1; i++) {
			d.getSessoes()[i] = d.getSessoes()[i+1];
		}
		d.setQtdSessoes(qtd-1);
		
		return true;
	}

	/**
	 * <b>inserirEditarCliente</b>é uma sobrecarga de um método da classe <b>Dados</b>
	 *Primeiro de tudo: Ele impede que o usuário insira algo diferente de um numero inteiro no argumento dadNovo[6]. que corresponde ao nivel de fidelidade.
	 *Caso nao tenha problema nessa primeira parte, ele chama o construtor de <b>Cliente</b>, e chama tambem o método <b>inserirEditarCliente</b> da classe <b>Dados</b>,
	 *assim ele atualiza ou adiciona um cliente dependendo do que foi selecionado pelo usuário
	 * @param dadoNovo -> valor cadastrado pelo usuario
	 * @return true ou false, para validação nas views
	 */
	public boolean inserirEditarCliente(String[] dadoNovo) {
		if(!dadoNovo[6].matches("[0-9]+")) {
			return false;
		} else {
			Cliente c = new Cliente(dadoNovo[1], dadoNovo[2], dadoNovo[3], getUnidadeFromShopping(dadoNovo[4]), dadoNovo[5], Integer.parseInt(dadoNovo[6]));
			d.inserirEditarCliente(c, Integer.parseInt(dadoNovo[0]));
			return true;
		}
	}
	/**
	 *<b> removerCliente</b> simplesmente diminui o array de clientes, e subistitui o valor excluido pelo próximo dentro de um <i>for</i>.
	 * @param pos -> indica a posicao que o usuario removeu
	 * @return true
	 */
	public boolean removerCliente(int pos) {
		int i;
		int qtd = d.getQtdClientes();
		
		for (i = pos; i<qtd-1; i++) {
			d.getClientes()[i] = d.getClientes()[i+1];
		}
		d.setQtdClientes(qtd-1);
		
		return true;
	}
	
	/**
	 * <b>inserirEditarFuncionario</b> chama seu construtor e seu método sobrecarregado na classe <b>Dados</b>
	 * @param dadoNovo -> valor cadastrado pelo usuario 
	 * @return true
	 */
	public boolean inserirEditarFuncionario(String[] dadoNovo) {
		Funcionario f = new Funcionario(dadoNovo[1], dadoNovo[2], dadoNovo[3], getUnidadeFromShopping(dadoNovo[4]), dadoNovo[5], dadoNovo[6], dadoNovo[7]);
		d.inserirEditarFuncionario(f, Integer.parseInt(dadoNovo[0]));
		return true;
	}
	/**
	 * <b>removerFuncionario</b> simplismente diminui o array de funcionários, e subistitui o valor excluído pelo próximo dentro de um <i>for</i>.
	 * @param pos -> indica a posicao que o usuario removeu
	 * @return true
	 */
	public boolean removerFuncionario(int pos) {
		int i;
		int qtd = d.getQtdFuncionarios();
		
		for (i = pos; i<qtd-1; i++) {
			d.getFuncionarios()[i] = d.getFuncionarios()[i+1];
		}
		d.setQtdFuncionarios(qtd-1);
		
		return true;
	}

	/**
	 * <b>inserirEditarUnidade</b> chama o construtor de unidade e seu método sobrecarregado na classe <b>Dados</b>
	 * @param dadoNovo -> Valor cadastrado pelo usuario
	 * @return true 
	 */
	public boolean inserirEditarUnidade(String[] dadoNovo) {
		Unidade u = new Unidade(dadoNovo[1], dadoNovo[2], dadoNovo[3]);
		d.inserirEditarUnidade(u, Integer.parseInt(dadoNovo[0]));
		return true;
	}
	/**
	 * <b>removerUnidade</b> Confere nas Sessões, Clientes, e Funcionários, se tem algum desses cadastrados com a unidade à ser removida. Se encontrar algo, ele retorna false
	 * e impede que a ação seja feita.
	 * Caso Contrário, é diminuido o array de Unidades e o valor excluído é subistituido pelo próximo dentro de um <i>for</i>.
	 * @param pos -> indica a posicao que o usuario removeu
	 * @return true or false
	 */
	public boolean removerUnidade(int pos) {
		int i, j;
		int qtd = d.getQtdUnidades();
		String aux;
		String unidadeRemovida = d.getUnidades()[pos].getShopping();
		
		for(j=0; j < getQtdSessoes(); j++) {
			aux = d.getSessoes()[j].getUnidade().getShopping();
			if (unidadeRemovida.compareTo(aux)==0)
				return false;
		}
		for(j=0; j < getQtdClientes(); j++) {
			aux = d.getClientes()[j].getUnidade().getShopping();
			if (unidadeRemovida.compareTo(aux)==0)
				return false;
		}
		for(j=0; j < getQtdFuncionarios(); j++) {
			aux = d.getFuncionarios()[j].getUnidade().getShopping();
			if (unidadeRemovida.compareTo(aux)==0)
				return false;
		}
		
		for (i = pos; i<qtd-1; i++) {
			d.getUnidades()[i] = d.getUnidades()[i+1];
		}
		d.setQtdUnidades(qtd-1);
		
		return true;
	}

}
