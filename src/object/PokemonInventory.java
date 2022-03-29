package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class PokemonInventory extends SuperObject {

	public PokemonInventory(){
		
		name = "Pokemon Inventory";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/Pokeball on UI (PK in).png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
	
}
}
