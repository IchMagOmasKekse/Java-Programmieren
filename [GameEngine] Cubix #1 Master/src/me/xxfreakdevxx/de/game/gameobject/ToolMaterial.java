package me.xxfreakdevxx.de.game.gameobject;

public enum ToolMaterial {
	
	/* Diese Klasse bestimmt das Material eines Werkzeuges */
	
	HAND(1D, "Hand", "toolmaterial_hand"),
	WOOD(15.5D, "Holz", "toolmaterial_wood"),
	STONE(23.25D, "Stein", "toolmaterial_stone"),
	IRON(57D, "Eisen", "toolmaterial_iron");
	
	double blockDestroyPower = 0D;
	String displayname = "";
	String codename = "";
	private ToolMaterial(double blockDestroyPower, String displayname, String codename) {
		this.blockDestroyPower = blockDestroyPower;
		this.displayname = displayname;
		this.codename = codename;
	}
	public double getBlockDestroyPower() {
		return blockDestroyPower;
	}
	public String getDisplayname() {
		return displayname;
	}
	public String getCodename() {
		return codename;
	}
	
}
