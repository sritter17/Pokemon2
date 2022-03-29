package main;

import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.Color;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import object.EmptyPokeballs;
import object.OBJ_StarterPokemon;
import object.PokemonInventory;

public class UI {

	GamePanel gp;
	Font GameText;
	BufferedImage PokeballImage;
	BufferedImage PokeballEmpty;
	public boolean messageOn = false;
	public String message = "";
	int messageTime = 0;
	
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
		
	}
	
}
