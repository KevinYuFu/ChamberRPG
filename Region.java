import java.awt.*;
import java.lang.Math.*;

public class Region {
	Point p1;
	Point p2;

	public Region(int x1, int y1, int x2, int y2){
		this.p1 = new Point(Math.min(x1, x2), Math.min(y1, y2));
		this.p2 = new Point(Math.max(x1, x2), Math.max(y1, y2));
	}

	// checks is points are within region x bound.
	public int inRegionXBound(int x, int rad){
		// check if x and y are within points 1 and 2
		if (x - rad < p1.getX()) { return p1.getX() + rad; }
		if (x + rad > p2.getX()) { return p2.getX() - rad; }
		return -1;
	}

	// checks is points are within region y bound.
	public int inRegionYBound(int y, int rad){
		// check if x and y are within points 1 and 2
		if (y - rad < p1.getY()) { return p1.getY() + rad; }
		if (y + rad > p2.getY()) { return p2.getY() - rad; }
		return -1;
		//return ((y - rad > p1.getY()) && (y + rad < p2.getY()) );
	}

	// Draw
	public void drawRegion(Graphics2D g2){
		int x1 = p1.getX();
		int y1 = p1.getY();
		int x2 = p2.getX();
		int y2 = p2.getY();

		Color oldColor = g2.getColor();
		g2.setColor(Color.BLACK);
		g2.fillRect(x1, y1, x2-x1, y2-y1);

		g2.setColor(oldColor);
		g2.drawRect(x1, y1, x2-x1, y2-y1);
	}
}
