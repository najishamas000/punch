import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.Dimension;
import javax.swing.*;
import java.util.*;



public class Player extends PunchObject {

	Random r = new Random();

	public Player(int x, int y, ID id) {
		super(x, y, id);
		x = 0;
		y = 0;
		velX  = 0;
		velY = 0;
		//setX(100);
	}

	public void tick() {
		x += velX;
		y += velY;
	}

	public void render(Graphics g) {
		if(id == ID.Player) g.setColor(Color.white);
		else g.setColor(Color.green);
		g.fillRect(x,y,10,10);
	}
}