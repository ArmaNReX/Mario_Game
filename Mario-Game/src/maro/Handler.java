package maro;

import maro.game.Game;
import maro.gfx.GameCamera;
import maro.input.KeyManager;
import maro.worlds.World;

//this class allows us to access our game or world object and any other required object across all our classes. good programing practice to have a handler class.
public class Handler {

	
	private Game game;
	private World world;
	
	public Handler (Game game) {
		this.game = game;
	}
	
	public int getWidth() {
		return game.getWidth();
	}
	
	public int getHeight() {
		return game.getHeight();
	}
	
	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}
	
	public GameCamera getGameCamera() {
		return game.getGameCamera();
	}
	

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}
	
}
