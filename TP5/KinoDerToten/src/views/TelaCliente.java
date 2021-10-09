package views;

import javax.swing.*;
import controller.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * A Classe <b>TelaCliente</b> é o front-end das configurações em relação à Clientes
 * @author Yago Milagres Passos
 *
 */
public class TelaCliente implements ActionListener, ListSelectionListener{
	private JFrame f = new JFrame("KDT - Clientes e Fidelidades");
	private JPanel p = new JPanel();
	private JLabel titulo = new JLabel("Clientes cadastrados com Fidelidade");
	private JLabel descr = new JLabel("Selecione da lista para exibir");
	private JLabel titulo2 = new JLabel("Níveis de Fidelidade:");
	private JLabel fide1 = new JLabel("1 (Básico)");
	private JLabel fide2 = new JLabel("2 (Intermediário)");
	private JLabel fide3 = new JLabel("3 (Avançado)");
	private JLabel mensalidade = new JLabel();
	private JLabel ingressos = new JLabel();
	private JLabel unidadesPermitidas = new JLabel();
	private JLabel unidadesAux = new JLabel();
	private JList<String> listaClientes;
	private String[] listaNomes = new String[20];
	private JTextField pesquisa = new JTextField();
	private JButton search = new JButton("Buscar");
	private	JButton criar = new JButton("Adicionar"); 
	private JButton atualizar = new JButton("Atualizar");
	private JButton voltar = new JButton("Voltar");
	private JButton back = new JButton("Voltar");
	private JButton butFide1 = new JButton("exibir");
	private JButton butFide2 = new JButton("exibir");
	private JButton butFide3 = new JButton("exibir");
	private static ImageIcon background = new ImageIcon("imgs/zombies.png");
	private static ImageIcon icone = new ImageIcon("imgs/icon_cliente.png");
	private static JLabel labelBackground = new JLabel();
	private static ControleDados dados;
	Font text2 = new Font("SansSerif", Font.PLAIN, 14);
	Font title2 = new Font("SansSerif", Font.BOLD, 16);
	Font but = new Font("SansSerif", Font.BOLD ,14);
	
	
	/**
	 * O Construtor <b>TelaCliente</b> Cria um JFrame Com Todas as configurações necessários em relacão à Clientes.
	 * Aqui temos a lista de clientes cadastrados, uma barra de pesquisa de nomes de clientes, um JPanel com informações das Fidelidades e uma opção de cadastrar um novo Cliente.
	 * @param d -> recebe instanca de ControleDados
	 */
	public TelaCliente(ControleDados d) {
		dados = d;
		Font text = new Font("SansSerif", Font.PLAIN, 18);
		Font title = new Font("SansSerif", Font.BOLD, 18);
		
		f.setIconImage(icone.getImage());
		
		f.setBounds(500,200,700,500);
		f.setLayout(new BorderLayout());
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
		f.add(p);
		p.setBounds(30,100,230,240);
		p.setLayout(null);
		
		f.add(titulo2);
		f.add(fide1);
		f.add(fide2);
		f.add(fide3);
		f.add(butFide1);
		f.add(butFide2);
		f.add(butFide3);
		titulo2.setBounds(10,10,200,50);
		fide1.setBounds(10,60,100,50);
		fide2.setBounds(10,110,130,50);
		fide3.setBounds(10,160,130,50);
		butFide1.setBounds(150,70,75,30);
		butFide2.setBounds(150,120,75,30);
		butFide3.setBounds(150,170,75,30);
		
		f.setIconImage(icone.getImage());
		
		titulo.setForeground(Color.white);
		descr.setForeground(Color.white);
		
		labelBackground.setIcon(background);
		f.add(labelBackground, BorderLayout.CENTER);		
		labelBackground.setPreferredSize(new Dimension(700,500));
		
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
		
		p.add(titulo2);
		p.add(fide1);
		p.add(fide2);
		p.add(fide3);
		p.add(butFide1);
		p.add(butFide2);
		p.add(butFide3);
		
		
		listaClientes.addListSelectionListener(this);
		criar.addActionListener(this);
		atualizar.addActionListener(this);
		voltar.addActionListener(this);
		search.addActionListener(this);
		butFide1.addActionListener(this);
		butFide2.addActionListener(this);
		butFide3.addActionListener(this);
	}
	
	/**
	 * Esse método, <b>exibeFidelidade</b>, Serve para demonstrar os detalhes de cada nível de Fidelidade.
	 * Não há edição de dados envolvida. Serve Somente para informar.
	 * @param op -> INdica de qual fidelidade exibir informações
	 */
	public void exibeFidelidade(int op) {
		f = new JFrame("Detalhes das Fidelidades");
		f.setBounds(650,200,400,500);
		f.setLayout(null);
		f.setResizable(false);
		f.setVisible(true);
		
		f.add(fide1);
		f.add(ingressos);
		f.add(mensalidade);
		f.add(unidadesPermitidas);
		f.add(unidadesAux);
		f.add(back);
		
		fide1.setBounds(50, 50, 300, 50);
		ingressos.setBounds(50, 100, 300, 50);
		mensalidade.setBounds(50, 150, 300, 50);
		unidadesPermitidas.setBounds(50, 200, 300, 50);
		unidadesAux.setBounds(50, 220, 300, 50);
		back.setBounds(250, 400, 100, 50);
		
		fide1.setFont(title2);
		ingressos.setFont(text2);
		mensalidade.setFont(text2);
		unidadesPermitidas.setFont(text2);
		unidadesAux.setFont(text2);
		
		if (op==1) {
			fide1.setText("Fidelidade Básica (1)");
			ingressos.setText("Ingressos disponíveis: 3");
			mensalidade.setText("Preço da mensalidade: R$90,00");
			unidadesPermitidas.setText("Unidades que podem ser utilizadas:");
			unidadesAux.setText("Apenas a de cadastro.");
		} else if (op==2) {
			fide1.setText("Fidelidade Média (2)");
			ingressos.setText("Ingressos disponíveis: 5");
			mensalidade.setText("Preço da mensalidade: R$120,00");
			unidadesPermitidas.setText("Unidades que podem ser utilizadas:");
			unidadesAux.setText("Apenas a de cadastro.");
		}else if (op==3) {
			fide1.setText("Fidelidade Avançada (3)");
			ingressos.setText("Ingressos disponíveis: 7");
			mensalidade.setText("Preço da mensalidade: R$150,00");
			unidadesPermitidas.setText("Unidades que podem ser utilizadas: Todas");
			unidadesAux.setText("");
		}
		
		back.setFont(but);
		back.addActionListener(this);
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
		if(src == back) {
			f.dispose();
		}
		
		if (src == search) {
			listaClientes.setListData(getListaFromSearch());
			listaClientes.updateUI();
		}
		
		if(src == butFide1) {
			exibeFidelidade(1);
		}
		if(src == butFide2) {
			exibeFidelidade(2);
		}
		if(src == butFide3) {
			exibeFidelidade(3);
		}
		
		
	}

	/**
	 * O método <b>getListaFromSearch</b> retorna uma lista de clientes com o mesmo nome pesquisado na JLabel pesquisa.
	 * @return Lista de clientes com o mesmo nome pesquisado na JLabel pesquisa
	 */
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


}
	

