package pacote;

public class Fidelidade {
	private Cliente cliente;
	private int nivel;
	static String mensalidade;
	static int ingressosMensais;
	
	
	Fidelidade(int nivel){
		switch (nivel) {
		case 1:
			nivel = 1;
			mensalidade = "R$ 50,00";
			ingressosMensais = 2;
			break;
		case 2:
			nivel = 2;
			mensalidade = "R$ 60,00";
			ingressosMensais = 3;
			break;
		case 3:
			nivel = 3;
			mensalidade = "R$ 70.00";
			ingressosMensais = 5;
			break;
		}
	}
	
	
	public String toString() {
		String saida= "";
		
		switch (nivel) {
		case 1:
			saida = "A fidelidade é básica, o valor da mensalidade é de "+mensalidade+", São disponibilizados"
					+ingressosMensais+" ingressos que só podem ser usados na unidade do shopping "+cliente.getUnidade().getShopping();
		case 2:
			saida = "A fidelidade é média, o valor da mensalidade é de "+mensalidade+", São disponibilizados"
					+ingressosMensais+" ingressos que podem ser usados em qualquer unidade.";
		case 3:
			saida = "A fidelidade é básica, o valor da mensalidade é de "+mensalidade+", São disponibilizados"
					+ingressosMensais+" ingressos que podem ser usados em qualquer unidade.";
			break;
		}
		
		return saida;
	}
	
	
	

	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	/*
	public static Unidade getUnidadesPermitidas() {
		return unidadesPermitidas;
	}
	public static void setUnidadesPermitidas(Unidade unidadesPermitidas) {
		Fidelidade.unidadesPermitidas = unidadesPermitidas;
	}
	public double getMensalidade() {
		return mensalidade;
	}
	public void setMensalidade(double precoMensal) {
		mensalidade = precoMensal;
	}
	public int getIngressosMensais() {
		return ingressosMensais;
	}
	public void setIngressosMensais(int ingressosMensais) {
		this.ingressosMensais = ingressosMensais;
	}
*/
	
	
}