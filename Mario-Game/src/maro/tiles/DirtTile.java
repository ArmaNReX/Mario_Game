package maro.tiles;

import maro.gfx.Assets;

public class DirtTile extends Tile{

	
	public DirtTile(int id) {
		super(Assets.stardew_dirt, id);
	}
	
	//we override the isSolid method because we dont want the player to walk on dirt.
	@Override
	public boolean isSolid(){
		return true;
	}
}
