import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Observer;
import java.util.Observable;

import java.util.ArrayList;
import java.lang.Math.*;


public class GamePanel extends JPanel implements Observer {
	int width;
	int height;
	GameModel model;

	public GamePanel(int width, int height, GameModel model){
		super();
		setBackground(Color.BLACK);
		this.width = width;
		this.height = height;
		this.model = model;

		this.setFocusable(true);

		// // This is code from other project. Add in if I want
		// this.setBorder(BorderFactory.createLineBorder(Color.black));
		// this.setBackground(Color.WHITE);

		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// Do Something
			}

			@Override
			public void mouseReleased(MouseEvent e){
				// Do Something
			}
		});

		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e){
				// Do Something
				model.setCursorCoordinate(e.getX(), e.getY());
			}
		});
	}

	private void drawBackground(Graphics2D g2){
		Stroke oldStroke = g2.getStroke();
		g2.setStroke(new BasicStroke(4));

		int n = height + width;
		for (int c = 0; c <= n; c+=10){
			if (c < width){
				g2.drawLine(0, c, c, 0);
			} else {
				g2.drawLine(c - height, height, width, c - width);
			}
		}
		g2.setStroke(oldStroke);
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;

		drawBackground(g2);
		model.getMap().drawWalkable(g2);
		model.getPlayer().drawUnit(g2);
	}

	// Observer Interface
	@Override
	public void update(Observable arg0, Object arg1){
		// do stuff
		this.repaint();
	}
}
