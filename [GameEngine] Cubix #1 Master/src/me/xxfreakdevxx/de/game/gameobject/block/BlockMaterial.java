package me.xxfreakdevxx.de.game.gameobject.block;

import me.xxfreakdevxx.de.game.gameobject.ToolType;

public enum BlockMaterial {
	
	/* Diese Klasse wird alle existierenden Materialien auflisten mit dazugehörigen Informationen */
	
	AIR(0, 0D, ToolType.MULTI_TOOL, false, "Luft", "block_air", "/assets/textures/blocks/air.png", "not yet"),
	STONE(1, 100D, ToolType.PICKAXE, true, "Stein", "block_stone", "/assets/textures/blocks/stone.png", "not yet"),
	GRASS_BLOCK(2, 50D, ToolType.SHOVEL, true, "Gras", "block_grass", "/assets/textures/blocks/grass.png", "not yet"),
	DIRT_BLOCK(3, 60D, ToolType.SHOVEL, true, "Erde", "block_dirt", "/assets/textures/blocks/dirt.png", "not yet");
	
	int id = 0;
	double healthpoints = 0D;
	ToolType toolType = ToolType.MULTI_TOOL;
	boolean isSolid = false;
	String displayname = "";
	String codename = "";
	String texturePath = "";
	String soundPath = "";
	private BlockMaterial(int id, double healthpoints, ToolType toolType, boolean isSolid, String displayname, String codename, String texturePath, String soundPath) {
		this.id = id;
		this.healthpoints = healthpoints;
		this.toolType = toolType;
		this.isSolid = isSolid;
		this.displayname = displayname;
		this.codename = codename;
		this.texturePath = texturePath;
		this.soundPath = soundPath;
	}
	public int getId() {
		return id;
	}
	public double getHealthpoints() {
		return healthpoints;
	}
	public ToolType getToolType() {
		return toolType;
	}
	public boolean isSolid() {
		return isSolid;
	}
	public String getDisplayname() {
		return displayname;
	}
	public String getCodename() {
		return codename;
	}
	public String getTexturePath() {
		return texturePath;
	}
	public String getSoundPath() {
		return soundPath;
	}
	
	
	
}
