package br.ufrpe.account_manager.gui;

import java.awt.TextArea;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import br.ufrpe.account_manager.SistemaAccountManager;
import br.ufrpe.account_manager.exception.NegocioException;
import br.ufrpe.account_manager.negocio.beans.Contato;
import br.ufrpe.account_manager.negocio.beans.Pessoa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class TelaMenuContatosController implements Initializable {

	@FXML
	private Button TelaMenuContatos_BT_Voltar;
	@FXML
	private Button TelaMenuContatos_BT_Remover;
	@FXML
	private Button TelaMenuContatos_BT_Adicionar;
	@FXML
	private Button TelaMenuContatos_BT_Atualizar;
	@FXML
	private TextField TelaMenuContatos_TF_Nome;
	@FXML
	private TextField TelaMenuContatos_TF_Sobrenome;
	@FXML
	private TextField TelaMenuContatos_TF_Email;
	@FXML
	private TextField TelaMenuContatos_TF_logradouro;
	@FXML
	private TextField TelaMenuContatos_TF_Telefone;
	@FXML
	private TextField TelaMenuContatos_TF_Comentario;
	@FXML
	private Button TelaMenuContatos_BT_Logoff;
	@FXML
	private TableView<Contato> tableContatos = new TableView<Contato>();
	@FXML
	private TableColumn<Contato, String> nomeColumn = new TableColumn<Contato, String>("Nome");
	@FXML
	private TableColumn<Contato, String> telefoneColumn = new TableColumn<Contato, String>("telefone");
	@FXML
	private TableColumn<Contato, String> logradouroColumn = new TableColumn<Contato, String>("logradouro");
	@FXML
	private TableColumn<Contato, String> comentarioColumn = new TableColumn<Contato, String>("comentario");
	@FXML
	private TextArea textArea;

	SistemaAccountManager fachada;
	String nome, tel, logradouro, comentario;

	public void initialize(URL url, ResourceBundle rb) {
		fachada = SistemaAccountManager.getInstance();
		ObservableList<Contato> list;
		
		try {
			list = getUserList();
			tableContatos.setItems(list);
			for (Contato contato : list) {
				int index = 0;
				tableContatos.getItems().add(index, contato);
				index++;
			}
		} catch (NegocioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@FXML
	private ObservableList<Contato> getUserList() throws NegocioException {

		ObservableList<Contato> list = FXCollections.observableArrayList(fachada.listarContatos());
		return list;
	}

	@FXML
	private void removerContato(ActionEvent event) {

	}

	@FXML
	private void adicionarContato(ActionEvent event) throws IOException {
		Parent root;
		Stage stage;

		if (validarCampos()) {
			try {

				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Confirmação de seleção ");
				alert.setHeaderText("ADICIONAR MEU PERFIL");
				alert.setContentText("você tem certeza ?");
				Optional<ButtonType> result = alert.showAndWait();

				if (event.getTarget() == TelaMenuContatos_BT_Adicionar) {
					String nome, logradouro, tel, comentario;
					nome = TelaMenuContatos_TF_Nome.getText();
					logradouro = TelaMenuContatos_TF_logradouro.getText();
					tel = TelaMenuContatos_TF_Telefone.getText();
					comentario = TelaMenuContatos_TF_Comentario.getText();
					Contato contato = new Contato(nome, logradouro, tel, comentario);
					tableContatos.getItems().add(contato);
					fachada.cadastrarContato(contato);

					if (result.get() == ButtonType.OK) {
						Alert alerts = new Alert(AlertType.INFORMATION);
						alerts.setTitle("Confirmação da opção");
						alerts.setHeaderText(null);
						alerts.setContentText("Usuario adicionado com Sucesso! ");
						alerts.showAndWait();

						stage = (Stage) TelaMenuContatos_BT_Adicionar.getScene().getWindow();
						root = FXMLLoader
								.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaMenuContatos.fxml"));
					} else {
						stage = (Stage) TelaMenuContatos_BT_Adicionar.getScene().getWindow();
						root = FXMLLoader
								.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaMenuPrincipal.fxml"));
					}
					Scene scene = new Scene(root);
					stage.setScene(scene);

				}
			} catch (Exception e) {
				// TODO: handle exception
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Error");
				alert.setHeaderText("Atenção!");
				alert.setContentText(e.getMessage());
				alert.showAndWait();
			}
		}

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

	private boolean validarCampos() throws IOException {
		boolean validate = false;

		try {
			if (TelaMenuContatos_TF_Sobrenome.getText().isEmpty() || TelaMenuContatos_TF_logradouro.getText().isEmpty()
					|| TelaMenuContatos_TF_Telefone.getText().isEmpty()
					|| TelaMenuContatos_TF_Comentario.getText().isEmpty()
					|| TelaMenuContatos_TF_Email.getText().isEmpty()) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Error");
				alert.setHeaderText("Informações inválidas");
				alert.setContentText("Verifique os campos digitados!");
				alert.showAndWait();

			} else {
				validate = true;
			}

		} catch (NumberFormatException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Error");
			alert.setHeaderText("Formato dos campos invalidos");
			alert.setContentText("Verifique os campos digitados!");
			alert.showAndWait();
		}
		return validate;
	}

}
