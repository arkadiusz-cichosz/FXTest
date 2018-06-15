package application;

public abstract class View<T1, T2, T3> {
	private T1 root;
	private T2 controller;
	private boolean isOpen;
	
	public abstract void loadView();
	
	public T1 getRoot() {
		return root;
	}
	
	public void setRoot(T1 root) {
		this.root = root;
	}
	
	public T2 getController() {
		return controller;
	}
	
	public void setController(T2 controller) {
		this.controller = controller;
	}
	
	public boolean isOpen() {
		return isOpen;
	}
	
	public void isOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}
}
