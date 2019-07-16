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

import aplicacao.*;

public class InterfaceCliente extends JFrame {

	JPanel painelFundo;
	JTable tabela;
	JScrollPane barraRolagem;
	private JTextArea cpf;
	private JButton listar;

	String[] colunas = { "Cód. Voo", "Companhia", "Status", "Data", "Hora", "Destino", "Origem" };

	public InterfaceCliente() {

		super("Vá-Com-Deus 1.0");

		setLayout(new FlowLayout());
		cpf = new JTextArea("CPF                                   ");
		add(cpf);

		listar = new JButton("Listar");
		listar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (!Validacao.validaCpf(cpf.getText().trim())) {
						Excecao.exceptionCPF();
					}
					painelFundo = new JPanel();
					painelFundo.setLayout(new GridLayout(1, 1));
					tabela = new JTable(getDados(cpf.getText().trim()), colunas);
					barraRolagem = new JScrollPane(tabela);
					painelFundo.add(barraRolagem);
					getContentPane().add(painelFundo);
					listar.setVisible(false);
					cpf.setVisible(false);
					setSize(550, 500);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		add(listar, BorderLayout.SOUTH);

		setSize(200, 100);
		setVisible(true);

	}

	public Object[][] getDados(String cpf) {
		int i, j, k, l = 0;
		Object[][] dados = new Object[10][7];
		for (i = 0; i < Aeroporto.getNumeroCompanhia(); i++) {
			try {
				CompanhiaAerea companhia = Aeroporto.getCompanhiaAerea(i);
				for (j = 0; j < 100; j++) {
					if (companhia.getVoo(j) != null) {
						Voo voo = companhia.getVoo(j);
						for (k = 0; k < 100; k++) {
							if (voo.getPassageiro(k) != null && cpf.equals(voo.getPassageiro(k).getCpf())) {
								dados[l][0] = voo.getCodigo();
								dados[l][1] = companhia.getNome();
								dados[l][2] = voo.getStatus();
								dados[l][3] = voo.getData();
								dados[l][4] = voo.getHorario();
								dados[l][5] = voo.getDestino();
								dados[l][6] = voo.getOrigem();
								l++;
							}
						}
					}
				}
			} catch (Exception e) {
			}
		}
		return (dados);
	}

}