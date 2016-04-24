package mvc;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import models.Barrel;
import models.BarrelStack;
import models.DonkeyKong;
import models.Hammer;
import models.Level;
import models.Mario;
import models.Platform;
import models.Princess;

public class Controller {
	private boolean getplay = true;
	private DonkeyKongViewer v;
	private int frameRate = 72; // frames per second
	private int timeDelay = 5000 / frameRate;//  milliseconds per frame
	private int hammertimer = 70000; // timer for hammer
	private int barreldelay = 4000; //timer inbetween barrel throws
	public final int SCREENWIDTH = 1000, SCREENHEIGHT = 1000;
	private int cell = SCREENWIDTH / 12; // 12 columns
	private int speed = 1;
	private int x, y;// direction = -1;
	private int size = 30; // character size
	private boolean moveLeft, moveRight, moveUp, moveDown;
	private int score;
	private int lives;
	private int ladders_climbed;

	//Platform params
	private ArrayList<Platform> platforms = new ArrayList<Platform>();
	private int platform_height = 30;
	private int platform_width = SCREENWIDTH/15;
	private int platform_initial_x = 0;
	private int platform_initial_y = SCREENHEIGHT-platform_height;
	
	//Mario Params
	private Mario mario;
	private int mario_height = 40;
	private int mario_width = 40;
	private int mario_initial_x = 100;
	private int mario_initial_y = SCREENHEIGHT-platform_height*2;
	
	//dkong Params
	private DonkeyKong dkong;
	private int dkong_height = mario_height*3;
	private int dkong_width = mario_width*3;
	private int dkong_initial_x = 100;
	private int dkong_initial_y = 100;
	
	//Princess Params
	private Princess princess;
	private int princess_height = mario_height;
	private int princess_width = mario_width;
	private int princess_initial_x = 300;
	private int princess_initial_y = 100;	
	
	//Barrel Params
	private Barrel[] barrels = new Barrel[12];
	private int barrel_height = mario_height;
	private int barrel_width = mario_width;
	private int barrel_initial_x = 25;
	private int barrel_initial_y = 25;	

	//BarrelStack Params
	private BarrelStack barrelstack;
	private int barrelstack_height = 100;
	private int barrelstack_width = 100;
	private int barrelstack_initial_x = dkong_initial_x - barrelstack_width;
	private int barrelstack_initial_y = dkong_initial_y+25;	
	
	//Hammer Params
	private Hammer hammer;
	private int hammer_height = mario_height;
	private int hammer_width = mario_width;
	private int hammer_initial_x = 200;
	private int hammer_initial_y = 200;	
	
	//Level Params
	private Level level;
	private int level_height = SCREENHEIGHT;
	private int level_width = SCREENWIDTH;
	private int level_initial_x = 0;
	private int level_initial_y = SCREENHEIGHT;	
	
	

	public Controller(DonkeyKongViewer v) {
		this.v = v;
		mario = new Mario(v, mario_height, mario_width, mario_initial_x, mario_initial_y);
		princess = new Princess(v, princess_height, princess_width, princess_initial_x, princess_initial_y);
		hammer = new Hammer(v, hammer_height, hammer_width, hammer_initial_x, hammer_initial_y);
		dkong = new DonkeyKong(v, dkong_height, dkong_width, dkong_initial_x, dkong_initial_y);
		level = new Level(v,level_height,level_width,level_initial_x,level_initial_y);
		barrelstack = new BarrelStack(v,barrelstack_height,barrelstack_width,barrelstack_initial_x,barrelstack_initial_y);
		ladders_climbed = 0;
		score = 0;
		setLives(3);
		for (int i = 0; i < 12; i ++){
			barrels[i] = new Barrel(v, barrel_height, barrel_width, barrel_initial_x+i*10, barrel_initial_y + i*i);
			barrels[i].setDirection("right");
		}
		platformDrawer(v);

	}
	
	public void platformDrawer(DonkeyKongViewer v){
		int platform_end_right = SCREENWIDTH;// for end of right side of screen
		int platform_end_left = platform_width; // for end of left screen
		for (int i = 0; i < SCREENWIDTH/2; i = i + platform_width){//draws first flat floor
			platforms.add(new Platform(v,platform_height,platform_width,platform_initial_x+i,platform_initial_y));
		}
		int counter = 0;
		for (int i = SCREENWIDTH/2; i < platform_end_right; i = i + platform_width){//draws incline in floor
			platforms.add(new Platform(v,platform_height,platform_width,platform_initial_x+i,platform_initial_y-counter));
			counter += 2;
		// start drawing for upper platforms
		}
		for (int r = 0; r < 5; r ++){
			if(r % 2 == 0){
				counter += 100;
				for (int i = platform_end_right-platform_width*2; i > 0; i = i - platform_width){//draws second floor
					platforms.add(new Platform(v,platform_height,platform_width,i,platform_initial_y-counter));
					counter += 2;
				}
			}
			else{
				counter += 100;
				for (int i = platform_end_left; i < platform_end_right-platform_width; i = i + platform_width){//draws incline in floor
					platforms.add(new Platform(v,platform_height,platform_width,platform_initial_x+i,platform_initial_y-counter));
					counter += 2;
				}
			}
		for (int i = 0; i < platform_end_right-platform_width;i += platform_width){//draws platform that dkong is on
			platforms.add(new Platform(v,platform_height,platform_width,i,dkong_initial_y+dkong_height));
		}
		for (int i = princess_initial_x; i < platform_width*7; i += platform_width){
			platforms.add(new Platform(v,platform_height,platform_width,i,princess_initial_y+princess_height));
		}
		}
	}	
	//added getter and setter for lives
	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
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
		for (Platform platform : platforms){
			platform.draw(g);
		}
		
