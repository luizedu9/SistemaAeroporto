package interfaceGrafica;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import aplicacao.Json;

public class InterfaceJson extends JFrame {

	private JPanel panelNorte;
	private JPanel panelSul;
	private JTextArea diretorio;
	private JTextArea codigoCompanhia;
	private JButton importarJson;
	private JButton exportarJson;

	public InterfaceJson() {

		super("Vá-Com-Deus 1.0");
		
		setLayout(new FlowLayout());
		Json funcaoJson = new Json(); 
		panelNorte = new JPanel();
		panelSul = new JPanel();
		diretorio = new JTextArea(System.getProperty("user.dir") + "\\exemplo.json");
		codigoCompanhia = new JTextArea("Cód. Companhia Aerea");
		importarJson = new JButton("Importar");
		exportarJson = new JButton("Exportar");
		
		importarJson.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				if (funcaoJson.importarJson(diretorio.getText(), codigoCompanhia.getText())) {
					JOptionPane.showMessageDialog(null, "IMPORTADO COM SUCESSO");
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "ERRO - ARQUIVO NÃO IMPORTADO");
				}
			}
		});
		exportarJson.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				funcaoJson.exportarJson(diretorio.getText(), codigoCompanhia.getText());
				dispose();
			}
		});
		
		add(panelNorte, BorderLayout.NORTH);
		panelNorte.add(diretorio);
		panelNorte.add(codigoCompanhia);
		add(panelSul, BorderLayout.SOUTH);	
		panelSul.add(importarJson);
		panelSul.add(exportarJson);

		setSize(600, 110);
		setVisible(true);
	}
}