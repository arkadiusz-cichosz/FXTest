package application;

import javafx.concurrent.WorkerStateEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Progress {
	
	private static Progress progress;
	private ProgressIndicator progressIndicator;
	private Stage progressStage;
	
	private final EventHandler<WorkerStateEvent> progressEventShow = new EventHandler<WorkerStateEvent>() {		
		@Override
		public void handle(WorkerStateEvent event) {
			progressStage.show();
		}
	};
	
	private EventHandler<WorkerStateEvent> progressEventClose = new EventHandler<WorkerStateEvent>() {
		@Override
		public void handle(WorkerStateEvent event) {
			progressStage.close();		
		}
	};
	
	private Progress() {
		progressIndicator = new ProgressIndicator();
		progressStage = new Stage();
		init();
	}

	private void init() {		
		progressStage.initStyle(StageStyle.TRANSPARENT);
		progressStage.initOwner(Main.getPrimaryStage());
		AnchorPane root = new AnchorPane();
		centerIndicator(root, 10.0);
		root.getChildren().add(progressIndicator);
		Scene scene = new Scene(root, 400, 400);
		scene.setFill(Color.TRANSPARENT);
		progressStage.setScene(scene);
		progressStage.sizeToScene();
		progressStage.centerOnScreen();
	}
	
	public static Progress getInstance() {
		if(progress == null) {
			progress = new Progress();
		}	
		return progress;
	}
	
	public ProgressIndicator getProgressIndicator() {
		return progressIndicator;
	}

	public void setProgressIndicator(ProgressIndicator progressIndicator) {
		this.progressIndicator = progressIndicator;
	}

	public Stage getProgressStage() {
		return progressStage;
	}

	public void setProgressStage(Stage progressStage) {
		this.progressStage = progressStage;
	}

	public EventHandler<WorkerStateEvent> getProgressEventClose() {
		return progressEventClose;
	}

	public void setProgressEventClose(EventHandler<WorkerStateEvent> progressEventClose) {
		this.progressEventClose = progressEventClose;
	}

	public EventHandler<WorkerStateEvent> getProgressEventShow() {
		return progressEventShow;
	}
	
	private void centerIndicator(AnchorPane root, double size) {
		root.setRightAnchor(progressIndicator, size);
		root.setLeftAnchor(progressIndicator, size);
		root.setTopAnchor(progressIndicator, size);
		root.setBottomAnchor(progressIndicator, size);
		root.setBackground(Background.EMPTY);
	}
}
