package maro.entities;

import java.awt.Graphics;
import java.util.ArrayList;

import maro.Handler;
import maro.entities.creatures.Creature;
import maro.entities.creatures.Player;
import maro.entities.statics.Princess;
import maro.gfx.Assets;

public class EntityManager {
	
	private Handler handler;
	private Player player;
	public static ArrayList<Entity> entities;

	public EntityManager(Handler handler, Player player) {
		this.handler = handler;
		this.player = player;
		entities = new ArrayList<Entity>();
		addEntity(player);
	}
	
	public void tick() {
		for (int i=0; i < entities.size(); i++) {
			Entity e = entities.get(i);
			e.tick();
		}
	}
	
	public void render(Graphics g) {
		for (Entity e : entities) {
			e.render(g);
		}
		//draws all the princess objects on the screen (if the player hasn't already got to them)
		if (Creature.Princess1) {
			g.drawImage(Assets.princess, (int) (Princess.p1x - handler.getGameCamera().getxOffset()), (int) (Princess.p1y - handler.getGameCamera().getyOffset()), Princess.princessWidth, Princess.princessHeight, null);
		}
		if (Creature.Princess2) {
			g.drawImage(Assets.princess, (int) (Princess.p2x - handler.getGameCamera().getxOffset()), (int) (Princess.p2y - handler.getGameCamera().getyOffset()), Princess.princessWidth, Princess.princessHeight, null);
		}
		if (Creature.Princess3) {
			g.drawImage(Assets.princess, (int) (Princess.p3x - handler.getGameCamera().getxOffset()), (int) (Princess.p3y - handler.getGameCamera().getyOffset()), Princess.princessWidth, Princess.princessHeight, null);
		}
		if (Creature.Princess4) {
			g.drawImage(Assets.princess, (int) (Princess.p4x - handler.getGameCamera().getxOffset()), (int) (Princess.p4y - handler.getGameCamera().getyOffset()), Princess.princessWidth, Princess.princessHeight, null);
		}
		if (Creature.Princess5) {
			g.drawImage(Assets.princess, (int) (Princess.p5x - handler.getGameCamera().getxOffset()), (int) (Princess.p5y - handler.getGameCamera().getyOffset()), Princess.princessWidth, Princess.princessHeight, null);
		}
		if (Creature.Princess6) {
			g.drawImage(Assets.princess, (int) (Princess.p6x - handler.getGameCamera().getxOffset()), (int) (Princess.p6y - handler.getGameCamera().getyOffset()), Princess.princessWidth, Princess.princessHeight, null);
		}

	}
	
	//Getters and Setters

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}
	
	public void addEntity(Entity e) { //adds entities to our ArrayList.
		entities.add(e);
	}
	
}
