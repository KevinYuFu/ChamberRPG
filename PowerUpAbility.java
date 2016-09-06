import java.awt.*;

public class PowerUpAbility extends UnitAbility{
	// I believe that this needs to know about it's owner
	// Will alter values of this unit

	public PowerUpAbility(Unit unit, double cd){
		super(unit, cd);
	}

	public void drawAbility(Graphics2D g2){}
	public void drawTargetIndicator(Graphics2D g2){}
}
