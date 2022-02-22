package object;

import java.io.IOException;

import javax.imageio.ImageIO;


public class FirstBattle extends SuperObject{

	public FirstBattle() {
		
		
		
		name = "First Battle";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/First Battle Guy.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}
	
}
