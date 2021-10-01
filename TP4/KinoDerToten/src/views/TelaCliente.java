package views;

import javax.swing.*;
import controller.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TelaCliente implements ActionListener, ListSelectionListener{
	private JFrame f = new JFrame("KDT - Clientes e Fidelidades");
	private JLabel titulo = new JLabel("Clientes cadastrados com Fidelidade");
	private JLabel descr = new JLabel("Selecione da lista para exibir");
	private JList<String> listaClientes;
	private String[] listaNomes = new String[20];
	private JTextField pesquisa = new JTextField();
	private JButton search = new JButton("Buscar");
	private	JButton criar = new JButton("Adicionar"); 
	private JButton atualizar = new JButton("Atualizar");
	private JButton voltar = new JButton("Voltar");
	private static ControleDados dados;
	
	
	public TelaCliente(ControleDados d) {
		dados = d;
		Font text = new Font("SansSerif", Font.PLAIN, 18);
		Font title = new Font("SansSerif", Font.BOLD, 22);
		Font but = new Font("SansSerif", Font.BOLD ,14);
		
		f.setBounds(500,200,700,500);
		f.setLayout(null);
		f.setVisible(true);
		
		listaNomes = new ControleCliente(dados).getNomeCliente();
		listaClientes = new JList<String>(listaNomes); 
		
		f.add(titulo);
		titulo.setBounds(150,0,400,50);
		f.add(listaClientes);
		listaClientes.setBounds(225,100,200,260);
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
		
		listaClientes.setFont(text);
		titulo.setFont(title);
		criar.setFont(but);
		atualizar.setFont(but);
		voltar.setFont(but);
		
		listaClientes.addListSelectionListener(this);
		criar.addActionListener(this);
		atualizar.addActionListener(this);
		voltar.addActionListener(this);
		search.addActionListener(this);
	}
	
	


	@Override
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
		
		if(e.getValueIsAdjusting() && src==listaClientes)
			new TelaDetalheFilme().exibeFilme(dados, listaClientes.getSelectedIndex());
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		
		if(src == criar)
			new TelaDetalheFilme().adicionaFilme(1, dados);
		
		if(src == atualizar)
			listaClientes.setListData(new ControleCliente(dados).getNomeCliente());
			listaClientes.updateUI();
			
		if(src == voltar) {
			f.dispose();
		}
		
		if (src == search) {
			listaClientes.setListData(getListaFromSearch());
			listaClientes.updateUI();
		}
		
		
	}

	
	public String[] getListaFromSearch() {
		String[] listaNomesPesquisa = new String[20];
		
		for (int i=0; i<5; i++) {
			
			if(pesquisa.getText().compareTo(listaNomes[i])==0) {
				listaNomesPesquisa[i] = listaNomes[i];
			}
		}
		
		return listaNomesPesquisa;
	}



	public JList<String> getListaFilmes() {
		return listaClientes;
	}

	public void setListaFilmes(JList<String> listaFilmes) {
		this.listaClientes = listaFilmes;
	}

}
	

