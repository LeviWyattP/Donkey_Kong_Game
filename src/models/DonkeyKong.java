package models;

import java.awt.Component;
import java.awt.Graphics;

public class DonkeyKong extends MyShape {
	public int currentState;
	private String Donkey_Kong_Front = "DK_front.png";
	private String donkey_kong_grabbing = "Kong_Grabbing_Barrel.jpg";
	private String donkey_kong_holding = "Kong_With_Barrel.jpg";
	private String donkey_kong_dropping = "Donkey_Kong_Dropping_Barrel.jpg";
	private Component component;

	
	public DonkeyKong(Component c, int height, int width, int x, int y) {
		super(c, height, width,  x, y);
		
		this.component = c;
		setCurrentImage(Donkey_Kong_Front);
	}
	
	public int get_currentState() {
		return this.currentState;
	}

	public void increment_currentState() {
		this.currentState = this.currentState + 1;
		setStateImage(this.currentState);
	}
	
	public  void resetCurrentState() {
		this.currentState = 0;
		setStateImage(this.currentState);
	}

	private void setStateImage(int state) {
		switch (state) {
		case 0:
			setCurrentImage(Donkey_Kong_Front);
			break;
		case 1:
			setCurrentImage(donkey_kong_grabbing);
			break;
		case 2:
			setCurrentImage(donkey_kong_holding);
			break;
		case 3:
			setCurrentImage(donkey_kong_dropping);
			break;			
		}
	}
	
}
