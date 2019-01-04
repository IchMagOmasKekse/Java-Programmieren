package me.xxfreakdevxx.de.game.gameobject.entity;

import me.xxfreakdevxx.de.game.gameobject.GameTexture;
import me.xxfreakdevxx.de.game.gameobject.Location;

public abstract class LivingEntity extends Entity {
	
	public boolean isDead = false; //Gibt an, ob das Entity tot ist
	public EntityControls controls = new EntityControls(this);
	
	public LivingEntity(EntityType entitytype, Location location, GameTexture texture, double healthpoints) {
		super(entitytype, location, texture, healthpoints);
		// TODO Auto-generated constructor stub
	}
	
	public void kill() {
		this.isDead = true;
		game.getWorld().unregisterObject(this);
	}
	
	public EntityControls getEntityControls() {
		return this.controls;
	}
	public void move() {
		if(getEntityControls().getGoLeft()) getUnClonedLocation().addX(-movementSpeed);
		if(getEntityControls().getGoRight()) getUnClonedLocation().addX(movementSpeed);
	}

}
