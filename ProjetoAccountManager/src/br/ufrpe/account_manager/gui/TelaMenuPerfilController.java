package br.ufrpe.account_manager.gui;

import java.io.IOException;

import br.ufrpe.account_manager.SistemaAccountManager;
import br.ufrpe.account_manager.negocio.beans.Pessoa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
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
	private PasswordField TelaMenuPerfil_TF_Senha;

	@FXML
	private TextField TelaMenuPerfil_TF_Logradouro;

	@FXML
	private TextField TelaMenuPerfil_TF_Nascimento;

	@FXML
	private TextField TelaMenuPerfil_TF_Telefone;

	String nome, sobrenome, cpf, salario, id, email, senha, logradouro, nascimento, telefone;
	SistemaAccountManager fachada;
	
	public void initialize() {
		SistemaAccountManager.getInstance();
	}
	
	@FXML
	public void botao_atualizar(ActionEvent event) throws IOException {
		
	}
	
	@FXML
	public void botao_voltar(ActionEvent event) throws IOException {
		
	}
	
	@FXML
	public void botao_excluirMeuPerfil(ActionEvent event) throws IOException {
		
	}
}
