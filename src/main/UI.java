package main;

import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import BattlePokemon.OpponentPokemon;
import BattlePokemon.PlayerPokemon;
import object.EmptyPokeballs;
import object.OBJ_StarterPokemon;
import object.PokemonInventory;

public class UI {

	GamePanel gp;
	Font GameText;
	BufferedImage PokeballImage;
	BufferedImage PokeballEmpty;
	BufferedImage Pokemon;
	BufferedImage OpponentPokemon;
	public boolean messageOn = false;
	public String message = "";
	int messageTime = 0;
	public boolean showBattle = false;
	int pokemonOpponentBattleSize = 16 * 3;
	int pokemonBattleSize = 16 * 5;
	public String selectedItem;
	public String[] currentPokemonAttacks;
	
	public UI(GamePanel gp) {
		this.gp = gp;
		GameText = new Font("Press Start 2P Regular",Font.PLAIN, 20);
		PokemonInventory Pokeballs = new PokemonInventory();
		EmptyPokeballs EmptyPokeballs = new EmptyPokeballs();
		PokeballImage = Pokeballs.image;
		PokeballEmpty = EmptyPokeballs.image;
		
	}
	
	
	public void showMessage(String text) {
		
		message = text;
		messageOn = true;
		
	}
	
	public void draw(Graphics2D g2) {
		
		//DRAW POKEBALLS
		if (gp.player.numOfPokemon >= 1) {
			int i = gp.player.numOfPokemon;
			int numEmpty = 6 - gp.player.numOfPokemon;
			int shift = 0;
			
			while (i  > 0) {
				g2.drawImage(PokeballImage,gp.intTileSize/2 + shift,gp.intTileSize/2,gp.intTileSize,gp.intTileSize,null);
				i -= 1;
				shift += 45;
			}
			while (i != numEmpty) {
				g2.drawImage(PokeballEmpty,gp.intTileSize/2 + shift,gp.intTileSize/2,gp.intTileSize,gp.intTileSize,null);
				shift += 45;
				i += 1;
			}
			
		}
		
		g2.setFont(GameText);
		g2.setColor(Color.black);
		g2.drawString("Pokeballs: " + gp.player.hasPokeBall, 30, 110);
		
		
		if (messageOn == true) {
			g2.setFont(g2.getFont().deriveFont(20F));
			g2.setColor(Color.white);
			g2.fillRect(230,700,750,150);
			g2.setColor(Color.black);
			g2.drawString(message, 300, 780);
			g2.drawRect(245,715,720,120);
			g2.drawRect(230,700,750,150);
			
			messageTime += 1;
			
			if (messageTime > 120) {
				messageTime = 0;
				messageOn = false;
			}
		}
		//DISPLAY BATTLE AND POKEMON
		if (showBattle == true) { 
			
			PlayerPokemon playerPokemon = new PlayerPokemon(gp);
			OpponentPokemon opponentPokemon = new OpponentPokemon(gp);
			
			try {
			Pokemon = ImageIO.read(getClass().getResourceAsStream(playerPokemon.CurrentPokemon[4]));
			} catch(IOException e) {
				e.printStackTrace();
			}
			
			try {
				OpponentPokemon = ImageIO.read(getClass().getResourceAsStream(opponentPokemon.CurrentOpponentPokemon[4]));
				} catch(IOException e) {
					e.printStackTrace();
				}
			
			g2.setColor(Color.white);
			g2.fillRect(0,0,25 * gp.intTileSize,19* gp.intTileSize);
			g2.setColor(Color.black);
			g2.fillRect(10,10,25 * gp.intTileSize - 20,19 * gp.intTileSize - 20);
			g2.setColor(Color.white);
			g2.fillRect(20,20,1160,1160);
			g2.setColor(Color.black);
			g2.fillRect(230,700,750,150);
			g2.setColor(Color.white);
			g2.fillRect(250,720,710,110);
			g2.setColor(Color.black);
			g2.drawImage(Pokemon,150,390,300,300,null);
			g2.drawImage(OpponentPokemon,800,120,200,200,null);
			g2.fillRect(10,680,1170,10);
			g2.setFont(g2.getFont().deriveFont(20F));
			//BATTLE OPTIONS
			g2.drawString("Attack", 560, 750);
			g2.drawString("Items", 450, 780);
			g2.drawString("Run", 570, 820);
			g2.drawString("Pokemon", 680, 780);
			
			if (gp.player.controlSwitch == true) {
				//BATTLE OPTION MOVEMENT
				switch (gp.player.direction) {
				case "up":
					g2.drawRect(558,730,60,40);
					
					selectedItem = "attack";
					break;
				case "down":
					g2.drawRect(568,800,60,40);
					
					selectedItem = "run";
					break;
				case "left":
					g2.drawRect(448,760,60,40);
					
					selectedItem = "items";
					break;
				case "right":
					g2.drawRect(678,760,90,40);
					
					selectedItem = "pokemon";
					break;
					//DISPLAY MENU BASED ON SELECTED ITEM
				case "select":
					switch (selectedItem) {
					case "attack":
						
						
					
						g2.drawString("Items", 450, 780);
						g2.drawString("Run", 570, 820);
						g2.drawString("Pokemon", 680, 780);
						break;
					case "run":
						
						break;
					case "items":
						
						break;
					case "pokemon":
						
						break;
					}
				break;
				}
			
		}
		
	}
	
	}
}

