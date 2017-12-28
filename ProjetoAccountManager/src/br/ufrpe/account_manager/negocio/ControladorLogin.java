package br.ufrpe.account_manager.negocio;

import br.ufrpe.account_manager.exception.NegocioException;
import br.ufrpe.account_manager.negocio.beans.Pessoa;

public class ControladorLogin {

	private ControladorPessoa pessoa;
	private static ControladorLogin instance;

	public ControladorLogin() {
		this.pessoa = ControladorPessoa.getInstance();
	}

	public static ControladorLogin getInstance() {
		if (instance == null) {
			instance = new ControladorLogin();
		}
		return instance;
	}

	public int efetuarLogin(String cpf, String senha) throws NegocioException {

		int igual = 0;
		Pessoa pessoa = this.pessoa.procurar(cpf);

		if (pessoa == null) {
			throw new NegocioException(" Usuario não existe! ");
		} else if (pessoa != null && pessoa.getSenha().equals(senha)) {
			igual = 1;
		} else {
			throw new NegocioException("senha invalida!");
		}

		return igual;
	}

}
