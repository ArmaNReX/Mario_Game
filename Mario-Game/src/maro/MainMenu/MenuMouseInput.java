package maro.MainMenu;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import maro.game.Game;
import maro.states.GameState;
import maro.states.State;

public class MenuMouseInput implements MouseListener {

	private State gameState;
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
//		if (mx > MainMenu.playX && mx < MainMenu.playX + MainMenu.buttonWidth){
//			if (my > MainMenu.playY && my < MainMenu.playY + MainMenu.buttonHeight) {
//				gameState = new GameState(Game.handler); //initialize our game state
//				State.setState(gameState);
//				System.out.println("chicken");
//			}
//		}
		if (mx > 0 && mx < 500){
			if (my > 0 && my < 500) {
//				gameState = new GameState(Game.handler); //initialize our game state
//				State.setState(gameState);
				System.out.println("chicken");
			}
		}
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

}
