package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class EmptyPokeballs extends SuperObject {

	public EmptyPokeballs() {
		
		name = "Empty Pokeballs";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/Pokeball on UI (PK NOT in).png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
	
		
		
	}
	
}
