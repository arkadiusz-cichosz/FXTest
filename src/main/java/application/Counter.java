package application;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class Counter extends Service<Void> {

	public Counter() {
		super();
	}

	@Override
	protected Task<Void> createTask() {
		return new Task<Void>() {
			@Override
			protected Void call() throws Exception {
				count(20);
				return null;
			}
		};
	}
	
	private void count(int numbers) {
		for(int i = 0; i < numbers; i++) {
			System.out.println(i);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
