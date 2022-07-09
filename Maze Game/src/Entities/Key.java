//Programmer: Raj Shukla
//Purpose: To make key entity item
package Entities;

import java.awt.Graphics;

import MainClasses.Handler;
import gfx.Assets;
import Items.Item;
import Tiles.Tile;

public class Key extends StaticEntity {
	//Constructor
	public Key(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT*2);
		
		//Boundaries for collision box
		bounds.x = 3;
		bounds.y = (int) (height / 1.1f);
		bounds.width = width - 6;
		bounds.height = (int) (height - height/1.1f);
		
	}

	@Override
	public void tick() {
		
	}
	//If key is destroyed in the game
	public void die() {
		handler.getWorld().getiManager().addItem(Item.keyItem.createnew((int) x+25, (int) y+80));
	}

	@Override
	public void render(Graphics g) {
		//Rendering for Key
		g.drawImage(Assets.key, (int) (x - handler.getGameCamera().getxOffset()), (int) (y- handler.getGameCamera().getyOffset()), width, height, null);
	}

}
