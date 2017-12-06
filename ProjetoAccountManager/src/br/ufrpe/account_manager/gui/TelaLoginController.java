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
	private Button TLogin_BT_Acessar;
	@FXML
	private TextField TLogin_TF_Usuario; //NOME DA CENA_TEXTFIELD_USUARIO| nome de usu�rio
	@FXML
	private PasswordField TLogin_PF_Senha;
	@FXML
	private Label TLogin_LB_Registro;// Ainda nao � registrado?
	@FXML
	private Label TLogin_LB_EsqueciSenha;// Precisa de Ajuda?
	
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
			 if (this.fachada.efetuarLogin(TLogin_TF_Usuario.getText(), TLogin_PF_Senha.getText()) == 1) {
				Parent root;
				Stage stage;

				stage = (Stage) TLogin_BT_Acessar.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/br/ufrpe/sistema_mercadinho/gui/TelaMenuPrincipal.fxml"));
				Scene scene = new Scene(root);
				stage.setScene(scene);
			}else if (this.fachada.efetuarLogin(TLogin_TF_Usuario.getText(), TLogin_PF_Senha.getText()) == -1) {
				Parent root;
				Stage stage;

				stage = (Stage) TLogin_BT_Acessar.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/br/ufrpe/sistema_mercadinho/gui/TelaLogin.fxml"));
				Scene scene = new Scene(root);
				stage.setScene(scene);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
}
