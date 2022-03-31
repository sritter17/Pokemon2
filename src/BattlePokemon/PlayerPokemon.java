package BattlePokemon;
import java.awt.image.BufferedImage;

import main.GamePanel;
public class PlayerPokemon {
	GamePanel gp;
	
	String[] PokemonNames = {"piplup", "charmander", "snivy", "starly"};
	String[] PokemonBaseHP = {"20","20","20","17"};
	String[] PokemonBaseAttack = {"7","7","7","6"};
	String[] PokemonBaseDefense = {"3","3","3","2"};
	String[] PokemonBattleFrontSprite = {"","","","/PokemonBattleSprites/Starly Front View.png"};
	String[] PokemonBattleRearSprite = {"","/PokemonBattleSprites/Charmander Rear Battle View.png","",""};
	
	String[] CurrentPokemon;
	
	public PlayerPokemon(GamePanel gp) {
		this.gp = gp;
		
for (int i=0; i < gp.player.numOfPokemon; i += 1) {
			
			switch(gp.player.playerPokemon[i]) {
			
			case("charmander"):
			CurrentPokemon[0] = PokemonNames[1];
			CurrentPokemon[1] = PokemonBaseHP[1];
			CurrentPokemon[2] = PokemonBaseAttack[1];
			CurrentPokemon[3] = PokemonBaseDefense[1];
			CurrentPokemon[4] = PokemonBattleRearSprite[1];
				break;
			
			case("piplup"): 
			CurrentPokemon[0] = PokemonNames[0];
			CurrentPokemon[1] = PokemonBaseHP[0];
			CurrentPokemon[2] = PokemonBaseAttack[0];
			CurrentPokemon[3] = PokemonBaseDefense[0];
			CurrentPokemon[4] = PokemonBattleRearSprite[0];
			break;	
			
			case("snivy"):
			CurrentPokemon[0] = PokemonNames[2];
			CurrentPokemon[1] = PokemonBaseHP[2];
			CurrentPokemon[2] = PokemonBaseAttack[2];
			CurrentPokemon[3] = PokemonBaseDefense[2];
			CurrentPokemon[4] = PokemonBattleRearSprite[2];
			break;
			case("starly"):
			CurrentPokemon[0] = PokemonNames[3];
			CurrentPokemon[1] = PokemonBaseHP[3];
			CurrentPokemon[2] = PokemonBaseAttack[3];
			CurrentPokemon[3] = PokemonBaseDefense[3];
			CurrentPokemon[4] = PokemonBattleRearSprite[3];
			break;
			
			}
		}
		
	}
	
}
