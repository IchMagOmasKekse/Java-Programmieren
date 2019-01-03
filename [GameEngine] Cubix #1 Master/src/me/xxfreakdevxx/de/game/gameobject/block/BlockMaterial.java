package me.xxfreakdevxx.de.game.gameobject.block;

import me.xxfreakdevxx.de.game.gameobject.ToolType;

public enum BlockMaterial {
	
	/* Diese Klasse wird alle existierenden Materialien auflisten mit dazugehörigen Informationen */
	
	AIR(0, 0D, ToolType.MULTI_TOOL, "Luft", "block_air", "/assets/textures/blocks/air.png", "not yet"),
	STONE(1, 100D, ToolType.PICKAXE, "Stein", "block_stone", "/assets/textures/blocks/stone.png", "not yet");
	
	int id = 0;
	double healthpoints = 0D;
	ToolType toolType = ToolType.MULTI_TOOL;
	String displayname = "";
	String codename = "";
	String texturePath = "";
	String soundPath = "";
	private BlockMaterial(int id, double healthpoints, ToolType toolType, String displayname, String codename, String texturePath, String soundPath) {
		this.id = id;
		this.healthpoints = healthpoints;
		this.toolType = toolType;
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
