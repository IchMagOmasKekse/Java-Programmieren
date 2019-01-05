package me.xxfreakdevxx.de.game.enviroment;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

import me.xxfreakdevxx.de.game.Console;
import me.xxfreakdevxx.de.game.Game;
import me.xxfreakdevxx.de.game.gameobject.Location;
import me.xxfreakdevxx.de.game.gameobject.block.Block;

public class WorldChunk {
	
	/*
	 * 
	 * Ein WorldChunk ist ein Teil der WorldUnterteilung.
	 * Die Welt wird in ein Raster eingeteilt. Jedes Quadrat hat die selbe Größe.
	 * Beispiel: jeder Chunk beinhaltet 16x16 Blöcke
	 * 
	 * Das dient der besseren Performance.
	 * Es sollen beispielsweise nur die Blöcke abgefragt werden, die sich %im Chunk des Spieler oder in den angrenzenden Chunks befinden
	 * 
	 */
	
	private ChunkManager chunkManager = Game.getInstance().getGameRaster().getChunkManager();
	private ConcurrentHashMap<String, Block> blocks = new ConcurrentHashMap<String, Block>();
	private ArrayList<Location> blockLocations = new ArrayList<Location>();
	private int chunkId = 0;
	private int x = 0;
	private int y = 0;
	private int dx = 0;
	private int dy = 0;
	public Color color = Color.cyan;
	
	public WorldChunk(int chunkId) {
		/* Rechnet die InGame Position aus, wo sich der Chunk befindet */
		this.chunkId = chunkId;
		int cProw = chunkManager.getChunksPerRow();
		int chunkSize = chunkManager.getChunkSize();
		int chunkY = (int)chunkId/cProw;
		int chunkX = chunkId - chunkY;
		chunkX -= ((cProw-1)*chunkY);
		this.x = chunkX*chunkSize*Game.blocksize;
		this.y = chunkY*chunkSize*Game.blocksize;
		dx = (chunkSize*Game.blocksize);
		dy = (chunkSize*Game.blocksize);
//		Console.send("WChunk", "Calced X/Y: "+x+"/"+y);
	}
	
	public void calculateBlockLocations() {
		int chunkSize = chunkManager.getChunkSize();
		for(int y = 0; y != chunkSize; y++) {
			for(int x = 0; x != chunkSize; x++) {
				blockLocations.add(new Location(this.x + (x*Game.blocksize), this.y + (y*Game.blocksize)));
			}
		}
	}
	
	public void render(Graphics g) {
		for(String s : getBlocks().keySet()) {
			blocks.get(s).render(g);
		}
		g.setColor(color);
		g.fillRect(x, y, dx, dy);
	}
	public void tick() {
		for(String s : getBlocks().keySet()) {
			blocks.get(s).tick();
		}
	}
	
	public ConcurrentHashMap<String, Block> getBlocks() {
		return this.blocks;
	}
	//Registriert block und fügt block in die HashMap hinzu
	public boolean addBlock(Block block) {
		if(block == null) Console.sendIfDebug("WorldChunk", "Block == null");
		if(block.getUnClonedLocation() == null) Console.sendIfDebug("WorldChunk", "Loc == null");
		if(blocks.containsKey(block.getLocation().getGameLocationString())) return false;
		else{
			Game.getInstance().getWorld().registerObject(block);
			blocks.put(block.getLocation().getGameLocationString(), block);
		}
		return true;
	}
	//DE-Registriert block und nimmt block aus der HashMap raus
	public boolean removeBlock(Block block) {
		if(blocks.containsKey(block.getLocation().getGameLocationString())){
			Game.getInstance().getWorld().unregisterObject(blocks.get(block.getLocation().getGameLocationString()));
			blocks.remove(block.getLocation().getGameLocationString(), block);
		}
		else return false;
		return true;
	}
	//DE-Registriert block und nimmt block aus der HashMap raus
	public boolean removeBlock(Location loc) {
		if(blocks.containsKey(loc.getGameLocationString())){
			Game.getInstance().getWorld().unregisterObject(blocks.get(loc.getGameLocationString()));
			blocks.remove(loc.getGameLocationString());
		}
		else return false;
		return true;
	}
	//De-Registriert alle Blöcke in diesem Chunk und löscht sie aus der HashMap
	public void clearChunk() {
		ArrayList<String> strings = new ArrayList<String>();
		for(String s : blocks.keySet()) {
			Game.getInstance().getWorld().unregisterObject(blocks.get(s));
			strings.add(s);
		}
		for(String s : strings) blocks.remove(s);			
	}
	public void updateBlocks() {
		for(String s : getBlocks().keySet()) {
			blocks.get(s).tick();
		}
	}
	public int getChunkId() {
		return chunkId;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getDX() {
		return dx;
	}
	public int getDY() {
		return dy;
	}
}
