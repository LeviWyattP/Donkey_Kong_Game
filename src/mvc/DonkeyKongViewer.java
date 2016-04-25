package mvc;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.*;


public class DonkeyKongViewer extends JFrame {
	private static final long serialVersionUID = 3891163111924324774L;
	protected Controller controller;
	protected Scoreboard score;
	protected AudioClip mario_jump, background_music; 

	public static void main(String[] args) {
		new DonkeyKongViewer();
	}

	public DonkeyKongViewer() {
		super("Almost Donkey Kong");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.mario_jump = getAudioClip("mario_jump.mp3");
		this.mario_jump = getAudioClip("mario_jump.aiff");
		this.background_music = getAudioClip("01-theme.aiff");
		controller = new Controller(this);
		score = new Scoreboard();
		
		ViewScoreBoard viewer = new ViewScoreBoard();
		getContentPane().setLayout(new BorderLayout());  //change to border
		getContentPane().add("Center", viewer);
		getContentPane().add("South", score);
		pack();
		setVisible(true);

	}
	/**
	 * Play a sound file (in .wav, .mid, or .au format) in a background thread.
	 */
	public AudioClip getAudioClip(String filename) {
		URL url = null;
		try {
			File file = new File(filename);
			if (file.canRead())
				url = file.toURI().toURL();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		if (url == null)
			throw new RuntimeException("audio " + filename + " not found");
		return Applet.newAudioClip(url);
	}
	
	
	private class ViewScoreBoard extends JPanel {
		private static final long serialVersionUID = 8651888917167259520L;
		public ViewScoreBoard() {
			setPreferredSize(new Dimension(controller.SCREENWIDTH, controller.SCREENHEIGHT));
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

	public void play_mario_jump() {
		// TODO Auto-generated method stub
		this.mario_jump.play();
	}

	public void play_background_music() {
		this.background_music.loop();
	}

	public void stop_background_music() {
		this.background_music.stop();
	}


}
