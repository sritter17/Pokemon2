package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_StarterPokemon extends SuperObject {

	public OBJ_StarterPokemon() {
		
		name = "Starter Pokemon";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/Pixel charmander.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		solidArea.x = 4;
		solidArea.y = 4;
	}
	
}
