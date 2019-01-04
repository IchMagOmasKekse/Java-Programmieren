package me.xxfreakdevxx.de.game.gameobject.block;

import java.awt.Graphics;

import me.xxfreakdevxx.de.game.Game;
import me.xxfreakdevxx.de.game.gameobject.GameObject;
import me.xxfreakdevxx.de.game.gameobject.GameObjectType;
import me.xxfreakdevxx.de.game.gameobject.GameTexture;
import me.xxfreakdevxx.de.game.gameobject.Location;
import me.xxfreakdevxx.de.game.gameobject.ToolMaterial;
import me.xxfreakdevxx.de.game.gameobject.ToolType;

public abstract class Block extends GameObject {
		
	public BlockMaterial blockMaterial = BlockMaterial.AIR;
	public ToolType toolType = ToolType.MULTI_TOOL;
	public ToolMaterial toolMaterial = ToolMaterial.HAND;
//	public ArrayList<ItemStack> loot = new ArrayList<ItemStack>();
	public double healthPoints = 100D;
	
	/* Temporär */
	public boolean hasDirtTop = false;
	public GameTexture dirtTop = new GameTexture(game.getTextureAtlas().getImage("dirt_top_0"), false);
	public void checkGrasTop() {
		Location loc = getLocation();
		loc.addY(-Game.blocksize);
		Block b = null;
		if(game.getGameRaster() != null) b = game.getGameRaster().getBlockAt(loc);
		if(b != null) {
			if(b.getBlockMaterial() == BlockMaterial.DIRT_BLOCK || b.getBlockMaterial() == BlockMaterial.GRASS_BLOCK) hasDirtTop = true;			
		}
		else hasDirtTop = true;
	}
	public void drawDirtTop(Graphics g) {
		if(hasDirtTop)g.drawImage(dirtTop.getTexture(), getLocation().getIntX(), getLocation().getIntY(), Game.blocksize, Game.blocksize, null);
	}
	//---------------------------------------
	
	public Block(Location location, GameTexture gameTexture) {
		super(GameObjectType.BLOCK, location, gameTexture);
	}
	
	public BlockMaterial getBlockMaterial() {
		return blockMaterial;
	}
	public ToolType getToolType() {
		return toolType;
	}
	public ToolMaterial getToolMaterial() {
		return toolMaterial;
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
