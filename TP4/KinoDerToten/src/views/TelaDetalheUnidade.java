package views;

import javax.swing.*;
import controller.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaDetalheUnidade implements ActionListener{
	private JFrame f = new JFrame();
	//private JPanel p = new JPanel();
	private JLabel labelRegiao = new JLabel("Região:");
	private JLabel labelEndereco = new JLabel("Endereço:");
	private JLabel labelShopping = new JLabel("Shopping:");
	private JTextField valorRegiao = new JTextField();
	private JTextField valorEndereco = new JTextField();
	private JTextField valorShopping = new JTextField();
	private JButton butConclui = new JButton();
	private JButton butEditar = new JButton("Editar");
	private JButton butVoltar = new JButton("Voltar");
	private JButton butExcluir = new JButton("Excluir");
	private String[] novoDado = new String[10];
	private int posicao;
	private int opcao;
	Font text = new Font("SansSerif", Font.PLAIN, 18);
	Font but = new Font("SansSerif", Font.BOLD ,16);
	private static ControleDados dados;
	
	public void adicionaUnidade(int op, ControleDados d) {
		dados = d;
		opcao = op;
		f = new JFrame("KDT - Adição de Unidade");
		
		if (op==1) {
			butConclui.setText("Adicionar");
		}
		
		if (op==2) {
			labelRegiao.setText("Região:");
			labelEndereco.setText("Endereço:");
			labelShopping.setText("Shopping:");
			
			valorRegiao.setText(dados.getUnidades()[posicao].getRegiao());
			valorEndereco.setText(dados.getUnidades()[posicao].getEndereco());	
			valorShopping.setText(dados.getUnidades()[posicao].getShopping());
			butConclui.setText("Salvar");			
		}
			f.setVisible(true);
			f.setLayout(null);
			f.setBounds(550, 250, 500, 350);
			
			f.add(labelRegiao);
			f.add(labelEndereco);
			f.add(labelShopping);
					
			labelRegiao.setBounds(85, 10, 220, 30);
			labelEndereco.setBounds(60, 48, 220, 30);	
			labelShopping.setBounds(70, 86, 220, 30);
			
			labelRegiao.setFont(text);
			labelEndereco.setFont(text);
			labelShopping.setFont(text);
			
			f.add(valorRegiao);
			f.add(valorEndereco);
			f.add(valorShopping);
			valorRegiao.setBounds(220, 10, 250, 30);
			valorEndereco.setBounds(220, 48, 250, 30);		
			valorShopping.setBounds(220, 86, 250, 30);
			
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

	public void exibeUnidade(ControleDados d, int pos) {
		dados = d;
		posicao = pos;
		
		f = new JFrame("KDT - Detalhes de Unidade");
		f.setVisible(true);
		f.setLayout(null);
		f.setBounds(550,250, 500, 350);
		
		f.add(labelRegiao);
		f.add(labelEndereco);
		f.add(labelShopping);
		f.add(butEditar);
		f.add(butVoltar);
		f.add(butExcluir);
				
		labelRegiao.setBounds(180, 10, 400, 30);
		labelEndereco.setBounds(130, 48, 400, 30);	
		labelShopping.setBounds(150, 86, 400, 30);
		
		labelRegiao.setFont(text);
		labelEndereco.setFont(text);
		labelShopping.setFont(text);
		
		labelRegiao.setText(labelRegiao.getText()+" "+dados.getUnidades()[pos].getRegiao());
		labelEndereco.setText(labelEndereco.getText()+" "+dados.getUnidades()[pos].getEndereco());
		labelShopping.setText(labelShopping.getText()+" "+dados.getUnidades()[pos].getShopping());
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
			novoDado[1] = valorRegiao.getText();
			novoDado[2] = valorEndereco.getText();
			novoDado[3] = valorShopping.getText();
			
			dados.inserirEditarUnidade(novoDado);
			f.dispose();
		}
		
		if (src==butVoltar) {
			f.dispose();
		}
		
		if (src==butEditar) {
			f.dispose();
			adicionaUnidade(2, dados);	
		}
		
		if(src==butExcluir){
			dados.removerUnidade(posicao);
			f.dispose();
		}
	}

}