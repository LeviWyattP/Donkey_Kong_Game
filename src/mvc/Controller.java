package mvc;

import java.awt.Color;
import java.awt.Graphics;

import models.Barrel;
import models.DonkeyKong;
import models.Hammer;
import models.Mario;
import models.Princess;

public class Controller {
	private DonkeyKongViewer v;
	private int frameRate = 72; // frames per second
	private int timeDelay = 300 / frameRate;//  milliseconds per frame
	private Barrel[] barrels = new Barrel[12];
	private Princess princess;
	private Hammer hammer;
	private int barreldelay = 10000; //timer inbetween barrel throws
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
		this.v = v;
		mario = new Mario(size,);
		princes = new Princess();
		ladders_climbed = 0;
		score = 0;
		for (int i = 0; i < 12; i ++){
			barrels[i] = new Barrel(size);
		}
				
	}
	
	void playAgain() {
		
	}
	
	public void paintModels(Graphics g) {
		//Probably need to move something
		playGame(g);
		
		// probably need to throw into a for each loop
		for (Barrel barrel : barrels) {
			barrel.draw(g);
		}
		
		// Single objects
		princess.draw(g);
		hammer.draw(g);
		mario.draw(g);
		dkong.draw(g);
		
	}
	
	/**
	 * Check for number of barrels on screen - need to have at least 4 (send more if less than four)
	 * If you touch a barrel mario dies
	 * If you touch a hammer mario changes state to hasHammer
	 */
	private void playGame(Graphics g) {
		
	}
	
	private void moveBarrels() {
		
	}
	
	private void moveActivePlayer(Mario mario) {
		
	}

	public int getScore() {
		return score;
	}

	public void rollFrames() {
		try {
			Thread.sleep(timeDelay);
			v.repaint();
		} catch (InterruptedException e) {
			System.out.println(e.toString());
		}
		
	}
	

}
