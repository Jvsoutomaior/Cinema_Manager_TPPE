
import java.awt.*;
import javax.swing.*;


public class Teste {
	private JFrame frame;
	private ImageIcon cineImagem;
	private JLabel labelImagem;
	private JButton butaozin;
	
	
	public Teste() {
		
		//cineImagem = new ImageIcon(this.getClass().getResource("cine_background.jpg"));
		//labelImagem = new JLabel(cineImagem);
		//labelImagem.setSize(600,500);
		
		cineImagem = new ImageIcon("imgs/KinoDerToten.png"); //Componente com a logotipo escolhida
		labelImagem = new JLabel(); //Define uma nova label que contém o espaço com o logotipo
		labelImagem.setIcon(cineImagem); //Adiciona o logotipo à  area

		frame  = new JFrame("IMagenzona BRABA");
		frame.setVisible(true);
		frame.setLayout(null);
		frame.setSize(700,500);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());
		frame.add(labelImagem, BorderLayout.CENTER);
		//labelImagem.setSize(600,500);
		labelImagem.setPreferredSize(new Dimension(700,500));
	}

    public static void main(String[] args) {
       new Teste();
    }

}