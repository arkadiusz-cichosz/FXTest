package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

public class MainView extends View<BorderPane, MainViewController, MainView> {

	public static MainView mainView; 

	private MainView() {
		loadView();
	}

	@Override
	public void loadView() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("MainView.fxml"));
			setRoot(fxmlLoader.load());
			setController(fxmlLoader.getController());
			isOpen(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static MainView getInstance() {
		if(mainView == null) {
			mainView = new MainView();
		}
		
		return mainView;
	}	
}
