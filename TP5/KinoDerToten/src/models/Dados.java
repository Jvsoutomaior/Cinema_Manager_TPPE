package models;

/**
 * A Classe Dados armazena arrays de instancias de outras classes, assim como quantidades. Ela conversa com todas as classes de models e constrollers.
 * @author Yago Milagres Passos
 *
 */
public class Dados {
	private Filme[] filmes = new Filme[20];
	private int qtdFilmes = 0;
	private Unidade[] unidades = new Unidade[20];
	private int qtdUnidades = 0;
	private Sessao[] sessoes = new Sessao[20];
	private int qtdSessoes = 0;
	private Cliente[] clientes = new Cliente[20];
	private int qtdClientes = 0;
	private Funcionario[] funcionarios = new Funcionario[20];
	private int qtdFuncionarios = 0;
	
	/**
	 * Esse método void, <b>preencheDataBase()</b> enche o meu programa com algumas instancias das classes de models.
	 */
	public void preencheDataBase() {
		boolean alterna;
		String turno;
		
		 for (int i=0; i<5; i++) {
			 int n = i+1;
			 
			 if(i%2==0) {
				 alterna = true;
				 turno = "Tarde";
			 } else {
				 alterna = false; 
				 turno = "Noite";
			 }
			 
			 filmes[i] = new Filme(("filme"+n), ("0"+n+"/0"+n+"/200"+n), 100+n, "Dublado", i, "Comédia/Drama");
			 unidades[i] = new Unidade("Bairro"+n, "Quadra"+ n, "Shopping"+n);
			 sessoes[i] = new Sessao(filmes[i], ("0"+n+":"+n+"0"), unidades[i], n, alterna);
			 clientes[i] = new Cliente("Cliente"+n, "01230123"+n, ("0"+n+"/0"+n+"/200"+n), unidades[i], n+"@gmail.com", 1);
			 funcionarios[i] = new Funcionario("Funcionário"+n, "01230123"+n, ("0"+n+"/0"+n+"/200"+n), unidades[i], n+"@gmail.com", turno, "R$100"+n+",00");
		 }
		 qtdFilmes = 5;
		 qtdSessoes = 5;
		 qtdUnidades = 5;
		 qtdClientes = 5;
		 qtdFuncionarios = 5;
	}
	
	/**
	 * metodo de acesso
	 * @return filmes
	 */
	public Filme[] getFilmes() {
		return filmes;
	}
	/**
	 * metodo de acesso
	 * @param filmes -> filmes
	 */
	public void setFilmes(Filme[] filmes) {
		this.filmes = filmes;
	}
	/**
	 * <b>inserirEditarFilme</b> atualiza os dados de uma instancia de <b>Filme</b>, e adiciona uma nova quantidade caso seja um filme novo.
	 * Ela é chamada na classe <b>ControleDados</b>
	 * @param f -> filme
	 * @param pos -> posicao
	 */
	public void inserirEditarFilme(Filme f, int pos) {
		this.filmes[pos] = f;
		if(pos==qtdFilmes) qtdFilmes++; 
	}
	/**
	 * metodo de acesso
	 * @return qtdFilmes
	 */
	public int getQtdFilmes() {
		return qtdFilmes;
	}
	/**
	 * metodo de acesso
	 * @param qtdFilmes -> qtdFilmes
	 */
	public void setQtdFilmes(int qtdFilmes) {
		this.qtdFilmes = qtdFilmes;
	}

	/**
	 * metodo de acesso
	 * @return unidades
	 */
	public Unidade[] getUnidades() {
		return unidades;
	}
	/**
	 * metodo de acesso
	 * @param unidades -> unidade
	 */
	public void setUnidades(Unidade[] unidades) {
		this.unidades = unidades;
	}
	/**
	 * metodo de acesso
	 * @return qtdUnidade
	 */
	public int getQtdUnidades() {
		return qtdUnidades;
	}
	/**
	 * metodo de acesso
	 * @param qtdUnidade -> qtdUnidade
	 */
	public void setQtdUnidades(int qtdUnidade) {
		this.qtdUnidades = qtdUnidade;
	}
	/**
	 * <b>inserirEditarUnidade</b> atualiza os dados de uma instancia de <b>Unidade</b>, e adiciona uma nova quantidade caso seja uma Unidade nova.
	 * Ela é chamada na classe <b>ControleDados</b>
	 * @param u -> unidade
	 * @param pos -> posicao
	 */
	public void inserirEditarUnidade(Unidade u, int pos) {
		this.unidades[pos] = u;
		if(pos==qtdUnidades) qtdUnidades++; 
	}

