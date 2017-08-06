package maro.entities.statics;

import java.awt.Graphics;

import maro.Handler;
import maro.gfx.Assets;
import maro.tiles.Tile;

public class Princess extends StaticEntity{
	
	public static int princessWidth = 75; //princess character's width
	public static int princessHeight = 75; //princess character's height
	
	//coordinates of the princess
	public static int p1x = 400;
	public static int p1y = 450;
	public static int p2x = 100;
	public static int p2y = 750;
	public static int p3x = 1100;
	public static int p3y = 1300;
	public static int p4x = 100;
	public static int p4y = 1100;
	public static int p5x = 700;
	public static int p5y = 1700;
	public static int p6x = 1800;
	public static int p6y = 1700;
	public static int p7x = 1800;
	public static int p7y = 1400;
	public static int p8x = 1300;
	public static int p8y = 900;
	public static int p9x = 1900;
	public static int p9y = 1000;
	public static int p10x = 1700;
	public static int p10y = 300;

	public Princess(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT * 2);
	}

	@Override
	public void tick() {
		
		
	}

	@Override
	public void render(Graphics g) {
		
//		g.drawImage(Assets.princess, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), princessWidth, princessHeight, null);
		
	}

	
	
}
