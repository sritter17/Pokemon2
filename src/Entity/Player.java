package Entity;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanel;
import main.KeyHandler;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

import BattlePokemon.MasterBattlePokemon;

public class Player extends Entity{

	GamePanel gp;
	KeyHandler keyH;
	
	public final int screenX;
	public final int screenY;
	public int hasPokeBall = 0;
	public int numOfPokemon = 0;
	public String[] playerPokemon = {"x","x","x","x","x","x"};
	public String[] opponentPokemon = {"x","x","x","x","x","x"};
	public int numOpponentPokemon = 0;
	public boolean controlSwitch = false;
	
	public Player(GamePanel gp, KeyHandler keyH) {
	
		this.gp = gp;	
		this.keyH = keyH;
		
		screenX = gp.intScreenWidth/2 - (gp.intTileSize/2);
		screenY = gp.intScreenHeight/2 - (gp.intTileSize/2);
		
		solidArea = new Rectangle();
		
		solidArea.x = 25;
		solidArea.y = 25;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.width = 15;
		solidArea.height = 16;
		
		setDefaultValues();
		getPlayerImage();
	}
		public void setDefaultValues() {
		
		worldX = gp.intTileSize * 19;
		worldY = gp.intTileSize * 88;
		intSpeed = 5;
		direction = "down";
	}
		
		public void getPlayerImage() {
			
			try {
				
				up1 = ImageIO.read(getClass().getResourceAsStream("/player/up1.png"));
				up2 = ImageIO.read(getClass().getResourceAsStream("/player/up2.png"));
				down1 = ImageIO.read(getClass().getResourceAsStream("/player/down1.png"));
				down2 = ImageIO.read(getClass().getResourceAsStream("/player/down2.png"));
				left1 = ImageIO.read(getClass().getResourceAsStream("/player/left1.png"));
				left2 = ImageIO.read(getClass().getResourceAsStream("/player/left2.png"));
				right1 = ImageIO.read(getClass().getResourceAsStream("/player/right1.png"));
				right2 = ImageIO.read(getClass().getResourceAsStream("/player/right2.png"));
				
			}catch(IOException e) {
			e.printStackTrace();
			}
		}
		
		public void update() {
			
			if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true || keyH.menuSelectPressed == true) {
		
			if (keyH.upPressed == true) {
				direction = "up";			
			}
			else if(keyH.downPressed == true)
			{
				direction = "down";				
			}
			else if(keyH.leftPressed == true)
			{
				direction = "left";				
			}
			else if(keyH.rightPressed == true)
			{
				direction = "right";
			}
			else if(keyH.menuSelectPressed == true) {
				direction = "select";
			}
			
					//CHECK TILE COLLISION
			collisionOn = false;
			gp.cChecker.checkerTile(this);
			
			//CHECK OBJ COLLISION
			int objIndex = gp.cChecker.checkObject(this, true);
			pickUpObject(objIndex);
			//IF COLLISION IS FALSE, PLAYER CAN MOVE
			
			if(collisionOn == false && controlSwitch == false) {
				
				switch(direction) {
				case "up":
					worldY -= intSpeed;
					break;
					
				case "down":
					worldY += intSpeed;
					break;
					
				case "left":
					worldX -= intSpeed;
					break;
					
				case "right":
					worldX += intSpeed;
					break;
					
				}
				
			}
				
			
			spriteCounter++;
			if (spriteCounter > 10) {
				if (spriteNum == 1) {
					spriteNum = 2;
				}
				else if(spriteNum == 2) {
					spriteNum = 1;
				}
				spriteCounter = 0;
			}
		  }
		}
		
		public void pickUpObject(int i) {
			
			if (i != 999) {
				
				String objectName = gp.obj[i].name;
				
				switch(objectName) {
				case "5x Pokeball":
					gp.obj[i] = null;
					hasPokeBall += 5;
					gp.ui.showMessage("You picked up 5 PokeBalls!");
					break;
					
				case "First Battle":
					numOpponentPokemon = 1;
					opponentPokemon[0] = "starly";
					controlSwitch = true;
					gp.ui.showBattle = true;
					break;
					
				case "Starter Pokemon":
					gp.obj[i] = null;
					playerPokemon[numOfPokemon] = "charmander";
					MasterBattlePokemon masterCharmanderBattlePokemon = new MasterBattlePokemon(this);
					masterCharmanderBattlePokemon.order = gp.player.numOfPokemon;
					gp.player.numOfPokemon += 1;
					gp.ui.showMessage("You obtained Charmander!");
					break;
					
				case "Piplup":
					gp.obj[i] = null;
					playerPokemon[numOfPokemon] = "piplup";
					MasterBattlePokemon masterPiplupBattlePokemon = new MasterBattlePokemon(this);
					masterPiplupBattlePokemon.order = gp.player.numOfPokemon;
					System.out.println(masterPiplupBattlePokemon.order);
					gp.player.numOfPokemon += 1;
					gp.ui.showMessage("You obtained Piplup!");
					break;
					
				case "Snivy":
					gp.obj[i] = null;
					playerPokemon[numOfPokemon] = "snivy";
					MasterBattlePokemon masterSnivyBattlePokemon = new MasterBattlePokemon(this);
					masterSnivyBattlePokemon.order = gp.player.numOfPokemon;
					gp.player.numOfPokemon += 1;
					gp.ui.showMessage("You obtained Snivy!");
					break;
					
				}
			}
		}
		
		public void draw(Graphics2D g2) {
			
			if (controlSwitch == false) {
			//MAP MOVEMENT
			BufferedImage image = null;
			
			switch(direction) {
			case "up":
			if (spriteNum == 1) {
				image = up1;
			}
				if (spriteNum == 2) {
					image = up2;
				}
			break;
			
			case "down":
			if (spriteNum == 1) {
				image = down1;
			}
				if (spriteNum == 2) {
					image = down2;
				}
			break;
			
			case "left":
			if (spriteNum == 1) {
				image = left1;
			}
				if (spriteNum == 2) {
				image = left2;
				}
			break;
			
			case "right":
			if (spriteNum == 1) {
				image = right1;
			}
				if (spriteNum == 2) {
					image = right2;
				}
			break;
			}
			g2.drawImage(image, screenX, screenY, gp.intTileSize, gp.intTileSize, null);
			}		
				
		
			
		}
		}

