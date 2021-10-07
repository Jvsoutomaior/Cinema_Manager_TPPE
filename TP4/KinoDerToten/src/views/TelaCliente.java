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
	private JLabel titulo2 = new JLabel("Níveis de Fidelidade:");
	private JLabel fide1 = new JLabel("1 (Básico)");
	private JLabel fide2 = new JLabel("2 (Intermediário)");
	private JLabel fide3 = new JLabel("3 (Avançado)");
	private JList<String> listaClientes;
	private String[] listaNomes = new String[20];
	private JTextField pesquisa = new JTextField();
	private JButton search = new JButton("Buscar");
	private	JButton criar = new JButton("Adicionar"); 
	private JButton atualizar = new JButton("Atualizar");
	private JButton voltar = new JButton("Voltar");
	private JButton butFide1 = new JButton("exibir");
	private JButton butFide2 = new JButton("exibir");
	private JButton butFide3 = new JButton("exibir");
	private static ImageIcon background = new ImageIcon("imgs/KinoDerToten3.png");
	private static ImageIcon icone = new ImageIcon("imgs/icon_cliente.png");
	private static JLabel labelBackground = new JLabel();
	private static ControleDados dados;
	
	
	public TelaCliente(ControleDados d) {
		dados = d;
		Font text = new Font("SansSerif", Font.PLAIN, 18);
		Font title = new Font("SansSerif", Font.BOLD, 18);
		Font but = new Font("SansSerif", Font.BOLD ,14);
		
		f.setIconImage(icone.getImage());
		
		f.setBounds(500,200,700,500);
		f.setLayout(null);
		f.setResizable(false);
		f.setVisible(true);
		
		listaNomes = new ControleCliente(dados).getNomeCliente();
		listaClientes = new JList<String>(listaNomes); 
		
		f.add(titulo);
		titulo.setBounds(280,0,400,50);
		f.add(listaClientes);
		listaClientes.setBounds(325,100,200,260);
		f.add(criar);	
		criar.setBounds(260,400,100,50);
		f.add(descr);
		descr.setBounds(330, 275, 200, 200);	
		f.add(atualizar);
		atualizar.setBounds(370,400,100,50);
		f.add(voltar);
		voltar.setBounds(550, 400, 100, 50);
		f.add(pesquisa);
		pesquisa.setBounds(310,50,200,35);
		f.add(search);
		search.setBounds(520,50,75,35);
		
		f.add(titulo2);
		f.add(fide1);
		f.add(fide2);
		f.add(fide3);
		f.add(butFide1);
		f.add(butFide2);
		f.add(butFide3);
		titulo2.setBounds(30,80,200,50);
		fide1.setBounds(30,130,100,50);
		fide2.setBounds(30,180,130,50);
		fide3.setBounds(30,230,130,50);
		butFide1.setBounds(180,140,75,30);
		butFide2.setBounds(180,190,75,30);
		butFide3.setBounds(180,240,75,30);
		
		listaClientes.setFont(text);
		titulo.setFont(title);
		titulo2.setFont(title);
		criar.setFont(but);
		atualizar.setFont(but);
		voltar.setFont(but);
		fide1.setFont(text);
		fide2.setFont(text);
		fide3.setFont(text);
		butFide1.setFont(but);
		butFide2.setFont(but);
		butFide3.setFont(but);
		
		listaClientes.addListSelectionListener(this);
		criar.addActionListener(this);
		atualizar.addActionListener(this);
		voltar.addActionListener(this);
		search.addActionListener(this);
		butFide1.addActionListener(this);
		butFide2.addActionListener(this);
		butFide3.addActionListener(this);
	}
	
	public void exibeFidelidade() {
		f = new JFrame("Detalhes das Fidelidades");
		f.setBounds(650,200,400,500);
		f.setLayout(null);
		f.setResizable(false);
		f.setVisible(true);
		
	}


	@Override
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
		
		if(e.getValueIsAdjusting() && src==listaClientes)
			new TelaDetalheCliente().exibeCliente(dados, listaClientes.getSelectedIndex());
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		
		if(src == criar)
			new TelaDetalheCliente().adicionaCliente(1, dados);
		
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
		
		if(src == butFide1) {
			exibeFidelidade();
		}
		if(src == butFide2) {
			exibeFidelidade();
		}
		if(src == butFide3) {
			exibeFidelidade();
		}
		
		
	}

	
	public String[] getListaFromSearch() {
		String[] listaNomesPesquisa = new String[20];
		
		listaNomes = new ControleCliente(dados).getNomeCliente();
		
		for (int i=0; i<dados.getQtdClientes(); i++) {
			
			if(pesquisa.getText().compareTo(listaNomes[i])==0) {
				listaNomesPesquisa[i] = listaNomes[i];
			}
		}
		
		return listaNomesPesquisa;
	}



	public JList<String> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(JList<String> listaFilmes) {
		this.listaClientes = listaFilmes;
	}

}
	

