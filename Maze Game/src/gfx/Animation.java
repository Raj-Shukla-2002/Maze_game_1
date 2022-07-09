//Programmer: Raj Shukla
//Purpose: To be able to provide movement animation for a character
package gfx;

import java.awt.image.BufferedImage;

public class Animation {
	
	
	private int speed, ind;
	private long finaltime, stopwatch;
	private BufferedImage[] frames;
	
	//Constructor
	public Animation(int velocity, BufferedImage[] fps) {
		this.speed = velocity;
		this.frames = fps;
		ind = 0;
		stopwatch = 0;
		//Time from when the program starts
		finaltime = System.currentTimeMillis();
	}
	
	//Tick method for the animations
	public void tick() {
		//Determines how many seconds has passed since the program started
		stopwatch += System.currentTimeMillis() - finaltime;
		//re determines final time for the next animation
		finaltime = System.currentTimeMillis();
		
		
		if(stopwatch > speed) {
			ind++;
			stopwatch = 0;
			//This is so that it may not pass over to animations which is how many animations for the movement of the character
			if(ind >= frames.length) {
				ind = 0;
			}
		}
		
	}
	
	//Buffered image to get the current frame of the animation
	public BufferedImage getCurrentFrame() {
		return frames[ind];
	}
}
