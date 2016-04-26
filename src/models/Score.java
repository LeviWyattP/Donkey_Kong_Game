package models;

import java.awt.Component;

public class Score extends MyShape{
	private String zero = "0.png";
	private String onehundred = "100.png";
	private String twohundred = "200.png";
	private String threehundred = "300.png";
	private String fourhundred = "400.png";
	private String fivehundred = "500.png";
	private String sixhundred = "600.png";
	private String sevenhundred = "700.png";
	private String eighthundred = "800.png";
	private String ninehundred = "900.png";
	private String tenhundred = "1000.png";
	private String elevenhundred = "1100.png";
	private String twelvehundred = "1200.png";
	private String thirteenhundred = "1300.png";
	public Score(Component c, int height, int width, int x, int y) {
		super(c, height, width, x, y);
		setCurrentImage(zero);
		// TODO Auto-generated constructor stub
	}

	public void setScore(int score) {
		if (score == 0) setCurrentImage(zero);
		if (score == 100) setCurrentImage(onehundred);
		if (score == 200) setCurrentImage(twohundred);
		if (score == 300) setCurrentImage(threehundred);
		if (score == 400) setCurrentImage(fourhundred);
		if (score == 500) setCurrentImage(fivehundred);
		if (score == 600) setCurrentImage(sixhundred);
		if (score == 700) setCurrentImage(sevenhundred);
		if (score == 800) setCurrentImage(eighthundred);
		if (score == 900) setCurrentImage(ninehundred);
		if (score == 1000) setCurrentImage(tenhundred);
		if (score == 1100) setCurrentImage(elevenhundred);
		if (score == 1200) setCurrentImage(twelvehundred);
		if (score == 1300) setCurrentImage(thirteenhundred);
	}

}
