package br.ufrpe.account_manager.negocio.beans;

import java.sql.Date;

//@Entity
public class Conta {

//	@Id
	//@GeneratedValue
	private long id;
	private String nome;
	private String descricao;
	private Date dataVencimento;
	private int valor;
	
	public Conta(String nome, String descricao, Date dataVencimento, int valor) {
		super();
		this.setNome(nome);
		this.setDescricao(descricao);
		this.setDataVencimento(dataVencimento);
		this.setValor(valor);
		this.setId(valor);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
}
