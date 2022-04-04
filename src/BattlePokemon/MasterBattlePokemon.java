package BattlePokemon;

import Entity.Player;
import main.GamePanel;

public class MasterBattlePokemon {
Player player;
	GamePanel gp;
	public int attack;
	public int defense;
	public String name;
	public String[] attacks = {"x","x","x","x"};
	public int HP;
	public int XP = 0;
	public double XPinterval = 1.5;
	public int order = 0;
	
	public MasterBattlePokemon(Player player) {
		this.player = player;
		System.out.println("Construtor ran");
		switch (player.playerPokemon[player.numOfPokemon]) {
		
		case "charmander":
			
			name = "charmander";
			attack = 7;
			defense = 3;
			HP = 20;
			attacks[0] = ("tackle");
			System.out.println(attacks[0]);
			attacks[1] = ("ember");
			attacks[2] = ("growl");
			attacks[3] = ("scratch");
			break;
		case "piplup":
			name = "piplup";
			attack = 7;
			defense = 3;
			HP = 20;
			attacks[0] = ("tackle");
			attacks[1] = ("water gun");
			attacks[2] = ("tail whip");
			attacks[3] = ("scratch");
			break;
		case "snivy":
			name = "snivy";
			attack = 7;
			defense = 3;
			HP = 20;
			attacks[0] = ("tackle");
			attacks[1] = ("razor leaf");
			attacks[2] = ("tail whip");
			attacks[3] = ("scratch");
			break;
		}
		
	}

	public static void main(String[] args) {
		
	}
		
	
	
	
}
