package me.xxfreakdevxx.de.game.gameobject;

public class GameVector {
	double subtraction = 0.1;
	double x = 0;
	double y = 0;
	double z = 0;
	double jumpY = 0;
	public GameVector(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public GameVector(double x, double y) {
		this.x = x;
		this.y = y;
	}
	public double getXAndDontSubtract() {
		return x;
	}
	public double getYAndDontSubtract() {
		return y;
	}
	public double getZAndDontSubtract() {
		return z;
	}
	public void addX(double x) {
		this.x += x;
	}
	public void addY(double y) {
		this.y += y;
	}
	public void addZ(double z) {
		this.z += z;
	}
	public void setX(double x) {
		this.x = x;
	}
	public void setY(double y) {
		this.y = y;
	}
	public void setZ(double z) {
		this.z = z;
	}
	
	public double getX() {
		//Diese Methode gibt X zurück und verringert X um subtraction bis es 0 ist
		boolean isNegative = false;
		if(x < 0) isNegative = true;
		if(isNegative) x=x*(-1);
		if(x-subtraction > 0) x=x-subtraction;
		else x = 0;
		if(isNegative) x=x*(-1);
		return x;
	}
	public double getY() {
		//Diese Methode gibt Y zurück und verringert Y um subtraction bis es 0 ist
		boolean isNegative = false;
		if(y < 0) isNegative = true;
		if(isNegative) y=y*(-1);
		if(y-subtraction > 0) y=y-subtraction;
		else y = 0;
		if(isNegative) y=y*(-1);
		return y;
	}
	public double getZ() {
		//Diese Methode gibt Z zurück und verringert Z um subtraction bis es 0 ist
		boolean isNegative = false;
		if(z < 0) isNegative = true;
		if(isNegative) z=z*(-1);
		if(z-subtraction > 0) z=z-subtraction;
		else z = 0;
		if(isNegative) z=z*(-1);
		return z;
	}
	public void jump(double jump) {
		y = 0d;
		if(jump > 0) this.jumpY = (jump*(-1));		
	}
	public double getJump() {
		boolean isNegative = false;
		if(jumpY < 0) isNegative = true;
		if(isNegative) jumpY=jumpY*(-1);
		if(jumpY-subtraction > 0) jumpY=jumpY-subtraction;
		else jumpY = 0;
		if(isNegative) jumpY=jumpY*(-1);
		return jumpY;
	}
	
}
