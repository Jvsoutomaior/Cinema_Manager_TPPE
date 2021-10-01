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
	
	
	public void preencheDataBase() {
		boolean alterna;
		 for (int i=0; i<5; i++) {
			 int n = i+1;
			 
			 if(i%2==0)  alterna = true;
			 else alterna = false;
			 
			 filmes[i] = new Filme(("filme"+n), ("0"+n+"/0"+n+"/200"+n), 100+n, "Dublado", i, "Comédia/Drama");
			 unidades[i] = new Unidade("Bairro"+n, "Quadra"+ n, "Shopping"+n);
			 sessoes[i] = new Sessao(filmes[i], ("0"+n+":"+n+"0"), unidades[i], n, alterna);
			 clientes[i] = new Cliente("Cliente"+n, "01230123"+n, ("0"+n+"/0"+n+"/200"+n), unidades[i], n+"@gmail.com", 1);
		 }
		 qtdFilmes = 5;
		 qtdSessoes = 5;
		 qtdUnidades = 5;
		 qtdClientes = 5;
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

	
	
	
	
	
	
	
	
	
	
	
	/*
		
			Scanner ler = new Scanner(System.in);
		
			Unidade uni1 = new Unidade("Norte", "Rua 3, Bairro das aves", "Boulevard");
			Unidade uni2 = new Unidade("Sul", "Rua7, Avenida do Gostares", "Iguatemi");
			
			Funcionario func1 = new Funcionario("Jorge", "05648315783", 24, uni1, "jorge@gmail.com", "Tarde", "R$ 1400,00");
			Funcionario func2 = new Funcionario("Eustácio","65483242975", 72, uni2, "eustacio1984@gmail.com", "Tarde e Noite", "R$ 2100,00");
			
			Filme film1 = new Filme("O Grande Hotel Budapeste", ": 3/07/2014", 100, "Legendado", 14, "Comédia/Crime");
			Filme film2 = new Filme("Baby Driver", "27/06/2017", 115, "Dublado", 14, "Ação/Thriller");		
			
			Sessao sess1 = new Sessao(4, film1, "19:30", uni2, false);
			Sessao sess2 = new Sessao(5, film2, "22:00", uni1, true);
			
			Cliente cli1 = new Cliente("André", "65484235128", 19, uni2, "dre@gmail.com", 1);
			Cliente cli2 = new Cliente("Sérgio","68452257879", 53, uni1, "email@email.com", 3);
		*/
	

}