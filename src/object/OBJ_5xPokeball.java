package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import javax.imageio.ImageIO;

public class OBJ_5xPokeball extends SuperObject{

	public OBJ_5xPokeball() {
		
		name = "5x Pokeball";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/5x Pokeball.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
		solidArea.x = 4;
		solidArea.y = 4;
	}
	
}
