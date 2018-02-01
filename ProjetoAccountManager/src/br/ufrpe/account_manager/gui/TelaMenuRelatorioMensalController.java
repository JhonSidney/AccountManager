package br.ufrpe.account_manager.gui;

import java.net.URL;
import java.util.ResourceBundle;

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
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;


public class TelaMenuRelatorioMensalController  {
	
	@FXML
	private Label RelatorioMensal_LB_ValorReceber;
	@FXML
	private Label RelatorioMensal_LB_ValorPagar;
	@FXML
	private Label RelatorioMensal_LB_GastosDebitos;
	@FXML
	private Label RelatorioMensal_LB_GastosDinheiro;
	@FXML
	private Label RelatorioMensal_LB_GastosCreditos;
	@FXML
	private Label RelatorioMensal_LB_MeuSalario;
	@FXML
	private Button TelaMenuRelatorioMensal_BT_Voltar;
	@FXML
	private Button TelaMenuRelatorioMensal_BT_Logoff;
	@FXML
	private TabPane paneRelatorioMensal;
	@FXML
	private Tab mensal;
	
	
	SistemaAccountManager fachada;
	String nome, sobrenome, cpf, salario, id, email, senha, logradouro, nascimento, tel;
	private Pessoa pessoa;

	
	
	public void Initializable(URL url, ResourceBundle rb){
		fachada = SistemaAccountManager.getInstance();
		paneRelatorioMensal.getTabs().add(mensal);
		this.preencheDados();
		}
	
	@FXML
	private void preencheDados() {
		new Pessoa(nome, sobrenome, cpf, salario, id, email, senha, logradouro, nascimento, tel);
		this.pessoa = fachada.getLogado();
		RelatorioMensal_LB_MeuSalario.setText(" "+pessoa.getSalario());
		
		
	}
	
	@FXML
	public void voltar(ActionEvent event) {
		Parent root;
		Stage stage;
		try {

			if (event.getTarget() == TelaMenuRelatorioMensal_BT_Voltar) {
				stage = (Stage) TelaMenuRelatorioMensal_BT_Voltar.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaMenuRelatorios.fxml"));
			} else {
				stage = (Stage) TelaMenuRelatorioMensal_BT_Voltar.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaMenuRelatoriosMensal.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void logoff(ActionEvent event) {
		Parent root;
		Stage stage;
		try {

			if (event.getTarget() == TelaMenuRelatorioMensal_BT_Logoff) {
				Alert alerts = new Alert(AlertType.INFORMATION);
				alerts.setTitle("Confirmação da opção");
				alerts.setHeaderText(null);
				alerts.setContentText("Logoff com Sucesso ! ");
				alerts.showAndWait();
				
				stage = (Stage) TelaMenuRelatorioMensal_BT_Logoff.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaLogin.fxml"));
			} else {
				stage = (Stage) TelaMenuRelatorioMensal_BT_Logoff.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaMenuRelatoriosMensal.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

  }

	

