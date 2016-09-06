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
	PlayerController controller;

	public GamePanel(int width, int height, GameModel model){
		super();
		setBackground(Color.BLACK);
		this.width = width;
		this.height = height;
		this.model = model;
		this.controller = new PlayerController(model.getPlayer());
		this.addKeyListener(this.controller);

		this.setFocusable(true);

		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (SwingUtilities.isLeftMouseButton(e)){
					// Left Mouse Click
					controller.leftMousePress();
				}
				if (SwingUtilities.isRightMouseButton(e)){
					// Right Mouse Click
				}
				if (SwingUtilities.isMiddleMouseButton(e)){
					// Middle Mouse Click
					// Probably won't need this so can remove
				}
			}

			@Override
			public void mouseReleased(MouseEvent e){
				// Do Something
				if (SwingUtilities.isLeftMouseButton(e)){
					// Left Mouse Click
					controller.leftMouseRelease();
				}
				if (SwingUtilities.isRightMouseButton(e)){
					// Right Mouse Click
				}
				if (SwingUtilities.isMiddleMouseButton(e)){
					// Middle Mouse Click
					// Probably won't need this so can remove
				}
			}
		});

		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e){
				// update controller
				controller.updateCursorLocation(e.getX(), e.getY());
				//System.out.println("x: " + e.getX());
				//System.out.println("y: " + e.getY());
			}

			@Override
			public void mouseDragged(MouseEvent e){
				mouseMoved(e);
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
