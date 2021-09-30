package models;

public class Filme {
	protected String titulo;
	protected String dataLancamento;
	protected int duracao;
	protected String linguagem;
	protected int classifIndicativa;
	protected String genero;
	
	Filme(){}
	public Filme(String t, String dL, int d, String l, int cI, String g){
		titulo = t;
		dataLancamento = dL;
		duracao = d;
		linguagem = l;
		classifIndicativa = cI;
		genero = g;
	}
	
	
	public String toString() {
		 return "Título: "+titulo+ "\nData de Lancamento: "+dataLancamento;
	}
	
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDataLancamento() {
		return dataLancamento;
	}
	public void setDataLancamento(String dataLancamento) {
		this.dataLancamento = dataLancamento;
	}
	public int getDuracao() {
		return duracao;
	}
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	public String getLinguagem() {
		return linguagem;
	}
	public void setLinguagem(String linguagem) {
		this.linguagem = linguagem;
	}
	public int getClassifIndicativa() {
		return classifIndicativa;
	}
	public void setClassifIndicativa(int classifIndicativa) {
		this.classifIndicativa = classifIndicativa;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
}