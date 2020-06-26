import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.Dimension;
import javax.swing.*;
import java.util.*;


public class Handler {

	LinkedList<PunchObject> object = new LinkedList<PunchObject>();

	public void tick() {
		for (int i = 0; i < object.size(); i++) {
			PunchObject tempObject = object.get(i);

			tempObject.tick();
		}
	}

	public void render(Graphics g) {
		for (int i = 0; i < object.size(); i++) {
			PunchObject tempObject = object.get(i);

			tempObject.render(g);
		}
	}

	public void addObject(PunchObject object) {
		this.object.add(object);
	}

	public void removeObject(PunchObject object) {
		this.object.remove(object);
	}

}