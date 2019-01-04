package me.xxfreakdevxx.de.game;

import me.xxfreakdevxx.de.game.gameobject.GameObject;
import me.xxfreakdevxx.de.game.gameobject.Location;

public class Camera {
	private float x = 0;
	private float y = 0;
	private float xOffset = 0;
	private float yOffset = 3*Game.blocksize;
	
	public Camera(float x, float y) {
		this.x=x;
		this.y=y;
	}
	
	public void tick(GameObject object) {
		y=0;
		x=0;
		x += ((object.getLocation().getX() - x) - Game.windowWidth/2)+xOffset * 0.05f;
		y += ((object.getLocation().getY() - y) - Game.windowHeight/2)+yOffset * 0.05f;
	
		if(x <= 0) x = 0; 
		if(x >= (Game.windowWidth + 32)) x = (Game.windowWidth+32);
		if(y <= 0) y = 0; 
		if(y >= (Game.windowHeight + 16)) y = (Game.windowHeight+16);
	}
	public void tick(Location loc) {
		x=0; 
		y=0;
		x += (float)loc.getX()- Game.windowWidth/2+xOffset;
		y += (float)loc.getY()- Game.windowHeight/2+yOffset;

//		if(x <= 0) x = 0; 
//		if(x >= (Game.windowWidth + 32)) x = (Game.windowWidth+32);
//		if(y <= 0) y = 0; 
//		if(x >= (Game.windowHeight + 16)) x = (Game.windowHeight+16);
	}
	public void tickKey(Location loc) {
		x += (float)loc.getX();
		y += (float)loc.getY();

//		if(x <= 0) x = 0; 
//		if(x >= (Game.windowWidth + 32)) x = (Game.windowWidth+32);
//		if(y <= 0) y = 0; 
//		if(x >= (Game.windowHeight + 16)) x = (Game.windowHeight+16);
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
	
}
