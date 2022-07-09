//Programmer: Raj Shukla
//Purpose: To manage and sort all the items
package Items;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import MainClasses.Handler;

public class ItemManager {
	
	//Array for all items
	private ArrayList<Item> items;
	private Handler handler;
	
	//Constructor for item manager
	public ItemManager(Handler handler) {
		this.handler = handler;
		items = new ArrayList<Item>();
		
	}
	
	//tick method for item manager
	public void tick() {
		Iterator<Item> it = items.iterator();
		while(it.hasNext()) {
			Item i = it.next();
			i.tick();
			//If player picks up the item it the if statement removes the item.
			if(i.getCount() == Item.picked_UP) {
				it.remove();
			}
		}
	}
	
	//Rendering for the items
	public void render(Graphics g) {
		for(Item i: items) {
			i.render(g);
		}
	}
	
	//To add items to the item array
	public void addItem(Item i) {
		i.setHandler(handler);
		items.add(i);
	}

	
	
	
	//Get and Set Methods
	public Handler getHandler() {
		return handler;
	}


	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	
}
