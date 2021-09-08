import java.util.Scanner;

public class ControleLojista {
	
	static int count = 10, contP = 10;
	static Scanner ler = new Scanner(System.in);
	
	public static void main(String[] args) {
		//Declara��es
		String nome[] = new String[30];
		String endereco[] = new String[30];
		String telefone[] = new String[30];
		String modelo[] = new String[30];
		String descricao[] = new String[30];
		double valor[] = new double[30];
		int porcentagem[] = new int[30];
		int quantidade[] = new int[30];
		
		int opcao;
		
		preenchimentoAutomatico(nome, endereco, telefone, modelo, descricao, valor, porcentagem, quantidade);
		
		//Instru��es
		
		do {
			menu();
			opcao = ler.nextInt();
			
			switch (opcao) {
				case 1:
					cadastroCliente(nome, endereco, telefone);			
					break;
					
				case 2: 
					buscaCliente(nome, endereco, telefone);
					break;
					
				case 3:
					cadastroProduto(modelo, descricao, valor, porcentagem, quantidade);
					break;
					
				case 4:
					buscaProduto(modelo, descricao, valor, porcentagem, quantidade);
					break;
					
				case 5:
					cadastroVenda(nome, modelo, quantidade);
					break;
					
				case 6:
					listaProdutos(modelo, quantidade);
					break;
					
				case 7: 
					System.out.println("Obrigado.   X_x zzZZZzzZZz");
					break;
				default:
					System.out.println("Opc�o inv�lida, Tente novamente:");
					break;
			}
			
		} while (opcao!=7);
		
		
	}
	
	
	static void menu() {
		System.out.println("\tEscolha uma opc�o do menu: \n");
		System.out.println("1 - Cadastro de novo cliente");
		System.out.println("2 - Busca por cliente.");
		System.out.println("3 - Cadastro de novo produto");
		System.out.println("4 - Busca por produto.");
		System.out.println("5 - Cadastro de venda");
		System.out.println("6 - Mostrar produtos em estoque");
		System.out.println("7 - Sair");
	}

	public static void cadastroCliente(String nome[], String endereco[], String telefone[]) {
		//Declara��es
		int qtdCadastros;
		
		//Instru��es
		System.out.println("Quantos clientes voc� deseja cadastrar?");
		qtdCadastros = ler.nextInt();
		while (qtdCadastros < 0 || qtdCadastros > 10) {
			System.out.println("Quantidade inv�lida, digite um n�mero de 1 a 10;");
			qtdCadastros = ler.nextInt();
		}
		ler.nextLine();
		for (int i=count; i<count+qtdCadastros; i++) {
			System.out.println("Digite o nome do novo cliente:");
			nome[i] = ler.nextLine();
			System.out.println("Digite o endereco desse cliente:");
			endereco[i] = ler.nextLine();
			System.out.println("Digite o telefone desse cliente:");
			telefone[i] = ler.nextLine();
		}
		count += qtdCadastros;
	}

	public static void buscaCliente(String nome[], String endereco[], String telefone[]) {
		String nomeBusca;
		int numSalva = 0, opcao;
		boolean encontrou = false;
		
		System.out.println("Digite o nome do cliente a ser pesquisado:");
		ler.nextLine();
		nomeBusca = ler.nextLine();
		for (int k=0; k<count; k++) {
			if(nomeBusca.equalsIgnoreCase(nome[k])) {
				encontrou = true;
				numSalva = k;
			}
		}
		if (encontrou) {
			System.out.println("\nAchamos!\nAqui est�o os dados do cliente que voc� pesquisou!");
			System.out.println("Nome: "+nome[numSalva]+"\nEndere�o: "+endereco[numSalva]+"\nTelefone: "+telefone[numSalva]);
			System.out.println("\nVoce quer alterar algum dado desse cliente?");
			System.out.println("\n1 - N�o, voltar ao menu.\n2 - Alterar o nome\n3 - Alterar o endere�o\n4 - Alterar o telefone");
			opcao = ler.nextInt();
			switch (opcao) {
				case 2:
					System.out.println("Digite o novo nome:");
					ler.nextLine();
					nome[numSalva] = ler.nextLine();
					break;
				case 3:
					System.out.println("Digite o novo endere�o:");
					ler.nextLine();
					endereco[numSalva] = ler.nextLine();
					break;
				case 4:
					System.out.println("Digite o novo telefone:");
					ler.nextLine();
					telefone[numSalva] = ler.nextLine();
					break;
			}
			
		} else {
		System.out.println("\nCliente n�o encontrado!\n");
		}
	}
	
	public static void cadastroProduto(String modelo[], String descricao[], double valor[], int porcentagem[], int quantidade[]) {
		//Declara��es
		int qtdProdutos;
		
		//Instru��es
		System.out.println("Quantos produtos voc� deseja cadastrar?");
		qtdProdutos = ler.nextInt();
		while (qtdProdutos < 0 || qtdProdutos > 10) {
			System.out.println("Quantidade inv�lida, digite um n�mero de 1 a 10;");
			qtdProdutos = ler.nextInt();
		}
		for (int i=contP; i<contP+qtdProdutos; i++) {
			System.out.println("Digite o nome do novo produto:");
			ler.nextLine();
			modelo[i] = ler.nextLine();
			System.out.println("Digite a descri��o desse produto:");
			descricao[i] = ler.nextLine();
			System.out.println("Digite o valor desse produto:");
			valor[i] = ler.nextDouble();
			System.out.println("Digite a porcentagem de lucro:");
			porcentagem[i] = ler.nextInt();
			System.out.println("Informe a quantidade em estoque:");
			quantidade[i] = ler.nextInt();
		}
		contP += qtdProdutos;
	}
	
