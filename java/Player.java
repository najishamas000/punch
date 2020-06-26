import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.Dimension;
import javax.swing.*;
import java.util.*;

public class Player extends PunchObject {

	Random r = new Random();
	Handler handler;

	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		x = 0;
		y = 0;
		velX = 0;
		velY = 0;
		this.handler = handler;
		// setX(100);
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 10, 10);
	}

	public void tick() {
		x += velX;
		y += velY;

		x = Punch.clamp(x, 0, Punch.WIDTH - 10);
		y = Punch.clamp(y, 0, Punch.HEIGHT - 32);

		collision();
	}

	private void collision() {
		for (int i = 0; i < handler.object.size(); i++) {
			PunchObject tempObject;

			tempObject = handler.object.get(i);
			if (tempObject.getId() == ID.BasicEnemy) {
				if (getBounds().intersects(tempObject.getBounds())) {
					// collisions
					HUD.HEALTH -= 2;
				}
			}
		}
	}

	public void render(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;

		g.setColor(Color.white);
		g2d.draw(getBounds());
		g.setColor(Color.green);
		g.fillRect(x, y, 10, 10);
	}
}