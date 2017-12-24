
package br.ufrpe.account_manager.gui;

import java.io.IOException;

import br.ufrpe.account_manager.SistemaAccountManager;
import br.ufrpe.account_manager.exception.NegocioException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TelaLoginController {
	private Inicio inicio; // Classe que inicia as cenas
	SistemaAccountManager fachada = SistemaAccountManager.getInstance(); // instancia da fachada

	@FXML
	private Button TLogin_BT_Acessar;
	@FXML
	private TextField TLogin_TF_Usuario; // NOME DA CENA_TEXTFIELD_USUARIO| nome de usu�rio
	@FXML
	private PasswordField TLogin_PF_Senha;
	@FXML
	private Hyperlink TLogin_HL_Registro;// Ainda nao � registrado?
	@FXML
	private Hyperlink TLogin_HL_EsqueciSenha;// Precisa de Ajuda?

	public void setPrincipal(Inicio principal) {
		this.inicio = principal;
	}

	public void acessarLogin() throws NegocioException {
		this.setPrincipal(inicio.getInstance());
	}

	@FXML
	public void acessarLogin(ActionEvent event) throws NegocioException {

		try {
			if (this.fachada.efetuarLogin(TLogin_TF_Usuario.getText(), TLogin_PF_Senha.getText()) == 1) {
				Parent root;
				Stage stage;

				stage = (Stage) TLogin_BT_Acessar.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaMenuPrincipal.fxml"));

				Scene scene = new Scene(root);
				stage.setScene(scene);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@FXML
	public void registroUsuario(ActionEvent event) {
		Parent root;
		Stage stage;
		try {

			if (event.getTarget() == TLogin_HL_Registro) {
				stage = (Stage) TLogin_HL_Registro.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaRegistro.fxml"));
			} else {
				stage = (Stage) TLogin_HL_Registro.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaLogin.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void esqueciSenha(ActionEvent event) {

		Parent root;
		Stage stage;
		try {

			if (event.getTarget() == TLogin_HL_EsqueciSenha) {
				stage = (Stage) TLogin_HL_EsqueciSenha.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaAjuda.fxml"));
			} else {
				stage = (Stage) TLogin_HL_EsqueciSenha.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaLogin.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}