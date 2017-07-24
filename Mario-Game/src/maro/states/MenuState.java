package maro.states;

import java.awt.Graphics;

import maro.Handler;
import maro.MainMenu.MainMenu;
import maro.entities.creatures.Player;
import maro.game.Game;
import maro.worlds.World;

public class MenuState extends State { //writing "extends State" allows us to write the abstract methods tick() and render() which belong to the State class.

	private MainMenu mainMenu;
	
	public MenuState(Handler handler) {
		super(handler); //calls the constructor of the class which extends this one, aka "State" class
		mainMenu = new MainMenu(handler, 100, 100);
	}

	@Override
	public void tick() {
//		mainMenu.tick();

	}

	@Override
	public void render(Graphics g) {
		mainMenu.render(g);		
	}
}