	/**
	 * metodo de acesso
	 * @return sessoes
	 */
	public Sessao[] getSessoes() {
		return sessoes;
	}
	/**
	 * metodo de acesso
	 * @param sessoes -> sessoes
	 */
	public void setSessoes(Sessao[] sessoes) {
		this.sessoes = sessoes;
	}
	/**
	 * metodo de acesso
	 * @return qtdSessoes
	 */
	public int getQtdSessoes() {
		return qtdSessoes;
	}	
	/**
	 * metodo de acesso
	 * @param qtdSessoes -> qtdSessoes
	 */
	public void setQtdSessoes(int qtdSessoes) {
		this.qtdSessoes = qtdSessoes;
	} 
	/**
	 * <b>inserirEditarSessao</b> atualiza os dados de uma instancia de <b>Sessao</b>, e adiciona uma nova quantidade caso seja uma sessao nova.
	 * Ela é chamada na classe <b>ControleDados</b>
	 * @param s -> sessao
	 * @param pos -> posicao
	 */
	public void inserirEditarSessao(Sessao s, int pos) {
		this.sessoes[pos] = s;
		if(pos==qtdSessoes) qtdSessoes++; 
	}

	/**
	 * metodo de acesso
	 * @return clientes
	 */
	public Cliente[] getClientes() {
		return clientes;
	}
	/**
	 * metodo de acesso	
	 * @param clientes -> cliente
	 */
	public void setClientes(Cliente[] clientes) {
		this.clientes = clientes;
	}
	/**
	 * metodo de acesso
	 * @return qtdClientes
	 */
	public int getQtdClientes() {
		return qtdClientes;
	}
	/**
	 * metodo de acesso
	 * @param qtdClientes -> qtdClientes
	 */
	public void setQtdClientes(int qtdClientes) {
		this.qtdClientes = qtdClientes;
	}
	/**
	 * <b>inserirEditarCliente</b> atualiza os dados de uma instancia de <b>Cliente</b>, e adiciona uma nova quantidade caso seja um Cliente novo.
	 * Ela é chamada na classe <b>ControleDados</b>
	 * @param c -> cliente
	 * @param pos -> posicao
	 */
	public void inserirEditarCliente(Cliente c, int pos) {
		this.clientes[pos] = c;
		if(pos==qtdClientes) qtdClientes++; 
	}

	/**
	 * metodo de acesso
	 * @return funcionarios
	 */
	public Funcionario[] getFuncionarios() {
		return funcionarios;
	}
	/**
	 * metodo de acesso
	 * @param funcionarios -> funcionarios
	 */
	public void setFuncionarios(Funcionario[] funcionarios) {
		this.funcionarios = funcionarios;
	}
	/**
	 * metodo de acesso
	 * @return -> qtdFuncionarios
	 */
	public int getQtdFuncionarios() {
		return qtdFuncionarios;
	}
	/**
	 * metodo de acesso
	 * @param qtdFuncionarios -> qtdFuncionarios
	 */
	public void setQtdFuncionarios(int qtdFuncionarios) {
		this.qtdFuncionarios = qtdFuncionarios;
	}
	/**
	 * <b>inserirEditarFuncionario</b> atualiza os dados de uma instancia de <b>Funcionario</b>, e adiciona uma nova quantidade caso seja um funcionario novo.
	 * Ela é chamada na classe <b>ControleDados</b>
	 * @param func -> funcionario
	 * @param pos -> posicao
	 */
	public void inserirEditarFuncionario(Funcionario func, int pos) {
		this.funcionarios[pos] = func;
		if(pos==qtdFuncionarios) qtdFuncionarios++; 
	}

	
	
	
	
	
	
	
	
	
	
}