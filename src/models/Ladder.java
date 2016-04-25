package models;

import java.awt.Component;

public class Ladder extends MyShape{
	public boolean isBroken;
	public String ladder = "ladder_4rungs.png";
	public String broken_ladder = "ladder_broken.png";
	public Ladder(Component c, int height, int width, int x, int y) {
		super(c, height, width, x, y);
		setCurrentImage(ladder);
	}
	public void setbroken_state(boolean b){
		isBroken = b;
		if(b){
			setCurrentImage(broken_ladder);
		}
		else{
			setCurrentImage(ladder);
		}
	}
	public boolean getbroken_state(){
		return isBroken;
	}
}
