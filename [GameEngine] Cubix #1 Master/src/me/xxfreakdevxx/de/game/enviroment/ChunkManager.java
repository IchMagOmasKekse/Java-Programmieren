package me.xxfreakdevxx.de.game.enviroment;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.concurrent.ConcurrentHashMap;

import me.xxfreakdevxx.de.game.Game;
import me.xxfreakdevxx.de.game.gameobject.Location;

public class ChunkManager {
/*
 * Diese Klasse handled alle Chunks.
 * */
	private ConcurrentHashMap<Integer, WorldChunk> chunks = new ConcurrentHashMap<Integer, WorldChunk>();
	/* ChunkSize Default: 10
	 * Wenn sie umgestellt wird, dann muss die WeltGröße angepasst werden, damit keine Welt Genrierungs Fehler auftreten */
	private int chunkSize = 10; //Jeder Chunk ist so groß. Also ChunkFläche = chunkSize * chunkSize
	public int renderedChunks = 0;
	public ChunkManager() {
		
	}

	public WorldChunk getChunk(Rectangle rect) {
		double x = rect.getX()/Game.blocksize*Game.blocksize;
		double y = rect.getY()/Game.blocksize*Game.blocksize;
		int col = (int)(x/chunkSize);
		int row = (int)(y/chunkSize)*(getChunksPerRow());
		int chunkId = (row+col);
		return chunks.get(chunkId);
	}
	public WorldChunk getChunk(int chunkId) {
		return chunks.get(chunkId);
	}
	public WorldChunk getChunk(Location loc) {
		int chunkSize = getChunkSize();
		int cProw = getChunksPerRow();
		int locX = loc.getIntX()/Game.blocksize;
		int locY = loc.getIntY()/Game.blocksize;
		
		int chunkX = (int)((locX/chunkSize));
		int chunkY = (int)((locY/chunkSize));
		
		int chunkId = (chunkY*cProw)+chunkX;

		return getChunk(chunkId);
	}
	int c = 0;
	public boolean createNewChunk(int chunkId) {
		if(chunks.containsKey(chunkId)) return false;
		chunks.put(chunkId, new WorldChunk(chunkId));
		if(c == 0) {
			chunks.get(chunkId).color = new Color(0.0f,0.0f,0.0f,0.2f);
			c=1;
		}else if(c == 1) {			
			chunks.get(chunkId).color = new Color(1.0f,1.0f,1.0f,0.2f);
			c=0;
		}
		return true;
	}
	public int getChunkSize() {
		return chunkSize;
	}
	public int getChunksPerRow() {
		return (Game.getInstance().getWorld().getWorldWidth()/chunkSize);
	}
	public int getChunksPerColumn() {
		return (Game.getInstance().getWorld().getWorldHeight()/chunkSize);
	}
	public void render(Graphics g) {
		if(Game.getInstance().getWorld().isGenerated) {
			
			for(int i : chunks.keySet()) {
				WorldChunk chunk = chunks.get(i);
				int x = chunk.getX();
				int y = chunk.getY();
				int dx = chunk.getDX();
				int dy = chunk.getDY();
				if(Game.checkIfInWindow(new Rectangle(x,y,dx,dy))) {
					chunk.render(g);
					renderedChunks++;
				}
			}
		}
	}
	public void tick() {
		if(Game.getInstance().getWorld().isGenerated) {
			for(int i : chunks.keySet()) {
				WorldChunk chunk = chunks.get(i);
				int x = chunk.getX();
				int y = chunk.getY();
				int dx = chunk.getDX();
				int dy = chunk.getDY();
				if(Game.checkIfInWindow(new Rectangle(x,y,dx,dy))) chunk.tick();
			}
		}
	}
	public int getChunkAmount() {
		return chunks.size();
	}

}
