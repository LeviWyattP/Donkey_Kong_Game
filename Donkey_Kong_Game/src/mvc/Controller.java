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

	private Hammer hammer;
	private int barreldelay = 10000; //timer inbetween barrel throws
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
		
	//Mario Params
	private Mario mario;
	private int mario_height = 10;
	private int mario_width = 10;
	private int mario_initial_x = 200;
	private int mario_initial_y = 200;

	//Princess Params
	private Princess princess;
	private int princess_height = 10;
	private int princess_width = 10;
	private int princess_initial_x = 100;
	private int princess_initial_y = 100;	
	
	//Barrel Params
	private Barrel[] barrels = new Barrel[12];
	private int barrel_height = 10;
	private int barrel_width = 10;
	private int barrel_initial_x = 100;
	private int barrel_initial_y = 100;		
	
	
	public Controller(DonkeyKongViewer v) {
		this.v = v;
		mario = new Mario(mario_height, mario_width, mario_initial_x, mario_initial_y);
		princess = new Princess(princess_height, princess_width, princess_initial_x, princess_initial_y);
		ladders_climbed = 0;
		score = 0;
		lives = 3;
		for (int i = 0; i < 12; i ++){
			barrels[i] = new Barrel(barrel_height, barrel_width, barrel_initial_x, barrel_initial_y);
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
		if (lives == 0){
			g.drawString("YOU HAVE LOST - 'R' to play again", 220, 280);
		}
		for (int i = 0; i < barrels.length; i++) {
			//takes care of barrels and lives 
			if (mario.hasHammer())
				barrels[i].breakState(true);
			else {
				barrels[i].breakState(false);
			}
			if (mario.touches(barrels[i]) && barrels[i].getVisible()) {
				if (mario.hasHammer()) {
					barrels[i].setVisible(false);
					score += 500;
				} 
				else { 
					mario.setAction("dead");
					lives = lives -1;
				}
			}
		}
		
		// Check if Mario has hammer 
		// maybe throw in method and run method??
		if (hammer.getVisible() && mario.isInsideHitbox(hammer.getRectangle()))  {
			mario.setHammer(true);
			mario.setAction("hammer");
			score += 100;
			hammer.setVisible(false);
		}
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
