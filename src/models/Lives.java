package models;

import java.awt.Component;

public class Lives extends MyShape{
	private String three = "three.png";
	private String two = "two.png";
	private String one = "one.png";
	private String zero = "zero.png";
	private Component component;
	
	public Lives(Component c, int height, int width, int x, int y) {
		super(c, height, width, x, y);
		this.component = c;
		setCurrentImage(three);
//		System.out.println("yes");
	}
	public void setLife(int i){
		if (i == 3)setCurrentImage(three);
		else if (i == 2)setCurrentImage(two);
//		System.out.println("yes");
		else if (i == 1)setCurrentImage(one);
		else setCurrentImage(zero);
	}

}
