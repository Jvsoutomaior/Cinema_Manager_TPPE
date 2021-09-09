package pacote;

public class Fidelidade {
	protected Cliente cliente;
	protected int nivel;
	protected double Mensalidade;
	protected int ingressosMensais;
	
	
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	public double getMensalidade() {
		return Mensalidade;
	}
	public void setMensalidade(double mensalidade) {
		Mensalidade = mensalidade;
	}
	public int getIngressosMensais() {
		return ingressosMensais;
	}
	public void setIngressosMensais(int ingressosMensais) {
		this.ingressosMensais = ingressosMensais;
	}

	
	
}