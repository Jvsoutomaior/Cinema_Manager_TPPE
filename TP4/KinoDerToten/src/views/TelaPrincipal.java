package views;

import javax.swing.*;
import controller.ControleDados;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipal implements ActionListener {

	private static JFrame f = new JFrame("Kino Der Toten (Controle interno)");
	private static JLabel titulo = new JLabel("O que você quer configurar?");
	private static JButton filme = new JButton("Filmes"); 
	private static JButton sessao = new JButton("Sessões");
	private static JButton cliente = new JButton("Fidelidades");
	private static JButton funcionario = new JButton("Funcionários");
	private static JLabel descricao = new JLabel("O front end irá mudar na versão final do TP5");
	public static ControleDados dados = new ControleDados();
	
	public TelaPrincipal() {
		f.setVisible(true);
		f.setLayout(null);
		f.setBounds(500,200,700,500);
		
		Font text = new Font("SansSerif",Font.PLAIN,18);
		Font button = new Font("SansSerif", Font.BOLD,20);
		
		f.add(filme);
		filme.setBounds(125, 100, 170, 90);
		filme.setFont(button);
		f.add(sessao);
		sessao.setBounds(375, 300, 170, 90);
		sessao.setFont(button);
		f.add(cliente);
		cliente.setBounds(125, 300, 170, 90);
		cliente.setFont(button);
		f.add(funcionario);
		funcionario.setBounds(375, 100, 170, 90);
		funcionario.setFont(button);
		f.add(titulo);
		titulo.setBounds(50, -15, 300, 100);
		titulo.setFont(text);
		f.add(descricao);
		descricao.setBounds(210, 400, 300,40);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		TelaPrincipal menu = new TelaPrincipal();

		sessao.addActionListener(menu);
		filme.addActionListener(menu);
	}

	
	//Sobrecarga do método da interface ActionListener
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src==filme)
			new TelaFilme(dados);
		
		if(src==sessao)
			new TelaSessao(dados);
		/*
		if(src==cliente)
			new TelaCliente();
		
		if(src==funcionario)
			new telaFuncionario();
			*/
		
	}

}
	