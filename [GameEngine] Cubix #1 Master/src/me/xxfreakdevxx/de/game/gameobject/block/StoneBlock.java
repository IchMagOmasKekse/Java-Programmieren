package me.xxfreakdevxx.de.game.gameobject.block;

import java.awt.Graphics;

import me.xxfreakdevxx.de.game.Game;
import me.xxfreakdevxx.de.game.gameobject.GameTexture;
import me.xxfreakdevxx.de.game.gameobject.Location;

public class StoneBlock extends Block {

	public StoneBlock(Location location) {
		super(location, new GameTexture(Game.getInstance().getTextureAtlas().getImage(BlockMaterial.STONE.getDisplayname()), false).setSize(Game.blocksize, Game.blocksize));
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getGameTexture().getTexture(), getLocation().getIntX(), getLocation().getIntY(), Game.blocksize, Game.blocksize, null);
		drawDirtTop(g);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		checkGrasTop();
	}

	@Override
	public void processBlockProperty() {
		// TODO Auto-generated method stub
		
	}

}
