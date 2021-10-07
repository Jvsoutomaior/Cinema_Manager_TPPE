package views;

import javax.swing.*;
import controller.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TelaFuncionario implements ActionListener, ListSelectionListener{
	private JFrame f = new JFrame("KDT - Funcionarios");
	private JLabel titulo = new JLabel("Nossos Funcionários:");
	private JLabel descr = new JLabel("Selecione da lista para exibir");
	private JList<String> listaFuncionarios;
	private String[] listaShoppings = new String[20];
	private	JButton criar = new JButton("Contratar"); 
	private JButton atualizar = new JButton("Atualizar");
	private JButton voltar = new JButton("Voltar");
	private static ControleDados dados;
	private static ImageIcon background = new ImageIcon("imgs/KinoDerToten3.png");
	private static ImageIcon icone = new ImageIcon("imgs/icon_funcionario.png");
	private static JLabel labelBackground = new JLabel();
	Font text = new Font("SansSerif", Font.PLAIN, 18);
	Font title = new Font("SansSerif", Font.BOLD, 26);
	Font but = new Font("SansSerif", Font.BOLD ,14);
	
	
	public TelaFuncionario (ControleDados d) {
		dados = d;
		
		f.setBounds(500,200,700,500);
		f.setLayout(null);
		f.setResizable(false);
		f.setVisible(true);
		
		f.setIconImage(icone.getImage());
		
		listaShoppings = new ControleFuncionario(dados).getNomeFuncionario();
		listaFuncionarios = new JList<String>(listaShoppings); 
		
		f.add(titulo);
		titulo.setBounds(210,-70,300,250);
		f.add(listaFuncionarios);
		listaFuncionarios.setBounds(225,100,200,260);
		f.add(criar);	
		criar.setBounds(210,400,100,50);
		f.add(descr);
		descr.setBounds(230, 275, 200, 200);	
		f.add(atualizar);
		atualizar.setBounds(320,400,100,50);
		f.add(voltar);
		voltar.setBounds(500, 400, 100, 50);
		
		listaFuncionarios.setFont(text);
		titulo.setFont(title);
		criar.setFont(but);
		atualizar.setFont(but);
		voltar.setFont(but);
		
		listaFuncionarios.addListSelectionListener(this);
		criar.addActionListener(this);
		atualizar.addActionListener(this);
		voltar.addActionListener(this);
	}
	
	


	@Override
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
		
		if(e.getValueIsAdjusting() && src==listaFuncionarios)
			new TelaDetalheFuncionario().exibeFuncionario(dados, listaFuncionarios.getSelectedIndex());
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		
		if(src == criar)
			new TelaDetalheFuncionario().adicionaFuncionario(1, dados);
		
		if(src == atualizar)
			listaFuncionarios.setListData(new ControleFuncionario(dados).getNomeFuncionario());
			listaFuncionarios.updateUI();
			
		if(src == voltar) {
			f.dispose();
		}
		
	}




	public JList<String> getListaFilmes() {
		return listaFuncionarios;
	}

	public void setListaFilmes(JList<String> listaFilmes) {
		this.listaFuncionarios = listaFilmes;
	} 
}