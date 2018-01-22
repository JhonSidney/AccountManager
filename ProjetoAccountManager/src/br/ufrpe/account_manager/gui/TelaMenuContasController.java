package br.ufrpe.account_manager.gui;

import java.sql.Date;

import br.ufrpe.account_manager.SistemaAccountManager;
import br.ufrpe.account_manager.exception.NegocioException;
import br.ufrpe.account_manager.negocio.beans.Conta;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TelaMenuContasController {

	@FXML
	private TextField TelaMenuContas_TF_Id;
	@FXML
	private TextField TelaMenuContas_TF_Nome;
	@FXML
	private TextField TelaMenuContas_TF_Descricao;
	@FXML
	private TextField TelaMenuContas_TF_DataVencimento;
	@FXML
	private TextField TelaMenuContas_TF_Valor;
	@FXML
	private Button TelaMenuContas_BT_Adicionar;
	@FXML
	private Button TelaMenuContas_BT_Voltar;
	@FXML
	private Button TelaMenuContas_BT_logoff;
	
	SistemaAccountManager fachada;
	
	public void initialize() {
		fachada = SistemaAccountManager.getInstance();
		
	}
	
	@FXML
	public void botao_adicionarConta(ActionEvent event) {
		
		
	}
	
	
	@FXML
	public void botao_voltar(ActionEvent event) {
		Parent root;
		Stage stage;
		try {

			if (event.getTarget() == TelaMenuContas_BT_Voltar) {
				stage = (Stage) TelaMenuContas_BT_Voltar.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaMenuPrincipal.fxml"));
			} else {
				stage = (Stage) TelaMenuContas_BT_Voltar.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaMenuContas.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@FXML
	public void logoff(ActionEvent event) {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
