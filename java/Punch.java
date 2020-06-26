import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.Dimension;
import javax.swing.*;
import java.util.*;

public class Punch extends Canvas implements Runnable {

	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
	private Thread thread;
	private Handler handler;
	private HUD hud;
	private boolean running = false;
	private Random r;

	public Punch() {
		new Window(WIDTH, HEIGHT, "PUNCH", this);

		handler = new Handler();
		hud = new HUD();
		r = new Random();
		/*
		 * for (int i = 0; i < 50; i++){ handler.addObject(new Player(0, 0, ID.Player));
		 * }
		 */

		handler.addObject(new Player(WIDTH / 2 - 32, HEIGHT / 2 - 32, ID.Player, handler));
		for (int i = 0; i < 6; i++) {
			handler.addObject(new BasicEnemy(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.BasicEnemy));
		}

		this.addKeyListener(new KeyInput(handler));
	}

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}

	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (Exception exc) {
			exc.printStackTrace();
		}

	}

	// Game loop
	public void run() {
		// so you don't have to click on the screen to move the player
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amtOfTicks = 60.0;
		double ns = 1000000000 / amtOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			if (running)
				render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				// System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}

	private void tick() {
		handler.tick();
		hud.tick();
	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();

		// setting colors
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		handler.render(g);

		hud.render(g);

		g.dispose();
		bs.show();
	}

	public static int clamp(int var, int min, int max) {
		if (var >= max) {
			return var = max;
		} else if (var <= min) {
			return var = min;
		} else {
			return var;
		}
	}

	public static void main(String args[]) {
		new Punch();
	}
}