		// Single objects
		dkong.draw(g);
		hammer.draw(g);
		barrelstack.draw(g);
		princess.draw(g);
		hammer.draw(g);
		mario.draw(g);
		
		
		
	}
	
	/**
	 * Check for number of barrels on screen - need to have at least 4 (send more if less than four)
	 * If you touch a barrel mario dies
	 * If you touch a hammer mario changes state to hasHammer
	 */
	private void playGame(Graphics g) {
		if (getLives() == 0){
			setplay(false);
			g.drawString("YOU HAVE LOST - 'R' to play again", 220, 280);
			setLives(3);
			setScore(0);
		}
		if (mario.isInsideHitbox(princess.getRectangle())){
			setplay(false);
			mario.setVisible(false);
			princess.wonGame();
			g.drawString("YOU HAVE WON - 'R' to play again", 220, 280);
		}
		for (int i = 0; i < barrels.length; i++) {
			//takes care of barrels and lives 
			//System.out.println(mario.hasHammer());
			if (mario.hasHammer())
				barrels[i].breakState(true);
			else {
				barrels[i].breakState(false);
			}
			if (mario.isInsideHitbox(barrels[i].getRectangle()) && barrels[i].getVisible()) {
				if (mario.hasHammer()) {
					barrels[i].setVisible(false);
					score += 500;
				} 
				else { 
					mario.setisDead(true);
					setLives(getLives() - 1);
					playAgain();
					
				}

			}
		}
		
		// Check if Mario has hammer 
		// maybe throw in method and run method??
		//System.out.println(mario.hasHammer());
		if (hammer.getVisible() && mario.isInsideHitbox(hammer.getRectangle()))  {
			//System.out.println(mario.hasHammer());
			mario.setHammer(true);
			setScore(getScore()+100);
			hammer.setVisible(false);
			
		}
		if (hammertimer == 0){
			mario.setHammer(false);
		}
		
		moveBarrels();
		
	}

	private void moveBarrels() {
		for (Barrel barrel : barrels) {

			// if barrel is moving left
			if (barrel.getDirection() == -1) {
				barrel.setX(barrel.getX() - 2);
			}//if moving right
			if (barrel.getDirection() == 1) {
				barrel.setX(barrel.getX() + 2);
			}
			// Try to fall
			barrel.setY(barrel.getY() + 1);
			// If barrel is touching ground for the first time - switch direction
			// Should be - If barrel is falling and touches ground - Change direction
			if (barrel.get_isFalling()) {
				
				barrel.changeDirection();
				barrel.set_isFalling(false);
				
			}
			

			
			
		}
	}
	
	public void moveActivePlayer(String action) {
		// First we need to make Mario invisible until we want him redrawn
		mario.setVisible(false);
		
		if (action.equals("left")) {
			mario.setface(action);
			mario.setX(mario.getX() - 4);
		}
		
		if (action.equals("right")) {
			mario.setface(action);
			mario.setX(mario.getX() + 4);
		}

		if (action.equals("up")) {
			if (mario.hasHammer){
			}
			else{
				mario.setface(action);
				mario.setY(mario.getY() - 4);
			}
		}

		if (action.equals("down")) {
			if (mario.onLadder){//mario only moves down if on a ladder for now
				mario.setY(mario.getY() + 4);
			}
			
			// now test if mario is on floor - If on floor go back up;
		}
		
		
		// Check if mario is on floor


		mario.setDirection(action);
		mario.setVisible(true);

	}
	public int getScore() {
		return score;
	}
	public void setScore(int s) {
		score = s;
	}
	public void rollFrames() {
		try {
			Thread.sleep(timeDelay);
			if (mario.hasHammer){
			hammertimer -= 1000;
			}
			v.repaint();
		} catch (InterruptedException e) {
			System.out.println(e.toString());
		}
		
	}
	public void setMoveLeft(boolean b) {
		// TODO Auto-generated method stub
		
	}
	public void setMoveRight(boolean b) {
		// TODO Auto-generated method stub
		
	}
	public void setMoveUp(boolean b) {
		// TODO Auto-generated method stub
		
	}
	public void setMoveDown(boolean b) {
		// TODO Auto-generated method stub
		
	}
	public boolean getplay() {
		// returns game status
		return getplay;
	}
	public void setplay(boolean b){
		// pauses the game when false, lets run when true 
		getplay = b;
	}
	

}
