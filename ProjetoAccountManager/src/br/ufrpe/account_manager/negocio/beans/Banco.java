package br.ufrpe.account_manager.negocio.beans;

public class Banco {
	
	private String codigo;
	private String nome;
	private String telefone;
	private String logradouro;
	private String site;
	
	public Banco(String codigo, String nome, String telefone, String logradouro, String site) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.telefone = telefone;
		this.logradouro = logradouro;
		this.site = site;
	}
	
	public Banco(){
		
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	@Override
	public String toString() {
		return "Banco [codigo=" + codigo + ", nome=" + nome + ", telefone=" + telefone + ", logradouro=" + logradouro
				+ ", site=" + site + "]";
	}
	
	
}
