package br.ufrpe.account_manager.gui;

import br.ufrpe.account_manager.SistemaAccountManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class TelaMenuContasController {

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
	private Button TelaMenuContatos_BT_Adicionar;
	@FXML
	private Button TelaMenuContatos_BT_Voltar;
	@FXML
	private Button TelaMenuContas_BT_logoff;
	
	SistemaAccountManager fachada;
	
	public void initialize() {
		fachada = SistemaAccountManager.getInstance();
		
	}
	
	@FXML
	public void botao_adicionarConta(ActionEvent event) {
		
	}
	
	
	@FXML
	public void botao_voltar(ActionEvent event) {
		
	}
	
	
	@FXML
	public void logoff(ActionEvent event) {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
