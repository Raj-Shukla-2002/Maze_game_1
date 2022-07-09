package States;

import java.awt.Graphics;

import MainClasses.Handler;
import Entities.Player;
import Entities.Key;
import Background.gameWorld;

public class GameState extends State {
	
	private gameWorld world;
	
	public GameState(Handler handler){
		super(handler);
		world = new gameWorld(handler, "Images_Sounds/worlds/world1.txt");
		handler.setWorld(world);
	}
	
	@Override
	public void tick() {
		world.tick();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
	}

}
