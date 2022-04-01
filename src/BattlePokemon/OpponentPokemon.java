package BattlePokemon;
import java.awt.image.BufferedImage;

import main.GamePanel;


public class OpponentPokemon {
	GamePanel gp;
	
	String[] PokemonNames = {"piplup", "charmander", "snivy", "starly"};
	String[] PokemonBaseHP = {"20","20","20","17"};
	String[] PokemonBaseAttack = {"7","7","7","6"};
	String[] PokemonBaseDefense = {"3","3","3","2"};
	String[] PokemonBattleFrontSprite = {"","","","/PokemonBattleSprites/Starly Front View.png"};
	String[] PokemonBattleRearSprite = {"","/PokemonBattleSprites/Charmander Rear Battle View.png","",""};
	
	public String[] CurrentOpponentPokemon = {"","","","",""};
	
	public OpponentPokemon(GamePanel gp) {
	
					switch(gp.player.opponentPokemon[0]) {
					
					case "charmander":
					CurrentOpponentPokemon[0] = PokemonNames[1];
					CurrentOpponentPokemon[1] = PokemonBaseHP[1];
					CurrentOpponentPokemon[2] = PokemonBaseAttack[1];
					CurrentOpponentPokemon[3] = PokemonBaseDefense[1];
					CurrentOpponentPokemon[4] = PokemonBattleRearSprite[1];
						break;
					
					case "piplup": 
					CurrentOpponentPokemon[0] = PokemonNames[0];
					CurrentOpponentPokemon[1] = PokemonBaseHP[0];
					CurrentOpponentPokemon[2] = PokemonBaseAttack[0];
					CurrentOpponentPokemon[3] = PokemonBaseDefense[0];
					CurrentOpponentPokemon[4] = PokemonBattleRearSprite[0];
					break;	
					
					case "snivy":
					CurrentOpponentPokemon[0] = PokemonNames[2];
					CurrentOpponentPokemon[1] = PokemonBaseHP[2];
					CurrentOpponentPokemon[2] = PokemonBaseAttack[2];
					CurrentOpponentPokemon[3] = PokemonBaseDefense[2];
					CurrentOpponentPokemon[4] = PokemonBattleRearSprite[2];
					break;
					case "starly":
					CurrentOpponentPokemon[0] = PokemonNames[3];
					CurrentOpponentPokemon[1] = PokemonBaseHP[3];
					CurrentOpponentPokemon[2] = PokemonBaseAttack[3];
					CurrentOpponentPokemon[3] = PokemonBaseDefense[3];
					CurrentOpponentPokemon[4] = PokemonBattleFrontSprite[3];
					
					break;
					
					}
				}
}