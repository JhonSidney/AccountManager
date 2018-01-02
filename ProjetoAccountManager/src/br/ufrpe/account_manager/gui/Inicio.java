package br.ufrpe.account_manager.gui;

import java.io.IOException;

import br.ufrpe.account_manager.exception.NegocioException;
import br.ufrpe.account_manager.negocio.beans.Pessoa;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Inicio extends Application {
	private Pessoa acesso = null;
	private Stage primaryStage;
	private BorderPane rootLayout;
	private static Inicio instancia;
	private Image imagem;

	public static Inicio getInstance() {
		if (instancia == null) {
			instancia = new Inicio();
		}
		return instancia;
	}

	@Override
	public void start(Stage primaryStage) throws NegocioException {
		// criação do palco

		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Account Manager");// Nome do Sistema
		this.primaryStage.setResizable(false);
		imagem = new Image(getClass().getResourceAsStream("/br/ufrpe/account_manager/gui/pictures/logoAccountManager.png"));
		this.primaryStage.getIcons().add(imagem);
		
		initRootLayout();
		if (acesso == null) {
			showLogin();
		}

	}

	private void initRootLayout() {
		// TODO Auto-generated method stub
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Inicio.class.getResource("/br/ufrpe/account_manager/gui/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showLogin() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Inicio.class.getResource("/br/ufrpe/account_manager/gui/TelaLogin.fxml"));
			AnchorPane Login = (AnchorPane) loader.load();

			rootLayout.setCenter(Login);
			TelaLoginController controller = loader.getController();
			controller.setPrincipal(this.getInstance());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//Tela de login
	public void acessarLogin() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Inicio.class.getResource("/br/ufrpe/account_manager/gui/TelaMenuPrincipal.fxml"));
			AnchorPane Login = (AnchorPane) loader.load();

			rootLayout.setCenter(Login);
			TelaLoginController controller = loader.getController();
			controller.setPrincipal(this.getInstance());
			
			

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void registroUsuario() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Inicio.class.getResource("/br/ufrpe/account_manager/gui/TelaRegistro.fxml"));
			AnchorPane Login = (AnchorPane) loader.load();
			

			rootLayout.setCenter(Login);
			TelaLoginController controller = loader.getController();
			controller.setPrincipal(this.getInstance());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public void esqueciSenha() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Inicio.class.getResource("/br/ufrpe/account_manager/gui/TelaAjuda.fxml"));
			AnchorPane Login = (AnchorPane) loader.load();
			

			rootLayout.setCenter(Login);
			TelaLoginController controller = loader.getController();
			controller.setPrincipal(this.getInstance());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void menuSair() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Inicio.class.getResource("/br/ufrpe/account_manager/gui/TelaLogin.fxml"));
			AnchorPane Login = (AnchorPane) loader.load();
			

			rootLayout.setCenter(Login);
			TelaLoginController controller = loader.getController();
			controller.setPrincipal(this.getInstance());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);

	}

}

