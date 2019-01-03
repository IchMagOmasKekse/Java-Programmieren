package me.xxfreakdevxx.de.game.gameobject;

import java.awt.image.BufferedImage;

public class GameTexture {
	
	/* System */
	public BufferedImage texture = null; //Die Texture
	public boolean isAnimation = false; //Ist diese Texture animiert?
	
	/* Animation */
	private int playSpeed = 1; //Wiedergabe geschwindkeit
	private int currentFrame = 0; //Der Index des aktuellen Frames
	private int frameAmount = 0; /* Die totale Anzahl an Frames der Animation.
	                              * Diese Variable wird immer um 1 größer sein als die Java-Listen Größe.
	                              * FrameAmount 15 wäre als das 14te Element aus der Frame-Liste */
	private boolean loop = true; //Soll die Animation immer wieder von vorne anfangen?
	private boolean forward = true; //Animation soll vor- oder rückwärts abgespielt werden
	private BufferedImage frames[] = new BufferedImage[100]; //Die einzelnen Frames
	public GameTexture(BufferedImage texture, boolean isAnimation) {
		super();
		this.texture = texture;
		this.isAnimation = isAnimation;
	}
	
	/* Standbild */
	public BufferedImage getTexture() {
		return texture;
	}
	
	
	/* Animation */
	public int getPlaySpeed() {
		return playSpeed;
	}
	public void setPlaySpeed(int playSpeed) {
		this.playSpeed = playSpeed;
	}
	public int getCurrentFrame() {
		return currentFrame;
	}
	public void setCurrentFrame(int currentFrame) {
		this.currentFrame = currentFrame;
	}
	public int getFrameAmount() {
		return frameAmount;
	}
	public void setFrameAmount(int frameAmount) {
		this.frameAmount = frameAmount;
	}
	public boolean isLoop() {
		return loop;
	}
	public void setLoop(boolean loop) {
		this.loop = loop;
	}
	public boolean isForward() {
		return forward;
	}
	public void setForward(boolean forward) {
		this.forward = forward;
	}
	public BufferedImage[] getFrames() {
		return frames;
	}
	public void setFrames(BufferedImage[] frames) {
		this.frames = frames;
	}
	/* Gibt den nächsten Frame zurück und setzt den Counter zurpck, wenn die Maximale Anzahl an Frames erreicht wurde */
	public GameTexture getNextFrame() {
		if(currentFrame+1 > frameAmount) {
			currentFrame = 0;
		}
		return new GameTexture(getFrames()[currentFrame], false);
	}
	public GameTexture getFirstFrame() {
		return new GameTexture(getFrames()[0], false);
	}
	public GameTexture getLastFrame() {
		return new GameTexture(getFrames()[frameAmount-1], false);
	}
}
