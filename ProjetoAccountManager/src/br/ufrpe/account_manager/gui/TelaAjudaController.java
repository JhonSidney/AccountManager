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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TelaAjudaController {

	@FXML
	private Button TAjuda_BT_atualizar;
	@FXML
	private Button TAjuda_BT_Cancelar;
	@FXML
	private TextField TAjuda_TF_CPF;
	@FXML
	private PasswordField TAjuda_PF_Senha;
	@FXML
	private PasswordField TAjuda_PF_ConfirmaSenha;

	String cpf, senhaAcesso, confirmarSenha,senhaOficial;
	SistemaAccountManager fachada;

	public void initialize() {
		fachada = SistemaAccountManager.getInstance();
	}

	@FXML
	public void botao_atualizar(ActionEvent event) throws IOException {
		Parent root;
		Stage stage;

		if (validarCampos()) {
			try {
				
				cpf = TAjuda_TF_CPF.getText();
				senhaAcesso = TAjuda_PF_Senha.getText();
				confirmarSenha = TAjuda_PF_ConfirmaSenha.getText();

				if (validarSenha() == true) {

					Pessoa pessoa = new Pessoa(cpf, confirmarSenha);

					fachada.atualizarPessoa(pessoa);

					stage = (Stage) TAjuda_BT_atualizar.getScene().getWindow();
					root = FXMLLoader.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaLogin.fxml"));

					Scene scene = new Scene(root);
					stage.setScene(scene);
				} 
				

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

	private boolean validarCampos() throws IOException {
		boolean validate = false;

		try {
			if (TAjuda_TF_CPF.getText().isEmpty() || TAjuda_PF_Senha.getText().isEmpty()
					|| TAjuda_PF_ConfirmaSenha.getText().isEmpty()) {
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


	private boolean validarSenha()throws IOException{
		boolean validar = false;
		cpf = TAjuda_TF_CPF.getText();
		senhaAcesso = TAjuda_PF_Senha.getText();
		confirmarSenha = TAjuda_PF_ConfirmaSenha.getText();
		
		if(this.TAjuda_PF_Senha.getText().equals(this.TAjuda_PF_ConfirmaSenha.getText())) {
			validar = true;
		}
		
		return validar;
		
	}
}
