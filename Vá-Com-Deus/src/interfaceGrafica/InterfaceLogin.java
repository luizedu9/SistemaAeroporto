package interfaceGrafica;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

import aplicacao.Aeroporto;
import aplicacao.Excecao;
import aplicacao.Validacao;

public class InterfaceLogin extends JFrame {

	private JTextArea codigoCompanhia;
	private JTextArea login;
	private JPasswordField senha;
	private JButton entrar;
	
	ConexaoMySQL conexao;

	public InterfaceLogin() {

		super("Vá-Com-Deus 1.0");

		setLayout(new FlowLayout());
		codigoCompanhia = new JTextArea("Cód. Companhia Aerea");
		login = new JTextArea("Login                                ");
		senha = new JPasswordField("Senha   ");
		add(codigoCompanhia);
		add(login);
		add(senha);

		entrar = new JButton("Entrar");
		entrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Aeroporto.getCompanhiaAerea(Integer.parseInt(codigoCompanhia.getText().trim()));
					if (login.getText().trim().isEmpty() || senha.getText().trim().isEmpty()) {
						Excecao.exceptionNull();
					}
					if (!(ConexaoMySQL.pesquisaSQL(codigoCompanhia.getText().trim(), login.getText().trim(), Validacao.sha1(senha.getText().trim())))) {
						Excecao.exceptionSenha();
					}
					InterfaceGerenciaCompanhia interfaceGerenciaCompanhia = new InterfaceGerenciaCompanhia(Integer.parseInt(codigoCompanhia.getText().trim()));
					dispose();
				} catch (HeadlessException | NoSuchAlgorithmException e1) {
					JOptionPane.showMessageDialog(null, "ERRO - SHA1");
				} catch (Excecao e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "ERRO - COMPANHIA INCORRETA");
				}
			}
		});
		add(entrar, BorderLayout.SOUTH);

		setSize(200, 140);
		setVisible(true);

	}

}