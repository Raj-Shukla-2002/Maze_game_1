//Programmer: Raj Shukla
//Purpose: To make ring entity item
package Entities;

import java.awt.Graphics;
import Items.Item;
import MainClasses.GameLaunch;
import MainClasses.Handler;
import Tiles.Tile;
import gfx.Assets;

public class Ring extends StaticEntity{
	
	//Constructor
	public Ring(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT*2);
		
		bounds.x = 5;
		bounds.y = (int) (height / 1.5f);
		bounds.width = width;
		bounds.height = (int) (height - height/1.5f);
		
	}

	@Override
	public void tick() {
		
	}
	//If Ring is destroyed
	public void die() {
		handler.getWorld().getiManager().addItem(Item.ringItem.createnew((int) x+25, (int) y+80));
		//Timer ending of the game and calculations for timer to be able to determine minutes and seconds
		long finaltime = System.currentTimeMillis() - GameLaunch.starttimer;
		long finalsec = finaltime / 1000;
		long secdisplay = finalsec % 60;
		long finalmin = finalsec / 60;
		//output for timer
		System.out.println("You beat the game in " + finalmin + " minutes and " + secdisplay + " seconds.");
		//Stops the program from continuing. To exit user must exit out using the x box on the window bar
		System.exit(1);

	}

	@Override
	public void render(Graphics g) {
		//Rendering for Ring
		g.drawImage(Assets.ring, (int) (x - handler.getGameCamera().getxOffset()), (int) (y- handler.getGameCamera().getyOffset()), width, height, null);
	}

}
