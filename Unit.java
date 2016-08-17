import java.awt.*;
import java.util.ArrayList;

public class Unit {
	int x;		// x position
	int y;		// y position
	int radius;	// radius of unit
	int speed;	// speed of unit
	int dx;		// change in x on next step
	int dy;		// change in y on next step

	public Unit(int x, int y, int r, int s) {
		this.x = x;
		this.y = y;
		this.radius = r;
		this.speed = s;
		this.dx = 0;
		this.dy = 0;
	}

	public void setDirUp(){ this.dy = -speed; }
	public void setDirDown(){ this.dy = speed; }
	public void setDirVerticalNull(){ this.dy = 0; }
	public void setDirRight(){ this.dx = speed; }
	public void setDirLeft(){ this.dx = -speed; }
	public void setDirHorizontalNull(){ this.dx = 0; }

	public void move(){
		x += dx;
		y += dy;
	}

	public void drawUnit(Graphics2D g2) {
		Stroke oldStroke = g2.getStroke();
		g2.setStroke(new BasicStroke(3));

		Color oldColor = g2.getColor();
		g2.setColor(Color.BLACK);
		g2.fillOval(x - radius,
					y - radius,
					2*radius,
					2*radius);
		g2.setColor(oldColor);

		g2.drawOval(x - radius,
					y - radius,
					2*radius,
					2*radius);

		g2.setStroke(oldStroke);
	}

}
