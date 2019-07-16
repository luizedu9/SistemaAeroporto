package interfaceGrafica;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import aplicacao.Aeroporto;

public class InterfaceGerenciaAeroporto extends JFrame {

	private JButton registraCompanhia;
	private JButton alteraCompanhia;
	private JButton excluiCompanhia;
	private JButton abrirJson;
	private JButton resetar;
	private JButton lucroAeroporto;
	private JButton numeroVoos;
	private JButton listaPassageiros;
	private JButton registrarUsuario;
	
	public InterfaceGerenciaAeroporto() {

		super("Vá-Com-Deus 1.0");

		setLayout(new FlowLayout());

		// REGISTRO
		JPanel panelRegistro = new JPanel();
		JLabel labelRegistro = new JLabel("REGISTRAR");
		add(panelRegistro, BorderLayout.NORTH);
		panelRegistro.add(labelRegistro);

		registraCompanhia = new JButton("Companhia Aerea");
		registraCompanhia.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				InterfaceCompanhia interfaceCompanhia = new InterfaceCompanhia();
			}
		});
		panelRegistro.add(registraCompanhia);

		// ALTERA
		JPanel panelAltera = new JPanel();
		JLabel labelAltera = new JLabel("ALTERAR    ");
		add(panelAltera, BorderLayout.NORTH);
		panelAltera.add(labelAltera);

		alteraCompanhia = new JButton("Companhia Aerea");
		alteraCompanhia.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				InterfaceCompanhia interfaceCompanhia = new InterfaceCompanhia(0);
			}
		});
		panelAltera.add(alteraCompanhia);

		// EXCLUI
		JPanel panelExclui = new JPanel();
		JLabel labelExclui = new JLabel("EXCLUIR     ");
		add(panelExclui, BorderLayout.NORTH);
		panelExclui.add(labelExclui);

		excluiCompanhia = new JButton("Companhia Aerea");
		excluiCompanhia.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				InterfaceCompanhia interfaceCompanhia = new InterfaceCompanhia("A");
			}
		});
		panelExclui.add(excluiCompanhia);

		// JSON
		abrirJson = new JButton("IMPORTAR / EXPORTAR");
		abrirJson.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				InterfaceJson interfaceJson = new InterfaceJson();
			}
		});
		add(abrirJson, BorderLayout.SOUTH);

		resetar = new JButton("EXCLUIR DADOS");
		resetar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Aeroporto.resetarAeroporto();
				try {
					(new File(System.getProperty("user.dir") + "\\Vá-Com-Deus.json")).delete();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "ERRO - ARQUIVO NÃO ENCONTRADO");
				}
				System.exit(0);
			}
		});
		add(resetar, BorderLayout.SOUTH);

		lucroAeroporto = new JButton("LUCRO AEROPORTO");
		lucroAeroporto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, Aeroporto.lucroAeroporto());
			}
		});
		add(lucroAeroporto, BorderLayout.SOUTH);

		numeroVoos = new JButton("NÚMERO DE VÔOS");
		numeroVoos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (Integer key : Aeroporto.getMapCompanhia().keySet()) {
					try {
						JOptionPane.showMessageDialog(null, Aeroporto.getCompanhiaAerea(key).getNome() + " : " + Aeroporto.getCompanhiaAerea(key).getQuantidadeVoo() + " Vôo(s).");
					} catch (Exception e1) {
					}
				}
			}
		});
		add(numeroVoos, BorderLayout.SOUTH);
		
		listaPassageiros = new JButton("LISTAR PASSAGEIROS");
		listaPassageiros.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				InterfacePassageiro interfacePassageiro = new InterfacePassageiro(true);
			}
		});
		add(listaPassageiros, BorderLayout.SOUTH);
		
		registrarUsuario = new JButton("REGISTRAR USUARIO");
		registrarUsuario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				InterfaceRegistraLogin interfaceRegistraLogin = new InterfaceRegistraLogin();
			}
		});
		add(registrarUsuario, BorderLayout.SOUTH);

		setSize(450, 250);
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