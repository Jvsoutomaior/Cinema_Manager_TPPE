package views;

import javax.swing.*;
import controller.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaDetalheCliente implements ActionListener{
	private JFrame f = new JFrame();
	//private JPanel p = new JPanel();
	private JLabel labelNome = new JLabel("Nome:");
	private JLabel labelCpf = new JLabel("CPF:");
	private JLabel labelDataNasc = new JLabel("Data de Nascimento:");
	private JLabel labelUnidade = new JLabel("Unidade de cadastro:");
	private JLabel labelEmail = new JLabel("Email:");
	private JLabel labelFidelidade = new JLabel("Nível de Fidelidade:");
	private JTextField valorNome = new JTextField();
	private JTextField valorCpf = new JTextField();
	private JTextField valorDataNasc = new JTextField();
	private JComboBox<String> valorUnidade = new JComboBox<String>();
	private JTextField valorEmail = new JTextField();
	private JRadioButton valorFide1 = new JRadioButton("1");
	private JRadioButton valorFide2 = new JRadioButton("2");
	private JRadioButton valorFide3 = new JRadioButton("3");
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
	private static ImageIcon background = new ImageIcon("imgs/KinoDerToten3.png");
	private static ImageIcon icone = new ImageIcon("imgs/icon_cliente.png");
	private static JLabel labelBackground = new JLabel();
	private static ControleDados dados;
	
	public void adicionaCliente(int op, ControleDados d) {
		dados = d;
		opcao = op;
		f = new JFrame("KDT - Adição de Cliente");
		f.setIconImage(icone.getImage());

		preencheComboBox();
		
		if (op==1) {
			butConclui.setText("Adicionar");
		}
		
		if (op==2) {
			labelNome.setText("Nome:");
			labelCpf.setText("CPF:");
			labelDataNasc.setText("Data de Nascimento:");
			labelUnidade.setText("Unidade de cadastro:");
			labelEmail.setText("Email:");
			labelFidelidade.setText("Nível de Fidelidade:");
			
			valorNome.setText(dados.getClientes()[posicao].getNome());
			valorCpf.setText(dados.getClientes()[posicao].getCpf());	
			valorDataNasc.setText(dados.getClientes()[posicao].getDataNasc());
			valorUnidade.setSelectedItem(dados.getClientes()[posicao].getUnidade().getShopping());			
			valorEmail.setText(dados.getClientes()[posicao].getEmail());
			if(d.getClientes()[posicao].getFidelidade()==1) valorFide1.setSelected(true);
			if(d.getClientes()[posicao].getFidelidade()==2) valorFide2.setSelected(true);
			if(d.getClientes()[posicao].getFidelidade()==3) valorFide3.setSelected(true);
			
			butConclui.setText("Salvar");			
		}
			f.setVisible(true);
			f.setLayout(null);
			f.setBounds(550, 250, 500, 350);
			
			f.add(labelNome);
			f.add(labelCpf);
			f.add(labelDataNasc);
			f.add(labelUnidade);
			f.add(labelEmail);
			f.add(labelFidelidade);
					
			labelNome.setBounds(85, 10, 220, 30);
			labelCpf.setBounds(120, 48, 220, 30);	
			labelDataNasc.setBounds(30, 86, 220, 30);
			labelUnidade.setBounds(30, 124, 220, 30);
			labelEmail.setBounds(125, 162, 220, 30);
			labelFidelidade.setBounds(20, 200, 220, 30);
			
			labelNome.setFont(text);
			labelCpf.setFont(text);
			labelDataNasc.setFont(text);
			labelUnidade.setFont(text);
			labelEmail.setFont(text);
			labelFidelidade.setFont(text);
			
			f.add(valorNome);
			f.add(valorCpf);
			f.add(valorDataNasc);
			f.add(valorUnidade);
			f.add(valorEmail);
			f.add(valorFide1);
			f.add(valorFide2);
			f.add(valorFide3);
			valorNome.setBounds(220, 10, 250, 30);
			valorCpf.setBounds(220, 48, 250, 30);		
			valorDataNasc.setBounds(220, 86, 250, 30);
			valorUnidade.setBounds(220, 124, 250, 30);
			valorEmail.setBounds(220, 162, 250, 30);
			valorFide1.setBounds(220, 200, 50, 30);
			valorFide2.setBounds(280, 200, 50, 30);
			valorFide3.setBounds(340, 200, 50, 30);
			
			radioGroup = new ButtonGroup();
			radioGroup.add(valorFide1);
			radioGroup.add(valorFide2);
			radioGroup.add(valorFide3);
			
			
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

	public void exibeCliente(ControleDados d, int pos) {
		dados = d;
		posicao = pos;
		
		f = new JFrame("KDT - Detalhes de Cliente");
		f.setVisible(true);
		f.setLayout(null);
		f.setBounds(550,250, 500, 350);
		f.setIconImage(icone.getImage());
		
		f.add(labelNome);
		f.add(labelCpf);
		f.add(labelDataNasc);
		f.add(labelUnidade);
		f.add(labelEmail);
		f.add(labelFidelidade);
		f.add(butEditar);
		f.add(butVoltar);
		f.add(butExcluir);
				
		labelNome.setBounds(180, 10, 400, 30);
		labelCpf.setBounds(170, 48, 400, 30);	
		labelDataNasc.setBounds(50, 86, 400, 30);
		labelUnidade.setBounds(40, 124, 400, 30);
		labelEmail.setBounds(170, 162, 400, 30);
		labelFidelidade.setBounds(70, 200, 400, 30);
		
		labelNome.setFont(text);
		labelCpf.setFont(text);
		labelDataNasc.setFont(text);
		labelUnidade.setFont(text);
		labelEmail.setFont(text);
		labelFidelidade.setFont(text);
		
		labelNome.setText(labelNome.getText()+" "+dados.getClientes()[pos].getNome());
		labelCpf.setText(labelCpf.getText()+" "+dados.getClientes()[pos].getCpf());
		labelDataNasc.setText(labelDataNasc.getText()+" "+dados.getClientes()[pos].getDataNasc());
		labelUnidade.setText(labelUnidade.getText()+" "+dados.getClientes()[pos].getUnidade().getShopping());
		labelEmail.setText(labelEmail.getText()+" "+dados.getClientes()[pos].getEmail());
		labelFidelidade.setText(labelFidelidade.getText()+" "+dados.getClientes()[pos].getFidelidade());
		
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
			try {
				boolean res;
				
				if (valorNome.getText().isEmpty()) {
					res = false;
				} else {
					if (opcao==1) {
						novoDado[0] = Integer.toString(dados.getQtdClientes());
					}
					if (opcao==2) {
						novoDado[0] = Integer.toString(posicao);
					}
					novoDado[1] = valorNome.getText();
					novoDado[2] = valorCpf.getText();
					novoDado[3] = valorDataNasc.getText();
					novoDado[4] = valorUnidade.getSelectedItem().toString();
					novoDado[5] = valorEmail.getText();
					if(valorFide1.isSelected()) {
						novoDado[6] = "1";
					} else if (valorFide2.isSelected()) {
						novoDado[6] = "2";
					}
					else if (valorFide3.isSelected()) {
						novoDado[6] = "3";
					}
					
					res = dados.inserirEditarCliente(novoDado);
					f.dispose();
			}
				
				if (res) {
					mensagemSucesso();
				} else {
					mensagemErro();
				}
				
			} catch (NullPointerException exc1) {
				mensagemErro();
			}
		}
		
		if (src==butVoltar) {
			f.dispose();
		}
		
		if (src==butEditar) {
			f.dispose();
			adicionaCliente(2, dados);	
		}
		
		if(src==butExcluir){
			dados.removerCliente(posicao);
			f.dispose();
		}
	}

	public void preencheComboBox() {
		for (int i=0; i<5; i++) {
			valorUnidade.addItem(dados.getUnidades()[i].getShopping());
		}
	}
	
	public void mensagemSucesso() {
		if (opcao==1) {
			JOptionPane.showMessageDialog(null, "SUCESSO\nCliente Cadastrado!", null, JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "SUCESSO\nCliente Atualizado!", null, JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public void mensagemErro() {
		JOptionPane.showMessageDialog(null, "ERRO\nCertifique-se de:\n-Preencher todos os Campos essenciais.", null, JOptionPane.ERROR_MESSAGE);
	}
}
