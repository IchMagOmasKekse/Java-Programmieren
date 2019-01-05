package me.xxfreakdevxx.de.game.gameobject.block;

import java.awt.Graphics;

import me.xxfreakdevxx.de.game.Game;
import me.xxfreakdevxx.de.game.gameobject.GameTexture;
import me.xxfreakdevxx.de.game.gameobject.Location;

public class GrassBlock extends Block {

	public GrassBlock(Location location) {
		super(location, new GameTexture(Game.getInstance().getTextureAtlas().getImage(BlockMaterial.GRASS_BLOCK.getDisplayname()), false).setSize(Game.blocksize, Game.blocksize));
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getGameTexture().getTexture(), getLocation().getIntX(), getLocation().getIntY(), Game.blocksize, Game.blocksize, null);
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
