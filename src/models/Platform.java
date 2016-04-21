package models;

import java.awt.Component;

public class Platform extends MyShape{
	private Component component;
	public String platform = "Platform.png";

	public Platform(Component c, int height, int width, int x, int y) {
		super(c, height, width, x, y);
		this.component = c;
		setCurrentImage(platform);
	}

}
