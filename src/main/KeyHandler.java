package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
	
	public boolean upPressed, downPressed, leftPressed, rightPressed, menuSelectPressed;

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		int intCode = e.getKeyCode();
		
		if (intCode == KeyEvent.VK_W) {
				upPressed = true;
		}
		
		if (intCode == KeyEvent.VK_A) {
			leftPressed = true;
		}
		
		if (intCode == KeyEvent.VK_S) {
			downPressed = true;
		}
		
		if (intCode == KeyEvent.VK_D) {
			rightPressed = true;
		}
		
		if (intCode == KeyEvent.VK_E) {
			menuSelectPressed = true;
			
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		int intCode = e.getKeyCode();
		
		if (intCode == KeyEvent.VK_W) {
				upPressed = false;
		}
		
		if (intCode == KeyEvent.VK_A) {
			leftPressed = false;
		}
		
		if (intCode == KeyEvent.VK_S) {
			downPressed = false;
		}
		
		if (intCode == KeyEvent.VK_D) {
			rightPressed = false;
		}
		
		if (intCode == KeyEvent.VK_E) {
			menuSelectPressed = false;
		}
	}

}