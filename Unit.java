import java.awt.*;
import java.util.ArrayList;
import java.lang.Math.*;

public class Unit {
	// Unit Properties
	double x;		// x position
	double y;		// y position
	double radius;	// radius of unit
	double speed;	// speed of unit
	double diagSp;	// speed when going at an angle (45%)
	double dx;		// change in x on next step
	double dy;		// change in y on next step

	// Unit Abilities
	AbilityKit abilityKit;

	// the current map tha player is on
	GameMap map;	

	public Unit(double x, double y, double r, double s, GameMap m) {
		this.x = x;
		this.y = y;
		this.radius = r;
		this.speed = s;
		this.diagSp = speed *  Math.sqrt(0.5);
		this.dx = 0;
		this.dy = 0;

		this.map = m;
	}

	public double getXCoord() {
		return this.x;
	}

	public double getYCoord() {
		return this.y;
	}

	public void setDir(char c){
		switch(c){
			case 'w': 	// up
				this.dx = 0;
				this.dy = -speed;
				break;
			case 'x': 	// down
				this.dx = 0;
				this.dy = speed;
				break;
			case 'a': 	// left
				this.dx = -speed;
				this.dy = 0;
				break;
			case 'd': 	// right
				this.dx = speed;
				this.dy = 0;
				break;
			case 'q': 	// up left
				this.dx = -diagSp;
				this.dy = -diagSp;
				break;
			case 'e': 	// up right
				this.dx = diagSp;
				this.dy = -diagSp;
				break;
			case 'z': 	// down left
				this.dx = -diagSp;
				this.dy = diagSp;
				break;
			case 'c': 	// down right
				this.dx = diagSp;
				this.dy = diagSp;
				break;
			case 's': 	// neutral
				this.dx = 0;
				this.dy = 0;
				break;
		}
	}


	public void move(){
		int xResponse = map.inXBound((int)Math.round(x + dx), (int)Math.round(radius));
		if (xResponse >= 0) {
			x = xResponse;
		} else if (xResponse == -2) {
			System.out.println ("There seems to be an error with boundary");
		} else {
			x += dx;
		}
		
		int yResponse = map.inYBound((int)Math.round(y + dy), (int)Math.round(radius));
		if (yResponse >= 0) {
			y = yResponse;
		} else if (yResponse == -2) {
			System.out.println ("There seems to be an error with boundary");
		} else {
			y += dy;
		}
	}

	public void drawUnit(Graphics2D g2) {
		int px = (int)Math.round(x - radius);
		int py = (int)Math.round(y - radius);
		int diameter = (int)Math.round(2*radius);

		Stroke oldStroke = g2.getStroke();
		g2.setStroke(new BasicStroke(3));

		Color oldColor = g2.getColor();
		g2.setColor(Color.BLACK); 
		g2.fillOval(px, py, diameter, diameter);

		g2.setColor(oldColor);
		g2.drawOval(px, py, diameter, diameter);

		g2.setStroke(oldStroke);
	}

}
