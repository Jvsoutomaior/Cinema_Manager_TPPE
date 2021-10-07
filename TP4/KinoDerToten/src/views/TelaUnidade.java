package views;

import javax.swing.*;
import controller.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TelaUnidade implements ActionListener, ListSelectionListener{
	private JFrame f = new JFrame("KDT - Unidades");
	private JLabel titulo = new JLabel("Filmes em Cartaz:");
	private JLabel descr = new JLabel("Selecione da lista para exibir");
	private JList<String> listaUnidades;
	private String[] listaShoppings = new String[20];
	private	JButton criar = new JButton("Adicionar"); 
	private JButton atualizar = new JButton("Atualizar");
	private JButton voltar = new JButton("Voltar");
	private static ControleDados dados;
	
	
	public TelaUnidade (ControleDados d) {
		dados = d;
		Font text = new Font("SansSerif", Font.PLAIN, 18);
		Font title = new Font("SansSerif", Font.BOLD, 26);
		Font but = new Font("SansSerif", Font.BOLD ,14);
		
		f.setBounds(500,200,700,500);
		f.setLayout(null);
		f.setVisible(true);
		
		listaShoppings = new ControleUnidade(dados).getShoppingUnidade();
		listaUnidades = new JList<String>(listaShoppings); 
		
		f.add(titulo);
		titulo.setBounds(210,-70,300,250);
		f.add(listaUnidades);
		listaUnidades.setBounds(225,100,200,260);
		f.add(criar);	
		criar.setBounds(210,400,100,50);
		f.add(descr);
		descr.setBounds(230, 275, 200, 200);	
		f.add(atualizar);
		atualizar.setBounds(320,400,100,50);
		f.add(voltar);
		voltar.setBounds(500, 400, 100, 50);
		
		listaUnidades.setFont(text);
		titulo.setFont(title);
		criar.setFont(but);
		atualizar.setFont(but);
		voltar.setFont(but);
		
		listaUnidades.addListSelectionListener(this);
		criar.addActionListener(this);
		atualizar.addActionListener(this);
		voltar.addActionListener(this);
	}
	
	


	@Override
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
		
		if(e.getValueIsAdjusting() && src==listaUnidades)
			new TelaDetalheUnidade().exibeUnidade(dados, listaUnidades.getSelectedIndex());
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		
		if(src == criar)
			new TelaDetalheUnidade().adicionaUnidade(1, dados);
		
		if(src == atualizar)
			listaUnidades.setListData(new ControleUnidade(dados).getShoppingUnidade());
			listaUnidades.updateUI();
			
		if(src == voltar) {
			f.dispose();
		}
		
	}




	public JList<String> getListaUnidades() {
		return listaUnidades;
	}

	public void setListaUnidades(JList<String> listaUnidades) {
		this.listaUnidades = listaUnidades;
	} 
}