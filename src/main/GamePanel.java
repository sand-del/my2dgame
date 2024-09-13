package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// SCREEN SETTINGS
	final int originalTileSize = 16; // 16x16 tile
	final int scale = 3;
	
	final int tileSize = originalTileSize * scale; // 48x48 tile
	final int maxScreenCol = 16;
	final int maxScreenRow = 12;
	final int screenWidth = tileSize * maxScreenCol; // 768 pixels
	final int screenHeight = tileSize * maxScreenRow; // 576 pixels
	
	KeyHandler keyHandler = new KeyHandler();
	
	Thread gameThread;
	
	// Set player's default position
	int playerX =  100;
	int playerY = 100;
	int playerSpeed = 4;
	
	public GamePanel() {
		
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black); //maybe not necessary
		this.setDoubleBuffered(true); //for better rendering performance
		this.addKeyListener(keyHandler);
		this.setFocusable(true);
	}

	public void startGameThread() {
		
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	@Override
	public void run() {
		
		while(gameThread != null) {
//			System.out.println("the game loop is running");
			
			long currentTime = System.nanoTime();
			
			// 1 UPDTATE : update information such as character position
			update();
			
			// 2 DRAW : draw the screen with the updated information
			repaint();
			
		}
		
	}
	
	public void update(){

		if(keyHandler.upPressed == true) {
			playerY -= playerSpeed;
		} 
		else if(keyHandler.downPressed == true) {
			playerY += playerSpeed;
		} 
		else if(keyHandler.rightPressed == true) {
			playerX += playerSpeed;
		}
		else if(keyHandler.leftPressed == true) {
			playerX -= playerSpeed;
		}
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		g2.setColor(Color.white);
		
		g2.fillRect(playerX, playerY, tileSize, tileSize); //x, y, width, height
		
		g2.dispose();
		
	}
	

}
