package aplicacao;

public class Excecao extends Exception {
	
	private Excecao() {
		super();
	}
	
	private Excecao(String msg) {
		super(msg);
	}
	
	public static void exceptionCPF() throws Excecao {
		throw new Excecao("ERRO - CPF INCORRETO");
	}
	
	public static void exceptionEmail() throws Excecao {
		throw new Excecao("ERRO - EMAIL INCORRETO");
	}
	
	public static void exceptionDataNascimento() throws Excecao {
		throw new Excecao("ERRO - DATA DE NASCIMENTO INCORRETA");
	}
	
	public static void exceptionData() throws Excecao {
		throw new Excecao("ERRO - DATA INCORRETA");
	}
	
	public static void exceptionHorario() throws Excecao {
		throw new Excecao("ERRO - HORARIO INCORRETO");
	}
	
	public static void exceptionSenha() throws Excecao {
		throw new Excecao("ERRO - USUARIO OU SENHA INCORRETO");
	}
		
	public static void exceptionNull() throws Excecao {
		throw new Excecao("ERRO - CAMPO VAZIO");
	}

}
