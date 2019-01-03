package me.xxfreakdevxx.de.game.gameobject.block;

import java.awt.Graphics;
import java.awt.Rectangle;

import me.xxfreakdevxx.de.game.Game;
import me.xxfreakdevxx.de.game.gameobject.GameTexture;
import me.xxfreakdevxx.de.game.gameobject.Location;

public class DirtBlock extends Block {

	public DirtBlock(Location location) {
		super(location, new GameTexture(Game.getInstance().getTextureAtlas().getImage(BlockMaterial.DIRT_BLOCK.getDisplayname()), false));
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getGameTexture().getTexture(), getLocation().getIntX(), getLocation().getIntY(), Game.blocksize, Game.blocksize, null);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(getLocation().getIntX(), getLocation().getIntY(), Game.blocksize, Game.blocksize);
	}

}
