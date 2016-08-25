import java.awt.*;

public abstract class PowerUpAbility extends UnitAbility{
	// I believe that this needs to know about it's owner
	// Will alter values of this unit

	public PowerUpAbility(Unit unit, double cd){
		super(unit, cd);
	}
}
