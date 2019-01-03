package me.xxfreakdevxx.de.game;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("unused")
public class KeyInput extends KeyAdapter {
	
	public KeyInput() {
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();	
	}
	
}
