package me.xxfreakdevxx.de.game.gameobject.entity;

import me.xxfreakdevxx.de.game.Game;
import me.xxfreakdevxx.de.game.enviroment.ChunkManager;
import me.xxfreakdevxx.de.game.gameobject.GameObject;

public class Collision {
	
	static ChunkManager chunkManager = Game.getInstance().getGameRaster().getChunkManager();
	
	public static boolean isCollidingGround(GameObject object) {
		int oWidth = object.getWidth();
		int oHeight = object.getHeight();
		int teilung = oWidth / Game.blocksize;
		int counter = 0;
		while(counter < oWidth) {
			
		}
		
		return false;
	}
//	public static boolean isCollidingGround(GameObject object) {
//		Location loc = object.getLocation();
//		loc.add(object.getWidth(), object.getHeight());
//		WorldChunk chunk = chunkManager.getChunk(loc);
//		Block atFoot = chunk.getBlocks().get(loc.getGameLocationString());
//		if(atFoot == null) Console.send("Collision", "atFoot = null");
//		if(atFoot.getBlockMaterial().isSolid()){
//			Console.send("Collision", "is NOT Coliding");
//			return true;
//		}
//		else{
//			Console.send("Collision", "is Coliding");
//			return false;
//		}
//	}
	
}
