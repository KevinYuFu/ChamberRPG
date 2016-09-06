import java.awt.*;
import java.lang.Math.*;

public class AimedAbility extends UnitAbility {
	int range;
	Point targetLoc;

	public AimedAbility(Unit unit, double cd, int range){
		super(unit, cd);
		this.range = range;
		targetLoc = new Point(0, 0);
		updateTargetLocation();
	}

	private void updateTargetLocation() {
		Point target = unit.getTargetLocation();

		int dx = target.getX() - (int)Math.round(this.unit.getXCoord());
		int dy = target.getY() - (int)Math.round(this.unit.getYCoord());

		int length = (int)Math.round(Math.sqrt(dx*dx + dy*dy));
		
		if (length > range) {
			double angle = Math.atan2(dx, dy);
			targetLoc.set((int)Math.round(this.unit.getXCoord() + (Math.sin(angle)*range)), 
						(int)Math.round(this.unit.getYCoord() + (Math.cos(angle)*range)));
		} else {
			targetLoc.set(target.getX(), target.getY());
		}
	}

	public void activate(){
		super.activate();
		updateTargetLocation();
	}

	public void drawAbility(Graphics2D g2){}

	public void drawTargetIndicator(Graphics2D g2){
		updateTargetLocation();

		Color oldColor = g2.getColor();
		g2.setColor(Color.GREEN);
		g2.drawLine((int)Math.round(this.unit.getXCoord()), 
					(int)Math.round(this.unit.getYCoord()),
					targetLoc.getX(), targetLoc.getY());

		g2.setColor(oldColor);
	}
}
