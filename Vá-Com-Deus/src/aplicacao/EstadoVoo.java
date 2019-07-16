package aplicacao;

public enum EstadoVoo {

	CONFIRMADO(1), ATRASADO(2), CANCELADO(3);
		
	public int estado_voo;

	EstadoVoo(int tipo) {
		estado_voo = tipo;
	}
		
	public int getTipo() {
		return(estado_voo);
	}
		
}