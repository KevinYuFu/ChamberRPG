import java.awt.*;
import java.util.ArrayList;
import java.lang.Math.*;

public class Unit {
	double x;		// x position
	double y;		// y position
	double radius;	// radius of unit
	double speed;	// speed of unit
	double diagSp;	// speed when going at 45%
	double dx;		// change in x on next step
	double dy;		// change in y on next step

	public Unit(double x, double y, double r, double s) {
		this.x = x;
		this.y = y;
		this.radius = r;
		this.speed = s;
		this.diagSp = speed *  Math.sqrt(0.5);
		this.dx = 0;
		this.dy = 0;
	}

	public void setDirN(){ 
		this.dx = 0; 
		this.dy = -speed;
	}
	public void setDirS(){
		this.dx = 0; 
		this.dy = speed;
	}
	public void setDirE(){
		this.dx = speed;
		this.dy = 0; 
	}
	public void setDirW(){
		this.dx = -speed;
		this.dy = 0; 
	}
	public void setDirNE(){
		this.dx = diagSp;
		this.dy = -diagSp;
	}
	public void setDirNW(){
		this.dx = -diagSp;
		this.dy = -diagSp;
	}
	public void setDirSE(){
		this.dx = diagSp;
		this.dy = diagSp;
	}
	public void setDirSW(){
		this.dx = -diagSp;
		this.dy = diagSp;
	}
	public void setDirNull(){ 
		this.dx = 0; 
		this.dy = 0; 
	}


	public void move(){
		x += dx;
		y += dy;
		// For testing location of Unit
		//System.out.println("X: " + x);
		//System.out.println("Y: " + y);
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
