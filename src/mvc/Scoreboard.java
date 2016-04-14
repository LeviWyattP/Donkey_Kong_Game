package mvc;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Scoreboard extends JPanel {
	private final int WIDTH = 600, HEIGHT = 50;
	private ImageIcon currentImage;
	private int score;
	private int x_loc, y_loc;
	
	public Scoreboard() {
		x_loc = WIDTH /2;
		y_loc = HEIGHT /3;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		currentImage.paintIcon(this, g, x_loc, y_loc);
		g.setColor(Color.white);
		g.drawString(Integer.toString(getScore()), 5, 30);
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
}
