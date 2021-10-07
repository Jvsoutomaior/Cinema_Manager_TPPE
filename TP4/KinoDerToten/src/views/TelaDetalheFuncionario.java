package views;

import javax.swing.*;
import controller.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaDetalheFuncionario implements ActionListener{
	private JFrame f ;
	//private JPanel p = new JPanel();
	private JLabel labelNome = new JLabel("Nome:");
	private JLabel labelCpf = new JLabel("CPF:");
	private JLabel labelDataNasc = new JLabel("Data de Nascimento:");
	private JLabel labelUnidade = new JLabel("Unidade de cadastro:");
	private JLabel labelEmail = new JLabel("Email:");
	private JLabel labelTurno = new JLabel("Turno:");
	private JLabel labelSalario = new JLabel("Salário:");
	private JTextField valorNome = new JTextField();
	private JTextField valorCpf = new JTextField();
	private JTextField valorDataNasc = new JTextField();
	private JComboBox<String> valorUnidade = new JComboBox<String>();
	private JTextField valorEmail = new JTextField();
	private JRadioButton valorTurnoTarde = new JRadioButton("Tarde");
	private JRadioButton valorTurnoNoite = new JRadioButton("Noite");
	private JTextField valorSalario = new JTextField();
	private JButton butConclui = new JButton();
	private JButton butEditar = new JButton("Editar");
	private JButton butVoltar = new JButton("Voltar");
	private JButton butExcluir = new JButton("Excluir");
	private ButtonGroup radioGroup;
	private String[] novoDado = new String[10];
	private int posicao;
	private int opcao;
	private static ControleDados dados;
	Font text = new Font("SansSerif", Font.PLAIN, 18);
	Font but = new Font("SansSerif", Font.BOLD ,16);
	
	public void adicionaFuncionario(int op, ControleDados d) {
		dados = d;
		opcao = op;
		f = new JFrame("KDT - Contrato de Funcionario");
		
		preencheComboBox();
		
		if (op==1) {
			butConclui.setText("Contratar");
		}
		
		if (op==2) {
			labelNome.setText("Nome:");
			labelCpf.setText("CPF:");
			labelDataNasc.setText("Data de Nascimento:");
			labelUnidade.setText("Unidade de cadastro:");
			labelEmail.setText("Email:");
			labelTurno.setText("Turno:");
			labelSalario.setText("Salario:");
			
			valorNome.setText(dados.getFuncionarios()[posicao].getNome());
			valorCpf.setText(dados.getFuncionarios()[posicao].getCpf());	
			valorDataNasc.setText(dados.getFuncionarios()[posicao].getDataNasc());
			valorUnidade.setSelectedItem(dados.getFuncionarios()[posicao].getUnidade().getShopping());			
			valorEmail.setText(dados.getFuncionarios()[posicao].getEmail());
			if(d.getFuncionarios()[posicao].getTurno()=="Tarde") valorTurnoTarde.setSelected(true);
			if(d.getFuncionarios()[posicao].getTurno()=="Noite") valorTurnoNoite.setSelected(true);
			valorSalario.setText(dados.getFuncionarios()[posicao].getSalario());
			
			butConclui.setText("Salvar");			
		}
			f.setVisible(true);
			f.setLayout(null);
			f.setBounds(550, 250, 500, 380);
			
			f.add(labelNome);
			f.add(labelCpf);
			f.add(labelDataNasc);
			f.add(labelUnidade);
			f.add(labelEmail);
			f.add(labelTurno);
			f.add(labelSalario);
					
			labelNome.setBounds(145, 10, 220, 30);
			labelCpf.setBounds(150, 48, 220, 30);	
			labelDataNasc.setBounds(30, 86, 220, 30);
			labelUnidade.setBounds(30, 124, 220, 30);
			labelEmail.setBounds(145, 162, 220, 30);
			labelTurno.setBounds(145, 200, 220, 30);
			labelSalario.setBounds(140, 238, 220, 30);
			
			labelNome.setFont(text);
			labelCpf.setFont(text);
			labelDataNasc.setFont(text);
			labelUnidade.setFont(text);
			labelEmail.setFont(text);
			labelTurno.setFont(text);
			labelSalario.setFont(text);
			
			f.add(valorNome);
			f.add(valorCpf);
			f.add(valorDataNasc);
			f.add(valorUnidade);
			f.add(valorEmail);
			f.add(valorTurnoTarde);
			f.add(valorTurnoNoite);
			f.add(valorSalario);
			valorNome.setBounds(220, 10, 250, 30);
			valorCpf.setBounds(220, 48, 250, 30);		
			valorDataNasc.setBounds(220, 86, 250, 30);
			valorUnidade.setBounds(220, 124, 250, 30);
			valorEmail.setBounds(220, 162, 250, 30);
			valorTurnoTarde.setBounds(220, 200, 80, 30);
			valorTurnoNoite.setBounds(300, 200, 80, 30);
			valorSalario.setBounds(220, 238, 250, 30);
			
			radioGroup = new ButtonGroup();
			radioGroup.add(valorTurnoTarde);
			radioGroup.add(valorTurnoNoite);
			
			f.add(butVoltar);
			f.add(butConclui);
			butConclui.setBounds(200, 280, 120, 40);
			butVoltar.setText("Cancelar");
			butVoltar.setBounds(350, 280, 120, 40);

			butConclui.setFont(but);
			butVoltar.setFont(but);
			
			butConclui.addActionListener(this);
			butVoltar.addActionListener(this);
	}

	public void exibeFuncionario(ControleDados d/*, int pos*/) {
		dados = d;
		//posicao = pos;
		
		f = new JFrame("KDT - Detalhes de Funcionario");
		f.setVisible(true);
		f.setLayout(null);
		f.setBounds(550,250, 500, 380);
		
		f.add(labelNome);
		f.add(labelCpf);
		f.add(labelDataNasc);
		f.add(labelUnidade);
		f.add(labelEmail);
		f.add(labelTurno);
		f.add(labelSalario);
		f.add(butEditar);
		f.add(butVoltar);
		f.add(butExcluir);
				
		labelNome.setBounds(180, 10, 400, 30);
		labelCpf.setBounds(170, 48, 400, 30);	
		labelDataNasc.setBounds(50, 86, 400, 30);
		labelUnidade.setBounds(40, 124, 400, 30);
		labelEmail.setBounds(170, 162, 400, 30);
		labelTurno.setBounds(170, 200, 400, 30);
		labelSalario.setBounds(160, 240, 400, 30);
		
		labelNome.setFont(text);
		labelCpf.setFont(text);
		labelDataNasc.setFont(text);
		labelUnidade.setFont(text);
		labelEmail.setFont(text);
		labelTurno.setFont(text);
		labelSalario.setFont(text);
		/*
		labelNome.setText(labelNome.getText()+" "+dados.getFuncionarios()[pos].getNome());
		labelCpf.setText(labelCpf.getText()+" "+dados.getFuncionarios()[pos].getCpf());
		labelDataNasc.setText(labelDataNasc.getText()+" "+dados.getFuncionarios()[pos].getDataNasc());
		labelUnidade.setText(labelUnidade.getText()+" "+dados.getFuncionarios()[pos].getUnidade().getShopping());
		labelEmail.setText(labelEmail.getText()+" "+dados.getFuncionarios()[pos].getEmail());
		labelTurno.setText(labelTurno.getText()+" "+dados.getFuncionarios()[pos].getTurno());
		labelSalario.setText(labelSalario.getText()+" "+dados.getFuncionarios()[pos].getSalario());
		*/
		butEditar.setBounds(200, 280, 100, 40);
		butVoltar.setBounds(350, 280, 100, 40);
		butExcluir.setBounds(80, 280, 100, 40);
		
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
				novoDado[0] = Integer.toString(dados.getQtdFuncionarios());
			}
			if (opcao==2) {
				novoDado[0] = Integer.toString(posicao);
			}
			novoDado[1] = valorNome.getText();
			novoDado[2] = valorCpf.getText();
			novoDado[3] = valorDataNasc.getText();
			novoDado[4] = valorUnidade.getSelectedItem().toString();
			novoDado[5] = valorEmail.getText();
			if(valorTurnoTarde.isSelected()) {
				novoDado[6] = "Tarde";
			} else if (valorTurnoNoite.isSelected()) {
				novoDado[6] = "Noite";
			}
			novoDado[7] = valorSalario.getText();
			
			dados.inserirEditarFuncionario(novoDado);
			f.dispose();
		}
		
		if (src==butVoltar) {
			f.dispose();
		}
		
		if (src==butEditar) {
			f.dispose();
			//adicionaFuncionario(2, dados);	
		}
		
		if(src==butExcluir){
			dados.removerFuncionario(posicao);
			f.dispose();
		}
	}

	public void preencheComboBox() {
		for (int i=0; i<5; i++) {
			valorUnidade.addItem(dados.getUnidades()[i].getShopping());
		}
	}
	
}
