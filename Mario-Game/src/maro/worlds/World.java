package maro.worlds;

import java.awt.Graphics;

import maro.game.Game;
import maro.tiles.Tile;
import maro.utils.Utils;

public class World {
	
	private Game game;
	private int width, height;
	private int spawnX, spawnY;
	private boolean gameFinished = false;
	private int[][] tiles; //2D array
	
	public World(Game game, String path) {
		loadWorld(path);
		this.game = game;
	}
	
	private void loadWorld(String path) {
		
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+"); //splits words by white spaces
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		for (int y=0; y<height; y++) {
			for (int x=0; x<width; x++) {
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}
	}

	public void tick() {
		
	}
	
	public void render(Graphics g) {
		
		//this method is redefined for efficiency purposes. We want the program to only render parts of the world 
		//which are visible on the player's screen.
		int xStart = (int) Math.max(0, game.getGameCamera().getxOffset() / Tile.TILE_WIDTH);
		int xEnd = (int) Math.min(width, (game.getGameCamera().getxOffset() + game.getWidth()) / Tile.TILE_WIDTH + 1);
		int yStart = (int) Math.max(0, game.getGameCamera().getyOffset() / Tile.TILE_HEIGHT);
		int yEnd = (int) Math.min(height, (game.getGameCamera().getyOffset() + game.getHeight()) / Tile.TILE_HEIGHT + 1);
		
		
		for (int y=yStart; y<yEnd; y++) {
			for (int x=xStart; x<xEnd; x++) {
				getTile(x, y).render(g, (int)(x * Tile.TILE_WIDTH - game.getGameCamera().getxOffset()), (int)(y * Tile.TILE_HEIGHT - game.getGameCamera().getyOffset()));
			}
		}
		
	}
	
	public boolean finishedGame() { //passes true when the game is over and the user meets the score required to end the level
		return false;
	}
	
	public Tile getTile(int x, int y) {
		Tile t  = Tile.tiles[tiles[x][y]];
		if (t == null) { //in case tile id Z was chose and Z was never specified in Tile class
			return Tile.grass_tile;
		}
		return t;
	}
	
}
