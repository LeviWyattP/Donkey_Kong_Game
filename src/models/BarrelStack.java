package models;

import java.awt.Component;

public class BarrelStack extends MyShape{
	public String Barrel_Stack = "Barrel_stack.png";
	public BarrelStack(Component c, int height, int width, int x, int y) {
		super(c, height, width, x, y);
		setCurrentImage(Barrel_Stack);
		
	}

}
