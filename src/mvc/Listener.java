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
	//this should be good for handling single presses for mario
	public void keyPressed(KeyEvent event) {
		switch (event.getKeyCode()) {
		case KeyEvent.VK_R:
			if (c.getLives() == 0)
				break;
		case KeyEvent.VK_C:
			c.playAgain();
			break;
		case KeyEvent.VK_LEFT:
			c.moveActivePlayer("left");
			break;
		case KeyEvent.VK_RIGHT:
			c.moveActivePlayer("right");
			break;
		case KeyEvent.VK_UP:
			c.moveActivePlayer("up");
			break;
		case KeyEvent.VK_DOWN:
			c.moveActivePlayer("down");
			break;
		}
	}
	// need to work finish this up 
	public void keyReleased(KeyEvent event) {
		switch (event.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			c.setMoveLeft(false);
			break;
		case KeyEvent.VK_RIGHT:
			c.setMoveRight(false);
			break;
		case KeyEvent.VK_UP:
			c.setMoveUp(false);
			break;
		case KeyEvent.VK_DOWN:
			c.setMoveDown(false);
			break;
		}
	}
	
	
}
