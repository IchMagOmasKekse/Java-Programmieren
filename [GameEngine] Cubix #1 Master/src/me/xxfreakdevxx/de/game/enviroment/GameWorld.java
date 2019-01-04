package me.xxfreakdevxx.de.game.enviroment;

import java.awt.Graphics;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

import me.xxfreakdevxx.de.game.Camera;
import me.xxfreakdevxx.de.game.Console;
import me.xxfreakdevxx.de.game.Game;
import me.xxfreakdevxx.de.game.gameobject.GameObject;
import me.xxfreakdevxx.de.game.gameobject.Location;
import me.xxfreakdevxx.de.game.gameobject.block.Block;
import me.xxfreakdevxx.de.game.gameobject.block.DirtBlock;
import me.xxfreakdevxx.de.game.gameobject.block.GrassBlock;
import me.xxfreakdevxx.de.game.gameobject.block.StoneBlock;
import me.xxfreakdevxx.de.game.gameobject.entity.Entity;
import me.xxfreakdevxx.de.game.gameobject.entity.Player;
import me.xxfreakdevxx.de.game.view.HUD;

public class GameWorld {
	
	/* Das ist die Welt-Klasse
	 * Hier werden alle Objekte registriert und gerendert, getickt usw. */
	
	private ConcurrentLinkedQueue<GameObject> allObjects = new ConcurrentLinkedQueue<GameObject>();
	private ConcurrentHashMap<String, Block> blocks = new ConcurrentHashMap<String, Block>();
	private ConcurrentLinkedQueue<Entity> entities = new ConcurrentLinkedQueue<Entity>();
	
	private int worldWidth = 100;
	private int worldHeight = 40;
	
	public Camera camera;
	
	public Player player; //Instanz des Hauptspielers
	
	public GameWorld() {
		camera = new Camera(0,0);
		if(generateWorld()) {
			player = new Player(new Location(49*Game.blocksize, 20*Game.blocksize));
			registerObject(player);
		}
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
		return true;
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
	
	/* Rechnet aus, ob eine Location sich innerhalb des Spiel-Fensters befindet
	 * und gibt das Ergebnis zurück */
	public boolean checkIfInWindow(Location loc) {
		int windowWidth = 0;
		int windowHeight = 0;
		return false;
	}
	public void render(Graphics g) {
		for(GameObject s : allObjects) {
			s.render(g);
		}
		HUD.drawWindowMiddle(g);
	}
	public void tick() {
		for(GameObject s : allObjects) {
			s.tick();
		}
		if(player != null) camera.tick(player.getLocation());
	}
	/* Registriert ein GameObject */
	public boolean registerObject(GameObject object) {
		if(allObjects.contains(object)) return false;
		else{
			allObjects.add(object);
			if(object instanceof Block) blocks.put(object.getLocation().getGameLocationString(), ((Block)object));
			if(object instanceof Entity) entities.add(((Entity)object));
		}
		return true;
	}
	/* De-Registriert ein GameObject */
	public boolean unregisterObject(GameObject object) {
		if(allObjects.contains(object)){
			allObjects.remove(object);
			if(object instanceof Block) blocks.remove(object.getLocation().getGameLocationString());
			if(object instanceof Entity) entities.remove((Entity)object);
		}else return false;
		return true;
	}

	public ConcurrentHashMap<String, Block> getBlocks() {
		return blocks;
	}
	public Player getPlayer() {
		return player;
	}
	
}
