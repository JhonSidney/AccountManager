package br.ufrpe.account_manager.gui;

import br.ufrpe.account_manager.SistemaAccountManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class TelaMenuRelatoriosController {
	@FXML
	private Hyperlink TelaMenuRelatorio_HL_RelatorioMensal;
	@FXML
	private Button TelaMenuRelatorio_BT_Logoff;
	@FXML
	private Button TelaMenuRelatorio_BT_Voltar;
	
	
	SistemaAccountManager fachada;
	
	
	public void initialize() {
		fachada = SistemaAccountManager.getInstance();
	}
	
	@FXML
	public void botao_logoff(ActionEvent event) {
		Parent root;
		Stage stage;
		try {

			if (event.getTarget() == TelaMenuRelatorio_BT_Logoff) {
				Alert alerts = new Alert(AlertType.INFORMATION);
				alerts.setTitle("Confirmação da opção");
				alerts.setHeaderText(null);
				alerts.setContentText("Logoff com Sucesso ! ");
				alerts.showAndWait();
				
				stage = (Stage) TelaMenuRelatorio_BT_Logoff.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaLogin.fxml"));
			} else {
				stage = (Stage) TelaMenuRelatorio_BT_Logoff.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaMenuRelatorios.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void botao_voltar(ActionEvent event) {
		Parent root;
		Stage stage;
		try {

			if (event.getTarget() == TelaMenuRelatorio_BT_Voltar) {
				stage = (Stage) TelaMenuRelatorio_BT_Voltar.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaMenuPrincipal.fxml"));
			} else {
				stage = (Stage) TelaMenuRelatorio_BT_Voltar.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaMenuRelatorios.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void relatorioMensal(ActionEvent event) {
		Parent root;
		Stage stage;
		try {

			if (event.getTarget() == TelaMenuRelatorio_HL_RelatorioMensal) {
				stage = (Stage) TelaMenuRelatorio_HL_RelatorioMensal.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaMenuRelatoriosMensal.fxml"));
			} else {
				stage = (Stage) TelaMenuRelatorio_HL_RelatorioMensal.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaMenuRelatorios.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
