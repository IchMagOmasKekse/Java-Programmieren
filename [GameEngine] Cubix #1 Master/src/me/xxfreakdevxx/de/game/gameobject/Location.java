package me.xxfreakdevxx.de.game.gameobject;

import me.xxfreakdevxx.de.game.Game;

public class Location {
	
	/* Diese Location Klasse gibt eine GameObjekt Location wieder */
	
	private double x = 0d;
	private double y = 0d;
	private double z = 0d; //Wird genutzt, um herauszufinden, ob der Spieler sich z.b. hinter einer Tür versteckt
	private int yaw = 0; //Reichweite -180 bis 180. Gibt die Blick richtung des Spielers an
	
	private String gameStringMask = "%X:%Y:%Z/%yaw";
	private String xReplacement = "%X";
	private String yReplacement = "%Y";
	private String zReplacement = "%Z";
	private String yawReplacement = "%yaw";
	
	public Location(double x, double y, double z, int yaw) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.yaw = yaw;
	}
	public Location(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public Location(double x, double y, int yaw) {
		this.x = x;
		this.y = y;
		this.yaw = yaw;
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
	public int getIntX() {
		return (int)x;
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
	public int getIntY() {
		return (int)y;
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
	public int getIntZ() {
		return (int)z;
	}
	public void setZ(double z) {
		this.z = z;
	}
	public void addZ(double z) {
		this.z += z;
	}
	
	public int getYaw() {
		return yaw;
	}
	public void setYaw(int yaw) {
		this.yaw = yaw;
	}
	public int calculateYaw() {
		return 0; //MUSS NOCH PROGRAMMIERT WERDEN
	}
	public void add(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public void add(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/* Gibt den an das System angepassten Location String zurück */
	public String getSystemLocationString() {
		String s = gameStringMask;
		int x = (int)getX();
		int y = (int)getY();
		int z = (int)getZ();
		s = s.replace(xReplacement, x+"");
		s = s.replace(yReplacement, y+"");
		s = s.replace(zReplacement, z+"");
		s = s.replace(yawReplacement, "");
		s = s.replace("/", "");
		return s;
	}
	/* Gibt den erweiterten und an das System angepassten Location String zurück */
	public String getExtendedSystemLocationString() {
		String s = gameStringMask;
		int x = (int)getX();
		int y = (int)getY();
		int z = (int)getZ();
		s = s.replace(xReplacement, x+"");
		s = s.replace(yReplacement, y+"");
		s = s.replace(zReplacement, z+"");
		s = s.replace(yawReplacement, getYaw()+"");
		return s;
	}
	/* Gibt den an das Raster angepassten Location String zurück */
	public String getGameLocationString() {
		String s = gameStringMask;
		int x = (int)getX()/Game.blocksize*Game.blocksize;
		int y = (int)getY()/Game.blocksize*Game.blocksize;
		int z = (int)getZ()/Game.blocksize*Game.blocksize;
		s = s.replace(xReplacement, x+"");
		s = s.replace(yReplacement, y+"");
		s = s.replace(zReplacement, z+"");
		s = s.replace(yawReplacement, "");
		return s;
	}
	/* Gibt den erweiterten und an das Raster angepassten Location String zurück */
	public String getExtendedGameLocationString() {
		String s = gameStringMask;
		int x = (int)getX()/Game.blocksize*Game.blocksize;
		int y = (int)getY()/Game.blocksize*Game.blocksize;
		int z = (int)getZ()/Game.blocksize*Game.blocksize;
		s = s.replace(xReplacement, x+"");
		s = s.replace(yReplacement, y+"");
		s = s.replace(zReplacement, z+"");
		s = s.replace(yawReplacement, getYaw()+"");
		return s;
	}
	public Location clone() {
		return new Location(getX(), getY(), getZ(), getYaw());
	}
}
