package views;

import javax.swing.*;
import controller.*;
import models.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaDetalheSessao implements ActionListener{
	private JFrame f = new JFrame();
	//private JPanel p = new JPanel();
	private JLabel labelFilme = new JLabel("Filme:");
	private JLabel labelHorario = new JLabel("Horario:");
	private JLabel labelUnidade = new JLabel("Unidade:");
	private JLabel labelSala = new JLabel("Sala:");
	private JLabel label3d = new JLabel("Tipo:");
	private JComboBox<String> valorFilme = new JComboBox<String>();
	private JTextField valorHorario = new JTextField();
	private JComboBox<String> valorUnidade = new JComboBox<String>();
	private JTextField valorSala = new JTextField();
	private JRadioButton sim3d = new JRadioButton("3D");
	private JRadioButton nao3d = new JRadioButton("Normal");
	private JComboBox<String> valorClassInd = new JComboBox<String>();
	private JButton butConclui = new JButton();
	private JButton butEditar = new JButton("Editar");
	private JButton butVoltar = new JButton("Voltar");
	private JButton butExcluir = new JButton("Excluir");
	private ButtonGroup radioGroup;
	private String[] novoDado = new String[10];
	private int posicao;
	private int opcao;
	Font text = new Font("SansSerif", Font.PLAIN, 18);
	Font but = new Font("SansSerif", Font.BOLD ,16);
	private static ControleDados dados;
	
	
	public void criaSessao(int op, ControleDados d) {
		dados = d;
		opcao = op;
		f = new JFrame("KDT - Criando de Sessão");
		
		if (op==1) {
			butConclui.setText("Adicionar");
		}
		
		if (op==2) {
			labelFilme.setText("Título:");
			labelHorario.setText("Lancamento:");
			labelUnidade.setText("Duaração:");
			labelSala.setText("Linguagem:");
			label3d.setText("Classificação Indicativa:");
			
			//valorFilme.setSelectedIndex(dados.getSessoes()[posicao].getFilme().getTitulo());
			valorHorario.setText(dados.getSessoes()[posicao].getHorario());	
			//valorUnidade.setSelectedIndex(String.valueOf(dados.getFilmes()[posicao].getDuracao()));
			valorSala.setText(dados.getSessoes()[posicao].getHorario());
			if(d.getSessoes()[posicao].getIs3d()) sim3d.setSelected(true);
			else nao3d.setSelected(true);
			
			butConclui.setText("Salvar");			
		}
			f.setVisible(true);
			f.setLayout(null);
			f.setBounds(550, 250, 500, 350);
			
			f.add(labelFilme);
			f.add(labelHorario);
			f.add(labelUnidade);
			f.add(labelSala);
			f.add(label3d);
					
			labelFilme.setBounds(85, 10, 220, 30);
			labelHorario.setBounds(75, 48, 220, 30);	
			labelUnidade.setBounds(70, 86, 220, 30);
			labelSala.setBounds(80, 124, 220, 30);
			label3d.setBounds(80, 162, 220, 30);
			
			labelFilme.setFont(text);
			labelHorario.setFont(text);
			labelUnidade.setFont(text);
			labelSala.setFont(text);
			label3d.setFont(text);
			
			f.add(valorFilme);
			f.add(valorHorario);
			f.add(valorUnidade);
			f.add(valorSala);
			f.add(sim3d);
			f.add(nao3d);
			valorFilme.setBounds(220, 10, 250, 30);
			valorHorario.setBounds(220, 48, 250, 30);		
			valorUnidade.setBounds(220, 86, 250, 30);
			valorSala.setBounds(220, 124, 250, 30);
			sim3d.setBounds(220, 162, 100, 30);
			nao3d.setBounds(320, 162, 250, 30);
			
			radioGroup = new ButtonGroup();
			radioGroup.add(sim3d);
			radioGroup.add(nao3d);
			
			preencheComboBox();
			
			f.add(butVoltar);
			f.add(butConclui);
			butConclui.setBounds(200, 250, 120, 40);
			butVoltar.setText("Cancelar");
			butVoltar.setBounds(350, 250, 120, 40);

			butConclui.setFont(but);
			butVoltar.setFont(but);
			
			butConclui.addActionListener(this);
			butVoltar.addActionListener(this);
	}
	
	public void exibeSessao(ControleDados d, int pos) {
		dados = d;
		posicao = pos;
		
		f = new JFrame("KDT - Detalhes de filme");
		f.setVisible(true);
		f.setLayout(null);
		f.setBounds(550,250, 500, 350);
		
		f.add(labelFilme);
		f.add(labelHorario);
		f.add(labelUnidade);
		f.add(labelSala);
		f.add(label3d);
		f.add(butEditar);
		f.add(butVoltar);
		f.add(butExcluir);
				
		labelFilme.setBounds(200, 10, 400, 30);
		labelHorario.setBounds(180, 48, 400, 30);	
		labelUnidade.setBounds(170, 86, 400, 30);
		labelSala.setBounds(200, 124, 400, 30);
		label3d.setBounds(200, 162, 400, 30);
		
		labelFilme.setFont(text);
		labelHorario.setFont(text);
		labelUnidade.setFont(text);
		labelSala.setFont(text);
		label3d.setFont(text);
		
		labelFilme.setText(labelFilme.getText()+" "+dados.getSessoes()[pos].getFilme().getTitulo());
		labelHorario.setText(labelHorario.getText()+" "+dados.getSessoes()[pos].getHorario());
		labelUnidade.setText(labelUnidade.getText()+" "+dados.getSessoes()[pos].getUnidade().getShopping());
		labelSala.setText(labelSala.getText()+" "+dados.getSessoes()[pos].getNumeroSala());
		label3d.setText(label3d.getText()+" "+dados.getSessoes()[pos].getTipo3d());
		
		butEditar.setBounds(200, 250, 100, 40);
		butVoltar.setBounds(350, 250, 100, 40);
		butExcluir.setBounds(80, 250, 100, 40);
		
		butEditar.setFont(but);
		butVoltar.setFont(but);
		butExcluir.setFont(but);
		butExcluir.setBackground(Color.RED);
		
		butEditar.addActionListener(this);
		butVoltar.addActionListener(this);
		butExcluir.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if (src==butConclui) {
			if (opcao==1) {
				novoDado[0] = Integer.toString(dados.getQtdFilmes());
			}
			if (opcao==2) {
				novoDado[0] = Integer.toString(posicao);
			}
			novoDado[1] = valorFilme.getSelectedItem().toString();
			novoDado[2] = valorHorario.getText();
			//novoDado[3] = valorUnidade.getSelectedItem().toString();
			novoDado[3] = "shopping3";
			novoDado[4] = valorSala.getText();
			if (sim3d.isSelected()) novoDado[5] ="1";
			else if (nao3d.isSelected()) novoDado[5] = "0";
			dados.inserirEditarFilme(novoDado);
			f.dispose();
		}
		
		if (src==butVoltar) {
			f.dispose();
		}
		
		if (src==butEditar) {
			f.dispose();
			criaSessao(2, dados);	
		}
		
		if(src==butExcluir){
			dados.removerFilme(posicao);
			f.dispose();
		}
		
	}
	
	public void preencheComboBox() {
		for (int i=0; i<5; i++) { 
			valorFilme.addItem(dados.getFilmes()[i].getTitulo());
			valorUnidade.addItem(dados.getUnidades()[i].getShopping());
		}
	}

	public String retornaValueComboBox(int alterna) {
		String retorna="0";
		
		if (alterna==1) {
		} else {
			//if (valorClassInd.getSelectedIndex() == 0) retorna = 0;
			if (valorClassInd.getSelectedIndex() == 1) retorna = "1";
			if (valorClassInd.getSelectedIndex() == 2) retorna = "2";
			if (valorClassInd.getSelectedIndex() == 3) retorna = "3";
			if (valorClassInd.getSelectedIndex() == 4) retorna = "4";
			if (valorClassInd.getSelectedIndex() == 5) retorna = "5";
		}
		return retorna;
	}

}
