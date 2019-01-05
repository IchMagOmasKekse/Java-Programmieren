package me.xxfreakdevxx.de.game;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.security.Key;

@SuppressWarnings("unused")
public class KeyInput extends KeyAdapter {
	
	public KeyInput() {
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_A) Game.getInstance().getWorld().getPlayer().getEntityControls().setGoLeft(true);
		if(key == KeyEvent.VK_D) Game.getInstance().getWorld().getPlayer().getEntityControls().setGoRight(true);
		if(key == KeyEvent.VK_S || key == KeyEvent.VK_SHIFT) Game.getInstance().getWorld().getPlayer().getEntityControls().setSneak(true);
		if(key == KeyEvent.VK_SPACE || key == KeyEvent.VK_W) Game.getInstance().getWorld().getPlayer().getVelocity().jump(4);
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_A) Game.getInstance().getWorld().getPlayer().getEntityControls().setGoLeft(false);
		if(key == KeyEvent.VK_D) Game.getInstance().getWorld().getPlayer().getEntityControls().setGoRight(false);
		if(key == KeyEvent.VK_S || key == KeyEvent.VK_SHIFT) Game.getInstance().getWorld().getPlayer().getEntityControls().setSneak(false);
		if(key == KeyEvent.VK_SPACE || key == KeyEvent.VK_W) Game.getInstance().getWorld().getPlayer().getEntityControls().setJump(false);
	}
	
}
