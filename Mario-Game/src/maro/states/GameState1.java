package maro.states;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.logging.Level;

import maro.entities.creatures.Player;
import maro.game.Game;
import maro.game.Launcher;
import maro.gfx.Assets;
import maro.tiles.Tile;
import maro.worlds.World;

public class GameState1 extends State { //writing "extends State" allows us to write the abstract methods tick() and render() which belong to the State class.
	
	private Player player;
	private World world;
	private int score;
	private int level = 1;
	
	public Rectangle header = new Rectangle(0, 0, Launcher.gameWidth, 100);
	
	public GameState1(Game game){
		super(game); //calls the constructor of the class which extends this one, aka "State" class
		class1();
	}
	
	public void class1() {
		world = new World(game, "res/worlds/world" + this.level + ".txt");//World is our level
		player = new Player(game, 100,100);
		//this.checkStates(world, game);
	}
	
	/*public void checkStates(World world, Game game){
		if (world.finishedGame()){
			this.level++;
			class1();
			System.out.println("OKKKK");
		}
		else{
			this.checkStates(world, game);
		}
	}*/

	@Override
	public void tick() {
		world.tick();
		player.tick();
	}

	@Override
	public void render(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		
		g.setColor(Color.WHITE);
		g2d.draw(header);
		
		world.render(g);
		player.render(g);
	}

	
	
}
