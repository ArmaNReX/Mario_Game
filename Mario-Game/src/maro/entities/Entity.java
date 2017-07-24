package maro.entities;

import java.awt.Graphics;

import maro.Handler;
import maro.game.Game;

public abstract class Entity {
	
	protected Handler handler;
	protected float x, y; //we choose protected so classes that extend this class will have access to these variable
	protected int width, height;
	
	public Entity(Handler handler, float x, float y, int width, int height) {
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
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
	
}
