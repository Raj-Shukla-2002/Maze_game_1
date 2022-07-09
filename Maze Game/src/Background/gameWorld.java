package Background;

import java.awt.Graphics;

import MainClasses.Handler;
import Entities.EntityManager;
import Entities.Player;
import Entities.Ring;
import Entities.Key;
import Items.ItemManager;
import Tiles.Tile;
import utils.Utils;

public class gameWorld {
	
	//Entities
	private EntityManager eManager;
	
	//Items
	private ItemManager iManager;
	
	
	private Handler handler;
	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;
	
	public gameWorld(Handler handler, String path){
		this.handler = handler;
		eManager = new EntityManager(handler, new Player(handler, 120, 64));
		iManager = new ItemManager(handler);
		eManager.addEntity(new Key(handler, 60, 150));
		eManager.addEntity(new Ring(handler, 1350, 1650));

		
		loadWorld(path);
		
		eManager.getPlayer().setX(120);
		eManager.getPlayer().setY(64);
		
	}
	
	public void tick(){
		iManager.tick();
		eManager.tick();
		
	}
	
	public void render(Graphics g){
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);
		
		for(int y = yStart;y < yEnd;y++){
			for(int x = xStart;x < xEnd;x++){
				getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
						(int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
		//Items
		iManager.render(g);
		
		//Entities
		eManager.render(g);
	}
	
	public Tile getTile(int x, int y){
		if(x < 0 || y < 0 || x >= width || y >= height)
			return Tile.grassTile;
		
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null)
			return Tile.dirtTile;
		return t;
	}
	
	private void loadWorld(String path){
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}

	public EntityManager geteManager() {
		return eManager;
	}

	public ItemManager getiManager() {
		return iManager;
	}

	public void setiManager(ItemManager iManager) {
		this.iManager = iManager;
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	
}








