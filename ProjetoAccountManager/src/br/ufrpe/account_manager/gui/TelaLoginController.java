package br.ufrpe.account_manager.gui;

import br.ufrpe.account_manager.SistemaAccountManager;
import br.ufrpe.account_manager.exception.NegocioException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TelaLoginController {

	@FXML
	private Button TLOGIN_BT_ACESSAR;
	@FXML
	private TextField TLOGIN_TF_USUARIO; //NOME DA CENA_TEXTFIELD_USUARIO| nome de usuário
	@FXML
	private PasswordField TLOGIN_PF_SENHA;
	@FXML
	private Label TLOGIN_LB_REGISTRO;// Ainda nao é registrado?
	@FXML
	private Label TLOGIN_LB_AJUDA;// Precisa de Ajuda?
	
	private Principal principal; //Classe que inicia as cenas
	SistemaAccountManager fachada = SistemaAccountManager.getInstance(); //instancia da fachada
	
	
	public void setPrincipal(Principal principal) {
		this.principal = principal;
	}

	public void acessarLogin() throws NegocioException {
		this.setPrincipal(principal.getInstance());
	}

	@FXML
	public void acessarLogin(ActionEvent event) throws NegocioException {

		try {
			 if (this.fachada.efetuarLogin(TLOGIN_TF_USUARIO.getText(), TLOGIN_PF_SENHA.getText()) == 1) {
				Parent root;
				Stage stage;

				stage = (Stage) TLOGIN_BT_ACESSAR.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/br/ufrpe/sistema_mercadinho/gui/TelaMenuPrincipal.fxml"));
				Scene scene = new Scene(root);
				stage.setScene(scene);
			}else if (this.fachada.efetuarLogin(TLOGIN_TF_USUARIO.getText(), TLOGIN_PF_SENHA.getText()) == -1) {
				Parent root;
				Stage stage;

				stage = (Stage) TLOGIN_BT_ACESSAR.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/br/ufrpe/sistema_mercadinho/gui/TelaLogin.fxml"));
				Scene scene = new Scene(root);
				stage.setScene(scene);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
}
