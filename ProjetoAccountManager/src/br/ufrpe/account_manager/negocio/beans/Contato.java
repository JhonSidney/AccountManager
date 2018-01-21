/**
 * 
 */
package br.ufrpe.account_manager.negocio.beans;

public class Contato extends Pessoa {

	private String preferencia;
	private String comentario;

	/*public Contato(String nome, String sobrenome, String cpf, String salario, String id, String email, String senha,
			String logradouro, String nascimento, String tel, String preferencia) {
		super(nome, sobrenome, cpf, salario, id, email, senha, logradouro, nascimento, tel);
		this.setPreferencia(preferencia);
		this.setComentario(comentario);
	}*/

	public Contato(String nome, String logradouro, String tel, String comentario,String cpf, String email) {
		super(nome, tel, logradouro);
		this.setPreferencia(preferencia);
		this.setComentario(comentario);
		this.setCpf(cpf);
		this.setEmail(email);
	}

	public void setPreferencia(String preferencia) {
		this.preferencia = preferencia;
	}

	public String getPreferencia() {
		return preferencia;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	@Override
	public String toString() {
		return "Contato [preferencia=" + preferencia + ", comentario=" + comentario + "]";
	}

	

}
