package br.ufrpe.account_manager.gui;

import java.util.ArrayList;

import br.ufrpe.account_manager.SistemaAccountManager;
import br.ufrpe.account_manager.exception.NegocioException;
import br.ufrpe.account_manager.negocio.beans.Pessoa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class TelaMenuPrincipalController {

	@FXML
	private Label TMenuPrincipal_LB_SejaBemVindo;
	@FXML
	private Label TMenuPrincipal_LB_Nome;
	@FXML
	private Label TMenuPrincipal_LB_Sobrenome;
	@FXML
	private Hyperlink TMenuPrincipal_HL_MeuPerfil;
	@FXML
	private Label TMenuPrincipal_LB_Configuracoes;
	@FXML
	private MenuItem TMenuPrincipal_BTConfiguracoes_MI_Banco;
	@FXML
	private MenuItem TMenuPrincipal_BTConfiguracoes_MI_Categoria;
	@FXML
	private Label TMenuPrincipal_LB_Cadastro;
	@FXML
	private MenuItem TMenuPrincipal_BTCadastro_MI_Contatos;
	@FXML
	private MenuItem TMenuPrincipal_BTCadastro_MI_Contas;
	@FXML
	private Hyperlink TMenuPrincipal_HL_Contas;
	@FXML
	private Hyperlink TMenuPrincipal_HL_Sair;

	SistemaAccountManager fachada;

	@FXML
	public void initialize() throws Exception {
		fachada = SistemaAccountManager.getInstance();
	}

	@FXML
	public void menuMeuPerfil(ActionEvent event) {
		Parent root;
		Stage stage;
		try {

			if (event.getTarget() == TMenuPrincipal_HL_MeuPerfil) {
				stage = (Stage) TMenuPrincipal_HL_MeuPerfil.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaMeuPerfil.fxml"));
			} else {
				stage = (Stage) TMenuPrincipal_HL_MeuPerfil.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaMenuPrincipal.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@FXML
	public void menuConfiguracaoBanco(ActionEvent event) {

	}

	@FXML
	public void menuConfiguracaoCategoria(ActionEvent event) {

	}

	@FXML
	public void menuCadastroContatos(ActionEvent event) {

	}

	@FXML
	public void menuCadastroContas(ActionEvent event) {

	}

	@FXML
	public void menuContas(ActionEvent event) {

	}

	@FXML
	public void menuSair(ActionEvent event) {
		Parent root;
		Stage stage;
		try {

			if (event.getTarget() == TMenuPrincipal_HL_Sair) {
				stage = (Stage) TMenuPrincipal_HL_Sair.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaLogin.fxml"));
			} else {
				stage = (Stage) TMenuPrincipal_HL_Sair.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaMenuPrincipal.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}