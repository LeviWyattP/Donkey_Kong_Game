package models;

import java.awt.Component;


public class Level extends MyShape {
	private Component component;
	
	public Level(Component c, int height, int width, int x, int y) {
		super(c, height, width, x, y);
		this.component = c;
//		setCurrentImage(platform);
		
	}
}



