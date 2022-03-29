package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_FriendHouse extends SuperObject {

public OBJ_FriendHouse() {
		
		name = "Friend House Door";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/Brick House Door.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}	
		collision = true;
}
}
