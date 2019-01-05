package me.xxfreakdevxx.de.game.gameobject.entity;

public class EntityControls {
	
	private boolean goLeft = false;
	private boolean goRight = false;
	private boolean sneak = false;
	private boolean jump = false;
	private LivingEntity entity = null;
	
	public EntityControls(LivingEntity entity) {
		this.entity = entity;
	}
	
	public void setGoLeft(boolean goLeft) {
		this.goLeft = goLeft;
		if(goLeft) this.goRight = false;
		this.entity.getUnClonedLocation().setYaw(-90);
	}
	public void setGoRight(boolean goRight) {
		this.goRight = goRight;
		if(goRight) this.goLeft = false;
		this.entity.getUnClonedLocation().setYaw(90);
	}
	public void setSneak(boolean sneak) {
		this.sneak = sneak;
	}
	public void setJump(boolean jump) {
		this.jump = jump;
	}
	
	public boolean getGoLeft() {
		return goLeft;
	}
	public boolean getGoRight() {
		return goRight;
	}
	public boolean getSneak() {
		return sneak;
	}
	public boolean getJump() {
		return jump;
	}
	
}
