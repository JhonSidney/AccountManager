package br.ufrpe.account_manager.negocio.beans;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class  Pessoa {

	 private String nome;
	 @Id
	 @GeneratedValue
	 private String cpf;
	 private long id;
	 private String email;
	 private String senha;
	 private String logradouro;
	 private Date nascimento;
	 private String tel;

	public Pessoa(String nome, String cpf, String email, String senha, String logradouro, Date nascimento, String tel) {
		super();
		this.setNome(nome);
		this.setCpf(cpf);
		this.setEmail(email);
		this.setSenha(senha);
		this.setLogradouro(logradouro);
		this.setNascimento(nascimento);
		this.setTel(tel);
		this.setId(id);
	}

	public String getNome() {
		return nome;
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

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	

}
