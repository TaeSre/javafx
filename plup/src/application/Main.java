package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Main extends Application
{
	public void start(Stage stage)
	{
			RootBorderPane root = new RootBorderPane();
			Scene scene = new Scene(root, 700, 700);
			stage.setScene(scene);
			stage.show();
			
		
	}

	public static void main(String[] args)
	{
		launch();
	}
	public static void createAlert(AlertType type, String error)
	{
		Alert a = new Alert(type);
		a.setContentText(error);
		a.showAndWait();
		
	}
}
