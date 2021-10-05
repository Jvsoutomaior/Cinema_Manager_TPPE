package models;

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
	
	
	public Filme[] getFilmes() {
		return filmes;
	}
	public void setFilmes(Filme[] filmes) {
		this.filmes = filmes;
	}
	public void inserirEditarFilme(Filme f, int pos) {
		this.filmes[pos] = f;
		if(pos==qtdFilmes) qtdFilmes++; 
	}
	public int getQtdFilmes() {
		return qtdFilmes;
	}
	public void setQtdFilmes(int qtdFilmes) {
		this.qtdFilmes = qtdFilmes;
	}


	public Unidade[] getUnidades() {
		return unidades;
	}
	public void setUnidades(Unidade[] unidades) {
		this.unidades = unidades;
	}
	public int getQtdUnidades() {
		return qtdUnidades;
	}
	public void setQtdUnidades(int qtdUnidade) {
		this.qtdUnidades = qtdUnidade;
	}


	public Sessao[] getSessoes() {
		return sessoes;
	}
	public void setSessoes(Sessao[] sessoes) {
		this.sessoes = sessoes;
	}
	public int getQtdSessoes() {
		return qtdSessoes;
	}	
	public void setQtdSessoes(int qtdSessoes) {
		this.qtdSessoes = qtdSessoes;
	} 
	public void inserirEditarSessao(Sessao s, int pos) {
		this.sessoes[pos] = s;
		if(pos==qtdSessoes) qtdSessoes++; 
	}


	public Cliente[] getClientes() {
		return clientes;
	}
	public void setClientes(Cliente[] clientes) {
		this.clientes = clientes;
	}
	public int getQtdClientes() {
		return qtdClientes;
	}
	public void setQtdClientes(int qtdClientes) {
		this.qtdClientes = qtdClientes;
	}
	public void inserirEditarCliente(Cliente c, int pos) {
		this.clientes[pos] = c;
		if(pos==qtdClientes) qtdClientes++; 
	}


	public Funcionario[] getFuncionarios() {
		return funcionarios;
	}
	public void setFuncionarios(Funcionario[] funcionarios) {
		this.funcionarios = funcionarios;
	}
	public int getQtdFuncionarios() {
		return qtdFuncionarios;
	}
	public void setQtdFuncionarios(int qtdFuncionarios) {
		this.qtdFuncionarios = qtdFuncionarios;
	}
	public void inserirEditarFuncionario(Funcionario func, int pos) {
		this.funcionarios[pos] = func;
		if(pos==qtdFuncionarios) qtdFuncionarios++; 
	}

	
	
	
	
	
	
	
	
	
	
}