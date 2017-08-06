package maro.entities.creatures;

import java.awt.Color;

import maro.Handler;
import maro.display.Display;
import maro.entities.Entity;
import maro.entities.EntityManager;
import maro.entities.statics.Ghost;
import maro.entities.statics.Princess;
import maro.game.Game;
import maro.states.GameState1;
import maro.tiles.Tile;

public abstract class Creature extends Entity {
	
	public static int DEFAULT_HEALTH = 10;
	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_CREATURE_WIDTH = 64;
	public static final int DEFAULT_CREATURE_HEIGHT = 64;
	
	
	protected int health;
	protected float speed;
	protected float xMove, yMove;
	
	public static boolean Princess1 = true;
	public static boolean Princess2 = true;
	public static boolean Princess3 = true;
	public static boolean Princess4 = true;
	public static boolean Princess5 = true;
	public static boolean Princess6 = true;
	public static boolean Princess7 = true;
	public static boolean Princess8 = true;
	public static boolean Princess9 = true;
	public static boolean Princess10 = true;

	public Creature(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height); //this will connect to the constructor in class "Entity"
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}
	
	/**
	 * 
	 */
	/**
	 * 
	 */
	/**
	 * 
	 */
	public void move() {
		
		//checks if the player comes into contact with any of the princess objects
		if (Princess1) {
			if (Player.marioXcenter > Princess.p1x && Player.marioXcenter < Princess.p1x+Princess.princessWidth && Player.marioYcenter > Princess.p1y && Player.marioYcenter < Princess.p1y+Princess.princessHeight) {
				Princess1 = false;
				GameState1.ScoreVal +=1;
			}
		}
		if (Princess2) {
			if (Player.marioXcenter > Princess.p2x && Player.marioXcenter < Princess.p2x+Princess.princessWidth && Player.marioYcenter > Princess.p2y && Player.marioYcenter < Princess.p2y+Princess.princessHeight) {
				Princess2 = false;
				GameState1.ScoreVal +=1;
			}
		}
		if (Princess3) {
			if (Player.marioXcenter > Princess.p3x && Player.marioXcenter < Princess.p3x+Princess.princessWidth && Player.marioYcenter > Princess.p3y && Player.marioYcenter < Princess.p3y+Princess.princessHeight) {
				Princess3 = false;
				GameState1.ScoreVal +=1;
			}
		}
		if (Princess4) {
			if (Player.marioXcenter > Princess.p4x && Player.marioXcenter < Princess.p4x+Princess.princessWidth && Player.marioYcenter > Princess.p4y && Player.marioYcenter < Princess.p4y+Princess.princessHeight) {
				Princess4 = false;
				GameState1.ScoreVal +=1;
			}
		}
		if (Princess5) {
			if (Player.marioXcenter > Princess.p5x && Player.marioXcenter < Princess.p5x+Princess.princessWidth && Player.marioYcenter > Princess.p5y && Player.marioYcenter < Princess.p5y+Princess.princessHeight) {
				Princess5 = false;
				GameState1.ScoreVal +=1;
			}
		}
		if (Princess6) {
			if (Player.marioXcenter > Princess.p6x && Player.marioXcenter < Princess.p6x+Princess.princessWidth && Player.marioYcenter > Princess.p6y && Player.marioYcenter < Princess.p6y+Princess.princessHeight) {
				Princess6 = false;
				GameState1.ScoreVal +=1;
			}
		}
		if (Princess7) {
			if (Player.marioXcenter > Princess.p7x && Player.marioXcenter < Princess.p7x+Princess.princessWidth && Player.marioYcenter > Princess.p7y && Player.marioYcenter < Princess.p7y+Princess.princessHeight) {
				Princess7 = false;
				GameState1.ScoreVal +=1;
			}
		}
		if (Princess8) {
			if (Player.marioXcenter > Princess.p8x && Player.marioXcenter < Princess.p8x+Princess.princessWidth && Player.marioYcenter > Princess.p8y && Player.marioYcenter < Princess.p8y+Princess.princessHeight) {
				Princess8 = false;
				GameState1.ScoreVal +=1;
			}
		}
		if (Princess9) {
			if (Player.marioXcenter > Princess.p9x && Player.marioXcenter < Princess.p9x+Princess.princessWidth && Player.marioYcenter > Princess.p9y && Player.marioYcenter < Princess.p9y+Princess.princessHeight) {
				Princess9 = false;
				GameState1.ScoreVal +=1;
			}
		}
		if (Princess10) {
			if (Player.marioXcenter > Princess.p10x && Player.marioXcenter < Princess.p10x+Princess.princessWidth && Player.marioYcenter > Princess.p10y && Player.marioYcenter < Princess.p10y+Princess.princessHeight) {
				Princess10 = false;
				GameState1.ScoreVal +=1;
			}
		}
		
		//checks if players comes into contact with an enemy
		
		if (Player.marioXcenter > Ghost.p1x && Player.marioXcenter < Ghost.p1x+Ghost.ghostWidth && Player.marioYcenter > Ghost.p1y && Player.marioYcenter < Ghost.p1y+Ghost.ghostHeight) {
			System.exit(0); //kills the application
		}
		if (Player.marioXcenter > Ghost.p2x && Player.marioXcenter < Ghost.p2x+Ghost.ghostWidth && Player.marioYcenter > Ghost.p2y && Player.marioYcenter < Ghost.p2y+Ghost.ghostHeight) {
			System.exit(0);//kills the application
		}
		if (Player.marioXcenter > Ghost.p3x && Player.marioXcenter < Ghost.p3x+Ghost.ghostWidth && Player.marioYcenter > Ghost.p3y && Player.marioYcenter < Ghost.p3y+Ghost.ghostHeight) {
			System.exit(0);//kills the application
		}
		if (Player.marioXcenter > Ghost.p4x && Player.marioXcenter < Ghost.p4x+Ghost.ghostWidth && Player.marioYcenter > Ghost.p4y && Player.marioYcenter < Ghost.p4y+Ghost.ghostHeight) {
			System.exit(0);//kills the application
		}
		if (Player.marioXcenter > Ghost.p5x && Player.marioXcenter < Ghost.p5x+Ghost.ghostWidth && Player.marioYcenter > Ghost.p5y && Player.marioYcenter < Ghost.p5y+Ghost.ghostHeight) {
			System.exit(0);//kills the application
		}
		if (Player.marioXcenter > Ghost.p6x && Player.marioXcenter < Ghost.p6x+Ghost.ghostWidth && Player.marioYcenter > Ghost.p6y && Player.marioYcenter < Ghost.p6y+Ghost.ghostHeight) {
			System.exit(0);//kills the application
		}
		if (Player.marioXcenter > Ghost.p7x && Player.marioXcenter < Ghost.p7x+Ghost.ghostWidth && Player.marioYcenter > Ghost.p7y && Player.marioYcenter < Ghost.p7y+Ghost.ghostHeight) {
			System.exit(0);//kills the application
		}
		if (Player.marioXcenter > Ghost.p8x && Player.marioXcenter < Ghost.p8x+Ghost.ghostWidth && Player.marioYcenter > Ghost.p8y && Player.marioYcenter < Ghost.p8y+Ghost.ghostHeight) {
			System.exit(0);//kills the application
		}
		
		
			moveX();
			moveY();
	}
	
	public void moveX() {
		
		if (xMove > 0) { //moving right
			int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILE_WIDTH;
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILE_HEIGHT) && !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)) { //checks if no solid tile is present
				x += xMove;
			}
		}
		else if(xMove < 0) { //moving left
			int tx = (int) (x + xMove + bounds.x) / Tile.TILE_WIDTH;
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILE_HEIGHT) && !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)) { //checks if no solid tile is present
				x += xMove;
			}
		}
	}
	
	public void moveY() {
		if (yMove < 0) { //moving up
			
			int ty = (int)(y + yMove + bounds.y) / Tile.TILE_HEIGHT;
			
			if (!collisionWithTile((int)(x + bounds.x) / Tile.TILE_WIDTH, ty) && !collisionWithTile((int)(x + bounds.x + bounds.width) / Tile.TILE_WIDTH, ty)) {
				y += yMove;
			}
			
		}
		else if (yMove > 0) { //moving down
			int ty = (int)(y + yMove + bounds.y + bounds.height) / Tile.TILE_HEIGHT;
			
			if (!collisionWithTile((int)(x + bounds.x) / Tile.TILE_WIDTH, ty) && !collisionWithTile((int)(x + bounds.x + bounds.width) / Tile.TILE_WIDTH, ty)) {
				y += yMove;
			}
		}
	}
	
	protected boolean collisionWithTile(int x, int y) {
		return handler.getWorld().getTile(x, y).isSolid();
	}
	
	
	//getters and setters begin here

	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	
	
	
}
