package maro.states;

import java.awt.Graphics;

import maro.Handler;
import maro.entities.creatures.Player;
import maro.game.Game;

public class MenuState extends State { //writing "extends State" allows us to write the abstract methods tick() and render() which belong to the State class.

	public MenuState(Handler handler) {
		super(handler); //calls the constructor of the class which extends this one, aka "State" class
	}

	@Override
	public void tick() {
		
		
	}

	@Override
	public void render(Graphics g) {
		
		
	}
	
	
	
}
