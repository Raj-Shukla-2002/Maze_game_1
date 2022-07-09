//Programmer: Raj Shukla
//Purpose: To make entities collectible
package Items;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import MainClasses.Handler;
import gfx.Assets;

public class Item {
	//Handler for items
	public static Item[] items = new Item[256];
	public static Item keyItem = new Item(Assets.key,  "Key", 0);
	public static Item ringItem = new Item(Assets.ring,  "Ring", 0);
	
	
	//Class integers
	public static final int itemWidth = 32, itemHeight = 32, picked_UP = -1;
	
	protected Handler handler;
	protected BufferedImage texture;
	protected String name;
	protected final int id;
	
	protected Rectangle bounds;
	
	protected int x, y;
	public static int count;
	
	//Constructor for item
	public Item(BufferedImage texture, String name, int id) {
		this.texture = texture;
		this.name = name;
		this.id = id;
		count = 1;
		
		bounds = new Rectangle(x, y, itemWidth, itemHeight);
		
		items[id] = this;
	}
	
	public void tick() {
		//checks for collision between item and player
		if(handler.getWorld().geteManager().getPlayer().getCollisionBounds(0f, 0f).intersects(bounds)) {
			count = picked_UP;
		}
		
	}
	//render method to render items
	public void render(Graphics g) {
		if(handler == null) {
			return;
		}
		render(g, (int) (x-handler.getGameCamera().getxOffset()), (int) (y-handler.getGameCamera().getyOffset()));
	}
	//rendering for item
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, itemWidth, itemHeight, null);
	}
	//create new method for more items
	public Item createnew(int x, int y) {
		Item i = new Item(texture, name, id);
		i.setPosition(x, y);
		return i;
	}
	
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
		bounds.x = x;
		bounds.y = y;
	}
	
	//Get and Set Methods
	
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public BufferedImage getTexture() {
		return texture;
	}

	public void setTexture(BufferedImage texture) {
		this.texture = texture;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getId() {
		return id;
	}


}
