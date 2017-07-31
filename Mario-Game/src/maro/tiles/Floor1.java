package maro.tiles;

import java.awt.image.BufferedImage;

import maro.gfx.Assets;

public class Floor1 extends Tile {

	public Floor1(int id) {
		super(Assets.stardew_sewer, id);
	}
	
	
	public boolean isSolid(){
		return false;
	}
}
