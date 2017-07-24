package maro.states;

import java.awt.Graphics;

import maro.entities.creatures.Player;
import maro.game.Game;
import maro.gfx.Assets;
import maro.tiles.Tile;
import maro.worlds.World;

public class GameState extends State { //writing "extends State" allows us to write the abstract methods tick() and render() which belong to the State class.
	
	private Player player;
	private World world;
	
	public GameState(Game game){
		super(game); //calls the constructor of the class which extends this one, aka "State" class
		world = new World(game, "res/worlds/world1.txt");
//		game.setWorld(world);
		player = new Player(game, 100,100);
		
		
	}

	@Override
	public void tick() {
		world.tick();
		player.tick();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
		player.render(g);
	}

	
	
}
