package br.ufrpe.account_manager.negocio.beans;

import java.io.Serializable;
import java.sql.Date;


public class Conta implements Serializable{


	private String id;
	private String nome;
	private String descricao;
	private String dataVencimento;
	private String valor;
	
	public Conta(String id, String nome, String descricao, String dataVencimento, String valor) {
		this.setId(id);
		this.setNome(nome);
		this.setDescricao(descricao);
		this.setDataVencimento(dataVencimento);
		this.setValor(valor);
		
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

	public String getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(String dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Conta [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", dataVencimento=" + dataVencimento
				+ ", valor=" + valor + "]";
	}
	
	
}
