package hssa;

import hssa.AgentManager.AgentManager;
import hssa.view.SocialAnalyzerOverviewController;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
	
	private Stage primaryStage;
    private BorderPane rootLayout;
    private AgentManager agentManager;

    @Override
    public void start(Stage primaryStage) {
		launchAgents();
		
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Holoniczny analizator serwisów spo³ecznoœciowych");

        initRootLayout();

        showSocialAnalyzerOverview();
    }

    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void showSocialAnalyzerOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/SocialAnalyzerOverview.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(personOverview);
            SocialAnalyzerOverviewController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

	public static void main(String[] args) {
		launch(args);
	}
	
	private void launchAgents() {
		agentManager = new AgentManager();
		agentManager.init();
	}

	public AgentManager getAgentManager() {
		return agentManager;
	}
}
