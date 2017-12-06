package br.ufrpe.account_manager.negocio;

import br.ufrpe.account_manager.exception.NegocioException;
import br.ufrpe.account_manager.negocio.beans.Pessoa;

public class ControladorLogin {

	private ControladorPessoa pessoa;
	private static ControladorLogin instance;

	public static ControladorLogin getInstance() {
		if (instance == null) {
			instance = new ControladorLogin();
		}
		return instance;
	}

	public int efetuarLogin(String cpf, String senha) throws NegocioException {
	
	int igual = 0;
	boolean resultado = this.pessoa.existeNome(cpf);
	Pessoa pessoa = null;
	
	if(resultado == false) {
		throw new NegocioException(" Usuario Nao Existe!");
	}else if(resultado != false && pessoa.getSenha().equals(senha)) {
		igual = 1;
	}else {
		throw new NegocioException (" Senha Invalida");
	}
	return igual;
		
	}

}
