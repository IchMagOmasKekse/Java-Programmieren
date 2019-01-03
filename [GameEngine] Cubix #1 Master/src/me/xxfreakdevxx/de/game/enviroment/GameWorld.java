package me.xxfreakdevxx.de.game.enviroment;

import java.awt.Graphics;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

import me.xxfreakdevxx.de.game.Game;
import me.xxfreakdevxx.de.game.gameobject.GameObject;
import me.xxfreakdevxx.de.game.gameobject.Location;
import me.xxfreakdevxx.de.game.gameobject.block.Block;
import me.xxfreakdevxx.de.game.gameobject.block.DirtBlock;
import me.xxfreakdevxx.de.game.gameobject.block.GrassBlock;
import me.xxfreakdevxx.de.game.gameobject.block.StoneBlock;

public class GameWorld {
	
	/* Das ist die Welt-Klasse
	 * Hier werden alle Objekte registriert und gerendert, getickt usw. */
	
	private ConcurrentLinkedQueue<GameObject> allObjects = new ConcurrentLinkedQueue<GameObject>();
	private ConcurrentHashMap<String, Block> blocks = new ConcurrentHashMap<String, Block>();
	
	private int worldWidth = 100;
	private int worldHeight = 40;
	
	public GameWorld() {
		generateWorld();
	}
	
	/* Generiert die Welt */
	public boolean generateWorld() {
		int y = 10*Game.blocksize;
		for(int h = 0; h != worldHeight; h++) {
			for(int i = 0; i != worldWidth; i++) {
				Location loc = new Location(i*Game.blocksize, y);
				if(y == 10*Game.blocksize) {
					registerObject(new GrassBlock(loc));					
				}else if(y == 11*Game.blocksize) {
					registerObject(new DirtBlock(loc));
				}else registerObject(new StoneBlock(loc));
			}
			y+=Game.blocksize;
		}
		return false;
	}
	public boolean saveWorld(String worldname) {
		//TODO:
		return false;
	}
	public boolean loadWorld(String worldname) {
		//TODO:
		return false;
	}
	public boolean deleteWorld(String worldname) {
		//TODO:
		return false;
	}
	public void render(Graphics g) {
		for(GameObject s : allObjects) {
			s.render(g);
		}
	}
	public void tick() {
		for(GameObject s : allObjects) {
			s.tick();
		}
	}
	/* Registriert ein GameObject */
	public boolean registerObject(GameObject object) {
		if(allObjects.contains(object)) return false;
		else{
			allObjects.add(object);
			if(object instanceof Block) blocks.put(object.getLocation().getGameLocationString(), ((Block)object));
		}
		return true;
	}
	/* De-Registriert ein GameObject */
	public boolean unregisterObject(GameObject object) {
		if(allObjects.contains(object)){
			allObjects.remove(object);
			if(object instanceof Block) blocks.remove(object.getLocation().getGameLocationString());
		}else return false;
		return true;
	}

	public ConcurrentHashMap<String, Block> getBlocks() {
		return blocks;
	}
	
}
