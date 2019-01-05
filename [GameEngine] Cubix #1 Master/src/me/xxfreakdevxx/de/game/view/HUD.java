package me.xxfreakdevxx.de.game.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import me.xxfreakdevxx.de.game.Camera;
import me.xxfreakdevxx.de.game.Game;

public class HUD {
	
	static Color transBlack = new Color(0.0f,0.0f,0.0f,0.3f);
	static Font font = new Font("Consolas",0, 20);
	
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
	
	public static void drawDebugInfos(Graphics g) {
		String fps = "FPS: "+Game.FPS;
		String renderedChunks = "Rendered Chunks: "+Game.getInstance().getGameRaster().getChunkManager().renderedChunks;
		Game.getInstance().getGameRaster().getChunkManager().renderedChunks = 0;
		int fpsWidth = Game.calculateStringWidth(font, fps);
		int renderedChunksWidth = Game.calculateStringWidth(font, renderedChunks);
		g.setFont(font);
		g.setColor(transBlack);
		g.fillRect(1, 5, fpsWidth, 20);
		g.fillRect(1, 25, renderedChunksWidth, 20);
		g.setColor(Color.WHITE);
		g.drawString(fps, 1, 20);
		g.drawString(renderedChunks, 1, 40);
	}
	
}
