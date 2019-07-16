package aplicacao;

public class Aviao {

	private int codigo;
	private double autonomia;
	private double altura;
	private double envergadura;
	private double comprimento;
	private double capacidade;
	private double pesoAviao;
	private int poltrona;
	
	public Aviao() {
		
	}
	
	public Aviao(double autonomia, double altura, double envergadura, double comprimento, double capacidade, double pesoAviao, int poltrona) {
		this.autonomia = autonomia;
		this.altura = altura;
		this.envergadura = envergadura;
		this.comprimento = comprimento;
		this.capacidade = capacidade;
		this.pesoAviao = pesoAviao;
		this.poltrona = poltrona;
	}
	
	//SET - GET -----------------------------------------------------------------------------------------
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return(codigo);
	}
	
	public void setAutonomia(double autonomia) {
		this.autonomia = autonomia;
	}
	
	public double getAutonomia() {
		return(autonomia);
	}
	
	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	public double getAltura() {
		return(altura);
	}
	
	public void setEnvergadura(double envergadura) {
		this.envergadura = envergadura;
	}
	
	public double getEnvergadura() {
		return(envergadura);
	}
	
	public void setComprimento(double comprimento) {
		this.comprimento = comprimento;
	}
	
	public double getComprimento() {
		return(comprimento);
	}
	
	public void setCapacidade(double capacidade) {
		this.capacidade = capacidade;
	}
	
	public double getCapacidade() {
		return(capacidade);
	}
	
	public void setPesoAviao(double pesoAviao) {
		this.pesoAviao = pesoAviao;
	}
	
	public double getPesoAviao() {
		return(pesoAviao);
	}
	
	public void setPoltrona(int poltrona) {
		this.poltrona = poltrona;
	}
	
	public int getPoltrona() {
		return(poltrona);
	}
	//---------------------------------------------------------------------------------------------------
	
	public double calcula_pagamento() {
		return(0);
	}
	
	public TipoAviao getTipo() {
		return(null);
	}

}