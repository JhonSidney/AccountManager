package br.ufrpe.account_manager.gui;

import java.io.IOException;

import br.ufrpe.account_manager.SistemaAccountManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
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

	String nome, sobrenome, cpf, salario, id, email, senha, logradouro, nascimento, telefone;
	SistemaAccountManager fachada;
	
	public void initialize() {
		fachada = SistemaAccountManager.getInstance();
	}
	
	@FXML
	public void botao_atualizar(ActionEvent event) throws IOException {
		
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
