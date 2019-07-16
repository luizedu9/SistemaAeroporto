package aplicacao;

public class Passageiro extends Validacao {

	private String nome;
	private String cpf;
	private String telefone;
	private String email;
	private String dataNascimento;

	public Passageiro() {

	}

	public Passageiro(String nome, String cpf, String telefone, String email, String dataNascimento) {
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
		this.dataNascimento = dataNascimento;
	}

	// SET - GET
	// -----------------------------------------------------------------------------------------
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return (nome);
	}

	public void setcpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCpf() {
		return (cpf);
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTelefone() {
		return (telefone);
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return (email);
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getDataNascimento() {
		return (dataNascimento);
	}
	// ---------------------------------------------------------------------------------------------------

}