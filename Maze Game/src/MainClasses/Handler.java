package MainClasses;

import gfx.GameCamera;
import MCMovement.Controls;
import Background.gameWorld;

public class Handler {
	
	private RunNGun game;
	private gameWorld world;
	
	public Handler(RunNGun game){
		this.game = game;
	}
	
	public GameCamera getGameCamera(){
		return game.getGameCamera();
	}
	
	public Controls getControls(){
		return game.getControls();
	}
	
	public int getWidth(){
		return game.getWidth();
	}
	
	public int getHeight(){
		return game.getHeight();
	}

	public RunNGun getGame() {
		return game;
	}

	public void setGame(RunNGun game) {
		this.game = game;
	}

	public gameWorld getWorld() {
		return world;
	}

	public void setWorld(gameWorld world) {
		this.world = world;
	}

}
