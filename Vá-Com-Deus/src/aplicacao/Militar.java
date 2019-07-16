package aplicacao;

public class Militar extends Aviao {
	
	private TipoAviao tipo = TipoAviao.MILITAR;
	
	@Override
	public double calcula_pagamento() {
		if (this.getPesoAviao() > 30) {
			return((12000 * 0.15) + 12000);
		}
		return(12000);
	}
	
	@Override
	public TipoAviao getTipo() {
		return(tipo);
	}
	
}
