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

import aplicacao.Aeroporto;
import aplicacao.CompanhiaAerea;
import aplicacao.EstadoVoo;
import aplicacao.Excecao;
import aplicacao.TipoAviao;
import aplicacao.Validacao;
import aplicacao.Voo;

public class InterfaceVoo extends JFrame {

	private JTextArea codigoCompanhia;
	private JTextArea codigoVoo;
	private JTextArea codigoAviao;
	private JTextArea data;
	private JTextArea horario;
	private JTextArea destino;
	private JTextArea origem;
	private JComboBox<EstadoVoo> status;
	private JButton registra;
	private JButton altera;
	private JButton exclui;

	public InterfaceVoo(int codigoCompanhia) {

		super("Vá-Com-Deus 1.0");

		setLayout(new FlowLayout());
		codigoAviao = new JTextArea("Cód. Avião                        ");
		data = new JTextArea("Data                                  ");
		horario = new JTextArea("Horario                             ");
		destino = new JTextArea("Destino                            ");
		origem = new JTextArea("Origem                             ");
		add(codigoAviao);
		add(data);
		add(horario);
		add(destino);
		add(origem);

		registra = new JButton("Registrar");
		registra.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (!Validacao.validaData(data.getText().trim())) {
						Excecao.exceptionData();
					}
					if (!Validacao.validaHorario(horario.getText().trim())) {
						Excecao.exceptionHorario();
					}
					if (destino.getText().trim().isEmpty() || origem.getText().trim().isEmpty()) {
						Excecao.exceptionNull();
					}
					CompanhiaAerea companhia = Aeroporto.getCompanhiaAerea(codigoCompanhia);
					companhia.setVoo(Integer.parseInt(codigoAviao.getText().trim()),
							data.getText().trim(),
							horario.getText().trim(),
							destino.getText().trim(),
							origem.getText().trim());
					dispose();
				} catch (Excecao e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "ERRO - AVIAO INEXISTENTE");
				}
			}
		});

		add(registra, BorderLayout.SOUTH);

		setSize(200, 210);
		setVisible(true);

	}

	public InterfaceVoo(int inicializaAlterar, int codigoCompanhia) {

		super("Vá-Com-Deus 1.0");

		setLayout(new FlowLayout());
		codigoVoo = new JTextArea("Cód. Voo                           ");
		codigoAviao = new JTextArea("Cód. Avião                        ");
		data = new JTextArea("Data                                  ");
		horario = new JTextArea("Horario                             ");
		destino = new JTextArea("Destino                            ");
		origem = new JTextArea("Origem                             ");
		status= new JComboBox<EstadoVoo>();
		status.addItem(EstadoVoo.CONFIRMADO);
		status.addItem(EstadoVoo.ATRASADO);
		status.addItem(EstadoVoo.CANCELADO);
		status.setSelectedIndex(1);
		add(codigoVoo);
		add(codigoAviao);
		add(data);
		add(horario);
		add(destino);
		add(origem);
		add(status);

		altera = new JButton("Alterar");
		altera.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean doNothing = false;
				if (!InterfaceGerenciaAeroporto.isNumber(codigoVoo.getText().trim())) {
					JOptionPane.showMessageDialog(null, "ERRO - CÓDIGO ESPERADO");
					doNothing = true;
				}
				if (!InterfaceGerenciaAeroporto.isNumber(codigoAviao.getText().trim())) {
					JOptionPane.showMessageDialog(null, "ERRO - CÓDIGO ESPERADO");
					doNothing = true;
				}
				if (!Validacao.validaData(data.getText().trim())) {
					JOptionPane.showMessageDialog(null, "ERRO - DATA INCORRETA");
					doNothing = true;
				}
				if (!Validacao.validaHorario(horario.getText().trim())) {
					JOptionPane.showMessageDialog(null, "ERRO - HORARIO INCORRETO");
					doNothing = true;
				}
				if (destino.getText().trim() == null || origem.getText().trim() == null) {
					JOptionPane.showMessageDialog(null, "ERRO - DESTINO / ORIGEM ESPERADO");
					doNothing = true;
				}
				if (!doNothing) {
					CompanhiaAerea companhia = Aeroporto.getCompanhiaAerea(codigoCompanhia);
					Voo voo = companhia.getVoo(Integer.parseInt(codigoVoo.getText().trim()));
					voo.alteraVoo(Integer.parseInt(codigoAviao.getText().trim()),
							data.getText().trim(),
							horario.getText().trim(),
							destino.getText().trim(),
							origem.getText().trim(),
							status.getItemAt(status.getSelectedIndex()));
					dispose();
				}

			}
		});

		add(altera, BorderLayout.SOUTH);

		setSize(200, 250);
		setVisible(true);

	}
	
	public InterfaceVoo(String inicializaExcluir, int codigoCompanhia) {

		super("Vá-Com-Deus 1.0");

		setLayout(new FlowLayout());
		codigoVoo = new JTextArea("Cód. Voo                           ");
		add(codigoVoo);
		exclui = new JButton("Excluir");
		exclui.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean doNothing = false;
				if (!InterfaceGerenciaAeroporto.isNumber(codigoVoo.getText().trim())) {
					JOptionPane.showMessageDialog(null, "ERRO - CÓDIGO ESPERADO");
					doNothing = true;
				}
				if (!doNothing) {
					Aeroporto.getCompanhiaAerea(codigoCompanhia).excluirVoo(Integer.parseInt(codigoVoo.getText().trim()));
					dispose();
				}

			}
		});
		add(exclui, BorderLayout.SOUTH);

		setSize(200, 120);
		setVisible(true);

	}

}