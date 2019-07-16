package aplicacao;

import java.util.Map;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class Voo {

	private int codigoVoo;
	private int codigoAviao;
	private String data;
	private String horario;
	private EstadoVoo status;
	private String destino;
	private String origem;
	private Map<Integer, Passageiro> passageiro = new HashMap<Integer, Passageiro>();
	private int numeroPoltrona;

	// SET - GET-----------------------------------------------------------------------------------------
	public void setCodigo(int codigo) {
		this.codigoVoo = codigo;
	}

	public int getCodigo() {
		return(codigoVoo);
	}

	public void setAviao(int codigoAviao) {
		this.codigoAviao = codigoAviao;
	}

	public int getAviao() {
		return (codigoAviao);
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getData() {
		return (data);
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getHorario() {
		return (horario);
	}

	public void setStatus(EstadoVoo status) {
		this.status = status;
	}

	public EstadoVoo getStatus() {
		return (status);
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getDestino() {
		return (destino);
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getOrigem() {
		return (origem);
	}

	public boolean setPassageiro(Passageiro passageiro) {
		int i;
		if (this.passageiro.size() < numeroPoltrona) {
			for (i = 0; i <= this.passageiro.size(); i++) {
				if (this.passageiro.get(i) == null) {
					this.passageiro.put(i, passageiro);
					break;
				}
			}
			return (true);
		}
		else{
			JOptionPane.showMessageDialog(null, "ERRO - AVIÃO LOTADO");
			return (false);
		}
		
	}

	public Passageiro getPassageiro(int poltrona) {
		return (passageiro.get(poltrona));
	}

	public void setNumeroPoltrona(int poltrona) {
		numeroPoltrona = poltrona;
	}

	public int getNumeroPoltrona() {
		return (numeroPoltrona);
	}

	public int getPoltronaLivre() {
		return (passageiro.size());
	}
	// ---------------------------------------------------------------------------------------------------

	public void alteraVoo(int codigoAviao, String data, String horario, String destino, String origem, EstadoVoo status) {
		if (Validacao.reservaHorario(data, horario)) {
			Validacao.desmarcaHorario(data, horario);
			setAviao(codigoAviao);
			setData(data);
			setHorario(horario);
			setDestino(destino);
			setOrigem(origem);
			setStatus(status);
		}
	}
	
	public void alteraPassageiro(Passageiro passageiro, int codigoPassageiro) {
		this.passageiro.put(codigoPassageiro, passageiro);
	}
	
	public void excluiPassageiro(int codigoPassageiro) {
		this.passageiro.remove(codigoPassageiro);
	}

}