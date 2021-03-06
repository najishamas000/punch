import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;

public class BasicEnemy extends PunchObject {
    public BasicEnemy(int x, int y, ID id) {
        super(x, y, id);

        velX = 5;
        velY = 5;
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 10, 10);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        if (y <= 0 || y >= Punch.HEIGHT - 32)
            velY *= -1;
        if (x <= 0 || x >= Punch.WIDTH - 16)
            velX *= -1;

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x, y, 16, 16);
    }
}