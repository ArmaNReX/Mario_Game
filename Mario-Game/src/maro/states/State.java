package maro.states;

import java.awt.Graphics;

import maro.game.Game;

public abstract class State { //State is the current window on screen shown to the user
	
	
	private static State currentState = null; //the current screen being shown (initially set as null)
	
	//setter
	public static void setState(State state){
		currentState = state;
	}
	
	//getter
	public static State getState() {
		return currentState;
	}
	
	
	
	protected Game game;
	
	public State(Game game) {
		this.game = game;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);

}
