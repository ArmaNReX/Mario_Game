package maro.game;


public class Launcher {
	
	public static void main(String[] args) {
		
		Game game = new Game("Mario Game!", 1300, 800); // game title, width of screen, height of screen
		game.start();
	}

}
