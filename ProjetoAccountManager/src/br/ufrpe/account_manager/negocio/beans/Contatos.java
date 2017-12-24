/**
 * 
 */
package br.ufrpe.account_manager.negocio.beans;


public class Contatos extends Pessoa{
	
	private String preferencia;
	

	public Contatos(String nome, String cpf, String email, String senha, String preferencia) {
		super(nome, cpf, email, senha);
		this.setPreferencia(preferencia);
	}

	public void setPreferencia(String preferencia) {
		this.preferencia = preferencia;
	}

	public String getPreferencia() {
		return preferencia;
	}
	
	
}
