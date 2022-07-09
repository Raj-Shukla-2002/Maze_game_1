package MCMovement;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controls implements KeyListener {
	
	private boolean[] keys;
	public boolean up, down, left, right;
	public boolean uAttack, dAttack, lAttack, rAttack;
	
	public Controls(){
		keys = new boolean[256];
	}
	
	public void tick(){
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
		
		uAttack = keys[KeyEvent.VK_UP];
		dAttack = keys[KeyEvent.VK_DOWN];
		lAttack = keys[KeyEvent.VK_LEFT];
		rAttack = keys[KeyEvent.VK_RIGHT];

	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
