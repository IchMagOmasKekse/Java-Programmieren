package me.xxfreakdevxx.de.game;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

import me.xxfreakdevxx.de.game.object.Material;

public class TextureAtlas {
	
	private BufferedImage image;
	private HashMap<String, BufferedImage> textures;
	
	
	/*
	 * Diese Klasse lädt alle Texturen und hält sie Bereit
	 * 
	 */
	public TextureAtlas() {
		this.textures=new HashMap<String, BufferedImage>();
		reloadTextures();
	}
	
	//Lädt eine Bild-Datei neu aus den Resourcen
	public BufferedImage loadImage(String path) {
		try {
			image = ImageIO.read(getClass().getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}
	
	//Gibt eine Textur aus dem Texturen Speicher zurück(HashMap: textures),
	//wenn diese Textur existieren sollte
	public BufferedImage getImage(String path) {
		if(textures.containsKey(path)) return textures.get(path);
		else return null;
	}
	
	//Lädt alle Texturen neu aus den Resourcen
	public void reloadTextures() {
		/* Lädt alle Texturen neu und fügt sie zum Atlas(textures(hashmap)) hinzu */
		textures.clear();
		for(int i = 0; i < Material.values().length; i++) {
			Material material = Material.values()[i];
			textures.put(material.getName(), loadImage("/"+material.getName()+".png"));
		}
		textures.put("monster", loadImage("/monster.png"));
	}
	
	//Gibt alle Texturen zurück
	public HashMap<String, BufferedImage> getTextures() {
		return textures;
	}
	
}
