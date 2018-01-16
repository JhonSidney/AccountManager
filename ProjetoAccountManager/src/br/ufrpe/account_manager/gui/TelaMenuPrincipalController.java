package br.ufrpe.account_manager.gui;

import java.util.ArrayList;

import org.w3c.dom.events.Event;

import br.ufrpe.account_manager.SistemaAccountManager;
import br.ufrpe.account_manager.exception.NegocioException;
import br.ufrpe.account_manager.negocio.beans.Pessoa;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
	private Hyperlink TMenuPrincipal_HL_MeuPerfil;
	@FXML
	private Hyperlink TMenuPrincipal_HL_Contatos;
	@FXML
	private Hyperlink TMenuPrincipal_HL_Contas;
	@FXML
	private Hyperlink TMenuPrincipal_HL_Bancos;
	@FXML
	private Hyperlink TMenuPrincipal_HL_Categoria;
	@FXML
	private Hyperlink TMenuPrincipal_HL_Relatorios;
	@FXML
	private Button TMenuPrincipal_BT_logoff;

	SistemaAccountManager fachada;
	String nome, sobrenome, cpf, salario, id, email, senha, logradouro, nascimento, tel;

	@FXML
	public void initialize() throws Exception {
		fachada = SistemaAccountManager.getInstance();
		Pessoa pessoa = new Pessoa(nome, sobrenome, cpf, salario, id, email, senha, logradouro, nascimento, tel);
		pessoa = fachada.getLogado();
		TMenuPrincipal_LB_Nome.setText(" " + pessoa.getNome() + "  " + pessoa.getSobrenome());
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
	public void menuContatos(ActionEvent event) {

		Parent root;
		Stage stage;
		try {

			if (event.getTarget() == TMenuPrincipal_HL_Contatos) {
				stage = (Stage) TMenuPrincipal_HL_Contatos.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaMenuContatos.fxml"));
			} else {
				stage = (Stage) TMenuPrincipal_HL_Contatos.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaMenuPrincipal.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@FXML
	public void menuContas(ActionEvent event) {
		
		Parent root;
		Stage stage;
		try {

			if (event.getTarget() == TMenuPrincipal_HL_Contas) {
				stage = (Stage) TMenuPrincipal_HL_Contas.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaMenuContas.fxml"));
			} else {
				stage = (Stage) TMenuPrincipal_HL_Contas.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaMenuPrincipal.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@FXML
	public void menuBancos(ActionEvent event) {

	}
	
	
	@FXML
	public void menuCategoria(ActionEvent event) {

	}
	
	
	@FXML
	public void menuRelatorio(ActionEvent event) {

	}

	
	@FXML
	public void botao_logoff(ActionEvent event) {
		Parent root;
		Stage stage;
		try {

			if (event.getTarget() == TMenuPrincipal_BT_logoff) {
				stage = (Stage) TMenuPrincipal_BT_logoff.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaLogin.fxml"));
			} else {
				stage = (Stage) TMenuPrincipal_BT_logoff.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaMenuPrincipal.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}