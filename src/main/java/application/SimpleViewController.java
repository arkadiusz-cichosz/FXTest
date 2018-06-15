package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class SimpleViewController implements Initializable {

	@FXML 
	private VBox simpleBox;

	@FXML 
	private Label simpleLabel;

	@FXML 
	private Button simpleButton;

	public SimpleViewController() {

	}
	
	@FXML
	public void clickedMe() {
		MainView.getInstance().getController().clearContainer();
		SimpleView.getInstance().isOpen(false);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		simpleLabel.setText("Okno testowe dodane do g³ównego widoku");
		simpleButton.setText("Zamknij okno");
	}
}
