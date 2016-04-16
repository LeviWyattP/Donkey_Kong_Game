package models;

import java.awt.Graphics;

public class Barrel extends MyShape  {
	public boolean next_ladder;
	public boolean am_i_dead;
	
	public Barrel(int height, int width, int x, int y) {
		super(height, width,  x, y);
	}
	public void draw(Graphics g) {
		
	}
	public void breakState(boolean b) {
		// TODO Auto-generated method stub
		this.am_i_dead = b;
		
	}
}
