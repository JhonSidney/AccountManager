/**
 * 
 */
package br.ufrpe.account_manager.negocio.beans;


public class Contatos {
	
	private String nome;
	private String telefone;
	private String email;
	private String Endereco;
	
	public Contatos(String nome, String telefone, String email, String endereco) {
		this.setNome(nome);
		this.setTelefone(telefone);
		this.setEmail(email);
		this.setEndereco(endereco);
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return Endereco;
	}

	public void setEndereco(String endereco) {
		Endereco = endereco;
	}

	@Override
	public String toString() {
		return "Contatos [nome=" + nome + ", telefone=" + telefone + ", email=" + email + ", Endereco=" + Endereco
				+ "]";
	}
	
	
	
}
