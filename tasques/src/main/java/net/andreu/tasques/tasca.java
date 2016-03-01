package net.andreu.tasques;

public class tasca {
	String text;
	boolean marcat = false;
	
	public tasca (String text) {
		this.text = text;
	}
	public String text(){
		return text;
	}
	public void marca(boolean marca) {
		marcat = marca;
	}
	
	public boolean esMarcat() {
		return marcat;
	}
	
	/*@Override
	public String toString() {
		return text;
	}*/
}
