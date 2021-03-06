package me.xxfreakdevxx.de.game;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import me.xxfreakdevxx.de.game.enviroment.GameWorld;
import me.xxfreakdevxx.de.game.gameobject.Location;
import me.xxfreakdevxx.de.game.view.HUD;

@SuppressWarnings({"serial", "unused"})
public class Game extends Canvas implements Runnable {
	
	/* Window */
	public static int windowWidth = 1200;
	public static int windowHeight = 900;
	
	/* System */
	private static Game instance;
	public static Game getInstance() {return instance;}
	private Thread thread;
	private boolean isRunning = false;
	public static boolean DEBUG = false;
	
	
	/* Game */
	public static int FPS = 0;
	private BufferedImage level = null;
	private TextureAtlas textureAtlas;
	public static int blocksize = 24;
	private GameWorld world = null;
	private GameRaster gameRaster = null;
	
	
	public static void main(String[] args) {
		new Game();
	}
	
	public Game() {
		preInit();
		init();
		postInit();
	}
	
	public void preInit() {
		instance = this;
		setBackground(Color.BLACK);
		new Window(windowWidth, windowHeight, "GameEngine Preset", this);
		start();
	}
	public void init() {
		textureAtlas = new TextureAtlas();
		gameRaster = new GameRaster();
		world = new GameWorld();
		world.generateWorld();
		this.addKeyListener(new KeyInput());
		this.addMouseListener(new MouseInput());
	}
	public void postInit() {
		level = textureAtlas.loadImage("/wizard_level.png");
		loadLevel(level);
	}
	
	private void start() {
		isRunning = true;
		thread = new Thread(this);
		thread.start();
	}
	private void stop() {
		isRunning = false;
		try {
			thread.join();
		} catch (InterruptedException e) {e.printStackTrace();}
	}
	
	/*
	 * Gameloop: Sorgt dafür, dass ein Kreislauf entsteht, mit dem man das Spiel zeichnen und updaten kann
	 * */
	@Override
	public void run() {
		/*
		 * GameLoop - Made by Notch (Markus Persson)
		 */
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(isRunning) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				//update++;
				delta--;
			}
			//Zeitpunkt zum ansteuern anderer Methoden
			render();
			frames++;
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				Game.FPS = frames;
				frames = 0;
			}
		}
		stop();
	}
	
	/* Steuert anderen Klassen an, in denen etwas getickt werden soll */
	public void tick() {
		if(world != null) world.tick();
	}
	/* Gibt die aktuelle FPS anzahl zurück */
	public int getFPS() {
		return FPS;
	}
	
	/*
	 * Steuert alle Klassen an, in denen was gerendert werden soll
	 * */
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, windowWidth, windowHeight);
		//Verschiebung durch Kamera Coords.
		//Dies ermöglich Kamerabewegung
		if(getWorld() != null) {
			g2d.translate(-getWorld().camera.getX(), -getWorld().camera.getY());
			
			//Klassen werden angesteuert
			getWorld().render(g);
			g2d.translate(getWorld().camera.getX(), getWorld().camera.getY());
			HUD.drawDebugInfos(g);
		}
		
		g.dispose();
		bs.show();
	}
	
	/* Test Welt wird geladen */
	private void loadLevel(BufferedImage image) {
		int w = image.getWidth();
		int h = image.getHeight();
		for(int xx = 0; xx < w; xx++) {
			for(int yy = 0; yy < h; yy++) {
				int pixel = image.getRGB(xx, yy);
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel) & 0xff;
				
//				if(red == 255) handler.addObject(new StoneWallBlock(ID.BLOCK, new Location(xx*blocksize, yy*blocksize), 32, 32));
//				if(green == 255) handler.addObject(new Monster(ID.ENEMY, new Location(xx*blocksize, yy*blocksize), 32, 32, 15.0D));
//				if(blue == 255) handler.addObject(new Player(ID.PLAYER, new Location(xx*blocksize, yy*blocksize), 100.0D));
			}
		}
	}
	
	public TextureAtlas getTextureAtlas() {
		return textureAtlas;
	}
	
	public Camera getCamera() {
		return getWorld().camera;
	}

	public GameWorld getWorld() {
		return world;
	}

	public GameRaster getGameRaster() {
		return gameRaster;
	}
	public static int calculateStringWidth(Font font, String enteredText) {
		BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
		FontMetrics fm = img.getGraphics().getFontMetrics(font);
		int width = fm.stringWidth(enteredText);
		return width;
	}
	/* Rechnet aus, ob eine Location sich innerhalb des Spiel-Fensters befindet
	 * und gibt das Ergebnis zurück */
	public static boolean checkIfInWindow(Location loc) {
		Camera cam = Game.getInstance().getCamera();
		int windowWidth = (int)((int)Game.windowWidth-cam.getX());
		int windowHeight = (int)((int)Game.windowHeight-cam.getY());
		int x = (int)((int)loc.getIntX()-cam.getX());
		int y = (int)((int)loc.getIntY()-cam.getY());
		
		Rectangle screen = new Rectangle((int)cam.getX(),
				(int)cam.getY(),
				windowWidth+(int)cam.getX(),
				windowHeight+(int)cam.getY());
		Rectangle locRect = new Rectangle(x,y,1,1);
		return screen.intersects(locRect);
	}
	public static boolean checkIfInWindow(Rectangle rect) {
		Camera cam = Game.getInstance().getCamera();
		int windowWidth = (int)((int)Game.windowWidth-cam.getX());
		int windowHeight = (int)((int)Game.windowHeight-cam.getY());
		
		Rectangle screen = new Rectangle((int)cam.getX(),
				(int)cam.getY(),
				windowWidth+(int)cam.getX(),
				windowHeight+(int)cam.getY());
		return screen.intersects(rect);
	}
	
}
