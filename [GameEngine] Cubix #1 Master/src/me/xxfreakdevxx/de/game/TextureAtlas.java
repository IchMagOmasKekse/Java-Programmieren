package me.xxfreakdevxx.de.game;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

import me.xxfreakdevxx.de.game.gameobject.block.BlockMaterial;

public class TextureAtlas {
	
	private BufferedImage image;
	/* Der Key ist der Name des Materials, der bei Material.getDisplayName() zur�ckgegeben wird */
	private HashMap<String, BufferedImage> textures;
	
	
	/*
	 * Diese Klasse l�dt alle Texturen und h�lt sie Bereit
	 * 
	 */
	public TextureAtlas() {
		this.textures=new HashMap<String, BufferedImage>();
		reloadTextures();
	}
	
	//L�dt eine Bild-Datei neu aus den Resourcen
	public BufferedImage loadImage(String path) {
		try {
			image = ImageIO.read(getClass().getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}
	
	//Gibt eine Textur aus dem Texturen Speicher zur�ck(HashMap: textures),
	//wenn diese Textur existieren sollte
	public BufferedImage getImage(String path) {
		if(textures.containsKey(path)) return textures.get(path);
		else return null;
	}
	
	//L�dt alle Texturen neu aus den Resourcen
	public void reloadTextures() {
		/* L�dt alle Texturen neu und f�gt sie zum Atlas(textures(hashmap)) hinzu */
		textures.clear();
		for(int i = 0; i < BlockMaterial.values().length; i++) {
			BlockMaterial material = BlockMaterial.values()[i];
			textures.put(material.getDisplayname(), loadImage(material.getTexturePath()));
		}
		textures.put("monster", loadImage("/assets/textures/entity/monster.png"));
		textures.put("player", loadImage("/assets/textures/entity/player-32x64.png"));
		textures.put("dirt_top_0", loadImage("/assets/textures/blocks/dirt_top_0.png"));
	}
	
	//Gibt alle Texturen zur�ck
	public HashMap<String, BufferedImage> getTextures() {
		return textures;
	}
	
}
