package MainClasses;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import Display.Display;
import gfx.Assets;
import gfx.GameCamera;
import MCMovement.Controls;
import States.GameState;
import States.MenuState;
import States.State;

public class RunNGun implements Runnable {

	private Display display;
	private int width, height;
	public String title;

	private boolean running = false;
	private Thread thread;

	private BufferStrategy bs;
	private Graphics g;

	// States
	private State gameState;
	public static State menuState;

	// Input
	private Controls actions;

	// Camera
	private GameCamera gameCamera;

	// Handler
	private Handler handler;

	public RunNGun(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		actions = new Controls();
	}

	private void init() {
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(actions);
		Assets.init();

		handler = new Handler(this);
		gameCamera = new GameCamera(handler, 0, 0);

		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		State.setState(gameState);
	}

	private void tick() {
		actions.tick();

		if (State.getState() != null)
			State.getState().tick();
	}

	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		// Clear Screen
		g.clearRect(0, 0, width, height);
		// Draw Here!

		if (State.getState() != null)
			State.getState().render(g);

		// End Drawing!
		bs.show();
		g.dispose();
	}

	public void run() {

		init();

		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;

		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;

			if (delta >= 1) {
				tick();
				render();
				ticks++;
				delta--;
			}

			if (timer >= 1000000000) {
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}

		stop();

	}

	public Controls getControls() {
		return actions;
	}

	public GameCamera getGameCamera() {
		return gameCamera;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public synchronized void start() {
		if (running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop() {
		if (!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		State.setState(menuState);
	}
	

}
