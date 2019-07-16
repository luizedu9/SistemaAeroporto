package interfaceGrafica;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

import aplicacao.Aeroporto;
import aplicacao.CompanhiaAerea;
import aplicacao.Excecao;
import aplicacao.Passageiro;
import aplicacao.Validacao;

public class InterfaceRegistraLogin extends JFrame {

	private JTextArea codigoCompanhia;
	private JTextArea nome;
	private JTextArea login;
	private JPasswordField senha;
	private JButton registrar;
	ConexaoMySQL conexao;

	public InterfaceRegistraLogin() {

		super("Vá-Com-Deus 1.0");

		conexao = new ConexaoMySQL();
		setLayout(new FlowLayout());
		codigoCompanhia = new JTextArea("Cód. Companhia Aerea");
		nome = new JTextArea("Nome                                ");
		login = new JTextArea("Login                                ");
		senha = new JPasswordField("Senha   ");
		add(codigoCompanhia);
		add(nome);
		add(login);
		add(senha);

		registrar = new JButton("Registrar");
		registrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (nome.getText().trim().isEmpty() || codigoCompanhia.getText().trim().isEmpty() || login.getText().trim().isEmpty() || senha.getText().trim().isEmpty()) {
						Excecao.exceptionNull();
					}
					if (!(ConexaoMySQL.insereSQL(codigoCompanhia.getText().trim(), nome.getText().trim(), login.getText().trim(), Validacao.sha1(senha.getText().trim())))) {
						Excecao.exceptionSenha();
					}
					dispose();		
				} catch (Excecao e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage()); 
				} catch (NoSuchAlgorithmException e1) {
					JOptionPane.showMessageDialog(null, "SHA1");
				}
			}
		});
		add(registrar, BorderLayout.SOUTH);

		setSize(200, 160);
		setVisible(true);

	}

}