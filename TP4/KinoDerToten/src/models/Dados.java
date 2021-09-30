package models;

public class Dados {
	private Filme[] filmes = new Filme[50];
	private int qtdFilmes = 0;
	
	
	public void preencheDataBase() {
		 for (int i=0; i<5; i++) {
			 int n = i+1;
			 filmes[i] = new Filme(("filme"+n), ("0"+n+"/0"+n+"/200"+n), 100+n, "Dublado", 2, "Comédia/Drama");
		 }
		 qtdFilmes = 5;
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