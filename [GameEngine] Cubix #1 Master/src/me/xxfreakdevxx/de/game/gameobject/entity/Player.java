package me.xxfreakdevxx.de.game.gameobject.entity;

import java.awt.Graphics;

import me.xxfreakdevxx.de.game.Game;
import me.xxfreakdevxx.de.game.gameobject.GameTexture;
import me.xxfreakdevxx.de.game.gameobject.Location;

public class Player extends LivingEntity {

	public Player(Location location) {
		super(EntityType.PLAYER, location, new GameTexture(game.getTextureAtlas().getImage("player"), false).setSize(Game.blocksize, Game.blocksize*2), 100d);
		setCustomname("Spieler");
	}

	@Override
	public void teleport(Location location) {
		setLocation(location);
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getGameTexture().getTexture(), getLocation().getIntX(), getLocation().getIntY(), getGameTexture().getWidth(), getGameTexture().getHeight(),null);
		drawHitbox(g);
	}

	@Override
	public void tick() {
		//Movement
		move();
	}
}
