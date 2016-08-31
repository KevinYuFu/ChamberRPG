import java.awt.*;
import java.lang.Math.*;

public class AimedAbility extends UnitAbility {
	int range;
	Point targetLoc;

	public AimedAbility(Unit unit, double cd, int range){
		super(unit, cd);
		this.range = range;
		targetLoc = new Point(0, 0);
		updateTargetLoc(((PlayerUnit)unit).getCursorCoordinate());
	}

	private void updateTargetLoc(Point cursor){
		// clean this up after
		int dx = cursor.getX() - (int)Math.round(this.unit.getXCoord());
		int dy = cursor.getY() - (int)Math.round(this.unit.getYCoord());

		int length = (int)Math.round(Math.sqrt(dx*dx + dy*dy));
		
		if (length > range) {
			double angle = Math.atan2(dx, dy);
			targetLoc.set((int)Math.round(this.unit.getXCoord() + (Math.sin(angle)*range)), 
						(int)Math.round(this.unit.getYCoord() + (Math.cos(angle)*range)));
		} else {
			targetLoc.set(cursor.getX(), cursor.getY());
		}
	}

	public void drawAbility(Graphics2D g2){
		updateTargetLoc(((PlayerUnit)unit).getCursorCoordinate());

		Color oldColor = g2.getColor();
		g2.setColor(Color.GREEN);
		g2.drawLine((int)Math.round(this.unit.getXCoord()), 
					(int)Math.round(this.unit.getYCoord()),
					targetLoc.getX(), targetLoc.getY());

		g2.setColor(oldColor);
		
	}
}
