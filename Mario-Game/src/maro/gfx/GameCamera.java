package maro.gfx;

import maro.entities.Entity;
import maro.game.Game;

public class GameCamera { //used to keep track (stick) the camera position on the player character in game

	private Game game;
	private float xOffset, yOffset;
	

	public GameCamera(Game game, float xOffset, float yOffset) {
		this.game = game;
		this.xOffset = xOffset;
		this.xOffset = yOffset;
	}
	
	public void centerOnEntity(Entity e) {
		xOffset = e.getX() - game.getWidth() / 2  + (e.getWidth() / 2); //dividing by 2 so the player gets centered 
		yOffset = e.getY() - game.getHeight() / 2  + (e.getHeight() / 2);
	}
	
	public void move(float xAmt, float yAmt) {
		xOffset += xAmt;
		yOffset += yAmt;
	}
	
	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	} 

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}
	
}
