package interfaceGrafica;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import aplicacao.Aeroporto;
import aplicacao.CompanhiaAerea;
import aplicacao.Excecao;

public class InterfaceCompanhia extends JFrame {

	private JTextArea codigoCompanhia;
	private JTextArea nome;
	private JButton registra;
	private JButton altera;
	private JButton exclui;

	//REGISTRA
	public InterfaceCompanhia() {

		super("Vá-Com-Deus 1.0");

		setLayout(new FlowLayout());
		codigoCompanhia = new JTextArea("Cód. Companhia Aerea");
		nome = new JTextArea("Nome                                ");
		add(codigoCompanhia);
		add(nome);

		registra = new JButton("Registrar");
		registra.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (nome.getText().isEmpty()) {
						Excecao.exceptionNull();
					}
					CompanhiaAerea companhiaAerea = new CompanhiaAerea();
					companhiaAerea.setCodigo(Integer.parseInt(codigoCompanhia.getText().trim()));
					companhiaAerea.setNome(nome.getText().trim());
					Aeroporto.setCompanhiaAerea(Integer.parseInt(codigoCompanhia.getText().trim()), companhiaAerea);
					dispose();
				} catch (Excecao e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "ERRO - CÓDIGO");
				}
			}
			});
			add(registra, BorderLayout.SOUTH);

		setSize(200, 130);
		setVisible(true);

	}

	//ALTERAR
	public InterfaceCompanhia(int inicializaAlterar) {

		super("Vá-Com-Deus 1.0");

		setLayout(new FlowLayout());
		codigoCompanhia = new JTextArea("Cód. Companhia Aerea");
		nome = new JTextArea("Nome                                ");
		add(codigoCompanhia);
		add(nome);

		altera = new JButton("Alterar");
		altera.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (nome.getText().isEmpty()) {
						Excecao.exceptionNull();
					}
					Aeroporto.getCompanhiaAerea(Integer.parseInt(codigoCompanhia.getText().trim())).alterarCompanhia(nome.getText().trim());
					dispose();
				} catch (Excecao e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "ERRO - CÓDIGO / NOME ESPERADO");
				}
			}
		});
		add(altera, BorderLayout.SOUTH);

		setSize(200, 130);
		setVisible(true);

	}

	//EXCLUIR
	public InterfaceCompanhia(String inicializaExcluir) {

		super("Vá-Com-Deus 1.0");

		setLayout(new FlowLayout());
		codigoCompanhia = new JTextArea("Cód. Companhia Aerea");
		add(codigoCompanhia);

		exclui = new JButton("Excluir");
		exclui.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Aeroporto.setCompanhiaAerea(Integer.parseInt(codigoCompanhia.getText().trim()), null);
					dispose();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "ERRO - CÓDIGO INEXISTENTE");
				}
			}
		});
		add(exclui, BorderLayout.SOUTH);

		setSize(200, 100);
		setVisible(true);

	}

}