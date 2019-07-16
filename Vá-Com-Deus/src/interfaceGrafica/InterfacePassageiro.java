package interfaceGrafica;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import aplicacao.Aeroporto;
import aplicacao.CompanhiaAerea;
import aplicacao.Excecao;
import aplicacao.Passageiro;
import aplicacao.Validacao;
import aplicacao.Voo;

public class InterfacePassageiro extends JFrame {

	private JTextArea codigoCompanhia;
	private JTextArea codigoVoo;
	private JTextArea codigoPassageiro;
	private JTextArea nome;
	private JTextArea cpf;
	private JTextArea telefone;
	private JTextArea email;
	private JTextArea dataNascimento;
	private JButton registra;
	private JButton altera;
	private JButton exclui;
	private JButton listar;
	JPanel painelFundo;
	JTable tabela;
	JScrollPane barraRolagem;

	String[] colunas = { "Nome", "CPF", "Telefone", "Email", "Data Nascimento" };

	public InterfacePassageiro(int codigoCompanhia) {

		super("Vá-Com-Deus 1.0");

		setLayout(new FlowLayout());
		codigoVoo = new JTextArea("Cód. Voo                          ");
		nome = new JTextArea("Nome                               ");
		cpf = new JTextArea("CPF                                   ");
		telefone = new JTextArea("Telefone                           ");
		email = new JTextArea("Email                                ");
		dataNascimento = new JTextArea("Data Nascimento           ");
		add(codigoVoo);
		add(nome);
		add(cpf);
		add(telefone);
		add(email);
		add(dataNascimento);

		registra = new JButton("Registrar");
		registra.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (nome.getText().trim().isEmpty() || telefone.getText().trim().isEmpty()) {
						Excecao.exceptionNull();
					}
					if (!Validacao.validaCpf(cpf.getText().trim())) {
						Excecao.exceptionCPF();
					}
					if (!Validacao.validaEmail(email.getText().trim())) {
						Excecao.exceptionDataNascimento();
					}
					if (!Validacao.validaData(dataNascimento.getText().trim())) {
						Excecao.exceptionDataNascimento();
					}
					try {
						Passageiro passageiro = new Passageiro(nome.getText().trim(), cpf.getText().trim(),
								telefone.getText().trim(), email.getText().trim(), dataNascimento.getText().trim());
						CompanhiaAerea companhia = Aeroporto.getCompanhiaAerea(codigoCompanhia);
						companhia.setPassageiro(companhia.getVoo(Integer.parseInt(codigoVoo.getText().trim())), passageiro);
						dispose();
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "ERRO - VOO INCORRETO");
					}				
				} catch (Excecao e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "ERRO - CÓDIGO ESPERADO");
				} 
			}
		});
		add(registra, BorderLayout.SOUTH);

		setSize(200, 230);
		setVisible(true);

	}

	public InterfacePassageiro(int inicializarAlterar, int codigoCompanhia) {

		super("Vá-Com-Deus 1.0");

		setLayout(new FlowLayout());
		codigoVoo = new JTextArea("Cód. Voo                          ");
		codigoPassageiro = new JTextArea("Cód. Passageiro           ");
		nome = new JTextArea("Nome                               ");
		cpf = new JTextArea("CPF                                   ");
		telefone = new JTextArea("Telefone                           ");
		email = new JTextArea("Email                                ");
		dataNascimento = new JTextArea("Data Nascimento           ");
		add(codigoVoo);
		add(codigoPassageiro);
		add(nome);
		add(cpf);
		add(telefone);
		add(email);
		add(dataNascimento);

		altera = new JButton("Alterar");
		altera.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (nome.getText().trim().isEmpty() || telefone.getText().trim().isEmpty()) {
						Excecao.exceptionNull();
					}
					if (!Validacao.validaCpf(cpf.getText().trim())) {
						Excecao.exceptionCPF();
					}
					if (!Validacao.validaEmail(email.getText().trim())) {
						Excecao.exceptionDataNascimento();
					}
					if (!Validacao.validaData(dataNascimento.getText().trim())) {
						Excecao.exceptionDataNascimento();
					}
					try {
						Passageiro passageiro = new Passageiro(nome.getText().trim(), cpf.getText().trim(),
								telefone.getText().trim(), email.getText().trim(), dataNascimento.getText().trim());
						CompanhiaAerea companhia = Aeroporto.getCompanhiaAerea(codigoCompanhia);
						companhia.getVoo(Integer.parseInt(codigoVoo.getText().trim())).alteraPassageiro(passageiro,	Integer.parseInt(codigoPassageiro.getText().trim()));
						dispose();
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "ERRO - VOO INCORRETO");
					}				
				} catch (Excecao e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "ERRO - CÓDIGO INCORRETO");
				} 
			}
		});
		add(altera, BorderLayout.SOUTH);

		setSize(200, 250);
		setVisible(true);

	}

	public InterfacePassageiro(String inicializarExcluir, int codigoCompanhia) {

		super("Vá-Com-Deus 1.0");

		setLayout(new FlowLayout());
		codigoVoo = new JTextArea("Cód. Voo                          ");
		codigoPassageiro = new JTextArea("Cód. Passageiro           ");
		add(codigoVoo);
		add(codigoPassageiro);

		exclui = new JButton("Excluir");
		exclui.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					CompanhiaAerea companhia = Aeroporto.getCompanhiaAerea(codigoCompanhia);
					companhia.getVoo(Integer.parseInt(codigoVoo.getText().trim())).excluiPassageiro(Integer.parseInt(codigoPassageiro.getText().trim()));
					dispose();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "ERRO - CÓDIGO INCORRETO");
				}
			}
		});
		add(exclui, BorderLayout.SOUTH);

		setSize(200, 150);
		setVisible(true);

	}

	public InterfacePassageiro(boolean inicializarLista) {

		super("Vá-Com-Deus 1.0");
		
		setLayout(new FlowLayout());	
		codigoCompanhia = new JTextArea("Cód. Companhia Aerea");
		codigoVoo = new JTextArea("Cód. Voo                          ");
		add(codigoCompanhia);
		add(codigoVoo);
		
		listar = new JButton("Listar");
		listar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					CompanhiaAerea companhia = Aeroporto.getCompanhiaAerea(Integer.parseInt(codigoCompanhia.getText().trim()));
					Voo voo = companhia.getVoo(Integer.parseInt(codigoVoo.getText().trim()));
					painelFundo = new JPanel();
					painelFundo.setLayout(new GridLayout(1, 1));
					tabela = new JTable(getDados(voo), colunas);
					barraRolagem = new JScrollPane(tabela);
					painelFundo.add(barraRolagem);
					getContentPane().add(painelFundo);
					listar.setVisible(false);
					codigoCompanhia.setVisible(false);
					codigoVoo.setVisible(false);
					setSize(550, 500);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "ERRO - CÓDIGO INCORRETO");
				}
			}
		});
		add(listar, BorderLayout.SOUTH);
		
		setSize(200, 130);
		setVisible(true);
		
	}

	public Object[][] getDados(Voo voo) {
		int i, k = 0;
		Object[][] dados = new Object[100][6];
		for (i = 0; i < 100; i++) {
			if (voo.getPassageiro(i) != null) {
				dados[k][0] = voo.getPassageiro(i).getNome();
				dados[k][1] = voo.getPassageiro(i).getCpf();
				dados[k][2] = voo.getPassageiro(i).getEmail();
				dados[k][3] = voo.getPassageiro(i).getTelefone();
				dados[k][4] = voo.getPassageiro(i).getDataNascimento();
				k++;
			}
		}
		return (dados);
	}

}