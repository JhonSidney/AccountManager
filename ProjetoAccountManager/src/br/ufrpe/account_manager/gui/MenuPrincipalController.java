package br.ufrpe.account_manager.gui;

import br.ufrpe.account_manager.SistemaAccountManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;

public class MenuPrincipalController {

	@FXML
	private Label TMenuPrincipal_LB_SejaBemVindo;
	@FXML
	private Label TMenuPrincipal_LB_Nome;
	@FXML
	private Label TMenuPrincipal_LB_Sobrenome;
	@FXML
	private Hyperlink TMenuPrincipal_HL_MeuPerfil;
	@FXML
	private Label TMenuPrincipal_LB_Configuracoes;
	@FXML
	private MenuItem TMenuPrincipal_BTConfiguracoes_MI_Banco;
	@FXML
	private MenuItem TMenuPrincipal_BTConfiguracoes_MI_Categoria;
	@FXML
	private Label TMenuPrincipal_LB_Cadastro;
	@FXML
	private MenuItem TMenuPrincipal_BTCadastro_MI_Contatos;
	@FXML
	private MenuItem TMenuPrincipal_BTCadastro_MI_Contas;
	@FXML
	private Button TMenuPrincipal_BT_Configuracoes;
	@FXML
	private Button TMenuPrincipal_BT_Cadastro;
	@FXML
	private Hyperlink TMenuPrincipal_HL_Contas;
	
	SistemaAccountManager fachada;

	@FXML
	public void initialize() {
		fachada = SistemaAccountManager.getInstance();
	}
	
	@FXML
	public void menuMeuPerfil(ActionEvent event) {

	}
	@FXML
	public void menuConfiguracaoBanco(ActionEvent event) {

	}
	@FXML
	public void menuConfiguracaoCategoria(ActionEvent event) {

	}
	@FXML
	public void menuCadastroContatos(ActionEvent event) {

	}
	@FXML
	public void menuCadastroContas(ActionEvent event) {

	}
	
	@FXML
	public void menuContas(ActionEvent event) {

	}
}

