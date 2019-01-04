package me.xxfreakdevxx.de.game.gameobject.entity;

import java.util.Random;

import me.xxfreakdevxx.de.game.CodeGenerator;
import me.xxfreakdevxx.de.game.gameobject.GameObject;
import me.xxfreakdevxx.de.game.gameobject.GameObjectType;
import me.xxfreakdevxx.de.game.gameobject.GameTexture;
import me.xxfreakdevxx.de.game.gameobject.Location;

public abstract class Entity extends GameObject{
	
	
	/* Gameplaye */
	protected double healthpoints = 0d; //Lebenspunkte des Entity
	protected double defense = 0d; //Abwehrpunkte
	protected String customname = ""; //Beliebiger Anzeigename
//	protected Inventory inventory = null;  INVENTAR MUSS PROGRAMMIERT WERDEN
	protected double fallDistance = 0d; //Die Distanz in nicht vollen Blöcken wird damit gespeichert
	protected boolean showCustomname = false; //Bestimmt, ob der Customname angezeigt werden soll
	protected boolean hasCustomname = false; //Besitzt Entity einen Customname?
	protected boolean isFalling = false; //Fällt es?
	protected boolean isOnGround = false; //Ist es auf dem Boden?
	protected boolean isOnFire = false; //Brennt es?
	/* System */
	public GameObject gameObject = null;
	protected EntityType entitytype = EntityType.UNDEFINED;
	protected String entityId = "No ID";
	public Random random = new Random();
	
	public Entity(EntityType entitytype, Location location, GameTexture texture, double healthpoints, double defense) {
		super(GameObjectType.ENTITY, location, texture);
		this.entitytype = entitytype;
		this.healthpoints = healthpoints;
		this.defense = defense;
		this.customname = "";
		this.entityId = CodeGenerator.generateEntityId();
	}
	public Entity(EntityType entitytype, Location location, GameTexture texture, double healthpoints) {
		super(GameObjectType.ENTITY, location, texture);
		this.entitytype = entitytype;
		this.healthpoints = healthpoints;
		this.defense = 0d;
		this.customname = "";
		this.entityId = CodeGenerator.generateEntityId();
	}

	public abstract void teleport(Location location);
	
	public double getHealthpoints() {
		return healthpoints;
	}
	public void setHealthpoints(double healthpoints) {
		this.healthpoints = healthpoints;
	}
	public double getDefense() {
		return defense;
	}
	public void setDefense(double defense) {
		this.defense = defense;
	}
	public String getCustomname() {
		return customname;
	}
	public void setCustomname(String customname) {
		this.customname = customname;
		setHasCustomname(true);
	}
	public double getFallDistance() {
		return fallDistance;
	}
	public void setFallDistance(double fallDistance) {
		this.fallDistance = fallDistance;
	}
	public boolean isShowCustomname() {
		return showCustomname;
	}
	public void setShowCustomname(boolean showCustomname) {
		this.showCustomname = showCustomname;
	}
	public boolean isHasCustomname() {
		return hasCustomname;
	}
	public void setHasCustomname(boolean hasCustomname) {
		this.hasCustomname = hasCustomname;
	}
	public boolean isFalling() {
		return isFalling;
	}
	public void setFalling(boolean isFalling) {
		this.isFalling = isFalling;
	}
	public boolean isOnGround() {
		return isOnGround;
	}
	public void setOnGround(boolean isOnGround) {
		this.isOnGround = isOnGround;
		if(isOnGround) setFallDistance(0d);
	}
	public boolean isOnFire() {
		return isOnFire;
	}
	public void setOnFire(boolean isOnFire) {
		this.isOnFire = isOnFire;
	}
	//Dem Entity wird Scahden zugefügt
	public void damage(double damage) {
		//Die Abwehrppunkte werden mit einberechnet
		double resultingDamage = damage / defense;
		healthpoints -= resultingDamage;
	}
	public String getEntityId() {
		return entityId;
	}
	
}
