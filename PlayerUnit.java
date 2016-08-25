import java.awt.*;

public class PlayerUnit extends Unit {
	Point cursorPoint;
	UnitAbility activeAbility;

	public PlayerUnit(GameMap map) {
		// Static Test values
		super(200, 200, 30, 5, map);
		this.cursorPoint = new Point(200, 200);
		testAbility = new AimedAbility(this, 5, 50);
		activeAbility = testAbility; //new AimedAbility(this, 5, 50);
	}

	public void setCursorCoordinate(int x, int y){
		this.cursorPoint.set(x, y);
	}

	public Point getCursorCoordinate(){
		return this.cursorPoint;
	}
	
	public void drawUnit(Graphics2D g2) {
		super.drawUnit(g2);
		this.activeAbility.drawAbility(g2);
	}
}
