package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_MyHouseDoor extends SuperObject {

public OBJ_MyHouseDoor() {
		
		name = "My House Door";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/Brick House Door.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}	
}
}
