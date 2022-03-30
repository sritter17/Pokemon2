package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_SnivyPokeball extends SuperObject {
	
	public OBJ_SnivyPokeball() {
		
		name = "Snivy";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/pixel snivy.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		solidArea.x = 4;
		solidArea.y = 4;
	}
	
}
