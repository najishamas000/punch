import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.Dimension;
import javax.swing.*;
import java.util.*;


public abstract class PunchObject {

	protected int x, y;
	protected ID id;
	protected int velX, velY;

	public PunchObject(int x, int y, ID id)
	{
		this.x = x;
		this.y = y;
		this.id = id;
	}

	public abstract void tick();
	public abstract void render(Graphics g);

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setId(ID id) {
		this.id = id;
	}	

	public ID getId() {
		return id;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}

	public int getVelX() {
		return velX;
	}

	public int getVelY() {
		return velY;
	}
}