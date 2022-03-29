package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_PiplupPokeball extends SuperObject {
	
	public OBJ_PiplupPokeball() {
		
		name = "Piplup";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/piplup pixel.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		solidArea.x = 4;
		solidArea.y = 4;
	}
	
}
