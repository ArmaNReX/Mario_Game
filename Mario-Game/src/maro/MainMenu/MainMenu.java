package maro.MainMenu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import maro.Handler;
import maro.game.Launcher;
import maro.gfx.Assets;

public class MainMenu {
	
	//button coordinates and size fields
	public static int playX=100;
	public static int playY=200;
	public static int helpX=550;
	public static int helpY=350;
	public static int quitX=550;
	public static int quitY=500;
	public static int buttonWidth=300;
	public static int buttonHeight=100;
	
	public Rectangle playButton = new Rectangle(playX, playY, buttonWidth, buttonHeight);
	public Rectangle helpButton = new Rectangle(helpX, helpY, buttonWidth, buttonHeight);
	public Rectangle quitButton = new Rectangle(quitX, quitY, buttonWidth, buttonHeight);

	public MainMenu(Handler handler, int width, int height) {
		
	}

	public void tick() {
		
	}
	
	public void render(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		//background Image
		g.drawImage(Assets.background_pic, 0, 0, Launcher.gameWidth, Launcher.gameHeight, null);
		
		//Game Title/Header
		Font font1 = new Font("arial", Font.BOLD, 50);
		g.setFont(font1);
		g.setColor(Color.BLUE);
		g.drawString("MARIO GETS ROUGH", Launcher.gameWidth / 3, 100);
		
		//Buttons
		
		
		Font font2 = new Font("arial", Font.BOLD, 50);
		g.setFont(font2);
		g.setColor(Color.RED);
		g.drawString("Play!", playButton.x+85, playButton.y+75);
		g2d.draw(playButton);
		g.drawString("Help", helpButton.x+85, helpButton.y+75);
		g2d.draw(helpButton);
		g.drawString("Quit", quitButton.x+85, quitButton.y+75);
		g2d.draw(quitButton);
		
	}
	
}
