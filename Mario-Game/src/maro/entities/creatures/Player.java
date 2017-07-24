package maro.entities.creatures;

import java.awt.Graphics;

import maro.Handler;
import maro.game.Game;
import maro.gfx.Assets;

public class Player extends Creature {
	
	public static int speed = 5;

	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
	}

	@Override
	public void tick() {
		
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
	}
	
	private void getInput() {
		xMove = 0;
		yMove = 0;
		
		if (handler.getKeyManager().up) {
			yMove = -speed;
		}
		if (handler.getKeyManager().down) {
			yMove = speed;
		}
		if (handler.getKeyManager().left) {
			xMove = -speed;
		}
		if (handler.getKeyManager().right) {
			xMove = speed;
		}
	}

	@Override
	public void render(Graphics g) {
		
		//width and height variables come from the extended Entity class. 
//		if(game.getKeyManager().up) {
			g.drawImage(Assets.mario_up, (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height, null); //used "casting" to convert float to int
//		}
//		if(game.getKeyManager().down) {
//			g.drawImage(Assets.mario_down, (int)x, (int)y, width, height, null); //used "casting" to convert float to int
//		}
//		if(game.getKeyManager().left) {
//			g.drawImage(Assets.mario_left, (int)x, (int)y, width, height, null); //used "casting" to convert float to int
//		}
//		if(game.getKeyManager().right) {
//			g.drawImage(Assets.mario_right, (int)x, (int)y, width, height, null); //used "casting" to convert float to int
//		}
//		if(game.getKeyManager().right == false && game.getKeyManager().left == false && game.getKeyManager().up == false && game.getKeyManager().down == false) {
//			g.drawImage(Assets.mario_down, (int)x, (int)y, width, height, null); //used "casting" to convert float to int
//		}
		
	}
	
	

}
