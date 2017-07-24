package maro.display;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display {
	
	private JFrame frame;
	private Canvas canvas; 
	
	private String title; //game window title
	private int width, height; //game window width and height
	
	public Display(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		
		createDisplay();
	}
	
	//this method is called in the constructor
	private void createDisplay() {
		frame = new JFrame(title);
		frame.setSize(width,height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //makes sure game closes completely and properly when it's asked to be closed.
		frame.setResizable(false); //we don't want the player to resize the window 
		frame.setLocationRelativeTo(null); //this causes the game window to appear in the center of screen everytime.
		frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height)); //will assure canvas will always remain at width and height we want it.
		canvas.setMinimumSize(new Dimension(width, height));//will assure canvas will always remain at width and height we want it.
		canvas.setFocusable(false); //causes the application to focus itself
		
		frame.add(canvas);//adds the canvas to JFrame.
		frame.pack();//makes sure canvas is resized to appear properly in JFrame.
	}
	
	public Canvas getCanvas() { //getter for canvas object.
		return canvas;
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	

}
