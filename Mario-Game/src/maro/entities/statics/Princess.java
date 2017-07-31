package maro.entities.statics;

import java.awt.Graphics;

import maro.Handler;
import maro.gfx.Assets;
import maro.tiles.Tile;

public class Princess extends StaticEntity{

	public Princess(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT * 2);
	}

	@Override
	public void tick() {
		
		
	}

	@Override
	public void render(Graphics g) {
		
		g.drawImage(Assets.princess, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), 75, 75, null);
		
	}

	
	
}
