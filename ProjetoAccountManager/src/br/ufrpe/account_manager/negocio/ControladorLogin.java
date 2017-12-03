package br.ufrpe.account_manager.negocio;

public class ControladorLogin {

	private ControladorPessoa pessoa;
	private static ControladorLogin instance;

	public static ControladorLogin getInstance() {
		if(instance == null) {
			instance = new ControladorLogin();
		}
		return instance;
	}
	
	public void efetuarLogin(String cpf, String senha) {
		
	}

}
