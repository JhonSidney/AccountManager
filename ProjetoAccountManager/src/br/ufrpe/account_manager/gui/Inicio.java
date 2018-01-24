package br.ufrpe.account_manager.gui;

import java.io.IOException;

import br.ufrpe.account_manager.exception.NegocioException;
import br.ufrpe.account_manager.negocio.beans.Pessoa;
import javafx.application.Application;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
	public void start(Stage primaryStage) throws NegocioException, IOException {

		
		// Carrega o FXML
		FXMLLoader splashLoader = new FXMLLoader(getClass().getResource("/br/ufrpe/account_manager/gui/Splash.fxml"));
		StackPane splashPane = splashLoader.load();

		// Cria a Janela do Splash
		// Define como transparente para que não apareça decoração de janela (maximizar,
		// minimizar)
		Stage splashStage = new Stage(StageStyle.TRANSPARENT);
		final Scene scene = new Scene(splashPane);
		scene.setFill(Color.TRANSPARENT); // Define que a cor do painel root seja transparente para que dê o efeito de
											// sombra
		splashStage.setScene(scene);

		// Cria o serviço para rodar alguma tarefa em background enquanto o splash é
		// mostrado (no caso somente um delay de 10s)
		Service<Boolean> splashService = new Service<Boolean>() {

			// Mostra o splash quando o serviço for iniciado
			@Override
			public void start() {
				super.start();
				splashStage.show(); // mostra a janela
			}

			// Simulação de uma tarefa pesada
			@Override
			protected Task<Boolean> createTask() {
				return new Task<Boolean>() {
					@Override
					protected Boolean call() throws Exception {
						Thread.sleep(10000); // Delay de 10s
						return true;
					}
				};
			}

			// Quando a tarefa for finalizada fecha o splash e mostra a tela principal
			@Override
			protected void succeeded() {
				splashStage.close(); // Fecha o splash
				try {
					chamarTelaPrincipal(primaryStage);// Chama a tela principal
				} catch (Exception ex) {
				}
			}
		};

	
		splashService.start();
	}

	private void initRootLayout() {

		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Inicio.class.getResource("/br/ufrpe/account_manager/gui/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			Scene scene = new Scene(rootLayout);
			scene.setFill(Color.TRANSPARENT);
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

	// Tela de login
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

	// menu principal

	public void botao_logoff() {
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

	@FXML
	public void menuContatos() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Inicio.class.getResource("/br/ufrpe/account_manager/gui/TelaMenuContatos.fxml"));
			AnchorPane Login = (AnchorPane) loader.load();
			rootLayout.setCenter(Login);
			TelaLoginController controller = loader.getController();
			controller.setPrincipal(this.getInstance());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void menuContas() {

		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Inicio.class.getResource("/br/ufrpe/account_manager/gui/TelaMenuContas.fxml"));
			AnchorPane Login = (AnchorPane) loader.load();
			rootLayout.setCenter(Login);
			TelaLoginController controller = loader.getController();
			controller.setPrincipal(this.getInstance());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@FXML
	public void menuMeuPerfil() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Inicio.class.getResource("/br/ufrpe/account_manager/gui/TelaMenuPerfil.fxml"));
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

	private void chamarTelaPrincipal(Stage primaryStage) throws Exception {

		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Account Manager");// Nome do Sistema
		this.primaryStage.setResizable(false);
		imagem = new Image(
				getClass().getResourceAsStream("/br/ufrpe/account_manager/gui/pictures/logoAccountManager.png"));
		this.primaryStage.getIcons().add(imagem);

		initRootLayout();
		if (acesso == null) {
			showLogin();
		}

	}

}
