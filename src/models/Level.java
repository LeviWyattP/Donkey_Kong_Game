package models;

import java.awt.Component;

import java.awt.Graphics;

public class Level extends MyShape{
	private Component component;
	public String platform = "Platform.png;";

	public Level(Component c, int height, int width, int x, int y) {
		super(c, height, width, x, y);
		this.component = c;
		setCurrentImage(platform);
		
	}
}



