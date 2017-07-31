package maro.entities.statics;

import java.awt.Graphics;

import maro.Handler;
import maro.gfx.Assets;
import maro.tiles.Tile;

public class Princess extends StaticEntity{
	
	public static int princessWidth = 75; //princess character's width
	public static int princessHeight = 75; //princess character's height
	
	//coordinates of the p
	public static int p1x = 100;
	public static int p1y = 250;
	public static int p2x = 1000;
	public static int p2y = 300;
	public static int p3x = 100;
	public static int p3y = 1550;
	public static int p4x = 500;
	public static int p4y = 250;
	public static int p5x = 800;
	public static int p5y = 250;
	public static int p6x = 900;
	public static int p6y = 250;

	public Princess(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT * 2);
	}

	@Override
	public void tick() {
		
		
	}

	@Override
	public void render(Graphics g) {
		
		g.drawImage(Assets.princess, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), princessWidth, princessHeight, null);
		
	}

	
	
}
