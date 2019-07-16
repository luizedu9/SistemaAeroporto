package interfaceGrafica;

import aplicacao.CompanhiaAerea;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import aplicacao.Aeroporto;

public class InterfaceVisao extends JFrame {

	JPanel painelFundo;
	JTable tabela;
	JScrollPane barraRolagem;

	String[] colunas = {"Cód. Voo", "Companhia", "Status", "Data", "Hora", "Destino"};

	public InterfaceVisao() {

		super("Vá-Com-Deus 1.0");

		setLayout(new FlowLayout());

		painelFundo = new JPanel();
		painelFundo.setLayout(new GridLayout(1, 1));
		tabela = new JTable(getDados(), colunas);
		barraRolagem = new JScrollPane(tabela);
		painelFundo.add(barraRolagem);
		getContentPane().add(painelFundo);
		
		setSize(500, 500);
		setVisible(true);
	}

	public Object[][] getDados() {
		DateTimeFormatter dataFormato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.now();
		int i, j, k = 0;
		Object[][] dados = new Object[100][6];
		for (i = 0; i < Aeroporto.getNumeroCompanhia(); i++) {			
			try {
				CompanhiaAerea companhia = Aeroporto.getCompanhiaAerea(i);
				for (j = 0; j < 100; j++) {
					if (companhia.getVoo(j) != null && Integer.parseInt(companhia.getVoo(j).getData().substring(0, 2)) == Integer.parseInt(dataFormato.format(localDate).substring(0, 2))) {
						dados[k][0] = companhia.getVoo(j).getCodigo();
						dados[k][1] = companhia.getNome();
						dados[k][2] = companhia.getVoo(j).getStatus();
						dados[k][3] = companhia.getVoo(j).getData();
						dados[k][4] = companhia.getVoo(j).getHorario();
						dados[k][5] = companhia.getVoo(j).getDestino();
						k++;
					}
				}
			} catch (Exception e) {
			}
		}
		return (dados);
	}

}