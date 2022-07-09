package Entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import MainClasses.Handler;
import Entities.Entity;
import gfx.Animation;
import gfx.Assets;

public class Player extends Character {
	
	//Animations
	private Animation animDownward, animUpward, animRight, animLeft;
	
	//Attack Timer
	private long lastATimer, aCooldown = 800, aTimer = aCooldown;
	
	
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, DEFAULT_Charcter_WIDTH, DEFAULT_Charcter_HEIGHT);
		
		bounds.x = 22;
		bounds.y = 44;
		bounds.width = 19;
		bounds.height = 19;
		
		//Animations
		animUpward = new Animation(500, Assets.player[3]);
		animLeft = new Animation(500, Assets.player[2]);
		animRight = new Animation(500, Assets.player[1]);
		animDownward = new Animation(500, Assets.player[0]);
		
	}

	@Override
	public void tick() {
		//Animations
		animDownward.tick();
		animUpward.tick();
		animLeft.tick();
		animRight.tick();
		
		//Movements
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
		
		//Attack
		checkattacks();
	}
	
	private void checkattacks() {
		aTimer += System.currentTimeMillis() - lastATimer;
		lastATimer = System.currentTimeMillis();
		if(aTimer < aCooldown) {
			return;
		}
		
		
		Rectangle cb = getCollisionBounds(0, 0);
		Rectangle r = new Rectangle();
		int rsize = 20;
		r.width = rsize;
		r.height = rsize;
		
		if(handler.getControls().uAttack) {
			r.x = cb.x + cb.width/2 - rsize/2;
			r.y = cb.y - rsize;
		}
		else if(handler.getControls().dAttack) {
			r.x = cb.x + cb.width/2 - rsize/2;
			r.y = cb.y + cb.height;
		}
		else if(handler.getControls().lAttack) {
			r.x = cb.x - rsize;
			r.y = cb.y + cb.height/2 - rsize/2;
		}
		else if(handler.getControls().rAttack) {
			r.x = cb.x + cb.width;
			r.y = cb.y + cb.height/2 - rsize/2;
		}
		else {
			return;
		}
		
		aTimer = 0;
		
		for(Entity e : handler.getWorld().geteManager().getEntities()) {
			if(e.equals(this)) {
				continue;
			}
			if(e.getCollisionBounds(0,0).intersects(r)) {
				e.damage(1);
				return;
			}
		}
	}
	
	public void die() {
		
	}
	
	private void getInput(){
		xMove = 0;
		yMove = 0;
		
		if(handler.getControls().up)
			yMove = -speed;
		if(handler.getControls().down)
			yMove = speed;
		if(handler.getControls().left)
			xMove = -speed;
		if(handler.getControls().right)
			xMove = speed;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		
//		g.setColor(Color.red);
//		g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
//				(int) (y + bounds.y - handler.getGameCamera().getyOffset()),
//				bounds.width, bounds.height);
	}
	
	private BufferedImage getCurrentAnimationFrame() {
		if(xMove < 0) {
			return animLeft.getCurrentFrame();
		}
		else if(xMove > 0) {
			return animRight.getCurrentFrame();
		}
		else if(yMove < 0) {
			return animUpward.getCurrentFrame();
		}
		else {
			return animDownward.getCurrentFrame();
		}
	}
	
}
