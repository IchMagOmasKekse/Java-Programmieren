package me.xxfreakdevxx.de.game.gameobject.block;

import java.awt.Graphics;

import me.xxfreakdevxx.de.game.Game;
import me.xxfreakdevxx.de.game.gameobject.GameTexture;
import me.xxfreakdevxx.de.game.gameobject.Location;

public class AirBlock extends Block {

	public AirBlock(Location location) {
		super(location, new GameTexture(Game.getInstance().getTextureAtlas().getImage(BlockMaterial.AIR.getDisplayname()), false).setSize(Game.blocksize, Game.blocksize));
		
	}

	@Override
	public void render(Graphics g) {
		drawHitbox(g);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processBlockProperty() {
		// TODO Auto-generated method stub
		
	}

}
