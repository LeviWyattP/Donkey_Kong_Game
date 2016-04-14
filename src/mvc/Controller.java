package mvc;

import java.awt.Color;

import models.Barrel;
import models.DonkeyKong;
import models.Hammer;
import models.Mario;
import models.Princess;

public class Controller {
	private DonkeyKongViewer v;
	private int frameRate = 72; // frames per second
	private int timeDelay = 300 / frameRate;//  milliseconds per frame
	private Barrel[] barrel = new Barrel[10];
	private Princess princess;
	private Hammer hammer;
	private Mario mario;
	private DonkeyKong dkong;
	private final int SCREENWIDTH = 600, SCREENHEIGHT = 600;
	private int cell = SCREENWIDTH / 12; // 12 columns
	private int speed = 1;
	private int x, y;// direction = -1;
	private int size = 30; // character size
	private boolean moveLeft, moveRight, moveUp, moveDown;
	private int score;
	private int lives;
	private int ladders_climbed;
		
	public Controller(DonkeyKongViewer v) {
		
	}
	
	void playAgain() {
		
	}
	
	/**
	 * Check for number of barrels on screen - need to have at least 4 (send more if less than four)
	 * If you touch a barrel mario dies
	 * If you touch a hammer mario changes state to hasHammer
	 */
	private void playGame() {
		
	}
	
	private void moveBarrels() {
		
	}
	
	private void moveActivePlayer(Mario mario) {
		
	}

}
