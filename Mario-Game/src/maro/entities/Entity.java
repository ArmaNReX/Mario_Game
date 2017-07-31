package maro.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import maro.Handler;
import maro.game.Game;

public abstract class Entity {
	
	protected Handler handler;
	protected float x, y; //we choose protected so classes that extend this class will have access to these variable
	protected int width, height;
	protected Rectangle bounds;
	
	public Entity(Handler handler, float x, float y, int width, int height) {
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		bounds = new Rectangle(0, 0, width, height);
	}
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	//abstract classes
	public abstract void tick();
	public abstract void render(Graphics g);
	
	public Rectangle getCollisionBounds(float xOffset, float yOffset) {
		return new Rectangle((int) (x + bounds.x + xOffset), (int)(y + bounds.y + yOffset), bounds.width, bounds.height);
	}
	
	public boolean checkEntityCollision(float xOffset, float yOffset) { //this method decides if collision has occured
		for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
			if (e.equals(this))//to assure we are not checking if an entity is colliding with itself
				continue; //this causes the loop the skip current iteration and go to next iteration.
			if (e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset)))
				return true;
		}
		return false;
	}
	
}
