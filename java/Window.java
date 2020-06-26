import java.awt.*;
import java.awt.image.BufferStrategy;
import javax.swing.*;
import java.awt.Dimension;
import java.util.*;

public class Window extends Canvas {

	public Window(int width, int height, String title, Punch game) {
		JFrame frame = new JFrame(title);

		frame.setPreferredSize(new Dimension(width,height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(game);
		frame.setVisible(true);
		frame.add(game);
		frame.setVisible(true);
		game.start();
	}
}