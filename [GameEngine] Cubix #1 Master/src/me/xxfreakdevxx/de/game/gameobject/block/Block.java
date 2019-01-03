package me.xxfreakdevxx.de.game.gameobject.block;

import me.xxfreakdevxx.de.game.gameobject.GameObject;
import me.xxfreakdevxx.de.game.gameobject.GameObjectType;
import me.xxfreakdevxx.de.game.gameobject.GameTexture;
import me.xxfreakdevxx.de.game.gameobject.Location;
import me.xxfreakdevxx.de.game.gameobject.ToolMaterial;
import me.xxfreakdevxx.de.game.gameobject.ToolType;

public abstract class Block extends GameObject {
		
	public BlockMaterial blockMaterial = BlockMaterial.AIR;
	public ToolType tooltype = ToolType.MULTI_TOOL;
	public ToolMaterial toolMaterial = ToolMaterial.HAND;
//	public ArrayList<ItemStack> loot = new ArrayList<ItemStack>();
	public double healthPoints = 100D;
	
	public Block(Location location, GameTexture gameTexture) {
		super(GameObjectType.BLOCK, location, gameTexture);
	}
	
	/* Diese Methode soll den Loot droppen, wenn der Block zerstört wird */
	public void dropLoot() {
		//TODO: Itemstacks müssen Programmiert werden
	}
	
	public void addDamage(double damage) {
		this.healthPoints -= damage;
		if(healthPoints <= 0D) destroyBlock();
	}
	
	public void destroyBlock() {
		//TODO: Muss noch programmiert werden
	}
	
	
	
}
