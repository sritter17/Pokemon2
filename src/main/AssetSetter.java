package main;

import object.FirstBattle;
import object.OBJ_5xPokeball;
import object.OBJ_FriendHouse;
import object.OBJ_MyHouseDoor;

public class AssetSetter {

	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
		
	}
	
	public void setObject() {
		
		gp.obj[0] = new OBJ_5xPokeball();
		gp.obj[0].worldX = (35)*gp.intTileSize;
		gp.obj[0].worldY = (73)*gp.intTileSize;
		
		gp.obj[1] = new OBJ_MyHouseDoor();
		gp.obj[1].worldX = (22)*gp.intTileSize;
		gp.obj[1].worldY = (85)*gp.intTileSize;
		
		gp.obj[2] = new OBJ_FriendHouse();
		gp.obj[2].worldX = (46)*gp.intTileSize;
		gp.obj[2].worldY = (85)*gp.intTileSize;
		
		gp.obj[3] = new FirstBattle();
		gp.obj[3].worldX = (35)*gp.intTileSize;
		gp.obj[3].worldY = (65)*gp.intTileSize;
		gp.obj[3].collision = true;
	}
	
}
