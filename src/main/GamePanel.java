package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import javax.swing.JPanel;

import Entity.Player;
import object.SuperObject;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable {

	//Screen Settings
	 
	final int intOriginalTileSize = 16; // 16 x 16 tile
	final int intScale = 3; // To scale ^^
	public final int intTileSize = intOriginalTileSize * intScale; // = 48
	
	public final int intMaxScreenCol = 25;
	public final int intMaxScreenRow = 18;
	
	public final int intScreenWidth = intTileSize * intMaxScreenCol; // 1200
	public final int intScreenHeight = intTileSize * intMaxScreenRow; // 864
	
	//World Settings
	
	public final int maxWorldCol = 215;
	public final int maxWorldRow = 95;
	public final int worldWidth = intTileSize * maxWorldCol;
	public final int worldHeight = intTileSize * maxWorldRow;
	
	// FPS
	int intFPS = 60;
	
	TileManager tileM = new TileManager(this);
	
	KeyHandler keyH = new KeyHandler();
	Thread gameThread;
	public CollisionChecker cChecker = new CollisionChecker(this);
	public AssetSetter aSetter = new AssetSetter(this);
	public UI ui = new UI(this);
	public Player player = new Player(this,keyH);
	public SuperObject obj[] = new SuperObject[10]; 
	
	public GamePanel() {
		
		this.setPreferredSize(new Dimension(intScreenWidth, intScreenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}
	
	public void setUpGame() {
		aSetter.setObject();
	}
	
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {
		
		double dblDrawInterval = 1000000000/intFPS;
		
		double dblNextDrawTime = System.nanoTime() + dblDrawInterval;
		
		while (gameThread != null) {
		
			//1 Update Information such as character position
			update();
			
			//2 Draw the screen with the updated information
			repaint();
			
			try {
				double dblRemainingTime = dblNextDrawTime - System.nanoTime();
				
				dblRemainingTime = dblRemainingTime / 1000000;
				
				if (dblRemainingTime < 0) {
				dblRemainingTime = 0;	
				}
				
				Thread.sleep((long)dblRemainingTime);
				
				dblNextDrawTime += dblDrawInterval;
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
		}	
	}
	public void update() {
	
		player.update();
	}	
		
	
	
	public void paintComponent(Graphics g) {
	
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		//tile
		tileM.draw(g2);
		
		//objects
		for (int i = 0; i < obj.length; i++) {
			if (obj[i] != null) {
				obj[i].draw(g2, this);
			}
		}
		
		//player
		player.draw(g2);
		//UI
		ui.draw(g2);
		
		g2.dispose();
		
		
	}
	
	
	

}
