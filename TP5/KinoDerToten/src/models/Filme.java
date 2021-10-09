package models;

/**
 * A classe <b>Filme</b> é uma das mais importantes do projeto.
 * @author Yago Milagres Passos
 *
 */
public class Filme {
	protected String titulo;
	protected String dataLancamento;
	protected int duracao;
	protected String linguagem;
	protected int classifIndicativa;
	protected String genero;
	
	/**
	 * Construtor padrão de filme
	 * Não é utilizado.
	 */
	Filme(){}
	/**
	 * 
	 * Construtor da Classe <b>Filme</b>
	 * @param t -> titulo
	 * @param dL -> data de lancamento
	 * @param d -> duracao
	 * @param l -> linguagem
	 * @param cI -> classificacao indicativa
	 * @param g -> genero
	 */
	public Filme(String t, String dL, int d, String l, int cI, String g){
		titulo = t;
		dataLancamento = dL;
		duracao = d;
		linguagem = l;
		classifIndicativa = cI;
		genero = g;
	}
	
	/**
	 * @deprecated
	 */
	public String toString() {
		 return "Título: "+titulo+ "\nData de Lancamento: "+dataLancamento;
	}
	
	/**
	 * metodo de acesso
	 * @return titulo
	 */
	public String getTitulo() {
		return titulo;
	}
	/**
	 * metodo de acesso
	 * @param titulo ->titulos
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	/**
	 * metodo de acesso
	 * @return dataLancamento
	 */
	public String getDataLancamento() {
		return dataLancamento;
	}
	/**
	 * metodo de acesso
	 * @param dataLancamento -> dataLancamento
	 */
	public void setDataLancamento(String dataLancamento) {
		this.dataLancamento = dataLancamento;
	}
	/**
	 * metodo de acesso
	 * @return duracao
	 */
	public int getDuracao() {
		return duracao;
	}
	/**
	 * metodo de acesso
	 * @param duracao -> duracao
	 */
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	/**
	 * metodo de acesso
	 * @return linguagem
	 */
	public String getLinguagem() {
		return linguagem;
	}
	/**
	 * metodo de acesso
	 * @param linguagem -> linguagem
	 */
	public void setLinguagem(String linguagem) {
		this.linguagem = linguagem;
	}
	/**
	 * metodo de acesso
	 * @return classifIndicativa
	 */
	public int getClassifIndicativa() {
		return classifIndicativa;
	}
	/**
	 * metodo de acesso
	 * @param classifIndicativa -> classifIndicativa
	 */
	public void setClassifIndicativa(int classifIndicativa) {
		this.classifIndicativa = classifIndicativa;
	}
	
	/**
	 * Esse método conversa com a classe <b>TelaDetalheFilme</b>
	 * Ele serve para preencher uma label na hora de exibir os dados de um filme
	 * @return Livre, 10, 12, 14, 16 ou 18
	 */
	public String getValueClassInd() {
		String retorna="Livre";
		if (classifIndicativa==1) retorna="10";
		if (classifIndicativa==2) retorna="12";
		if (classifIndicativa==3) retorna="14";
		if (classifIndicativa==4) retorna="16";
		if (classifIndicativa==5) retorna="18";
		
		return retorna;
	}
	
	/**
	 * metodo de acesso
	 * @return genero
	 */
	public String getGenero() {
		return genero;
	}
	/**
	 * metodo de acesso
	 * @param genero -> genero
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
}