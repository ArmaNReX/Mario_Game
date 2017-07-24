package maro.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 40, height = 40;
	
	public static BufferedImage mario_right, mario_down, mario_left, mario_up, tile_mid, tile_left, tile_right, background_pic, stardew_sewer, stardew_grass,stardew_dirt;
	
	
	//this method is what loads in everything for our game. everything including sounds and pictures and musics.
	//this method only gets called ONCE.
	public static void init(){
		SpriteSheet bgSheet = new SpriteSheet(ImageLoader.loadImage("/textures/background-sheet.png")); //creates a spritesheet object.
		SpriteSheet sheet1 = new SpriteSheet(ImageLoader.loadImage("/textures/mario-sheet2.png")); 
		SpriteSheet sheet2 = new SpriteSheet(ImageLoader.loadImage("/textures/tiles-sheet.png"));
		SpriteSheet stardewSheet1 = new SpriteSheet(ImageLoader.loadImage("/textures/stardew-sheet1.png"));
		SpriteSheet stardewSheet2 = new SpriteSheet(ImageLoader.loadImage("/textures/stardew-sheet2.png"));
		
		
		stardew_sewer = stardewSheet1.crop(0, 214, 160, 107);
		stardew_grass = stardewSheet2.crop(0, 209, 47, 46);
		stardew_dirt = stardewSheet2.crop(81, 715, 46, 28);
		background_pic = bgSheet.crop(3, 3, 512, 432);
		mario_right = sheet1.crop(202, 237, width, height);
		mario_down = sheet1.crop(0, 277, width, height);
		mario_left = sheet1.crop(163, 237, width, height);
		mario_up = sheet1.crop(40, 277, width, height);
	}

}
