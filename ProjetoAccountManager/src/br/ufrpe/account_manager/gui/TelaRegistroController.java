package br.ufrpe.account_manager.gui;

import java.io.IOException;

import br.ufrpe.account_manager.SistemaAccountManager;
import br.ufrpe.account_manager.negocio.beans.Pessoa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
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
	public void botao_enviar(ActionEvent event) throws IOException{
		
		Parent root;
		Stage stage;
		
		if(validarCampos()) {
			try {
				String nome,sobrenome,cpf, senha;
				
				nome = TRegistro_TF_Nome.getText();
				sobrenome = TRegistro_TF_Sobrenome.getText();
				cpf = TRegistro_TF_CPF.getText();
				senha = TRegistro_PF_Senha.getText();
				
				Pessoa pessoa = new Pessoa(nome, sobrenome, cpf, senha);
				
				fachada.cadastrarPessoa(pessoa);
				
				stage = (Stage) TRegistro_BT_Enviar.getScene().getWindow();
				root = FXMLLoader.load(
				getClass().getResource("/br/ufrpe/account_manager/gui/TelaLogin.fxml"));

				Scene scene = new Scene(root);
				stage.setScene(scene);
				
			} catch (Exception e) {
				// TODO: handle exception
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Error");
				alert.setHeaderText("Formato dos campos invalidos");
				alert.setContentText(e.getMessage());
				alert.showAndWait();
			}
		}

		
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

	private boolean validarCampos() throws IOException {
		boolean validate = false;

		try {
			if (TRegistro_TF_Nome.getText().isEmpty() || TRegistro_TF_Sobrenome.getText().isEmpty()
					|| TRegistro_TF_CPF.getText().isEmpty() || TRegistro_PF_Senha.getText().isEmpty()) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Error");
				alert.setHeaderText("Informações inválidas");
				alert.setContentText("Verifique os campos digitados!");
				alert.showAndWait();

			} else {
				validate = true;
			}

		} catch (NumberFormatException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Error");
			alert.setHeaderText("Formato dos campos invalidos");
			alert.setContentText("Verifique os campos digitados!");
			alert.showAndWait();
		}
		return validate;
	}

}
