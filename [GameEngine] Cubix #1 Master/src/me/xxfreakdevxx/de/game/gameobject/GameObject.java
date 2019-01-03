package me.xxfreakdevxx.de.game.gameobject;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import me.xxfreakdevxx.de.game.Game;

public abstract class GameObject {
	
	/* Alle Gegenstände, Lebewesen und Projektile sind GameObjekte */
	
	public Game game = Game.getInstance();
	private Location location = null;
	private GameObjectType gameObjectType = GameObjectType.UNDEFINED;
	private GameTexture texture = null;
	
	public GameObject(GameObjectType gameObjectType, Location location, GameTexture texture) {
		this.gameObjectType = gameObjectType;
		this.location = location;
		this.texture = texture;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public GameObjectType getGameObjectType() {
		return gameObjectType;
	}
	public GameTexture getGameTexture() {
		return texture;
	}
	public void setGameTexture(GameTexture Texture) {
		
	}
	
	public abstract void render(Graphics g);
	public abstract void tick();
	
	public void remove() {
		//game.getGameWorld().unregisterObject(this);
		//TODO:
	}
	
}
