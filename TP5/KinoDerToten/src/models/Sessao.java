package models;

/**
 * A classe <b>Sessão</b> é muito importante e possui atributos das classes <b>Filme</b> e <b>Unidade</b>.
 * @author Yago Milagres Passo
 *
 */
public class Sessao {
	protected Filme filme;
	protected String horario;
	protected Unidade unidade;
	protected int numeroSala;
	protected boolean is3d;
	
	Sessao(){
	}
	/**
	 * Construtor da classe <b>Sessão</b>
	 * @param f -> filme
	 * @param h -> horario
	 * @param u -> unidade
	 * @param nS -> numeroSala
	 * @param i3 -> i3
	 */
	public Sessao(Filme f, String h, Unidade u, int nS,  boolean i3){
		filme = f;
		horario = h;
		unidade = u;
		numeroSala = nS;
		is3d = i3;
	}
	
	/**
	 * @deprecated
	 */
	public String toString() {
		 return filme.titulo+" na sala "+numeroSala+" às "+horario+", Divirta-se!";
	}
	
	/**
	 * metodo de acesso
	 * @return numerosala
	 */
	public int getNumeroSala() {
		return numeroSala;
	}
	/**
	 * metodo de acesso
	 * @param numeroSala -> numeroSala
	 */
	public void setNumeroSala(int numeroSala) {
		this.numeroSala = numeroSala;
	}
	/**
	 * metodo de acesso
	 * @return filme
	 */
	public Filme getFilme() {
		return filme;
	}
	/**
	 * metodo de acesso
	 * @param filme -> filme
	 */
	public void setFilme(Filme filme) {
		this.filme = filme;
	}
	/**
	 * metodo de acesso
	 * @return horario
	 */ 
	public String getHorario() {
		return horario;
	}
	/**
	 * metodo de acesso
	 * @param horario -> horario
	 */
	public void setHorario(String horario) {
		this.horario = horario;
	}
	/**
	 * metodo de acesso
	 * @return unidade
	 */
	public Unidade getUnidade() {
		return unidade;
	}
	/**
	 * metodo de acesso
	 * @param unidade -> unidade
	 */
	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}
	/**
	 * metodo de acesso
	 * @return is3d
	 */
	public boolean getIs3d() {
		return is3d;
	}
	/**
	 * metodo de acesso
	 * @param is3d -> is3d
	 */
	public void setIs3d(boolean is3d) {
		this.is3d = is3d;
	}
	/**
	 * O método <b>getTipo3d</b> serve para transformar o valor booleano do atributo da classe <b>Sessao</b>: is3d, em uma String. Serve para exibir essa informação nas views.
	 * @return se is3d for true, retorna: "3D". Se i3d for false, retorna: "Normal"
	 */
	public String getTipo3d() {
		String s = "Normal";
		if(is3d) s = "3D";
		
		return s;
	}
	
	
}
