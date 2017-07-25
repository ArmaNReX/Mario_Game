package maro.input;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import maro.MainMenu.MainMenu;
import maro.display.Display;
import maro.game.Game;
import maro.states.GameState1;
import maro.states.State;

public class MouseManager implements MouseListener, MouseMotionListener {

	private boolean leftPressed, rightPressed;
	private int mouseX, mouseY;
	
	public MouseManager() {
		
	}
	
	//helper classes
	public boolean isLeftPressed() {
		return this.leftPressed;
	}
	
	public boolean isRightPressed() {
		return this.rightPressed;
	}
	
	public int getMouseX() {
		return this.mouseX;
	}
	
	public int getMouseY() {
		return this.mouseY;
	}
	
	//mouse methods
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
		
		if (e.getButton() == MouseEvent.BUTTON1) {//BUTTON1 is left mouse button
			leftPressed = true;
		}
		else if (e.getButton() == MouseEvent.BUTTON3) {//BUTTON3 is right mouse button
			rightPressed = true;
		}

		//Conditions for Play button
		if (mouseX > MainMenu.playX && mouseX < MainMenu.playX + MainMenu.buttonWidth) {
			if (mouseY > MainMenu.playY && mouseY < MainMenu.playY + MainMenu.buttonHeight) {
				State.setState(Game.gameState); //opens the game frame
			}
		}
		//Conditions for Help button
		if (mouseX > MainMenu.helpX && mouseX < MainMenu.helpX + MainMenu.buttonWidth) {
			if (mouseY > MainMenu.helpY && mouseY < MainMenu.helpY + MainMenu.buttonHeight) {
				
			}
		}
		//Conditions for Quit button
		if (mouseX > MainMenu.quitX && mouseX < MainMenu.quitX + MainMenu.buttonWidth) {
			if (mouseY > MainMenu.quitY && mouseY < MainMenu.quitY + MainMenu.buttonHeight) {
				Display.frame.dispose();
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {//BUTTON1 is left mouse button
			leftPressed = false;
		}
		else if (e.getButton() == MouseEvent.BUTTON3) {
			rightPressed = false;
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
	}

	
	@Override
	public void mouseMoved(MouseEvent e) { //when mouse moves, this method is triggered
		
		mouseX = e.getX();
		mouseY = e.getY();
		
	}

}
