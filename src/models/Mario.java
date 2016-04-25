package models;

import java.awt.Component;

import java.awt.Graphics;

import mvc.Controller;

public class Mario extends MyShape {
	public boolean hasHammer;
	public boolean touchingLadder;
	public boolean onLadder;//maybe put this into myshape so barrels can use
	public boolean isJumping;
	public boolean isOnPlatform;
	public int x,y;
	public int jump;

	public String action;
	private Component component;
	public String marioleft = "mario_left.png";
	public String marioright = "mario_right.png";
	public String mariodead = "mario_die.png";
	public String hammer_right = "mario_hammer_right.png";
	public String hammer_left = "mario_hammer_left.png";
	public String climbright = "mario_climb_right.png";
	public String jumpright = "mario_jump_right.png";
	public String jumpleft = "mario_jump_left.png";
	public String mario_hammer_upleft = "Mario_Hammer_upleft.png";
	public String mario_hammer_upright = "Mario_Hammer_upright.png";
	
	private boolean isDead = false;
	
	
	public Mario(Component c, int height, int width, int x, int y) {
		super(c, height, width, x, y);
		this.component = c;
		this.hasHammer = false;
		setCurrentImage(marioright);
		this.jump = 0;
		
	}


	public boolean hasHammer() {
		// TODO Auto-generated method stub
		return hasHammer;
	}

	public void setHammer(boolean b) {
		// TODO Auto-generated method stub
		this.hasHammer = b;
		if (b == true){
			setCurrentImage(hammer_right);
		}
	}
	
	public boolean isDead() {
		return isDead;
	}
	public void setisDead(boolean b) {
		setCurrentImage(mariodead);
		this.isDead = b;
	}
	
	public void setJump(boolean j) {
		if (j == true) {
			this.jump = 10;
			}
		this.isJumping = j;
		
	}
	
	public int getJump() {
		return this.jump;
	}
	
	public void decrementJump() {
		this.jump = this.jump - 1;
		if (this.jump == -3 ) {
			this.isJumping = false;
		}
		
	}
	
	public void setIsOnPlatform(boolean b) {
		this.isOnPlatform = b;
	}
	
	public boolean getIsOnPlatform() {
		return this.isOnPlatform;
	}
	
	public void setface(String action) {
		// TODO Auto-generated method stub
		if (action.equals("left")){
			if (hasHammer){
				setCurrentImage(hammer_left);
			}
			else{
				setCurrentImage(marioleft);
			}
		}
		if (action.equals("right")){
			if (hasHammer){
				setCurrentImage(hammer_right);
			}
			else{
				setCurrentImage(marioright);
			}
		}
		if (action.equals("up")){
			if (touchingLadder){
				setCurrentImage(climbright);
			}
			else{
				if (getDirection() == 1){//for facing right
					setCurrentImage(jumpright);
				}
				else{//facing left
					setCurrentImage(jumpleft);
				}
			}
		}
	}
	
	public void autoChangeFace() {
		if (hasHammer()) {

			// Deal with hammer facing right
			if (currentImageLocation.equals(hammer_right)) {
				setCurrentImage(mario_hammer_upright);

			}
			else if (currentImageLocation.equals(mario_hammer_upright)) {
				setCurrentImage(hammer_right);
			}
			else if (currentImageLocation.equals(hammer_left)) {
				setCurrentImage(mario_hammer_upleft);
			}
			else if (currentImageLocation.equals(mario_hammer_upleft)) {
				setCurrentImage(hammer_left);
			}
	
			
			
		}
		
	}


	public void settouchingLadder(boolean b) {
		touchingLadder = b;
		
	}
		
}
