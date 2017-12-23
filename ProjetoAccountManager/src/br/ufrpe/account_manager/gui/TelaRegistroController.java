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

public class TelaRegistroController {

	@FXML
	private Button TRegistro_BT_Cancelar;
	@FXML
	private Button TRegistro_BT_Enviar;
	@FXML
	private TextField TRegistro_TF_Nome;
	@FXML
	private TextField TRegistro_TF_Sobrenome;
	@FXML
	private TextField TRegistro_TF_CPF;
	@FXML
	private PasswordField TRegistro_PF_Senha;

	SistemaAccountManager fachada;

	@FXML
	public void initialize() {
		fachada = SistemaAccountManager.getInstance();
	}

	@FXML
	public void botao_enviar(ActionEvent event) {
		// implementar codigo para o botão Enviar
	}

	@FXML
	public void botao_cancelar(ActionEvent event) {
		try {
			Parent root;
			Stage stage;

			if (event.getSource() == TRegistro_BT_Cancelar) {
				stage = (Stage) TRegistro_BT_Cancelar.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaLogin.fxml"));
			} else {
				stage = (Stage) TRegistro_BT_Cancelar.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaRegistro.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
