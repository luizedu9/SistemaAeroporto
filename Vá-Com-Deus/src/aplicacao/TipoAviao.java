package aplicacao;

public enum TipoAviao {

	MILITAR(1), COMERCIAL(2), CARGA(3);
	
	public int tipo_aviao;
	
	TipoAviao(int tipo) {
		tipo_aviao = tipo;
	}
	
	public int getTipo() {
		return(tipo_aviao);
	}
	
}
