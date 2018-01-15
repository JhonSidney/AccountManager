package br.ufrpe.account_manager.gui;

import br.ufrpe.account_manager.SistemaAccountManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TelaMenuContatosController {

	@FXML
	private Button TelaMenuContatos_BT_Voltar;

	@FXML
	private TextField TelaMenuContatos_TF_Nome;
	@FXML
	private TextField TelaMenuContatos_TF_Sobrenome;
	@FXML
	private TextField TelaMenuContatos_TF_Email;
	@FXML
	private TextField TelaMenuContatos_TF_Endereco;
	@FXML
	private TextField TelaMenuContatos_TF_Telefone;
	@FXML
	private TextField TelaMenuContatos_TF_Comentario;
	
	@FXML
	private Button TelaMenuContatos_BT_Logoff;
	
	SistemaAccountManager fachada;
	
	public void initializable() {
		fachada = SistemaAccountManager.getInstance();
	}
	
	@FXML
	public void botao_voltar(ActionEvent event) {
		Parent root;
		Stage stage;
		try {

			if (event.getTarget() == TelaMenuContatos_BT_Voltar) {
				stage = (Stage) TelaMenuContatos_BT_Voltar.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaMenuPrincipal.fxml"));
			} else {
				stage = (Stage) TelaMenuContatos_BT_Voltar.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaMenuContatos.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void botao_logoff(ActionEvent event) {
		Parent root;
		Stage stage;
		try {

			if (event.getTarget() == TelaMenuContatos_BT_Logoff) {
				stage = (Stage) TelaMenuContatos_BT_Logoff.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaLogin.fxml"));
			} else {
				stage = (Stage) TelaMenuContatos_BT_Logoff.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaMenuContatos.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
