package aplicacao;

public class Carga extends Aviao {

	private TipoAviao tipo = TipoAviao.CARGA;
	
	@Override
	public double calcula_pagamento() {
		if (this.getPesoAviao() > 30) {
			return((15000 * 0.15) + 15000);
		}
		return(15000);
	}
	
	@Override
	public TipoAviao getTipo() {
		return(tipo);
	}
	
}
