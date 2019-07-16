package aplicacao;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

public class CompanhiaAerea {

	private int codigo;
	private String nome;
	private Map<Integer, Aviao> aviao = new HashMap<Integer, Aviao>();
	private Map<Integer, Voo> voo = new HashMap<Integer, Voo>();
	private double tributo;

	public CompanhiaAerea() {
		tributo = 0;
	}

	// SET - GET-----------------------------------------------------------------------------------------
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return (codigo);
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return (nome);
	}

	public void setAviao(Aviao aviao) {
		int i;
		for (i = 0; i <= this.aviao.size(); i++) {
			if (this.aviao.get(i) == null) {
				this.aviao.put(i, aviao);
				return;
			}
		}
		return;
	}

	public Aviao getAviao(int codigo) {
		return(aviao.get(codigo));
	}

	public int getQuantidadeAviao() {
		return(aviao.size());
	}

	public int getQuantidadeVoo() {
		return(voo.size());
	}

	public Voo setVoo(int codigoAviao, String data, String horario, String destino, String origem) {
		int i;
		Voo voo = new Voo();
		try {
			voo.setNumeroPoltrona(aviao.get(codigoAviao).getPoltrona());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO - AVIÃO INEXISTENTE");
			return(null);
		}
		if (!Validacao.reservaHorario(data, horario)) {
			JOptionPane.showMessageDialog(null, "ERRO - HORARIO LOTADO");
			return(null);
		}
		voo.setCodigo(Aeroporto.getNumeroVoos());
		voo.setAviao(codigoAviao);
		voo.setData(data);
		voo.setHorario(horario);
		voo.setStatus(EstadoVoo.CONFIRMADO);
		voo.setDestino(destino);
		voo.setOrigem(origem);
		for (i = 0; i <= this.voo.size(); i++) {
			if (this.voo.get(i) == null) {
				this.voo.put(i, voo);
				break;
			}
		}
		incrementaTributo(aviao.get(codigoAviao));
		return(voo);
	}

	public Voo getVoo(int codigo) {
		return(voo.get(codigo));
	}
	
	public double getTributo() {
		return(tributo);
	}

	public String setPassageiro(Voo voo, Passageiro passageiro) {
		if (voo.setPassageiro(passageiro)) {
			return ("REGISTRADO - POLTRONA " + Integer.toString(voo.getPoltronaLivre() - 1));
		}
		return ("ERRO - Número de Passageiros Excedido");
	}
	// ---------------------------------------------------------------------------------------------------
	
	public void alterarCompanhia(String nome) {
		setNome(nome);
	}
	
	public void alterarAviao(int codigoAviao, Aviao aviao) {
		this.aviao.put(codigoAviao, aviao);
	}

	public void excluirAviao(int codigoAviao) {
		aviao.remove(codigoAviao);
	}
	
	public void excluirVoo(int codigoVoo) {
		decrementaTributo(aviao.get(voo.get(codigoVoo).getAviao()));
		voo.remove(codigoVoo);
	}
	
	public void incrementaTributo(Aviao aviao) {
		tributo += aviao.calcula_pagamento();	
	}
	
	public void decrementaTributo(Aviao aviao) {
		tributo -= aviao.calcula_pagamento();		
	}

}