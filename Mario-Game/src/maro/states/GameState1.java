package maro.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.logging.Level;

import maro.Handler;
import maro.entities.EntityManager;
import maro.entities.creatures.Player;
import maro.entities.statics.Princess;
import maro.game.Game;
import maro.game.Launcher;
import maro.gfx.Assets;
import maro.tiles.Tile;
import maro.worlds.World;

public class GameState1 extends State { //writing "extends State" allows us to write the abstract methods tick() and render() which belong to the State class.
	
	private World world;
	private int score;
	private int level = 1;
	public static String HealthVal = "FULL";
	public static int ScoreVal = 0;
	
	public Rectangle header = new Rectangle(0, 0, Launcher.gameWidth, 100);
	
	public GameState1(Handler handler){
		super(handler); //calls the constructor of the class which extends this one, aka "State" class
		world = new World(handler, "res/worlds/world1.txt");//World is our level
		handler.setWorld(world); //set the handler's object world to what gets passed in here
	}
	

	@Override
	public void tick() {
		world.tick();
	}

	@Override
	public void render(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		
		world.render(g);
		
		g.setColor(Color.WHITE);
		g2d.draw(header);
		Font myFont1 = new Font("arial", java.awt.Font.BOLD, 25);
		g.setColor(Color.BLACK);
		g.setFont(myFont1);
		g.drawString("Score: ", Launcher.gameWidth - 300, 55); //Score String
		g.drawString(ScoreVal+"/"+EntityManager.princessCount, Launcher.gameWidth - 200, 55); //Score Value String
		g.drawString("Health: ", 200, 55); //Health String
		g.drawString(HealthVal +"", 300, 55); //Health Value String
	}
	
	public class SecretLevel extends State {
		
		public SecretLevel(Handler handler){
			super(handler); //calls the constructor of twhe class which extends this one, aka "State" class
			world = new World(handler, "res/worlds/world2.txt");//World is our level
			handler.setWorld(world); //set the handler's object world to what gets passed in here
		}
		
		@Override
		public void tick() {
			world.tick();
		}

		@Override
		public void render(Graphics g) {
			
			Graphics2D g2d = (Graphics2D) g;
			
			world.render(g);
			
			g.setColor(Color.WHITE);
			g2d.draw(header);
			Font myFont1 = new Font("arial", java.awt.Font.BOLD, 25);
			g.setColor(Color.BLACK);
			g.setFont(myFont1);
			g.drawString("Score: ", Launcher.gameWidth - 300, 55); //Score String
			g.drawString(ScoreVal+"/"+EntityManager.princessCount, Launcher.gameWidth - 200, 55); //Score Value String
			g.drawString("Health: ", 200, 55); //Health String
			g.drawString(HealthVal+"", 300, 55); //Health Value String
		}
		
		
		
	}

	
	
}
