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

	// Abilities effect on selection (Sustained effect)
	public void select() {}

	// Abilities effect on activation (Final Effect)
	public void activate() {
		// set cooldown counter
	}

	// Ability Drawing methods
	public abstract void drawAbility(Graphics2D g2);
	public abstract void drawTargetIndicator(Graphics2D g2);
}
