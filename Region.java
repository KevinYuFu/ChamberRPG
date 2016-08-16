import java.awt.*;
import java.lang.Math.*;

public class Region {
	Point p1;
	Point p2;

	public Region(int x1, int y1, int x2, int y2){
		this.p1 = new Point(Math.min(x1, x2), Math.min(y1, y2));
		this.p2 = new Point(Math.max(x1, x2), Math.max(y1, y2));
	}

	/* Not sure if need this
	public int getX1() { return this.p1.getX(); }
	public int getX2() { return this.p2.getX(); }
	public int getY1() { return this.p1.getY(); }
	public int getY2() { return this.p2.getY(); }
	*/

	// checks is points are within region.
	// // Should add radius checking
	public boolean inRegion(int x, int y){
		// check if x and y are within points 1 and 2
		return ((x > p1.getX()) && (y > p1.getY()) &&
			(x < p2.getX()) && (y < p2.getY()));
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
