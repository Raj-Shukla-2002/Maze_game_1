package gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 32, height = 32;
	
	public static BufferedImage dirt, grass, stone, tree, key, door, ring;
	public static BufferedImage player[][];
	
	public static void init(){
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
		
		player = new BufferedImage[4][2];
		
		//Player facing Downward
		player[0][0] = sheet.crop(width * 4, 0, width, height);
		player[0][1] = sheet.crop(width * 5, 0, width, height);
		
		//Player facing Right
		player[1][0] = sheet.crop(width * 4, height, width, height);
		player[1][1] = sheet.crop(width * 5, height, width, height);
		
		//Player facing left
		player[2][0] = sheet.crop(width * 6, height, width, height);
		player[2][1] = sheet.crop(width * 7, height, width, height);
		
		//Player facing Upward
		player[3][0] = sheet.crop(width * 6, 0, width, height);
		player[3][1] = sheet.crop(width * 7, 0, width, height);
		
		dirt = sheet.crop(width, 0, width, height);
		grass = sheet.crop(width * 2, 0, width, height);
		stone = sheet.crop(width * 3, 0, width, height);
		tree = sheet.crop(0, 0, width, height);
		key = sheet.crop(width * 3 + 1, height, width, height);
		door = sheet.crop(width * 2 + 1, height, width, height);
		ring = sheet.crop(0, 0, width, height);
	}
	
}
