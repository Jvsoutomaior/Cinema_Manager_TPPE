package views;

import javax.swing.*;
import controller.ControleDados;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipal implements ActionListener {

	private static JFrame f = new JFrame("Kino Der Toten (Controle interno)");
	private static JLabel titulo = new JLabel("O que você quer configurar?");
	private static JButton filme = new JButton("Filmes"); 
	private static JButton sessao = new JButton("Sessões");
	private static JButton cliente = new JButton("Fidelidades");
	private static JButton funcionario = new JButton("Funcionários");
	private static JButton unidade = new JButton("Unidades");
	private static JLabel descricao = new JLabel("O controle interno da sua franquia de cinemas!");
	private static ImageIcon background = new ImageIcon("imgs/KinoDerToten3.png");
	private static ImageIcon icone = new ImageIcon("imgs/icon.png");
	private static JLabel labelBackground = new JLabel();
	public static ControleDados dados = new ControleDados();
	
	public TelaPrincipal() {
		f.setVisible(true);
		f.setLayout(new BorderLayout());
		f.setBounds(500,200,700,500);
		f.setResizable(false);
		
		Font text = new Font("SansSerif",Font.PLAIN,16);
		Font button = new Font("SansSerif", Font.BOLD,18);
		
		f.add(filme, BorderLayout.CENTER);
		filme.setBounds(125, 120, 150, 70);
		filme.setFont(button);
		f.add(sessao, BorderLayout.CENTER);
		sessao.setBounds(390, 320, 150, 70);
		sessao.setFont(button);
		f.add(cliente, BorderLayout.CENTER);
		cliente.setBounds(125, 320, 150, 70);
		cliente.setFont(button);
		f.add(funcionario, BorderLayout.CENTER);
		funcionario.setBounds(390, 120, 150, 70);
		funcionario.setFont(button);
		f.add(unidade, BorderLayout.CENTER);
		unidade.setBounds(250, 220, 150, 70);
		unidade.setFont(button);
		//f.add(titulo, BorderLayout.CENTER);
		titulo.setBounds(50, 75, 250, 50);
		titulo.setFont(text);
		f.add(descricao, BorderLayout.CENTER);
		descricao.setBounds(210, 400, 300,40);
		
		f.setIconImage(icone.getImage());
		
		titulo.setForeground(Color.white);
		descricao.setForeground(Color.white);
		
		labelBackground.setIcon(background);
		f.add(labelBackground, BorderLayout.CENTER);		
		labelBackground.setPreferredSize(new Dimension(700,500));
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		TelaPrincipal menu = new TelaPrincipal();

		sessao.addActionListener(menu);
		filme.addActionListener(menu);
		cliente.addActionListener(menu);
		funcionario.addActionListener(menu);
		unidade.addActionListener(menu);
	}

	
	//Sobrecarga do método da interface ActionListener
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src==filme)
			new TelaFilme(dados);
		
		if(src==sessao)
			new TelaSessao(dados);
		
		if(src==cliente)
			new TelaCliente(dados);
		
		if(src==funcionario)
			new TelaFuncionario(dados);
			
		if(src==unidade)
			new TelaUnidade(dados);
	}
	
}
	