package me.xxfreakdevxx.de.game.gameobject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import me.xxfreakdevxx.de.game.Game;

public abstract class GameObject {
	
	/* Alle Gegenstände, Lebewesen und Projektile sind GameObjekte */
	
	/* System */
	protected static Game game = Game.getInstance();
	private GameObjectType gameObjectType = GameObjectType.UNDEFINED;
	/* Gameplay */
	//Movement
	private boolean hasGravity = false; //Bestimmt die Gravitatiosn Einwirkung
	public double movementSpeed = 1.5d; //Bestimmt die Bewegungsgeschwindigkeit des GameObjects
	private Location location = null; //Location wo sich das Entity befidnet
	//Rendering
	private boolean drawHitbox = false; //Soll die Hitbox gezeichnet werden?
	public Color hitboxColor = new Color(0.5f, 0.0f, 0.0f, 0.5f); //Die Farbe, in der die Hitbox gezeichnet werden soll
	private GameTexture texture = null; //Die GameTexture Klasse in der die Textur eund Animation gespeichert wird
	public int width = 0; //Breite des Entities
	public int height = 0; //Höhe des Entities
	
	public GameObject(GameObjectType gameObjectType, Location location, GameTexture texture) {
		this.gameObjectType = gameObjectType;
		this.location = location;
		this.texture = texture;
		this.width = texture.getWidth();
		this.height = texture.getHeight();
	}
	
	public abstract void render(Graphics g);
	public abstract void tick();
	
	public Rectangle getBounds() {
		return new Rectangle(getLocation().getIntX(), getLocation().getIntY(), width, height);
	}
	
	public void remove() {
		//game.getGameWorld().unregisterObject(this);
		//TODO:
	}
	
	/* Diese Location wird NICHT geklont.
	 * Als jede Veränderung einer dritten Variable dieser Variable,
	 * wird direkt auf diese Ursprungs Variable übertragen */
	public Location getUnClonedLocation() {
		return location;
	}
	public Location getLocation() {
		return location.clone();
	}

	public void setLocation(Location location) {
		this.location = location.clone();
	}

	public GameObjectType getGameObjectType() {
		return gameObjectType;
	}
	public GameTexture getGameTexture() {
		return texture;
	}
	public void setGameTexture(GameTexture Texture) {
		
	}
	public boolean hasGravity() {
		return hasGravity;
	}
	public void setHasGravity(boolean hasGravity) {
		this.hasGravity = hasGravity;
	}
	public void setDrawHitbox(boolean hitbox) {
		this.drawHitbox = hitbox;
	}
	public boolean getDrawHitbox() {
		return this.drawHitbox;
	}
	public void drawHitbox(Graphics g) {
		if(drawHitbox) {			
			g.setColor(hitboxColor);
			g.fillRect(getLocation().getIntX(), getLocation().getIntY(), getWidth(), getHeight());
		}
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	
	public void fixToGameRaster() {
		/* Diese Methode fixiert die Location an das GameRaster */
		double x = getLocation().getX();
		double y = getLocation().getY();
		double z = getLocation().getZ();
		x=x/Game.blocksize*Game.blocksize;
		y=y/Game.blocksize*Game.blocksize;
		z=z/Game.blocksize*Game.blocksize;
		Location location = getLocation();
		location.setX(x);
		location.setY(y);
		location.setZ(z);
		setLocation(location);
	}
	
}
