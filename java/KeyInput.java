import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

	private Handler handler;

	public KeyInput(Handler handler) {

		this.handler = handler;

	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		for (int i = 0; i < handler.object.size(); i++) {

			PunchObject tempObject = handler.object.get(i);

			if(tempObject.getId() == ID.Player) {
				//key events for player1

				if(key == KeyEvent.VK_W) tempObject.setVelY(-5);
				if(key == KeyEvent.VK_S) tempObject.setVelY(5);
				if(key == KeyEvent.VK_A) tempObject.setVelX(-5);
				if(key == KeyEvent.VK_D) tempObject.setVelX(5);

			}
			if(tempObject.getId() == ID.Player2) {

				if(key == KeyEvent.VK_I) tempObject.setVelY(-5);
				if(key == KeyEvent.VK_K) tempObject.setVelY(5);
				if(key == KeyEvent.VK_J) tempObject.setVelX(-5);
				if(key == KeyEvent.VK_L) tempObject.setVelX(5);

			}
		}
		//System.out.println(key);
	}

	public void keyReleased(KeyEvent e) {

		int key = e.getKeyCode();
		for (int i = 0; i < handler.object.size(); i++) {

			PunchObject tempObject = handler.object.get(i);

			if(tempObject.getId() == ID.Player) {
				//key events for player1

				if(key == KeyEvent.VK_W) tempObject.setVelY(0);
				if(key == KeyEvent.VK_S) tempObject.setVelY(0);
				if(key == KeyEvent.VK_A) tempObject.setVelX(0);
				if(key == KeyEvent.VK_D) tempObject.setVelX(0);

			}
			if(tempObject.getId() == ID.Player2) {


				if(key == KeyEvent.VK_I) tempObject.setVelY(0);
				if(key == KeyEvent.VK_K) tempObject.setVelY(0);
				if(key == KeyEvent.VK_J) tempObject.setVelX(0);
				if(key == KeyEvent.VK_L) tempObject.setVelX(0);

			}
		}

	}

}