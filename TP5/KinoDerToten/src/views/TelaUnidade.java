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
 * Classe <b>TelaUnidade</b>
 * @author Yago Milagres Passos
 *
 */
public class TelaUnidade implements ActionListener, ListSelectionListener{
	private JFrame f = new JFrame("KDT - Unidades");
	private JLabel titulo = new JLabel("Nossas unidades:");
	private JLabel descr = new JLabel("Selecione da lista para exibir");
	private JList<String> listaUnidades;
	private String[] listaShoppings = new String[20];
	private	JButton criar = new JButton("Adicionar"); 
	private JButton atualizar = new JButton("Atualizar");
	private JButton voltar = new JButton("Voltar");
	private static ImageIcon background = new ImageIcon("imgs/KinoDerToten.png");
	private static ImageIcon icone = new ImageIcon("imgs/icon.png");
	private static JLabel labelBackground = new JLabel();
	private static ControleDados dados;
	
	/**
	 * Construtor da classe <b>TelaUnidade</b>. Aqui temos um JFrame com as Unidades listadas, com a opção de editá-las ou adicionar uma nova.
	 * @param d -> recebe instancia de ControleDados
	 */
	public TelaUnidade (ControleDados d) {
		dados = d;
		Font text = new Font("SansSerif", Font.PLAIN, 18);
		Font title = new Font("SansSerif", Font.BOLD, 26);
		Font but = new Font("SansSerif", Font.BOLD ,14);
		
		f.setBounds(500,200,700,500);
		f.setLayout(new BorderLayout());
		f.setVisible(true);
		f.setResizable(false);
		
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
		
		f.setIconImage(icone.getImage());
		
		titulo.setForeground(Color.white);
		descr.setForeground(Color.white);
		
		labelBackground.setIcon(background);
		f.add(labelBackground, BorderLayout.CENTER);		
		labelBackground.setPreferredSize(new Dimension(700,500));
		
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


}