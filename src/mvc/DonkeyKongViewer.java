package mvc;

import java.awt.*;

import javax.swing.*;


public class DonkeyKongViewer extends JFrame {
	private static final long serialVersionUID = 3891163111924324774L;
	protected Controller controller;
	protected Scoreboard score;
	

	public static void main(String[] args) {
		new DonkeyKongViewer();
	}

	public DonkeyKongViewer() {
		super("Almost Donkey Kong");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		controller = new Controller(this);
		score = new Scoreboard();
		
		ViewScoreBoard viewer = new ViewScoreBoard();
		getContentPane().setLayout(new BorderLayout());  //change to border
		getContentPane().add("Center", viewer);
		getContentPane().add("South", score);
		pack();
		setVisible(true);
	}
	
	private class ViewScoreBoard extends JPanel {
		private static final long serialVersionUID = 8651888917167259520L;
		public ViewScoreBoard() {
			setPreferredSize(new Dimension(600, 600));
			setBackground(Color.black);
			addKeyListener(new Listener(controller, score));
			setFocusable(true);
		}
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			drawLevel(g);
			controller.paintModels(g);
			score.setScore(controller.getScore());
			controller.rollFrames();
		}
		
		private void drawLevel(Graphics g){
			
		}
		
	}
}
