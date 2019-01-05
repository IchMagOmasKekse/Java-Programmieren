package me.xxfreakdevxx.de.game;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import me.xxfreakdevxx.de.game.enviroment.WorldChunk;
import me.xxfreakdevxx.de.game.gameobject.Location;

public class MouseInput extends MouseAdapter {
	

	public MouseInput() {
	}
	
	public void mousePressed(MouseEvent e) {
		Camera camera = Game.getInstance().getCamera();
		int mx = (int) (e.getX() + camera.getX());
		int my = (int) (e.getY() + camera.getY());
		Location mouseLoc = new Location((mx/Game.blocksize)*Game.blocksize, (my/Game.blocksize)*Game.blocksize);
		
		if(e.getButton() == MouseEvent.BUTTON2) {
			
			WorldChunk chunk = Game.getInstance().getGameRaster().getChunkManager().getChunk(mouseLoc);
			Console.send("Mouse", "Chunk: "+chunk.getChunkId());
		}else if(e.getButton() == MouseEvent.BUTTON1) {
			Location loc = new Location(0,0);
			Console.send("Mouse", "In Screen? "+Game.checkIfInWindow(loc));
		}else if(e.getButton() == MouseEvent.BUTTON3) {
		}
	}
}
