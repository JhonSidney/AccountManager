package br.ufrpe.account_manager.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import br.ufrpe.account_manager.SistemaAccountManager;
import br.ufrpe.account_manager.exception.NegocioException;
import br.ufrpe.account_manager.negocio.beans.Conta;
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

public class TelaMenuContasController implements Initializable {

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
	private Button TelaMenuContas_BT_Remover;
	@FXML
	private Button TelaMenuContas_BT_Atualizar;
	@FXML
	private Button TelaMenuContas_BT_Limpar;
	@FXML
	private Button TelaMenuContas_BT_Voltar;
	@FXML
	private Button TelaMenuContas_BT_logoff;
	@FXML
	private TableView<Conta> tabelaContas;
	@FXML
	private TableColumn<Contato, String> colunaId;
	@FXML
	private TableColumn<Contato, String> colunaNome;
	@FXML
	private TableColumn<Contato, String> colunaDescricao;
	@FXML
	private TableColumn<Contato, String> colunaDataVencimento;
	@FXML
	private TableColumn<Contato, String> colunaValor;
	
	SistemaAccountManager fachada;
	
	public void initialize() {
		fachada = SistemaAccountManager.getInstance();
	}
	
	@FXML
	public void atualizarConta(ActionEvent event) {
		Parent root;
		Stage stage;
		try {
			if (validateFields()) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Confirmação de seleção ");
				alert.setHeaderText("Atualizar Conta");
				alert.setContentText("você tem certeza ?");
				Optional<ButtonType> result = alert.showAndWait();

				String id, nome, descricao,  dataVencimento, valor;
				id = TelaMenuContas_TF_Id.getText();
				nome = TelaMenuContas_TF_Nome.getText();
				descricao = TelaMenuContas_TF_Descricao.getText();
				dataVencimento = TelaMenuContas_TF_DataVencimento.getText();
				valor = TelaMenuContas_TF_Valor.getText();
				Conta conta = new Conta(id, nome, descricao, dataVencimento, valor);
				if (event.getTarget() == TelaMenuContas_BT_Atualizar) {
					if (result.get() == ButtonType.OK) {
						SistemaAccountManager.getInstance().alterarConta(conta);
						limparForm1();
						refreshTable();

						Alert alerts = new Alert(AlertType.INFORMATION);
						alerts.setTitle("Confirmação da opção");
						alerts.setHeaderText(null);
						alerts.setContentText("Conta Atualizada com Sucesso! ");
						alerts.showAndWait();

						stage = (Stage) TelaMenuContas_BT_Atualizar.getScene().getWindow();
						root = FXMLLoader
								.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaMenuContas.fxml"));

					} else {
						stage = (Stage) TelaMenuContas_BT_Atualizar.getScene().getWindow();
						root = FXMLLoader
								.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaMenuContas.fxml"));
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
	public void removerConta(ActionEvent event) {
		Parent root;
		Stage stage;

		try {
			if (validateFields()) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Confirmação de seleção ");
				alert.setHeaderText("Remover Conta");
				alert.setContentText("você tem certeza ?");
				Optional<ButtonType> result = alert.showAndWait();

				String id, nome, descricao,  dataVencimento, valor;
				id = TelaMenuContas_TF_Id.getText();
				nome = TelaMenuContas_TF_Nome.getText();
				descricao = TelaMenuContas_TF_Descricao.getText();
				dataVencimento = TelaMenuContas_TF_DataVencimento.getText();
				valor = TelaMenuContas_TF_Valor.getText();
				Conta conta = new Conta(id, nome, descricao, dataVencimento, valor);

				if (event.getTarget() == TelaMenuContas_BT_Remover) {
					if (result.get() == ButtonType.OK) {
						SistemaAccountManager.getInstance().removerConta(conta.getId());
						limparForm1();
						refreshTable();

						Alert alerts = new Alert(AlertType.INFORMATION);
						alerts.setTitle("Confirmação da opção");
						alerts.setHeaderText(null);
						alerts.setContentText("Conta Removida com Sucesso! ");
						alerts.showAndWait();
						stage = (Stage) TelaMenuContas_BT_Remover.getScene().getWindow();
						root = FXMLLoader
								.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaMenuContas.fxml"));

					} else {
						stage = (Stage) TelaMenuContas_BT_Remover.getScene().getWindow();
						root = FXMLLoader
								.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaMenuContas.fxml"));
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
	public void adicionarConta(ActionEvent event) throws NegocioException, IOException {

		Parent root;
		Stage stage;
		try {
			if (validateFields()) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Confirmação de seleção ");
				alert.setHeaderText("Adicionar Conta");
				alert.setContentText("você tem certeza ?");
				Optional<ButtonType> result = alert.showAndWait();

				String id, nome, descricao,  dataVencimento, valor;
				id = TelaMenuContas_TF_Id.getText();
				nome = TelaMenuContas_TF_Nome.getText();
				descricao = TelaMenuContas_TF_Descricao.getText();
				dataVencimento = TelaMenuContas_TF_DataVencimento.getText();
				valor = TelaMenuContas_TF_Valor.getText();
				Conta conta = new Conta(id, nome, descricao, dataVencimento, valor);

				if (event.getTarget() == TelaMenuContas_BT_Adicionar) {
					if (result.get() == ButtonType.OK) {
						fachada.cadastrarConta(conta);;
						limparForm1();
						refreshTable();

						Alert alerts = new Alert(AlertType.INFORMATION);
						alerts.setTitle("Confirmação da opção");
						alerts.setHeaderText(null);
						alerts.setContentText("Usuario Adicionado com Sucesso! ");
						alerts.showAndWait();

						stage = (Stage) TelaMenuContas_BT_Adicionar.getScene().getWindow();
						root = FXMLLoader
								.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaMenuContas.fxml"));

					} else {
						stage = (Stage) TelaMenuContas_BT_Adicionar.getScene().getWindow();
						root = FXMLLoader
								.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaMenuContas.fxml"));
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
		ObservableList<Conta> data = FXCollections.observableArrayList();
		data.addAll(fachada.listarContas());
		tabelaContas.setItems(data);
	}

	@FXML
	public void limparForm1() {
		try {
			TelaMenuContas_TF_Id.clear();
			TelaMenuContas_TF_Nome.clear();
			TelaMenuContas_TF_Descricao.clear();
			TelaMenuContas_TF_DataVencimento.clear();
			TelaMenuContas_TF_Valor.clear();
			tabelaContas.getSelectionModel().clearSelection();
			TelaMenuContas_TF_Id.setStyle(null);

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
			
			if (event.getTarget() == TelaMenuContas_BT_Limpar) {
			stage = (Stage) TelaMenuContas_BT_Limpar.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaMenuContas.fxml"));

			}else {
				stage = (Stage) TelaMenuContas_BT_Limpar.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaMenuContas.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {

		}

	}

	private boolean validateFields() throws IOException {
		boolean validate = false;
		try {
			if (TelaMenuContas_TF_Id.getText().isEmpty() || TelaMenuContas_TF_Nome.getText().isEmpty()
					|| TelaMenuContas_TF_DataVencimento.getText().isEmpty()
					|| TelaMenuContas_TF_Descricao.getText().isEmpty()
					|| TelaMenuContas_TF_Valor.getText().isEmpty()) {

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
		if (!tabelaContas.getSelectionModel().isEmpty()) {
			Conta c = tabelaContas.getSelectionModel().getSelectedItem();
			TelaMenuContas_TF_Id.setText(c.getId());
			TelaMenuContas_TF_Nome.setText(c.getNome());
			TelaMenuContas_TF_Descricao.setText(c.getDescricao());
			TelaMenuContas_TF_DataVencimento.setText(c.getDataVencimento());
			TelaMenuContas_TF_Valor.setText(c.getValor());
			TelaMenuContas_TF_Id.editableProperty().set(false);
			TelaMenuContas_TF_Id.setStyle("-fx-background-color: #ff8c00;");
		}
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
	public void botao_logoff(ActionEvent event) {
		Parent root;
		Stage stage;
		try {

			if (event.getTarget() == TelaMenuContas_BT_logoff) {
				Alert alerts = new Alert(AlertType.INFORMATION);
				alerts.setTitle("Confirmação da opção");
				alerts.setHeaderText(null);
				alerts.setContentText("Logoff com Sucesso ! ");
				alerts.showAndWait();
				
				stage = (Stage) TelaMenuContas_BT_logoff.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaLogin.fxml"));
			} else {
				stage = (Stage) TelaMenuContas_BT_logoff.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaMenuContas.fxml"));
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
			ArrayList<Conta> cont = fachada.getInstance().listarContas();
			colunaId.setCellValueFactory(new PropertyValueFactory<Contato, String>("id"));
			colunaNome.setCellValueFactory(new PropertyValueFactory<Contato, String>("nome"));
			colunaDescricao.setCellValueFactory(new PropertyValueFactory<Contato, String>("descricao"));
			colunaDataVencimento.setCellValueFactory(new PropertyValueFactory<Contato, String>("dataVencimento"));
			colunaValor.setCellValueFactory(new PropertyValueFactory<Contato, String>("valor"));
			tabelaContas.setItems(FXCollections.observableArrayList(cont));

		} catch (NegocioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
