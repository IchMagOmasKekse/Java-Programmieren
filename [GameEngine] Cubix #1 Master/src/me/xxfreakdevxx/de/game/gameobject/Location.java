package me.xxfreakdevxx.de.game.gameobject;

public class Location {
	
	/* Diese Location Klasse gibt eine GameObjekt Location wieder */
	
	private double x = 0d;
	private double y = 0d;
	private double z = 0d;
	
	public Location(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public Location(double x, double y) {
		this.x = x;
		this.y = y;
	}
	public Location(Location loc) {
		this.x = loc.getX();
		this.y = loc.getY();
		this.z = loc.getZ();
	}
	
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public void addX(double x) {
		this.x += x;
	}
	
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public void addY(double y) {
		this.y += y;
	}

	public double getZ() {
		return z;
	}
	public void setZ(double z) {
		this.z = z;
	}
	public void addZ(double z) {
		this.z += z;
	}
}
