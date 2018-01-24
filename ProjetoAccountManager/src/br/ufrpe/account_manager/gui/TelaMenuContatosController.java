package br.ufrpe.account_manager.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import br.ufrpe.account_manager.SistemaAccountManager;
import br.ufrpe.account_manager.exception.NegocioException;
import br.ufrpe.account_manager.negocio.beans.Contato;
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
import javafx.scene.input.MouseEvent;
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
	private Button TelaMenuContatos_BT_limpar;
	@FXML
	private TextField TelaMenuContatos_TF_Nome;
	@FXML
	private TextField TelaMenuContatos_TF_Sobrenome;
	@FXML
	private TextField TelaMenuContatos_TF_Cpf;
	@FXML
	private TextField TelaMenuContatos_TF_logradouro;
	@FXML
	private TextField TelaMenuContatos_TF_Telefone;
	@FXML
	private TextField TelaMenuContatos_TF_Comentario;
	@FXML
	private TextField TelaMenuContatos_TF_Email;
	@FXML
	private Button TelaMenuContatos_BT_Logoff;
	@FXML
	private Button botao_voltar;
	@FXML
	private Button adicionarContato;
	@FXML
	private Button atualizarContato;
	@FXML
	private TableView<Contato> tabelaContatos;
	@FXML
	private TableColumn<Contato, String> colunaNome;
	@FXML
	private TableColumn<Contato, String> colunaSobrenome;
	@FXML
	private TableColumn<Contato, String> colunaCpf;
	@FXML
	private TableColumn<Contato, String> colunaTelefone;
	@FXML
	private TableColumn<Contato, String> colunaLogradouro;
	@FXML
	private TableColumn<Contato, String> colunaComentario;
	@FXML
	private TableColumn<Contato, String> colunaEmail;
	SistemaAccountManager fachada;

	
	
	
	
	@FXML
	public void atualizarContato(ActionEvent event) {
		Parent root;
		Stage stage;
		try {
			if (validateFields()) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Confirmação de seleção ");
				alert.setHeaderText("Atualizar Contato");
				alert.setContentText("você tem certeza ?");
				Optional<ButtonType> result = alert.showAndWait();

				String nome, sobrenome, cpf, logradouro, email, comentario, telefone;
				cpf = TelaMenuContatos_TF_Cpf.getText();
				nome = TelaMenuContatos_TF_Nome.getText();
				sobrenome = TelaMenuContatos_TF_Sobrenome.getText();
				logradouro = TelaMenuContatos_TF_logradouro.getText();
				email = TelaMenuContatos_TF_Email.getText();
				comentario = TelaMenuContatos_TF_Comentario.getText();
				telefone = TelaMenuContatos_TF_Telefone.getText();
				Contato novoContato = new Contato(nome, sobrenome, logradouro, telefone, comentario, cpf, email);

				if (event.getTarget() == TelaMenuContatos_BT_Atualizar) {
					if (result.get() == ButtonType.OK) {
						SistemaAccountManager.getInstance().alterarContato(novoContato);
						limparForm1();
						refreshTable();

						Alert alerts = new Alert(AlertType.INFORMATION);
						alerts.setTitle("Confirmação da opção");
						alerts.setHeaderText(null);
						alerts.setContentText("Usuario Atualizado com Sucesso! ");
						alerts.showAndWait();

						stage = (Stage) TelaMenuContatos_BT_Atualizar.getScene().getWindow();
						root = FXMLLoader
								.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaMenuContatos.fxml"));

					} else {
						stage = (Stage) TelaMenuContatos_BT_Atualizar.getScene().getWindow();
						root = FXMLLoader
								.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaMenuContatos.fxml"));
					}

					Scene scene = new Scene(root);
					stage.setScene(scene);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@FXML
	public void removerContato(ActionEvent event) {
		Parent root;
		Stage stage;

		try {
			if (validateFields()) {
				String nome, sobrenome, cpf, logradouro, email, comentario, telefone;
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Confirmação de seleção ");
				alert.setHeaderText("Remover Contato");
				alert.setContentText("você tem certeza ?");
				Optional<ButtonType> result = alert.showAndWait();

				cpf = TelaMenuContatos_TF_Cpf.getText();
				nome = TelaMenuContatos_TF_Nome.getText();
				sobrenome = TelaMenuContatos_TF_Sobrenome.getText();
				logradouro = TelaMenuContatos_TF_logradouro.getText();
				email = TelaMenuContatos_TF_Email.getText();
				comentario = TelaMenuContatos_TF_Comentario.getText();
				telefone = TelaMenuContatos_TF_Telefone.getText();
				Contato novoContato = new Contato(nome, sobrenome, logradouro, telefone, comentario, cpf, email);

				if (event.getTarget() == TelaMenuContatos_BT_Remover) {
					if (result.get() == ButtonType.OK) {
						SistemaAccountManager.getInstance().removerContato(novoContato.getCpf());
						limparForm1();
						refreshTable();

						Alert alerts = new Alert(AlertType.INFORMATION);
						alerts.setTitle("Confirmação da opção");
						alerts.setHeaderText(null);
						alerts.setContentText("Usuario Removido com Sucesso! ");
						alerts.showAndWait();
						stage = (Stage) TelaMenuContatos_BT_Remover.getScene().getWindow();
						root = FXMLLoader
								.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaMenuContatos.fxml"));

					} else {
						stage = (Stage) TelaMenuContatos_BT_Remover.getScene().getWindow();
						root = FXMLLoader
								.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaMenuContatos.fxml"));
					}

					Scene scene = new Scene(root);
					stage.setScene(scene);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void adicionarContato(ActionEvent event) throws NegocioException, IOException {

		Parent root;
		Stage stage;
		try {
			if (validateFields()) {
				String nome, sobrenome, cpf, logradouro, email, comentario, telefone;

				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Confirmação de seleção ");
				alert.setHeaderText("Adicionar Contato");
				alert.setContentText("você tem certeza ?");
				Optional<ButtonType> result = alert.showAndWait();

				cpf = TelaMenuContatos_TF_Cpf.getText();
				nome = TelaMenuContatos_TF_Nome.getText();
				sobrenome = TelaMenuContatos_TF_Sobrenome.getText();
				logradouro = TelaMenuContatos_TF_logradouro.getText();
				email = TelaMenuContatos_TF_Email.getText();
				comentario = TelaMenuContatos_TF_Comentario.getText();
				telefone = TelaMenuContatos_TF_Telefone.getText();
				Contato novoContato = new Contato(nome, sobrenome, logradouro, telefone, comentario, cpf, email);
				SistemaAccountManager.getInstance().cadastrarContato(novoContato);
				limparForm1();
				refreshTable();

				if (event.getTarget() == TelaMenuContatos_BT_Adicionar) {
					if (result.get() == ButtonType.OK) {

						Alert alerts = new Alert(AlertType.INFORMATION);
						alerts.setTitle("Confirmação da opção");
						alerts.setHeaderText(null);
						alerts.setContentText("Usuario Adicionado com Sucesso! ");
						alerts.showAndWait();

						stage = (Stage) TelaMenuContatos_BT_Adicionar.getScene().getWindow();
						root = FXMLLoader
								.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaMenuContatos.fxml"));

					} else {
						stage = (Stage) TelaMenuContatos_BT_Adicionar.getScene().getWindow();
						root = FXMLLoader
								.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaMenuContatos.fxml"));
					}
					Scene scene = new Scene(root);
					stage.setScene(scene);

				}
			}
		} catch (NegocioException e) {
			//e.printStackTrace();
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Error");
			alert.setHeaderText("Atenção!");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}

	@FXML
	private void refreshTable() throws NegocioException {
		ObservableList<Contato> data = FXCollections.observableArrayList();
		data.addAll(fachada.listarContatos());
		tabelaContatos.setItems(data);
	}

	@FXML
	public void limparForm1() {
		try {
			TelaMenuContatos_TF_Nome.clear();
			TelaMenuContatos_TF_Sobrenome.clear();
			TelaMenuContatos_TF_Cpf.clear();
			TelaMenuContatos_TF_Telefone.clear();
			TelaMenuContatos_TF_logradouro.clear();
			TelaMenuContatos_TF_Email.clear();
			TelaMenuContatos_TF_Comentario.clear();
			tabelaContatos.getSelectionModel().clearSelection();
			TelaMenuContatos_TF_Cpf.setStyle(null);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@FXML
	public void limparForm2(ActionEvent event) throws NegocioException {
		Parent root;
		Stage stage;
		try {
			limparForm1();
			refreshTable();
			
			if (event.getTarget() == TelaMenuContatos_BT_limpar) {
			stage = (Stage) TelaMenuContatos_BT_Adicionar.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaMenuContatos.fxml"));

			}else {
				stage = (Stage) TelaMenuContatos_BT_Adicionar.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaMenuContatos.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {

		}

	}

	private boolean validateFields() throws IOException {
		boolean validate = false;
		try {
			if (TelaMenuContatos_TF_Nome.getText().isEmpty() || TelaMenuContatos_TF_Sobrenome.getText().isEmpty()
					|| TelaMenuContatos_TF_Cpf.getText().isEmpty() || TelaMenuContatos_TF_Telefone.getText().isEmpty()
					|| TelaMenuContatos_TF_logradouro.getText().isEmpty()
					|| TelaMenuContatos_TF_Email.getText().isEmpty()
					|| TelaMenuContatos_TF_Comentario.getText().isEmpty()) {

				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Error");
				alert.setHeaderText("Informações inválidas");
				alert.setContentText("Verifique os campos digitados!");
				alert.showAndWait();

			} else {
				validate = true;
			}
		} catch (NumberFormatException e) {
			// e.getMessage();
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Error");
			alert.setHeaderText("Formato dos campos invalidos");
			alert.setContentText("Verifique os campos digitados!");
			alert.showAndWait();

		}
		return validate;
	}

	@FXML
	public void selecionarCliente(MouseEvent arg0) {
		if (!tabelaContatos.getSelectionModel().isEmpty()) {
			Contato c = tabelaContatos.getSelectionModel().getSelectedItem();
			TelaMenuContatos_TF_Cpf.setText(c.getCpf());
			TelaMenuContatos_TF_Nome.setText(c.getNome());
			TelaMenuContatos_TF_Sobrenome.setText(c.getSobrenome());
			TelaMenuContatos_TF_Email.setText(c.getEmail());
			TelaMenuContatos_TF_Comentario.setText(c.getComentario());
			TelaMenuContatos_TF_Telefone.setText(c.getTel());
			TelaMenuContatos_TF_logradouro.setText(c.getLogradouro());
			TelaMenuContatos_TF_Cpf.editableProperty().set(false);
			TelaMenuContatos_TF_Cpf.setStyle("-fx-background-color: #ff8c00;");
		}
	}

	@FXML
	public void botao_logoff(ActionEvent event) {
		Parent root;
		Stage stage;
		try {

			if (event.getTarget() == TelaMenuContatos_BT_Logoff) {
				Alert alerts = new Alert(AlertType.INFORMATION);
				alerts.setTitle("Confirmação da opção");
				alerts.setHeaderText(null);
				alerts.setContentText("Logoff com Sucesso ! ");
				alerts.showAndWait();
				
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {

			fachada = SistemaAccountManager.getInstance();
			ArrayList<Contato> cont = fachada.getInstance().listarContatos();
			colunaNome.setCellValueFactory(new PropertyValueFactory<Contato, String>("nome"));
			colunaSobrenome.setCellValueFactory(new PropertyValueFactory<Contato, String>("sobrenome"));
			colunaCpf.setCellValueFactory(new PropertyValueFactory<Contato, String>("cpf"));
			colunaTelefone.setCellValueFactory(new PropertyValueFactory<Contato, String>("tel"));
			colunaEmail.setCellValueFactory(new PropertyValueFactory<Contato, String>("email"));
			colunaLogradouro.setCellValueFactory(new PropertyValueFactory<Contato, String>("logradouro"));
			colunaComentario.setCellValueFactory(new PropertyValueFactory<Contato, String>("comentario"));
			tabelaContatos.setItems(FXCollections.observableArrayList(cont));

		} catch (NegocioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}