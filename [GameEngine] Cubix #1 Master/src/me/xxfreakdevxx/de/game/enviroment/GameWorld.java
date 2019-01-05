package me.xxfreakdevxx.de.game.enviroment;

import java.awt.Graphics;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

import me.xxfreakdevxx.de.game.Camera;
import me.xxfreakdevxx.de.game.Console;
import me.xxfreakdevxx.de.game.Game;
import me.xxfreakdevxx.de.game.gameobject.GameObject;
import me.xxfreakdevxx.de.game.gameobject.Location;
import me.xxfreakdevxx.de.game.gameobject.block.AirBlock;
import me.xxfreakdevxx.de.game.gameobject.block.Block;
import me.xxfreakdevxx.de.game.gameobject.block.DirtBlock;
import me.xxfreakdevxx.de.game.gameobject.block.GrassBlock;
import me.xxfreakdevxx.de.game.gameobject.block.StoneBlock;
import me.xxfreakdevxx.de.game.gameobject.entity.Entity;
import me.xxfreakdevxx.de.game.gameobject.entity.LivingEntity;
import me.xxfreakdevxx.de.game.gameobject.entity.Player;
import me.xxfreakdevxx.de.game.view.HUD;

public class GameWorld {
	
	/* Das ist die Welt-Klasse
	 * Hier werden alle Objekte registriert und gerendert, getickt usw. */
	
	private ChunkManager chunkManager = Game.getInstance().getGameRaster().getChunkManager();
	private ConcurrentLinkedQueue<GameObject> allObjects = new ConcurrentLinkedQueue<GameObject>();
	private ConcurrentHashMap<String, Block> blocks = new ConcurrentHashMap<String, Block>();
	private ConcurrentLinkedQueue<Entity> entities = new ConcurrentLinkedQueue<Entity>();
	
	private int worldWidth = 50;
	private int worldHeight = 50;
	
	public Camera camera;
	public boolean isGenerated = false;
	
	public Player player; //Instanz des Hauptspielers
	
	public GameWorld() {
		camera = new Camera(0,0);
	}
	
	/* Generiert die Welt */
	public boolean generateWorld() {
		createChunks();
		int chunkId = 0;
		int y = 0;
		Block block = null;
		for(int h = 0; h != worldHeight; h++) {
			for(int i = 0; i != worldWidth; i++) {
				Location loc = new Location(i*Game.blocksize, y);
			
				if(y < 10*Game.blocksize) {
					block = new AirBlock(loc);
					registerObject(block);			
				}else if(y == 10*Game.blocksize) {
					block = new GrassBlock(loc);
					registerObject(block);			
				}else if(y <= 11*Game.blocksize) {
					block = new DirtBlock(loc);
					registerObject(block);
				}else{
					block = new StoneBlock(loc);
					registerObject(block);
				}
				//Berechnung, ob es noch der selbe Chunk ist, oder nicht
				int calcChunk = calculateChunk(loc);
				if(calcChunk != chunkId) chunkId = calcChunk;
				if(chunkManager.getChunk(chunkId) == null){
					chunkManager.createNewChunk(chunkId);
					Console.send("World", "Chunk#"+chunkId+" wurde EXTRA erstellt");
				}else chunkManager.getChunk(chunkId).addBlock(block);
			}
			y+=Game.blocksize;
		}
		Console.send("GameWorld", "Welt wurde generiert");
		
		Console.send("GameWorld", "Chunk Amount: "+chunkManager.getChunkAmount()+" Blocks: "+blocks.size());
		player = new Player(new Location(2*Game.blocksize, 2*Game.blocksize));
		registerObject(player);
		isGenerated = true;
		return true;
	}
	
	
	//Berechnet, in welchen Chunk die Location liegt
	public int calculateChunk(Location loc) {
		int chunkSize = chunkManager.getChunkSize();
		int cProw = chunkManager.getChunksPerRow();
		int locX = loc.getIntX()/Game.blocksize;
		int locY = loc.getIntY()/Game.blocksize;
		
		int chunkX = (int)((locX/chunkSize));
		int chunkY = (int)((locY/chunkSize));
		
		int chunkId = (chunkY*cProw)+chunkX;

		return chunkId;
	}
	int chunksCreated = 0;
	public void createChunks() {
		chunksCreated=0;
		int xA = chunkManager.getChunksPerRow(); //Anzahl an Chunks, die auf eine X Linie passen
		int yA = chunkManager.getChunksPerColumn(); //Anzahl an Chunks, die auf eine Y Linie passen
		for(int y = 0; y != yA-1; y++) {
			for(int x = 0; x != xA+1; x++) {
				chunkManager.createNewChunk(chunksCreated);
				chunksCreated++;
			}			
		}			
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
		Game.getInstance().getGameRaster().getChunkManager().render(g);
//		for(GameObject s : allObjects) {
//			s.render(g);
//		}
		for(Entity ent : entities) ent.render(g);
		HUD.drawWindowMiddle(g);
	}
	public void tick() {
		Game.getInstance().getGameRaster().getChunkManager().tick();
//		for(GameObject s : allObjects) {
//			s.tick();
//			if(s instanceof Block) ((Block)s).storeCurrentTime();
//		}
		for(Entity ent : entities){
			ent.tick();
			ent.addGravity();
			if(ent instanceof LivingEntity) ((LivingEntity)ent).move();
		}
		if(player != null) camera.tick(player);
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
	public int getWorldWidth() {
		return worldWidth;
	}
	public int getWorldHeight() {
		return worldHeight;
	}
	//Gibt den Blöck zurück, der an Location XY ist
	public Block getBlockAt(double x, double y) {
		Location loc = new Location(x,y);
		return blocks.get(loc.getGameLocationString());
	}
	//Gibt den Blöck zurück, der an Location XY ist
	public Block getBlockAt(Location loc) {
		return getBlockAt(loc.getX(), loc.getY());
	}
	
}
