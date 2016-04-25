package mvc;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

import models.Barrel;
import models.BarrelStack;
import models.DonkeyKong;
import models.Hammer;
import models.Ladder;
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
	private int speed = 1;//anything more than 1 makes game explode
	private int x, y;// direction = -1;
	private int size = 30; // character size
	private boolean moveLeft, moveRight, moveUp, moveDown;
	private int score;
	private int lives;
	private Platform current_platform;

	//Platform params
	private ArrayList<ArrayList<Platform>> platforms = new ArrayList<ArrayList<Platform>>();
	//changed to list of lists to keep track of which level of platforms we are on
	private int platform_height = 30;
	private int platform_width = SCREENWIDTH/12;
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
	
	//Ladder Parrams
	private ArrayList<Ladder> ladders = new ArrayList<Ladder>();
//	private int ladder_height = 1;//will be modified to fit in between 2 platforms
	private int ladder_width = mario_width;
//	private int ladder_initial_x = 1;//will be modified
//	private int ladder_initial_y = 1;//will be modified
	
	
	

	public Controller(DonkeyKongViewer v) {
		this.v = v;
		platformDrawer(v);
		ladderDrawer(v);
		current_platform = platforms.get(0).get(3);
		mario = new Mario(v, mario_height, mario_width, mario_initial_x, platforms.get(0).get(2).getY()-platform_height*2);
		mario.setCurrentPlatform(platforms.get(0).get(3));
		princess = new Princess(v, princess_height, princess_width, princess_initial_x, princess_initial_y);
		hammer = new Hammer(v, hammer_height, hammer_width, hammer_initial_x, hammer_initial_y);
		dkong = new DonkeyKong(v, dkong_height, dkong_width, dkong_initial_x, dkong_initial_y);
		//level = new Level(v,level_height,level_width,level_initial_x,level_initial_y);
		barrelstack = new BarrelStack(v,barrelstack_height,barrelstack_width,barrelstack_initial_x,barrelstack_initial_y);
		score = 0;
		setLives(3);
		for (int i = 0; i < 12; i ++){
			barrels[i] = new Barrel(v, barrel_height, barrel_width, barrel_initial_x+i*10, barrel_initial_y + i*i);
			barrels[i].setDirection("right");
		}
	}
	
	private void ladderDrawer(DonkeyKongViewer v) {
		ArrayList<Platform> plat = new ArrayList<Platform>();
		for (int i = 0; i < platforms.size(); i ++){
			//Random rand = new Random();
			Platform randomplatform = platforms.get(i).get(platforms.get(i).size()-4);//picks a random platform for the given level
			//Platform randomplatform2 = platforms.get(i).get(rand.nextInt(platforms.get(i).size()));//picks a random platform for the given level
			plat.add(randomplatform);
			//plat.add(randomplatform2);
		}
		for (int i = 0; i < plat.size(); i ++){
			System.out.print("this");
			System.out.println(plat.get(i).getRectangle());
			for (ArrayList<Platform> platform : platforms){
				for (Platform plates : platform){
					if (plat.get(i).getX() == plates.getX() && plat.get(i) != plates){//needs work for picking what ladders to go to
						//System.out.println(plates.getRectangle());
						int height = plat.get(i).getY()-plates.getY();
						ladders.add(new Ladder(v,height,ladder_width,plat.get(i).getX(),plat.get(i).getY()));
//						System.out.println(ladders.get(i).getRectangle());
						
					}
				}
			}
		}
		
	}

	public void platformDrawer(DonkeyKongViewer v){
		int platform_end_right = SCREENWIDTH;// for end of right side of screen
		ArrayList<Platform> plates = new ArrayList<Platform>();
		ArrayList<Platform> plates1 = new ArrayList<Platform>();
		ArrayList<Platform> plates2 = new ArrayList<Platform>();
		ArrayList<Platform> plates3 = new ArrayList<Platform>();
		ArrayList<Platform> plates4 = new ArrayList<Platform>();
		ArrayList<Platform> plates5 = new ArrayList<Platform>();
		ArrayList<Platform> plates6 = new ArrayList<Platform>();
		ArrayList<Platform> plates7 = new ArrayList<Platform>();
		for (int i = 0; i < SCREENWIDTH/2; i = i + platform_width){//draws first flat floor
			plates.add(new Platform(v,platform_height,platform_width,platform_initial_x+i,platform_initial_y));
		}
		int counter = 0;
		for (int i = SCREENWIDTH/2; i < platform_end_right-platform_width; i = i + platform_width){//draws incline in floor
			plates.add(new Platform(v,platform_height,platform_width,platform_initial_x+i,platform_initial_y-counter));
			counter += 2;
		// start drawing for upper platforms
		}
		for (int r = 0; r < 5; r ++){
			
			if(r % 2 == 0){
				counter += 100;
				for (int i = platform_end_right-platform_width*2; i > 0; i = i - platform_width){//draws odd floors
					if (r == 0){
						plates1.add(new Platform(v,platform_height,platform_width,i,platform_initial_y-counter));
						counter += 2;
					}
					if (r == 2){
						plates3.add(new Platform(v,platform_height,platform_width,i,platform_initial_y-counter));
						counter += 2;
					}
					if (r == 4){
						plates5.add(new Platform(v,platform_height,platform_width,i,platform_initial_y-counter));
						counter += 2;
					}
				}
				
			}
			else{
				counter += 100;
				for (int i = platform_width; i < platform_end_right-platform_width; i = i + platform_width){//draws even floors
					if (r == 1){
						plates2.add(new Platform(v,platform_height,platform_width,i,platform_initial_y-counter));
						counter += 2;
					}
					if (r == 3){
						plates4.add(new Platform(v,platform_height,platform_width,i,platform_initial_y-counter));
						counter += 2;
					}
				}
			}
		}

		for (int i = 0; i < platform_end_right-platform_width;i += platform_width){//draws platform that dkong is on
			plates6.add(new Platform(v,platform_height,platform_width,i,dkong_initial_y+dkong_height));
		}
		for (int i = princess_initial_x; i < platform_width*7; i += platform_width){
			plates7.add(new Platform(v,platform_height,platform_width,i,princess_initial_y+princess_height));
		}
		platforms.add(plates);
		platforms.add(plates1);
		platforms.add(plates2);
		platforms.add(plates3);
		platforms.add(plates4);
		platforms.add(plates5);
		platforms.add(plates6);
		platforms.add(plates7);
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
		for (ArrayList<Platform> platform : platforms){
			for (Platform plates : platform){
				plates.draw(g);
			}
		}
		for (Ladder ladder : ladders){
			ladder.draw(g);
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
			barrels[i].set_isFalling(true);
			for (ArrayList<Platform> platform : platforms){//mario finds the platform he is on and makes sure he isnt falling
				for (Platform plate : platform){
					if(barrels[i].isInsideHitbox(plate.getRectangle())){
						barrels[i].set_isFalling(false);
						barrels[i].setCurrentPlatform(plate);
						break;
					}	
				}
			}
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
		
		for (ArrayList<Platform> platform : platforms){//mario finds the platform he is on and makes sure he isnt falling
				for (Platform plate : platform){
					if(mario.isInsideHitbox(plate.getRectangle())){
						//System.out.println("here");
						mario.set_isFalling(false);
						mario.setCurrentPlatform(plate);
						mario.setY(plate.getY()-platform_height-5);//bumps mario up as he walks along platforms needs work
						//System.out.println(mario.getY());
						break;
				}	
			}
		}

		if (mario.get_isFalling()){
			mario.setY((mario.getY()+2)*speed);
		}
		// Check if Mario has hammer 
		// maybe throw in method and run method??
		//System.out.println(mario.hasHammer());
		if (hammer.getVisible() && mario.isInsideHitbox(hammer.getRectangle()))  {
			//System.out.println(mario.hasHammer());
			mario.setHammer(true);
			setScore(getScore()+100);
			hammer.setVisible(false);
			
		}//sets mario back to normal state after timer is over
		if (hammertimer == 0){
			mario.setHammer(false);
		}
		
		moveBarrels();
		
	}

	private void moveBarrels() {
		for (Barrel barrel : barrels) {

			// if barrel is moving left
			if (barrel.get_isFalling() == false){//only moves left and right if not falling
			if (barrel.getDirection() == -1) {
				barrel.setX((barrel.getX() - 1)*speed);
			}//if moving right
			if (barrel.getDirection() == 1) {
				barrel.setX((barrel.getX() + 1)*speed);
			}
			}
			// Try to fall
			
			// If barrel is touching ground for the first time - switch direction
			// Should be - If barrel is falling and touches ground - Change direction
			if (barrel.get_isFalling()) {
				barrel.setY((barrel.getY() + 1)*speed);
				//barrel.changeDirection();
				barrel.set_isFalling(false);
				
			}
			

			
			
		}
	}
	
	public void moveActivePlayer(String action) {
		// First we need to make Mario invisible until we want him redrawn
		mario.setVisible(false);
		//System.out.println(mario.get_isFalling());
		if (mario.get_isFalling() == false){
		if (action.equals("left")) {
			mario.setface(action);
			mario.setX((mario.getX() - 1)*speed);
		}
		
		if (action.equals("right")) {
			mario.setface(action);
			mario.setX((mario.getX() + 1)*speed);
		}

		if (action.equals("up")) {
			if (mario.hasHammer){
			}
			else{
				mario.setface(action);
				mario.setY((mario.getY() - 1)*speed);
			}
		}
		}
		if (action.equals("down")) {
			if (mario.onLadder){//mario only moves down if on a ladder for now
				mario.setY((mario.getY() + 1)*speed);
			}
			
			// now test if mario is on floor - If on floor go back up;
		}
		
		
		
		// Check if mario is on floor


		mario.setDirection(action);
		mario.setVisible(true);

	}
	public int getspeed(){
		return speed;
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
			if(getplay()){
				v.repaint();
			}
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
		// pauses the game when false, lets run when true tried using in rollframes, but could not get the game started again
		getplay = b;
	}
	

}
