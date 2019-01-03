package me.xxfreakdevxx.de.game.gameobject;

public enum ToolType {
	
	/* Diese Klasse bestimmt die Art des Werkzeuges */
	
	MULTI_TOOL("Multi-Tool", "tooltype_multitool"),
	SWORD("Schwert", "tooltype_sword"),
	PICKAXE("Spitzhacke", "tooltype_spitzhacke"),
	AXE("Axt", "tooltype_axt"),
	SHOVEL("Schaufel", "tooltype_schaufel");
	
	String displayname = "";
	String codename = "";
	private ToolType(String displayname, String codename) {
		this.displayname = displayname;
		this.codename = codename;
	}
	public String getDisplayname() {
		return displayname;
	}
	public String getCodename() {
		return codename;
	}
	
	
	
}
