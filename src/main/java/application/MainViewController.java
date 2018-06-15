package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.util.Callback;

public class MainViewController implements Initializable {

	@FXML 
	private Button startButton;

	@FXML 
	private Button stopButton;

	@FXML 
	private AnchorPane container;

	public MainViewController() {

	}

	@FXML 
	public void eventHandlerButton(ActionEvent event) throws IOException {	
		SimpleView view = SimpleView.getInstance();
		if(((Button)event.getSource()).getText().equals("Start")) {
			if(!view.isOpen()) {
				fillContainer(view.getRoot());
				view.isOpen(true);
			}
		} else if(((Button)event.getSource()).getText().equals("Stop")) {
			/*clearContainer();
			view.isOpen(false);*/
			Counter counter = new Counter();
			counter.setOnRunning(Progress.getInstance().getProgressEventShow());	
			counter.setOnSucceeded(Progress.getInstance().getProgressEventClose());
			counter.start();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public Button getStartButton() {
		return startButton;
	}

	public Button getStopButton() {
		return stopButton;
	}

	public AnchorPane getContainer() {
		return container;
	}

	public void clearContainer() {
		container.getChildren().clear();
	}

	public void fillContainer(Node node) {
		container.getChildren().add(node);
	}
}
