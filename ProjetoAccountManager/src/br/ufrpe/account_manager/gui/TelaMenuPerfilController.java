package br.ufrpe.account_manager.gui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import br.ufrpe.account_manager.SistemaAccountManager;
import br.ufrpe.account_manager.exception.NegocioException;
import br.ufrpe.account_manager.negocio.beans.Pessoa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TelaMenuPerfilController {

	@FXML
	private TextField TelaMenuPerfil_TF_Nome;
	@FXML
	private TextField TelaMenuPerfil_TF_Sobrenome;
	@FXML
	private TextField TelaMenuPerfil_TF_Cpf;
	@FXML
	private TextField TelaMenuPerfil_TF_Salario;
	@FXML
	private TextField TelaMenuPerfil_TF_Id;
	@FXML
	private TextField TelaMenuPerfil_TF_Email;
	@FXML
	private TextField TelaMenuPerfil_TF_Senha;
	@FXML
	private TextField TelaMenuPerfil_TF_Logradouro;
	@FXML
	private TextField TelaMenuPerfil_TF_Nascimento;
	@FXML
	private Button TelaMenuPerfil_BT_Voltar;
	@FXML
	private Button TelaMenuPerfil_BT_Atualizar;
	@FXML
	private Button TelaMenuPerfil_BT_ExcluirMinhaConta;
	@FXML
	private TextField TelaMenuPerfil_TF_Telefone;
	@FXML
	private Button TelaMenuPerfil_BT_Logoff;

	String nome, sobrenome, cpf, salario, id, email, senha, logradouro, nascimento, tel;
	SistemaAccountManager fachada;

	public void initialize() {
		fachada = SistemaAccountManager.getInstance();
		Pessoa pessoa = new Pessoa(nome, sobrenome, cpf, salario, id, email, senha, logradouro, nascimento, tel);
		pessoa = fachada.getLogado();

		TelaMenuPerfil_TF_Nome.setText(pessoa.getNome());
		TelaMenuPerfil_TF_Sobrenome.setText(pessoa.getSobrenome());
		TelaMenuPerfil_TF_Cpf.setText(pessoa.getCpf());
		TelaMenuPerfil_TF_Id.setText(pessoa.getId());
		TelaMenuPerfil_TF_Salario.setText(pessoa.getSalario());
		TelaMenuPerfil_TF_Email.setText(pessoa.getEmail());
		TelaMenuPerfil_TF_Senha.setText(pessoa.getSenha());
		TelaMenuPerfil_TF_Logradouro.setText(pessoa.getLogradouro());
		TelaMenuPerfil_TF_Nascimento.setText(pessoa.getNascimento());
		TelaMenuPerfil_TF_Telefone.setText(pessoa.getTel());
	}

	@FXML
	public void botao_atualizar(ActionEvent event) throws IOException {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmação de seleção ");
		alert.setHeaderText("ATUALIZAR MEU PERFIL");
		alert.setContentText("você tem certeza ?");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			// ... user chose OK
		} else {
			// ... user chose CANCEL or closed the dialog
		}
	}

	@FXML
	public void botao_voltar(ActionEvent event) throws IOException {
		Parent root;
		Stage stage;
		try {

			if (event.getTarget() == TelaMenuPerfil_BT_Voltar) {
				stage = (Stage) TelaMenuPerfil_BT_Voltar.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaMenuPrincipal.fxml"));
			} else {
				stage = (Stage) TelaMenuPerfil_BT_Voltar.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaMenuPerfil.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void botao_excluirMeuPerfil(ActionEvent event) throws IOException {

		Parent root;
		Stage stage;
		try {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmação de Opcão ");
			alert.setHeaderText("VOCÊ DESEJA EXCLUIR SUA CONTA DE USUÁRIO ?");
			alert.setContentText("Obs.Após confirmar a exclusão do seu perfil,"
					+ " você será deslogado do sistema! Você tem certeza ?");
			Optional<ButtonType> result = alert.showAndWait();
			if (event.getTarget() == TelaMenuPerfil_BT_ExcluirMinhaConta) {
				if (result.get() == ButtonType.OK) {
					Pessoa pessoa;
					pessoa = fachada.getLogado();
					fachada.removerPessoa(pessoa.getCpf());
					stage = (Stage) TelaMenuPerfil_BT_ExcluirMinhaConta.getScene().getWindow();
					root = FXMLLoader.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaLogin.fxml"));

				} else {
					stage = (Stage) TelaMenuPerfil_BT_ExcluirMinhaConta.getScene().getWindow();
					root = FXMLLoader.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaMenuPerfil.fxml"));
				}
				Scene scene = new Scene(root);
				stage.setScene(scene);
			}
		} catch (Exception e) {
			//e.printStackTrace();
		}
	}

	@FXML
	public void botao_FazerLogoff(ActionEvent event) throws IOException {
		Parent root;
		Stage stage;
		try {

			if (event.getTarget() == TelaMenuPerfil_BT_Logoff) {
				stage = (Stage) TelaMenuPerfil_BT_Logoff.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaLogin.fxml"));
			} else {
				stage = (Stage) TelaMenuPerfil_BT_Logoff.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaMenuPerfil.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
