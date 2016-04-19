package models;

import java.awt.Component;
import java.awt.Graphics;

public class Princess extends MyShape {
	public boolean isGameWon;
	public boolean previous_state;
	public String princess_front = "Princess_help.png";
	private Component component;
	
	public Princess(Component c, int height, int width, int x, int y) {
		super(c, height, width,  x, y);
		this.component = c;
		setCurrentImage(princess_front);
	}
	

}
