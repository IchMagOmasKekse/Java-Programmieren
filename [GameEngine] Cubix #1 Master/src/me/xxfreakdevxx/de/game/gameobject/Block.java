package me.xxfreakdevxx.de.game.gameobject;

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
	
	
	
}
