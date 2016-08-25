import java.awt.*;

// make this into an abstract class
public abstract class UnitAbility {
	// The time unit must wait before being able to cast this ability again
	Unit unit;
	double cooldown;

	public UnitAbility(Unit unit, double cd){
		this.unit = unit;
		this.cooldown = cd;
	}

	// What the ability does
	public void activate() {} // set cooldown counter

	// What ability looks like when active
	public abstract void drawAbility(Graphics2D g2);
}
