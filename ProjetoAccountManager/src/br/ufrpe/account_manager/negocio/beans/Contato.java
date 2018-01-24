/**
 * 
 */
package br.ufrpe.account_manager.negocio.beans;

public class Contato extends Pessoa {

	private String comentario;

	public Contato(String nome, String sobrenome, String logradouro, String tel, String comentario, String cpf,
			String email) {
		super(nome, sobrenome, tel, logradouro, email);
		this.setComentario(comentario);
		this.setCpf(cpf);
		this.setTel(tel);
		this.setLogradouro(logradouro);
		this.setSobrenome(sobrenome);
		this.setNome(nome);
		this.setEmail(email);
		
		}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	@Override
	public String toString() {
		return "Contato [comentario=" + comentario + "]";
	}

}
