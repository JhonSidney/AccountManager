package br.ufrpe.account_manager.negocio;

import br.ufrpe.account_manager.exception.NegocioException;
import br.ufrpe.account_manager.negocio.beans.Pessoa;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

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

	public int efetuarLogin(String cpf, String senha) throws NegocioException, Exception {

		int igual = 0;
		Pessoa pessoa = this.pessoa.procurar(cpf);

		if (pessoa == null) {
			try {
				throw new NegocioException(" Usuario não existe! ");
			} finally {
				// TODO: handle finally clause
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Login Inválido");
				alert.setHeaderText("Usuário Não existe");
				alert.setContentText("Por favor!procure o administrador do sistema !");
				alert.showAndWait();
			}
		} else if (pessoa != null && (pessoa.getSenha().equals(senha)) == false) {
			try {
				throw new NegocioException(" Senha Inválida! ");
			} finally {
				// TODO: handle finally clause
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Login Inválido");
				alert.setHeaderText(" Senha de Acesso incorreta");
				alert.setContentText("Por favor!procure o administrador do sistema !");
				alert.showAndWait();
			}
		} else if (pessoa != null && pessoa.getSenha().equals(senha)) {
			igual = 1;

		} else {
			try {
				throw new NegocioException(" Senha Inválida! ");
			} finally {
				// TODO: handle finally clause
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Login Inválido");
				alert.setHeaderText(" Senha de Acesso incorreta");
				alert.setContentText("Por favor!procure o administrador do sistema !");
				alert.showAndWait();
			}
		}

		return igual;
	}

}
