/**
 * 
 */
package br.ufrpe.account_manager.negocio.beans;

public class Contatos extends Pessoa {

	private String preferencia;

	public Contatos(String nome, String sobrenome, String cpf, String salario, String id, String email, String senha,
			String logradouro, String nascimento, String tel,String preferencia) {
		super(nome, sobrenome, cpf, salario, id, email, senha, logradouro, nascimento, tel);
		this.setPreferencia(preferencia);
	}

	public void setPreferencia(String preferencia) {
		this.preferencia = preferencia;
	}

	public String getPreferencia() {
		return preferencia;
	}

	@Override
	public String toString() {
		return "Contatos [preferencia=" + preferencia + "]";
	}

	
}
