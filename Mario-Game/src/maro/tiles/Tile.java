package maro.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;



public class Tile {
	
	//POLYMORPHISM 
	public static Tile[] tiles = new Tile[256]; //creates array with 256 capacity. each index is id of a different tile type.
	public static Tile floor1 = new Floor1(0); //0 is the id.
	public static Tile dirt_tile = new DirtTile(1);
	public static Tile grass_tile = new GrassTile(2);
	
	
	
	public static final int TILE_WIDTH = 100;
	public static final int TILE_HEIGHT = 100;
	
	protected BufferedImage texture;
	protected final int id;
	
	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT, null);
	}
	
	//decides whether a tile is walkable or no. eg: tree tile should not be walkable.
	public boolean isSolid(){
		return false;
	}
		
	public int getId() {
		return id;
	}
	

}
