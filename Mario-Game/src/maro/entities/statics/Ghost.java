package maro.entities.statics;

import java.awt.Graphics;

import maro.Handler;
import maro.gfx.Assets;
import maro.tiles.Tile;

public class Ghost extends StaticEntity{
	
	public static int ghostWidth = 55; //princess character's width
	public static int ghostHeight = 55; //princess character's height
	
	//coordinates of the princess
		public static int p1x = 100;
		public static int p1y = 150;
		public static int p2x = 200;
		public static int p2y = 320;
		public static int p3x = 100;
		public static int p3y = 1550;
		public static int p4x = 500;
		public static int p4y = 250;
		public static int p5x = 800;
		public static int p5y = 250;
		public static int p6x = 900;
		public static int p6y = 250;
		public static int p7x = 900;
		public static int p7y = 250;
		public static int p8x = 900;
		public static int p8y = 250;

		public Ghost(Handler handler, float x, float y) {
			super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT * 2);
		}

		public void tick() {
			
			
		}

		@Override
		public void render(Graphics g) {
			
//			g.drawImage(Assets.princess, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), ghostWidth, ghostHeight, null);
			
		}

}
