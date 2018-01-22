package br.ufrpe.account_manager.gui;

import br.ufrpe.account_manager.SistemaAccountManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

public class TelaMenuRelatoriosController {
	@FXML
	private Hyperlink TelaMenuRelatorio_HL_Relatorio;
	
	SistemaAccountManager fachada;
	
	
	public void initialize() {
		fachada = SistemaAccountManager.getInstance();
	}
	
	@FXML
	public void link_RelatorioMensal(ActionEvent event) {
		Parent root;
		Stage stage;
		try {

			if (event.getTarget() == TelaMenuRelatorio_HL_Relatorio) {
				stage = (Stage) TelaMenuRelatorio_HL_Relatorio.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaMenuRelatorios.fxml"));
			} else {
				stage = (Stage) TelaMenuRelatorio_HL_Relatorio.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaMenuContas.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
