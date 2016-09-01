import java.awt.*;

public class PlayerUnit extends Unit {
	Point cursorPoint;

	public PlayerUnit(GameMap map) {
		// Static Test values
		super(200, 200, 30, 5, map);
		this.cursorPoint = new Point(200, 200);
		this.abilityKit = new AbilityKit(new AimedAbility(this, 5, 100),
										new AimedAbility(this, 5, 100));
	}

	// Sets an ability as it's current selected ability
	// ability will indicat it's selection before it's activated
	public void selectAbility(char c){
		// do something
	}

	// use the ability that is selected
	public void activateAblity(){
		// activate ability
	}

	public void setCursorCoordinate(int x, int y){
		this.cursorPoint.set(x, y);
	}

	public Point getCursorCoordinate(){
		return this.cursorPoint;
	}
	
	public void drawUnit(Graphics2D g2) {
		super.drawUnit(g2);
		this.abilityKit.drawAbilities(g2);
	}
}
