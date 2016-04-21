package models;

import java.awt.Component;
import java.awt.Graphics;

public class DonkeyKong extends MyShape {
	public int currentState;
	public String Donkey_Kong_Front = "DK_front.png";
	private Component component;

	
	public DonkeyKong(Component c, int height, int width, int x, int y) {
		super(c, height, width,  x, y);
		
		this.component = c;
		setCurrentImage(Donkey_Kong_Front);
	}
	

}
