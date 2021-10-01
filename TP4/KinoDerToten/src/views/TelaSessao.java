package views;

import javax.swing.*;
import controller.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TelaSessao implements ActionListener, ListSelectionListener{
	private JFrame f = new JFrame("KDT - Sessões");
	private JLabel titulo = new JLabel("Sessões");
	private JList<String> listaSessoes;
	private String[] listaDetalhes = new String[50];
	private	JButton criar = new JButton("Criar"); 
	private JButton atualizar = new JButton("Atualizar");
	private JButton voltar = new JButton("Voltar");
	private static ControleDados dados;
	
	Font text = new Font("SansSerif", Font.PLAIN, 18);
	Font title = new Font("SansSerif", Font.BOLD, 26);
	Font but = new Font("SansSerif", Font.BOLD ,14);
	
	
	public TelaSessao(ControleDados d) {
		dados = d;
		
		f.setBounds(500,200,700,500);
		f.setLayout(null);
		f.setVisible(true);
		
		listaDetalhes = new ControleSessao(dados).displaySessaoOnJList();
		listaSessoes = new JList<String>(listaDetalhes); 
		
		f.add(titulo);
		titulo.setBounds(280,-70,300,250);
		f.add(listaSessoes);
		listaSessoes.setBounds(50,100,600,260);
		f.add(criar);	
		criar.setBounds(210,400,100,50);
		//f.add(descr);
		//descr.setBounds(230, 275, 200, 200);	
		f.add(atualizar);
		atualizar.setBounds(320,400,100,50);
		f.add(voltar);
		voltar.setBounds(500, 400, 100, 50);
		
		
		listaSessoes.setFont(text);
		titulo.setFont(title);
		criar.setFont(but);
		atualizar.setFont(but);
		voltar.setFont(but);
		
		listaSessoes.addListSelectionListener(this);
		criar.addActionListener(this);
		atualizar.addActionListener(this);
		voltar.addActionListener(this);
	}
	
	
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
		
		if(e.getValueIsAdjusting() && src==listaSessoes)
			new TelaDetalheSessao().exibeSessao(dados, listaSessoes.getSelectedIndex());
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		
		if(src == criar)
			new TelaDetalheSessao().criaSessao(1, dados);
		
		if(src == atualizar)
			listaSessoes.setListData(new ControleSessao(dados).displaySessaoOnJList());
			listaSessoes.updateUI();
			
		if(src == voltar) {
			f.dispose();
		}
		
	}
	
}
