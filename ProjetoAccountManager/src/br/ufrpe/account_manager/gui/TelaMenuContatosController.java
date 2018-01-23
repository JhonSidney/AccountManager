package br.ufrpe.account_manager.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.xml.bind.ValidationException;

import br.ufrpe.account_manager.SistemaAccountManager;
import br.ufrpe.account_manager.exception.NegocioException;
import br.ufrpe.account_manager.negocio.beans.Contato;
import br.ufrpe.account_manager.negocio.beans.Pessoa;
import javafx.beans.property.SimpleStringProperty;
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
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TelaMenuContatosController {

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

	private ObservableList<Contato> data;
	SistemaAccountManager fachada;

	private void initialize() throws NegocioException, IOException {
		fachada = SistemaAccountManager.getInstance();

		colunaNome.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNome()));
		colunaSobrenome.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSobrenome()));
		colunaCpf.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCpf()));
		colunaLogradouro.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLogradouro()));
		colunaTelefone.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTel()));
		colunaComentario.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getComentario()));
		colunaEmail.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getComentario()));

		data = FXCollections.observableArrayList();
		data.addAll(fachada.listarContatos());
		tabelaContatos.setItems(data);

	}

	@FXML
	public void limparForm() {
		TelaMenuContatos_TF_Nome.clear();
		TelaMenuContatos_TF_Sobrenome.clear();
		TelaMenuContatos_TF_Cpf.clear();
		TelaMenuContatos_TF_Telefone.clear();
		TelaMenuContatos_TF_logradouro.clear();
		TelaMenuContatos_TF_Comentario.clear();
		TelaMenuContatos_TF_Email.clear();

		tabelaContatos.getSelectionModel().clearSelection();

	}

	public void setDados(ObservableList<Contato> dadosCliente) {
		tabelaContatos.setItems(dadosCliente);
	}

	private boolean validarCampos() throws IOException {
		boolean validate = false;
		try {
			if (TelaMenuContatos_TF_Nome.getText().isEmpty() || TelaMenuContatos_TF_Sobrenome.getText().isEmpty()
					|| TelaMenuContatos_TF_Cpf.getText().isEmpty() || TelaMenuContatos_TF_Telefone.getText().isEmpty()
					|| TelaMenuContatos_TF_logradouro.getText().isEmpty()
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

	@FXML
	private void refreshTable(){
		data = FXCollections.observableArrayList();
		System.out.println("Elementos Tablea: "+this.tabelaContatos.getItems().toString());
		try {
			for(Contato c : this.fachada.listarContatos()) {
				this.tabelaContatos.getItems().add(c);
			}
			this.tabelaContatos.refresh();
//			data.addAll(fachada.listarContatos());	
		}catch(NegocioException e) {
			e.printStackTrace();
		}
		//tabelaContatos.setItems(data);
		System.out.println("Elementos Tablea: "+this.tabelaContatos.getItems().toString());
		
	}

	@FXML
	public void selecionarCliente(MouseEvent arg0) {
		if (!tabelaContatos.getSelectionModel().isEmpty()) {
			Contato c = tabelaContatos.getSelectionModel().getSelectedItem();
			TelaMenuContatos_TF_Nome.setText(c.getNome());
			TelaMenuContatos_TF_Sobrenome.setText(c.getSobrenome());
			TelaMenuContatos_TF_Cpf.setText(c.getCpf());
			TelaMenuContatos_TF_logradouro.setText(c.getLogradouro());
			TelaMenuContatos_TF_Telefone.setText(c.getTel());
			TelaMenuContatos_TF_Comentario.setText(c.getComentario());
			TelaMenuContatos_TF_Email.setText(c.getEmail());
			TelaMenuContatos_TF_Cpf.editableProperty().set(false);
			TelaMenuContatos_TF_Cpf.setStyle("-fx-background-color: blue;");
			
		}
	}

	@FXML
	public void adicionarContato(ActionEvent event) throws IOException, NegocioException {
		this.fachada = SistemaAccountManager.getInstance();
		if (validarCampos()) {
			String nome, sobrenome, cpf, logradouro, comentario, email, telefone;
			nome = TelaMenuContatos_TF_Nome.getText();
			sobrenome = TelaMenuContatos_TF_Sobrenome.getText();
			cpf = TelaMenuContatos_TF_Cpf.getText();
			logradouro = TelaMenuContatos_TF_logradouro.getText();
			telefone = TelaMenuContatos_TF_Telefone.getText();
			email = TelaMenuContatos_TF_Email.getText();
			comentario = TelaMenuContatos_TF_Comentario.getText();
			Contato cont = new Contato(nome, sobrenome, logradouro, telefone, comentario, cpf, email);
			if(fachada != null) System.out.println("ok");
			this.fachada.cadastrarContato(cont);
			refreshTable();
			limparForm();
			
		}

	}

	@FXML
	public void atualizarContato(ActionEvent event) {
		
		try {
			this.fachada = SistemaAccountManager.getInstance();
			String nome, sobrenome, logradouro, tel, comentario, cpf, email;
			nome = TelaMenuContatos_TF_Nome.getText();
			sobrenome = TelaMenuContatos_TF_Sobrenome.getText();
			logradouro = TelaMenuContatos_TF_logradouro.getText();
			tel = TelaMenuContatos_TF_Telefone.getText();
			comentario = TelaMenuContatos_TF_Comentario.getText();
			cpf = TelaMenuContatos_TF_Cpf.getText();
			email = TelaMenuContatos_TF_Email.getText();
			Contato novoContato = new Contato(nome, sobrenome, logradouro, tel, comentario, cpf, email);
			novoContato.setNome(nome);
			novoContato.setSobrenome(sobrenome);
			novoContato.setLogradouro(logradouro);
			novoContato.setTel(tel);
			novoContato.setComentario(comentario);
			novoContato.setCpf(cpf);
			novoContato.setEmail(email);
			this.fachada.alterarContato(novoContato);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void removerContato(ActionEvent event) {

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
