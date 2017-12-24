package br.ufrpe.account_manager.gui;

import java.io.IOException;

import br.ufrpe.account_manager.SistemaAccountManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TelaAjudaController {

	@FXML
	private Button TAjuda_BT_alterar;
	@FXML
	private Button TAjuda_BT_Cancelar;
	@FXML
	private TextField TAjuda_TF_CPF;
	@FXML
	private PasswordField TAjuda_PF_Senha;
	@FXML
	private PasswordField TAjuda_PF_ConfirmaSenha;

	SistemaAccountManager fachada;

	public void initialize() {
		fachada = SistemaAccountManager.getInstance();
	}
	
	
	@FXML
	public void botao_enviar(ActionEvent event) {
		// implementar codigo para o botão alterar
	}

	@FXML
	public void botao_cancelar(ActionEvent event) {
		try {
			Parent root;
			Stage stage;

			if (event.getSource() == TAjuda_BT_Cancelar) {
				stage = (Stage) TAjuda_BT_Cancelar.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaLogin.fxml"));
			} else {
				stage = (Stage) TAjuda_BT_Cancelar.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaAjuda.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	
	
}
