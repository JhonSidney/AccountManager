package br.ufrpe.account_manager.gui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

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
import util.TextFieldFormatter;

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
	private TextField TelaMenuPerfil_TF_Rg;
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

	SistemaAccountManager fachada;
	private Pessoa pessoa;

	public void initialize() {
		fachada = SistemaAccountManager.getInstance();
		this.pessoa = fachada.getLogado();
		TelaMenuPerfil_TF_Nome.setText(pessoa.getNome());
		TelaMenuPerfil_TF_Sobrenome.setText(pessoa.getSobrenome());
		TelaMenuPerfil_TF_Cpf.setText(pessoa.getCpf());
		TelaMenuPerfil_TF_Rg.setText(pessoa.getId());
		TelaMenuPerfil_TF_Salario.setText(pessoa.getSalario());
		TelaMenuPerfil_TF_Email.setText(pessoa.getEmail());
		TelaMenuPerfil_TF_Senha.setText(pessoa.getSenha());
		TelaMenuPerfil_TF_Logradouro.setText(pessoa.getLogradouro());
		TelaMenuPerfil_TF_Nascimento.setText(pessoa.getNascimento());
		TelaMenuPerfil_TF_Telefone.setText(pessoa.getTel());

	}

	@FXML
	public void botao_atualizar(ActionEvent event) throws IOException, NegocioException {

		try {
			Parent root;
			Stage stage;
			String nome, sobrenome, cpf, salario, id, email, senha, logradouro, nascimento, tel;

			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmação de seleção ");
			alert.setHeaderText("ATUALIZAR MEU PERFIL");
			alert.setContentText("você tem certeza ?");
			Optional<ButtonType> result = alert.showAndWait();

			nome = TelaMenuPerfil_TF_Nome.getText();
			sobrenome = TelaMenuPerfil_TF_Sobrenome.getText();
			cpf = TelaMenuPerfil_TF_Cpf.getText();
			id = TelaMenuPerfil_TF_Rg.getText();
			salario = TelaMenuPerfil_TF_Salario.getText();
			email = TelaMenuPerfil_TF_Email.getText();
			senha = TelaMenuPerfil_TF_Senha.getText();
			logradouro = TelaMenuPerfil_TF_Logradouro.getText();
			nascimento = TelaMenuPerfil_TF_Nascimento.getText();
			tel = TelaMenuPerfil_TF_Telefone.getText();
			Pessoa pessoa = new Pessoa(nome, sobrenome, cpf, salario, id, email, senha, logradouro, nascimento, tel);

			if (event.getTarget() == TelaMenuPerfil_BT_Atualizar) {

				if (this.fachada.getLogado().getCpf().equals(this.TelaMenuPerfil_TF_Cpf.getText()) == false) {
					Alert alerts = new Alert(AlertType.INFORMATION);
					alerts.setTitle("Atenção!!");
					alerts.setHeaderText("VOCÊ NÃO PODE ALTERAR SEU CPF!!");
					alerts.setContentText(
							"Obs:Se seu cpf está incorreto, por favor exclua seu perfil e registre-se novamente.");
					alerts.showAndWait();
					return;

				}

				if (result.get() == ButtonType.OK) {
					fachada.atualizarPessoa(pessoa);
					fachada.gravarLogado(pessoa);

					Alert alerts = new Alert(AlertType.INFORMATION);
					alerts.setTitle("Confirmação da opção");
					alerts.setHeaderText(null);
					alerts.setContentText("Usuario Atualizado com Sucesso! ");
					alerts.showAndWait();

					stage = (Stage) TelaMenuPerfil_BT_Atualizar.getScene().getWindow();
					root = FXMLLoader.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaMenuPerfil.fxml"));
				} else {
					stage = (Stage) TelaMenuPerfil_BT_Atualizar.getScene().getWindow();
					root = FXMLLoader.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaMenuPerfil.fxml"));
					Scene scene = new Scene(root);
					stage.setScene(scene);
				}

			}

		} catch (Exception e) {
			//e.printStackTrace();
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

					Alert alerts = new Alert(AlertType.INFORMATION);
					alerts.setTitle("Confirmação da opção");
					alerts.setHeaderText(null);
					alerts.setContentText("Usuario excluído com Sucesso! ");
					alerts.showAndWait();

				} else {
					stage = (Stage) TelaMenuPerfil_BT_ExcluirMinhaConta.getScene().getWindow();
					root = FXMLLoader.load(getClass().getResource("/br/ufrpe/account_manager/gui/TelaMenuPerfil.fxml"));
				}
				Scene scene = new Scene(root);
				stage.setScene(scene);
			}
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

	@FXML
	public void botao_FazerLogoff(ActionEvent event) throws IOException {
		Parent root;
		Stage stage;
		try {

			if (event.getTarget() == TelaMenuPerfil_BT_Logoff) {
				
				Alert alerts = new Alert(AlertType.INFORMATION);
				alerts.setTitle("Confirmação da opção");
				alerts.setHeaderText(null);
				alerts.setContentText("Logoff com Sucesso ! ");
				alerts.showAndWait();
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
	
	@FXML
	private void FormatterTF_Nascimento() {
		TextFieldFormatter tff = new TextFieldFormatter();
		tff.setMask("##/##/####");
		tff.setCaracteresValidos("0123456789");
		tff.setTf(TelaMenuPerfil_TF_Nascimento);
		tff.formatter();
	}
	
	@FXML
	private void FormatterTF_Telefone() {
		TextFieldFormatter tff = new TextFieldFormatter();
		tff.setMask("(##)#####-####");
		tff.setCaracteresValidos("0123456789");
		tff.setTf(TelaMenuPerfil_TF_Telefone);
		tff.formatter();
	}

	@FXML
	private void FormatterTF_Rg() {
		TextFieldFormatter tff = new TextFieldFormatter();
		tff.setMask("#.###.###");
		tff.setCaracteresValidos("0123456789");
		tff.setTf(TelaMenuPerfil_TF_Rg);
		tff.formatter();
	}
	
}
