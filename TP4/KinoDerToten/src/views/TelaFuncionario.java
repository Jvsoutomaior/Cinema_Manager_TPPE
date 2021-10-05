package views;

import javax.swing.*;
import controller.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TelaFuncionario implements ActionListener, ListSelectionListener{
	private JFrame f = new JFrame("KDT - Funcionários");
	private JLabel titulo = new JLabel("Nossos Funcionários");
	private JLabel descr = new JLabel("Selecione da lista para exibir");
	private JList<String> listaFuncionarios;
	private String[] listaNomes = new String[20];
	private JTextField pesquisa = new JTextField();
	private JButton search = new JButton("Buscar");
	private	JButton criar = new JButton("Adicionar"); 
	private JButton atualizar = new JButton("Atualizar");
	private JButton voltar = new JButton("Voltar");
	private static ControleDados dados;
	
	
	public TelaFuncionario(ControleDados d) {
		dados = d;
		Font text = new Font("SansSerif", Font.PLAIN, 18);
		Font title = new Font("SansSerif", Font.BOLD, 22);
		Font but = new Font("SansSerif", Font.BOLD ,14);
		
		f.setBounds(500,200,700,500);
		f.setLayout(null);
		f.setVisible(true);
		
		listaNomes = new ControleFuncionario(dados).getNomeFuncionario();
		listaFuncionarios = new JList<String>(listaNomes); 
		
		f.add(titulo);
		titulo.setBounds(150,0,400,50);
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
		f.add(pesquisa);
		pesquisa.setBounds(210,50,200,35);
		f.add(search);
		search.setBounds(420,50,75,35);
		
		listaFuncionarios.setFont(text);
		titulo.setFont(title);
		criar.setFont(but);
		atualizar.setFont(but);
		voltar.setFont(but);
		
		listaFuncionarios.addListSelectionListener(this);
		criar.addActionListener(this);
		atualizar.addActionListener(this);
		voltar.addActionListener(this);
		search.addActionListener(this);
		
	}
	
	


	@Override
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
		
		if(e.getValueIsAdjusting() && src==listaFuncionarios);
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
		
		if (src == search) {
			listaFuncionarios.setListData(getListaFromSearch());
			listaFuncionarios.updateUI();
		}
		
		
	}

	
	public String[] getListaFromSearch() {
		String[] listaNomesPesquisa = new String[20];
		
		listaNomes = new ControleFuncionario(dados).getNomeFuncionario();
		
		for (int i=0; i<dados.getQtdFuncionarios(); i++) {
			
			if(pesquisa.getText().compareTo(listaNomes[i])==0) {
				listaNomesPesquisa[i] = listaNomes[i];
			}
		}
		
		return listaNomesPesquisa;
	}



	public JList<String> getListaFuncionarios() {
		return listaFuncionarios;
	}

	public void setListaFuncionarios(JList<String> listaFilmes) {
		this.listaFuncionarios = listaFilmes;
	}

}
	

