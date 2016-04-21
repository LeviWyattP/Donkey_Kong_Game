package models;

import java.awt.Component;

import java.awt.Graphics;

public class Mario extends MyShape {
	public boolean hasHammer;
	public int x,y;
	public String action;
	private Component component;
	public String marioleft = "mario_left.png";
	public String marioright = "mario_right.png";
	
	
	public Mario(Component c, int height, int width, int x, int y) {
		super(c, height, width, x, y);
		
		this.component = c;
		this.hasHammer = false;
		setCurrentImage(marioright);
	}


	public boolean hasHammer() {
		// TODO Auto-generated method stub
		return hasHammer;
	}

	public void setHammer(boolean b) {
		// TODO Auto-generated method stub
		this.hasHammer = b;
	}

	public void setAction(String string) {
		// TODO Auto-generated method stub
		this.action = string;
		if (action.equals("hammer")){
			setHammer(true);
			
		}
//		else if (action.equals("moveLeft")){
//			
//			
//		}
	}

	public String getAction() {
		return this.action;
	}
	
}
