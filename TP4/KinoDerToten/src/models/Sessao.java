package models;

public class Sessao {
	protected Filme filme;
	protected String horario;
	protected Unidade unidade;
	protected int numeroSala;
	protected boolean is3d;
	
	Sessao(){
	}
	public Sessao(Filme f, String h, Unidade u, int nS,  boolean i3){
		filme = f;
		horario = h;
		unidade = u;
		numeroSala = nS;
		is3d = i3;
	}
	
	
	public String toString() {
		 return filme.titulo+" na sala "+numeroSala+" às "+horario+", Divirta-se!";
	}
	
	public int getNumeroSala() {
		return numeroSala;
	}
	public void setNumeroSala(int numeroSala) {
		this.numeroSala = numeroSala;
	}
	public Filme getFilme() {
		return filme;
	}
	public void setFilme(Filme filme) {
		this.filme = filme;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public Unidade getUnidade() {
		return unidade;
	}
	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}
	public boolean getIs3d() {
		return is3d;
	}
	public void setIs3d(boolean is3d) {
		this.is3d = is3d;
	}
	public String getTipo3d() {
		String s = "Normal";
		if(is3d) s = "3D";
		
		return s;
	}
	
	
}
