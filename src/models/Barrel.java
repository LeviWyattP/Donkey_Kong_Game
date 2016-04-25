package models;

import java.awt.Component;
import java.awt.Graphics;

import javax.swing.*;

/**
 * @author Levi
 *
 */
public class Barrel extends MyShape {
	public boolean next_ladder;
	public boolean am_i_dead;
	public String barrel_front = "Barrel_front.png";
	public String barrel_side = "Sprites\\Barrel_front.png";
	private ImageIcon barrelImage;
	private Component component;
	
	public Barrel(Component c, int height, int width, int x, int y) {
		super(c, height, width,  x, y);
		
		component = c;
		setCurrentImage(barrel_front);
		
	}
	
	public void breakState(boolean b) {
		// TODO Auto-generated method stub
		this.am_i_dead = b;
		
	}
	
}
