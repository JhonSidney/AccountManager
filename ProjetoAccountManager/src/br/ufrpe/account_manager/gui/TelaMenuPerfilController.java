package br.ufrpe.account_manager.gui;

import br.ufrpe.account_manager.SistemaAccountManager;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
}
