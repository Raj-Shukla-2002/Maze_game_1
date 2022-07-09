package Tiles;

import gfx.Assets;
import Items.Item;

public class DoorTile extends Tile{
		
	public DoorTile(int id) {
		super(Assets.door, id);
	}
	
	public boolean isSolid(){
		if(Item.count ==  Item.picked_UP) {
			return false;
		}
		else {
			return true;
		}
	}
	
}
