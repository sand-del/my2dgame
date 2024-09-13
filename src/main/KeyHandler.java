package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
	
	public boolean upPressed, downPressed, rightPressed, leftPressed;

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {

		int code = e.getKeyCode();
		
		if (code == KeyEvent.VK_Z) { // W
			upPressed = true;
		}
		
		if (code == KeyEvent.VK_S) { // S
			downPressed = true;
		}
		
		if (code == KeyEvent.VK_Q) { // A
			rightPressed = true;
		}

		if (code == KeyEvent.VK_D) { // D
			leftPressed = true;
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		
		if (code == KeyEvent.VK_Z) { // W
			upPressed = false;
		}
		
		if (code == KeyEvent.VK_S) { // S
			downPressed = false;
		}
		
		if (code == KeyEvent.VK_Q) { // A
			rightPressed = false;
		}

		if (code == KeyEvent.VK_D) { // D
			leftPressed = false;
		}
		
	}
	
	

}
