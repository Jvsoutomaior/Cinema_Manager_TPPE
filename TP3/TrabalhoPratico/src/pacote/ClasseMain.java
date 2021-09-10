package pacote;

public class ClasseMain {

	public static void main(String[] args) {
		
		Unidade uni1 = new Unidade("Norte", "Rua 3, Bairro das aves", "Boulevard");
		Unidade uni2 = new Unidade("Sul", "Rua7, Avenida do Gostares", "Iguatemi");
		
		Funcionario func1 = new Funcionario("Jorge", "05648315783", 24, uni1, "jorge@gmail.com", "Tarde", "R$ 1400,00");
		Funcionario func2 = new Funcionario("Eustácio","65483242975", 72, uni2, "eustacio1984@gmail.com", "Tarde e Noite", "R$ 2100,00");
		
		Filme film1 = new Filme("O Grande Hotel Budapeste", ": 3/07/2014", 100, "Legendado", 14, "Comédia/Crime");
		Filme film2 = new Filme("Baby Driver", "27/06/2017", 115, "Dublado", 14, "Ação/Thriller");		
		
		Sessao sess1 = new Sessao(4, film1, "19:30", uni2, false);
		Sessao sess2 = new Sessao(5, film2, "22:00", uni1, true);
		
		Fidelidade fide1 = new Fidelidade(1);
		
		Cliente cli1 = new Cliente("André", "65484235128", 19, uni2, "dre@gmail.com", fide1);
		
		
		fide1.setCliente(cli1);
		
		
		
		System.out.println(fide1.getCliente());
		System.out.println("_____________________________\n");
		System.out.println(sess1);
		System.out.println("_____________________________\n");
		
		sess1.setHorario("18:45");
		
		System.out.println(sess1);
		System.out.println("_____________________________\n");
		
		
	}

	
}