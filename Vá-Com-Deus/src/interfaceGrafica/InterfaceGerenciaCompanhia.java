package interfaceGrafica;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InterfaceGerenciaCompanhia extends JFrame {

	private JButton registraAviao;
	private JButton registraVoo;
	private JButton registraPassageiro;
	private JButton alteraAviao;
	private JButton alteraVoo;
	private JButton alteraPassageiro;
	private JButton excluiAviao;
	private JButton excluiVoo;
	private JButton excluiPassageiro;
	private JButton abrirJson;
	private JButton registrarUsuario;
	
	public InterfaceGerenciaCompanhia(int codigoCompanhia) {

		super("Vá-Com-Deus 1.0");

		setLayout(new FlowLayout());

		// REGISTRO
		JPanel panelRegistro = new JPanel();
		JLabel labelRegistro = new JLabel("REGISTRAR");
		add(panelRegistro, BorderLayout.NORTH);
		panelRegistro.add(labelRegistro);

		registraAviao = new JButton("Avião");
		registraAviao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				InterfaceAviao interfaceAviao = new InterfaceAviao(codigoCompanhia);
			}
		});
		panelRegistro.add(registraAviao);

		registraVoo = new JButton("Vôo");
		registraVoo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				InterfaceVoo interfaceVoo = new InterfaceVoo(codigoCompanhia);
			}
		});
		panelRegistro.add(registraVoo);

		registraPassageiro = new JButton("Passageiro");
		registraPassageiro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				InterfacePassageiro interfacePassageiro = new InterfacePassageiro(codigoCompanhia);
			}
		});
		panelRegistro.add(registraPassageiro);

		// ALTERA
		JPanel panelAltera = new JPanel();
		JLabel labelAltera = new JLabel("ALTERAR    ");
		add(panelAltera, BorderLayout.NORTH);
		panelAltera.add(labelAltera);

		alteraAviao = new JButton("Avião");
		alteraAviao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				InterfaceAviao interfaceAviao = new InterfaceAviao(0, codigoCompanhia);
			}
		});
		panelAltera.add(alteraAviao);

		alteraVoo = new JButton("Vôo");
		alteraVoo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				InterfaceVoo interfaceVoo = new InterfaceVoo(0, codigoCompanhia);
			}
		});
		panelAltera.add(alteraVoo);

		alteraPassageiro = new JButton("Passageiro");
		alteraPassageiro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				InterfacePassageiro interfacePassageiro = new InterfacePassageiro(0, codigoCompanhia);
			}
		});
		panelAltera.add(alteraPassageiro);

		// EXCLUI
		JPanel panelExclui = new JPanel();
		JLabel labelExclui = new JLabel("EXCLUIR     ");
		add(panelExclui, BorderLayout.NORTH);
		panelExclui.add(labelExclui);

		excluiAviao = new JButton("Avião");
		excluiAviao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				InterfaceAviao interfaceAviao = new InterfaceAviao("0", codigoCompanhia);
			}
		});
		panelExclui.add(excluiAviao);

		excluiVoo = new JButton("Vôo");
		excluiVoo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				InterfaceVoo interfaceVoo = new InterfaceVoo("0", codigoCompanhia);
			}
		});
		panelExclui.add(excluiVoo);

		excluiPassageiro = new JButton("Passageiro");
		excluiPassageiro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				InterfacePassageiro interfacePassageiro = new InterfacePassageiro("0", codigoCompanhia);
			}
		});
		panelExclui.add(excluiPassageiro);

		// JSON
		abrirJson = new JButton("IMPORTAR / EXPORTAR");
		abrirJson.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				InterfaceJson interfaceJson = new InterfaceJson();
			}
		});
		add(abrirJson, BorderLayout.SOUTH);
		
		registrarUsuario = new JButton("REGISTRAR USUARIO");
		registrarUsuario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				InterfaceRegistraLogin interfaceRegistraLogin = new InterfaceRegistraLogin();
			}
		});
		add(registrarUsuario, BorderLayout.SOUTH);

		setSize(400, 200);
		setVisible(true);
	}

	public static boolean isNumber(String numero) {
		try {
			double d = Double.parseDouble(numero);
			return (true);
		} catch (NumberFormatException e) {
			return (false);
		}
	}

}