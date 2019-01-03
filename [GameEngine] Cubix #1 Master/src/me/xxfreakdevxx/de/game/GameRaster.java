package me.xxfreakdevxx.de.game;

import me.xxfreakdevxx.de.game.gameobject.Location;
import me.xxfreakdevxx.de.game.gameobject.block.Block;

public class GameRaster {
	
	private Game game = Game.getInstance();
	
	public GameRaster() {}
	
	
	//Gibt den Blöck zurück, der an Location XY ist
	public Block getBlockAt(double x, double y) {
		Location loc = new Location(x,y);
		return game.getWorld().getBlocks().get(loc.getGameLocationString());
	}
	//Gibt den Blöck zurück, der an Location XY ist
	public Block getBlockAt(Location loc) {
		return getBlockAt(loc.getX(), loc.getY());
	}
	
	//Setz einen Block an Location XY
	public boolean setBlock(Block block, double x, double y) {
		Location loc = new Location(x,y);
		game.getWorld().getBlocks().remove(loc.getGameLocationString());
		return game.getWorld().registerObject(block);
	}
	//Setz einen Block an Location XY
	public boolean setBlock(Block block, Location loc) {
		return setBlock(block, loc.getX(), loc.getY());
	}
	
	/* Entfernt einen Block an Location XY
	 * Wird verwendet, um einen Block zu entfernen ohne Loot zu hinterlassen*/
	public boolean removeBlockAt(double x, double y) {
		return false;
	}
	/* Entfernt einen Block an Location XY
	 * Wird verwendet, um einen Block zu entfernen ohne Loot zu hinterlassen*/
	public boolean removeBlockAt(Location loc) {
		return removeBlockAt(loc.getX(), loc.getY());
	}
	
	/* Zerstört einen Block an Location XY
	 * - Loot dropt*/
	public boolean destroyBlockAt(double x, double y) {
		return false;
	}
	/* Zerstört einen Block an Location XY
	 * - Loot dropt*/
	public boolean destroyBlockAt(Location loc) {
		return destroyBlockAt(loc.getX(), loc.getY());
	}
	
	
	
}
