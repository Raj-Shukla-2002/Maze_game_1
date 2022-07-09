//Programmer: Raj Shukla
//Purpose: To manage all the entities in the game
package Entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import MainClasses.Handler;
import Entities.Player;

public class EntityManager {
	
	private Handler handler;
	private Player player;
	//Array to hold every entity in the game
	private ArrayList<Entity> entities;
	private Comparator<Entity> rendersort = new Comparator<Entity>() {

		@Override
		public int compare(Entity a, Entity b) {
			if(a.getY() + a.getHeight() < b.getY() + b.getHeight()) {
				return -1;
			}
			else {
				return 1;
			}
		}
		
	};
	//Constructor
	public EntityManager(Handler handler, Player player) {
		this.handler = handler;
		this.player = player;
		entities = new ArrayList<Entity>();
		addEntity(player);
	}
	
	//Tick method for EntityManager
	public void tick() {
		Iterator<Entity> it = entities.iterator();
		while(it.hasNext()) {
			
			Entity e = it.next();
			e.tick();
			if(!e.isActive()) {
				it.remove();
			}
		}
		entities.sort(rendersort);
	}
	//Render method for entities
	public void render(Graphics g) {
		for(Entity e : entities) {
			e.render(g);
		}
	}
	
	
	public void addEntity(Entity e) {
		entities.add(e);
	}
	
	
	
	//Set and Get Methods
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}
	
	
}
