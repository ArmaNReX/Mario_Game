package maro.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;

import maro.Handler;
import maro.entities.EntityManager;
import maro.game.Game;
import maro.gfx.Assets;

public class Player extends Creature {
	
	public static int speed = 10;
	public static float marioXpos;
	public static float marioYpos;
	public static int marioXcenter = (int)(Player.marioXpos + 20);
	public static int marioYcenter = (int)(Player.marioYpos + 10);

	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		bounds.x = 20;
		bounds.y = 10;
		bounds.width = 25;
		bounds.height = 43;
		
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
		
		
//		g.drawImage(Assets.mario_up, (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), 80, 80, null); //used "casting" to convert float to int

//		g.setColor(Color.RED);
//		g.fillRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()), 
//				(int)(y + bounds.y - handler.getGameCamera().getyOffset()), 
//				bounds.width, bounds.height);
		
		
		
//		width and height variables come from the extended Entity class. 
		if(handler.getKeyManager().up) {
			g.drawImage(Assets.mario_up, (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height, null); //used "casting" to convert float to int
		}
		if(handler.getKeyManager().down) {
			g.drawImage(Assets.mario_down, (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height, null); //used "casting" to convert float to int
		}
		if(handler.getKeyManager().left) {
			g.drawImage(Assets.mario_left, (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height, null); //used "casting" to convert float to int
		}
		if(handler.getKeyManager().right) {
			g.drawImage(Assets.mario_right, (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height, null); //used "casting" to convert float to int
		}
		if(handler.getKeyManager().right == false && handler.getKeyManager().left == false && handler.getKeyManager().up == false && handler.getKeyManager().down == false) {
			g.drawImage(Assets.mario_down, (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height, null); //used "casting" to convert float to int
		}
		marioXpos = x;
		marioYpos = y;
		marioXcenter = (int)(Player.marioXpos + 20);
		marioYcenter = (int)(Player.marioYpos + 10);
	}
}
