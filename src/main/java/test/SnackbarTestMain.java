package test;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SnackbarTestMain extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Parent n = new FXMLLoader(getClass().getClassLoader().getResource("test/SnackbarTest.fxml")).load();
		stage.setScene(new Scene(n));
		stage.show();
	}

}
