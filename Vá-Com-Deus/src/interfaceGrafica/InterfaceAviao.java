package interfaceGrafica;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import aplicacao.*;

public class InterfaceAviao extends JFrame {
	
	private JTextArea codigoAviao;
	private JTextArea autonomia;
	private JTextArea altura;
	private JTextArea envergadura;
	private JTextArea comprimento;
	private JTextArea capacidade;
	private JTextArea peso;
	private JTextArea poltrona;	
	private JComboBox<TipoAviao> tipo;
	private JButton registra;
	private JButton altera;
	private JButton exclui;

	// REGISTRA
	public InterfaceAviao(int codigoCompanhia) {

		super("Vá-Com-Deus 1.0");

		setLayout(new FlowLayout());
		autonomia = new JTextArea("Autonomia                       ");
		altura = new JTextArea("Altura                                ");
		envergadura = new JTextArea("Envergadura                   ");
		comprimento = new JTextArea("Comprimento                 ");
		capacidade = new JTextArea("Capacidade                    ");
		peso = new JTextArea("Peso                                ");
		poltrona = new JTextArea("Poltrona                           ");
		tipo = new JComboBox<TipoAviao>();
		tipo.addItem(TipoAviao.MILITAR);
		tipo.addItem(TipoAviao.COMERCIAL);
		tipo.addItem(TipoAviao.CARGA);
		tipo.setSelectedIndex(1);
		add(autonomia);
		add(altura);
		add(envergadura);
		add(comprimento);
		add(capacidade);
		add(peso);
		add(poltrona);
		add(tipo);

		registra = new JButton("Registrar");
		registra.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (tipo.getSelectedIndex() + 1 == TipoAviao.MILITAR.getTipo()) {
						Aviao aviao = new Militar();
						aviao.setAutonomia(Double.parseDouble(autonomia.getText().trim()));
						aviao.setAltura(Double.parseDouble(altura.getText().trim()));
						aviao.setEnvergadura(Double.parseDouble(envergadura.getText().trim()));
						aviao.setComprimento(Double.parseDouble(comprimento.getText().trim()));
						aviao.setCapacidade(Double.parseDouble(capacidade.getText().trim()));
						aviao.setPesoAviao(Double.parseDouble(peso.getText().trim()));
						aviao.setPoltrona(Integer.parseInt(poltrona.getText().trim()));
						Aeroporto.getCompanhiaAerea(codigoCompanhia).setAviao(aviao);
					}
					if (tipo.getSelectedIndex() + 1 == TipoAviao.COMERCIAL.getTipo()) {
						Aviao aviao = new Comercial();
						aviao.setAutonomia(Double.parseDouble(autonomia.getText().trim()));
						aviao.setAltura(Double.parseDouble(altura.getText().trim()));
						aviao.setEnvergadura(Double.parseDouble(envergadura.getText().trim()));
						aviao.setComprimento(Double.parseDouble(comprimento.getText().trim()));
						aviao.setCapacidade(Double.parseDouble(capacidade.getText().trim()));
						aviao.setPesoAviao(Double.parseDouble(peso.getText().trim()));
						aviao.setPoltrona(Integer.parseInt(poltrona.getText().trim()));
						Aeroporto.getCompanhiaAerea(codigoCompanhia).setAviao(aviao);
					}
					if (tipo.getSelectedIndex() + 1 == TipoAviao.CARGA.getTipo()) {
						Aviao aviao = new Carga();
						aviao.setAutonomia(Double.parseDouble(autonomia.getText().trim()));
						aviao.setAltura(Double.parseDouble(altura.getText().trim()));
						aviao.setEnvergadura(Double.parseDouble(envergadura.getText().trim()));
						aviao.setComprimento(Double.parseDouble(comprimento.getText().trim()));
						aviao.setCapacidade(Double.parseDouble(capacidade.getText().trim()));
						aviao.setPesoAviao(Double.parseDouble(peso.getText().trim()));
						aviao.setPoltrona(Integer.parseInt(poltrona.getText().trim()));
						Aeroporto.getCompanhiaAerea(codigoCompanhia).setAviao(aviao);
					}					
					dispose();
				}
				catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "ERRO - NÚMERO ESPERADO");
				}
			}
		});
		add(registra, BorderLayout.SOUTH);

		setSize(200, 300);
		setVisible(true);

	}

	// ALTERAR
	public InterfaceAviao(int inicializaAlterar, int codigoCompanhia) {

		super("Vá-Com-Deus 1.0");

		setLayout(new FlowLayout());
		codigoAviao = new JTextArea("Cód. Avião                       ");
		autonomia = new JTextArea("Autonomia                       ");
		altura = new JTextArea("Altura                                ");
		envergadura = new JTextArea("Envergadura                   ");
		comprimento = new JTextArea("Comprimento                 ");
		capacidade = new JTextArea("Capacidade                    ");
		peso = new JTextArea("Peso                                ");
		poltrona = new JTextArea("Poltrona                           ");
		tipo = new JComboBox<TipoAviao>();
		tipo.addItem(TipoAviao.MILITAR);
		tipo.addItem(TipoAviao.COMERCIAL);
		tipo.addItem(TipoAviao.CARGA);
		tipo.setSelectedIndex(1);
		add(codigoAviao);
		add(autonomia);
		add(altura);
		add(envergadura);
		add(comprimento);
		add(capacidade);
		add(peso);
		add(poltrona);
		add(tipo);

		altera = new JButton("Alterar");
		altera.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (tipo.getSelectedIndex() == TipoAviao.MILITAR.getTipo()) {
						Militar aviao = new Militar();
						aviao.setAutonomia(Double.parseDouble(autonomia.getText().trim()));
						aviao.setAltura(Double.parseDouble(altura.getText().trim()));
						aviao.setEnvergadura(Double.parseDouble(envergadura.getText().trim()));
						aviao.setComprimento(Double.parseDouble(comprimento.getText().trim()));
						aviao.setCapacidade(Double.parseDouble(capacidade.getText().trim()));
						aviao.setPesoAviao(Double.parseDouble(peso.getText().trim()));
						aviao.setPoltrona(Integer.parseInt(poltrona.getText().trim()));
						Aeroporto.getCompanhiaAerea(codigoCompanhia).alterarAviao(Integer.parseInt(codigoAviao.getText().trim()), aviao);						
					}
					if (tipo.getSelectedIndex() == TipoAviao.COMERCIAL.getTipo()) {
						Comercial aviao = new Comercial();
						aviao.setAutonomia(Double.parseDouble(autonomia.getText().trim()));
						aviao.setAltura(Double.parseDouble(altura.getText().trim()));
						aviao.setEnvergadura(Double.parseDouble(envergadura.getText().trim()));
						aviao.setComprimento(Double.parseDouble(comprimento.getText().trim()));
						aviao.setCapacidade(Double.parseDouble(capacidade.getText().trim()));
						aviao.setPesoAviao(Double.parseDouble(peso.getText().trim()));
						aviao.setPoltrona(Integer.parseInt(poltrona.getText().trim()));
						Aeroporto.getCompanhiaAerea(codigoCompanhia).alterarAviao(Integer.parseInt(codigoAviao.getText().trim()), aviao);					
					}
					if (tipo.getSelectedIndex() == TipoAviao.CARGA.getTipo()) {
						Carga aviao = new Carga();
						aviao.setAutonomia(Double.parseDouble(autonomia.getText().trim()));
						aviao.setAltura(Double.parseDouble(altura.getText().trim()));
						aviao.setEnvergadura(Double.parseDouble(envergadura.getText().trim()));
						aviao.setComprimento(Double.parseDouble(comprimento.getText().trim()));
						aviao.setCapacidade(Double.parseDouble(capacidade.getText().trim()));
						aviao.setPesoAviao(Double.parseDouble(peso.getText().trim()));
						aviao.setPoltrona(Integer.parseInt(poltrona.getText().trim()));
						Aeroporto.getCompanhiaAerea(codigoCompanhia).alterarAviao(Integer.parseInt(codigoAviao.getText().trim()), aviao);						
					}
					dispose();
				} 
				catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "ERRO - NÚMERO ESPERADO");
				}
			}
		});
		add(altera, BorderLayout.SOUTH);

		setSize(200, 270);
		setVisible(true);

	}

	// Excluir
	public InterfaceAviao(String inicializaExcluir, int codigoCompanhia) {

		super("Vá-Com-Deus 1.0");

		setLayout(new FlowLayout());
		codigoAviao = new JTextArea("Cód. Avião                       ");
		add(codigoAviao);
		exclui = new JButton("Excluir");
		exclui.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Aeroporto.getCompanhiaAerea(codigoCompanhia).excluirAviao(Integer.parseInt(codigoAviao.getText().trim()));
					dispose();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "ERRO - NÚMERO ESPERADO");
				}
			}
		});
		add(exclui, BorderLayout.SOUTH);

		setSize(200, 120);
		setVisible(true);

	}

}