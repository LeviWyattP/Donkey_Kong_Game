package mvc;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Listener implements KeyListener {
	private Controller c;
	private Scoreboard s;
	
	public Listener(Controller c, Scoreboard s) {
		this.c = c;
		this.s = s;
	}
	
	public void keyTyped(KeyEvent event) {
	}
	
	public void keyPressed(KeyEvent event) {
		
	}
	
	public void keyReleased(KeyEvent event) {
		
	}
	
	
}
