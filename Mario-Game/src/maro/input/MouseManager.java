package maro.input;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import maro.game.Game;
import maro.states.GameState;
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
		
		System.out.println("clicked");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		System.out.println("clicked");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		System.out.println("clicked");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		if (e.getButton() == MouseEvent.BUTTON1) {//BUTTON1 is left mouse button
			leftPressed = true;
		}
		else if (e.getButton() == MouseEvent.BUTTON3) {
			rightPressed = true;
		}

		if (mouseX > 0 && mouseX < 500) {
			if (mouseY > 0 && mouseY < 500) {
				System.out.println("FUCK");
			}
		}
		System.out.println("clicked");
		
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
