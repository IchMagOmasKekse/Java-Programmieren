package me.xxfreakdevxx.de.game.view;

import java.awt.Color;
import java.awt.Graphics;

import me.xxfreakdevxx.de.game.Camera;
import me.xxfreakdevxx.de.game.Game;

public class HUD {
	
	public static void drawWindowMiddle(Graphics g) {
		Camera cam = Game.getInstance().getCamera();
		int w = Game.windowWidth;
		int h = Game.windowHeight;
		g.setColor(Color.BLACK);
		//Vert
		g.drawLine((int) ((int)(w/2)+cam.getX()), 0, (int)((int)(w/2)+cam.getX()), (int)((int)(h)+cam.getY()));
		//Hori
		g.drawLine(0, (int) ((int)(h/2)+cam.getY()), (int) ((int)(w)+cam.getX()), (int) ((int)(h/2)+cam.getY()));
	}
	
}
