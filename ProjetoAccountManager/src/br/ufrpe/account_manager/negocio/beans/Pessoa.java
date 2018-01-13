package br.ufrpe.account_manager.negocio.beans;

import java.io.Serializable;

//@Entity
public class Pessoa implements Serializable {

	private String nome;
	private String sobrenome;
	// @Id
	private String cpf;
	private String salario;
	private String id;
	private String email;
	private String senha;
	private String logradouro;
	private String nascimento;
	private String tel;

	public Pessoa(String nome, String sobrenome, String cpf, String salario, String id, String email, String senha,
			String logradouro, String nascimento, String tel) {
		this.setNome(nome);
		this.setSobrenome(sobrenome);
		this.setCpf(cpf);
		this.setEmail(email);
		this.setSenha(senha);
		this.setLogradouro(logradouro);
		this.setNascimento(nascimento);
		this.setTel(tel);
		this.setId(id);
		this.setSalario(salario);
	}

	public Pessoa(String nome, String sobrenome, String cpf, String senha) {
		this.setNome(nome);
		this.setSobrenome(sobrenome);
		this.setCpf(cpf);
		this.setSenha(senha);
	}

	public Pessoa(String cpf, String senha) {
		this.setCpf(cpf);
		this.setSenha(senha);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSalario() {
		return salario;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", sobrenome=" + sobrenome + ", cpf=" + cpf + ", salario=" + salario + ", id="
				+ id + ", email=" + email + ", senha=" + senha + ", logradouro=" + logradouro + ", nascimento="
				+ nascimento + ", tel=" + tel + "]";
	}

}
