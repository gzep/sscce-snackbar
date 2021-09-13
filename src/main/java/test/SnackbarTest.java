package test;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXSnackbar;
//import com.jfoenix.controls.JFXSnackbar;
import com.jfoenix.controls.JFXSnackbar.SnackbarEvent;
import com.jfoenix.controls.JFXSnackbarLayout;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

public class SnackbarTest {

	@FXML
	JFXListView<String> nodeList;
	@FXML
	JFXButton deleteButton;
	@FXML
	HBox bottomPane;

	@FXML
	void initialize() {
		nodeList.getItems().addAll("Hello", "Wold", "foo", "bar");
		JFXSnackbar snackbar = new JFXSnackbar(bottomPane);

		deleteButton.setOnAction(evt -> {
			String item = nodeList.getSelectionModel().getSelectedItem();
			if (item != null) {
				nodeList.getItems().remove(item);
				snackbar.enqueue(new SnackbarEvent(
						new JFXSnackbarLayout("removed " + item, "UNDO", evt2 -> Platform.runLater(() -> {
							nodeList.getItems().add(item);
							snackbar.close();
						})), Duration.seconds(8)));
			}
		});
	}

}
