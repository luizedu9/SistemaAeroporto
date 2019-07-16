package aplicacao;

public class Comercial extends Aviao {

	private TipoAviao tipo = TipoAviao.COMERCIAL;
	
	@Override
	public double calcula_pagamento() {
		if (this.getPesoAviao() > 30) {
			return((10000 * 0.1) + 10000);
		}
		return(10000);
	}
	
	@Override
	public TipoAviao getTipo() {
		return(tipo);
	}
	
}