package interfaceGrafica;

import aplicacao.Json;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class InterfaceMain extends JFrame {

	private JButton moduloAeroporto;
	private JButton moduloCompanhia;
	private JButton moduloVisao;
	private JButton moduloCliente;
	private Json json = new Json();

	public InterfaceMain() {

		super("V�-Com-Deus 1.0");

		setLayout(new FlowLayout());
		
		if (json.importarJson(System.getProperty("user.dir") + "\\V�-Com-Deus.json")) {
			JOptionPane.showMessageDialog(null, "IMPORA��O DE BACKUP FEITA COM SUCESSO");
		}
		else {
			JOptionPane.showMessageDialog(null, "N�O FOI ENCONTRADO O BACKUP DE DADOS");
		}
		
		moduloAeroporto = new JButton("M�dulo Aeroporto");
		moduloAeroporto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				InterfaceGerenciaAeroporto interfaceGerenciaAeroporto = new InterfaceGerenciaAeroporto();
			}
		});
		add(moduloAeroporto);

		moduloCompanhia = new JButton("M�dulo Companhia");
		moduloCompanhia.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				InterfaceLogin interfaceLogin = new InterfaceLogin();
			}
		});
		add(moduloCompanhia);

		moduloVisao = new JButton("M�dulo Visao");
		moduloVisao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				InterfaceVisao interfaceVisao = new InterfaceVisao();
			}
		});
		add(moduloVisao);

		moduloCliente = new JButton("M�dulo Cliente");
		moduloCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				InterfaceCliente interfacecliente = new InterfaceCliente();
			}
		});
		add(moduloCliente);
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		WindowListener exitListener = new WindowAdapter() {

		    @Override
		    public void windowClosing(WindowEvent e) {
		        json.exportarJson(System.getProperty("user.dir") + "\\V�-Com-Deus.json");
		        System.exit(0);
		    }
		};
		addWindowListener(exitListener);
		setSize(600, 75);
		setVisible(true);

	}

}