	public static void buscaProduto(String modelo[], String descricao[], double valor[], int porcentagem[], int quantidade[]) {
		String produtoBusca;
		int numSalva = 0, opcao;
		boolean encontrou = false;
		
		System.out.println("Digite o nome do produto a ser pesquisado:");
		ler.nextLine();
		produtoBusca = ler.nextLine();
		for (int k=0; k<count; k++) {
			if(produtoBusca.equalsIgnoreCase(modelo[k])) {
				encontrou = true;
				numSalva = k;
			}
		}
		if (encontrou) {
			System.out.println("\nAchamos!\nAqui est�o os dados do produto que voc� pesquisou!");
			System.out.println("Modelo: "+modelo[numSalva]+"\nDescri��o: "+descricao[numSalva]+".\nValor: R$ "+valor[numSalva]);
			System.out.println("Lucro: "+porcentagem[numSalva]+"%\nEm estoque: "+quantidade[numSalva]);
			System.out.println("\nVoce quer alterar algum dado desse produto?");
			System.out.println("\n1 - N�o, voltar ao menu.\n2 - Alterar o nome\n3 - Alterar a descri��o\n4 - Alterar o valor\n5 - Alterar a porcentagem\n6 - Alterar a quantidade");
			opcao = ler.nextInt();
			switch (opcao) {
				case 2:
					System.out.println("Digite o novo nome:");
					ler.nextLine();
					modelo[numSalva] = ler.nextLine();
					break;
				case 3:
					System.out.println("Digite a nova descri��o:");
					ler.nextLine();
					descricao[numSalva] = ler.nextLine();
					break;
				case 4:
					System.out.println("Digite o novo valor:");
					ler.nextLine();
					valor[numSalva] = ler.nextDouble();
					break;
				case 5:
					System.out.println("Digite a nova porcentagem:");
					ler.nextLine();
					porcentagem[numSalva] = ler.nextInt();
					break;
				case 6:
					System.out.println("Digite a quantidade em estoque:");
					ler.nextLine();
					quantidade[numSalva] = ler.nextInt();
					break;
			}
		} else {
		System.out.println("\nProduto n�o encontrado!\n");
		}
	}

	public static void cadastroVenda(String nome[], String modelo[], int quantidade[]) {
		int opcao1, opcao2, qtdVendidos;
		char repete;
		
		System.out.println("\nSelecione um da lista para cadastrar a venda:");
		for (int i=0; i<count; i++) {
			System.out.println((i+1)+" - "+nome[i]);
		}
		opcao1 = ler.nextInt();
		while (opcao1<=0 || opcao1>count) {
			System.out.println("Esse usu�rio n�o est� na lista! Tente novamente:");
			opcao1 = ler.nextInt();
		}
		do {
			System.out.println("\nAgora selecione um produto:");
			for (int i=0; i<contP; i++) {
				System.out.println((i+1)+" - "+modelo[i]);
			}
			opcao2 = ler.nextInt();
			while (opcao2<=0 || opcao2>count) {
				System.out.println("Esse produto n�o est� na lista! Tente novamente:");
				opcao2 = ler.nextInt();
			}
			
			if(quantidade[opcao2-1]==0) {
				System.out.println("Esse produto, apesar de cadastrado, n�o se encontra no estoque! Altere isso na terceira opc�o do menu.");
			} else {
				System.out.println(modelo[opcao2-1]+" tem "+quantidade[opcao2-1]+" em estoque.");
				System.out.println("Quantos desse produto v�o ser vendidos?");
				qtdVendidos = ler.nextInt();
				while (qtdVendidos<=0 || qtdVendidos>quantidade[opcao2-1]) {
					System.out.println("Quantidade inv�lida. Digite um numero entre 1 e "+ quantidade[opcao2-1]);
					qtdVendidos = ler.nextInt();
				}
				quantidade[opcao2-1] -= qtdVendidos;
			}
			System.out.println("Quer escolher outro produto? S / N");
			repete = ler.next().charAt(0);
		} while(repete == 's' || repete == 'S');
	}
	
	public static void listaProdutos(String modelo[], int quantidade[]) {
		char saida;
		
		for (int i=0; i<contP; i++) {
			System.out.println(modelo[i]+"\tEstoque: "+ quantidade[i]);
		}
		System.out.println("Digite qualquer caractere para voltar ao menu");
		saida = ler.next().charAt(0);
	}
	
	public static void preenchimentoAutomatico(String nome[], String endereco[], String telefone[], String modelo[], String descricao[], double valor[], int porcentagem[], int quantidade[]) {
		for (int i=0; i<10; i++) {
			nome[i] = "Cliente " + (i+1);
			endereco[i] = "EnderecoExemplo" +(i+1);
			telefone[i] = "00"+(i+1);
			modelo[i] = "Produto "+ (i+1);
			descricao[i] = "Produto autoreabastecido";
			valor[i] = 10.90+(i+1);
			porcentagem[i] = 50+(i+1);
			quantidade[i] = 5;
		}
	}
	
	
}