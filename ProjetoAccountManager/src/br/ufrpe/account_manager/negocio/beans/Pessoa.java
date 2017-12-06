package br.ufrpe.account_manager.negocio.beans;

//@Entity
public class  Pessoa {

	 private String nome;
	// @Id
	 private String cpf;
	 private String salario;
	 private String id;
	 private String email;
	 private String senha;
	 private String logradouro;
	 private String nascimento;
	 private String tel;

	public Pessoa(String nome, String cpf, String email, String senha, String logradouro, String nascimento, String tel) {
		super();
		this.setNome(nome);
		this.setCpf(cpf);
		this.setEmail(email);
		this.setSenha(senha);
		this.setLogradouro(logradouro);
		this.setNascimento(nascimento);
		this.setTel(tel);
		this.setId(id);
		this.setSalario(salario);
	}

	public String getNome() {
		return nome;
	}

	public String getSalario() {
		return salario;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	

}
