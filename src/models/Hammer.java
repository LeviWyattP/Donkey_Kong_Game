package models;

import java.awt.Component;
import java.awt.Graphics;

public class Hammer extends MyShape {

	public int isTaken;
	public String hammer_png = "Hammer.png";
	private Component component;

	
	public Hammer(Component c, int height, int width, int x, int y) {
		super(c, height, width,  x, y);
		
		this.component = c;
		setCurrentImage(hammer_png);
		
	}
	
}
