package models;

import java.awt.Graphics;

public class Mario extends MyShape{
	public boolean hasHammer;
	public int x,y;
	public String action;
	
	
	public Mario(int height, int width, int x, int y) {
		super(height, width, x, y);
		this.hasHammer = false;
	}
	
	public void draw(Graphics g) {
		
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
	}

	public String getAction() {
		return this.action;
	}
	
}
