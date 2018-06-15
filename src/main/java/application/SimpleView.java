package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class SimpleView extends View<AnchorPane, SimpleViewController, SimpleView> {
	
	public static SimpleView simpleView;
	
	public SimpleView() {
		loadView();
	}
	
	@Override
	public void loadView() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("SimpleView.fxml"));
			setRoot(fxmlLoader.load());
			setController(fxmlLoader.getController());
			isOpen(false);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public static SimpleView getInstance() {
		if(simpleView == null) {
			simpleView = new SimpleView();
		}		
		return simpleView;
	}	
}
