import java.awt.*;

public class ToggleAbility extends UnitAbility{
	boolean simulCast = false;
	boolean active = false;

	public ToggleAbility(Unit unit, double cd, boolean simulCast){
		super(unit, cd);
		this.simulCast = simulCast;
	}

	public void toggleActive(){
		active = !active;
	}

	public void drawAbility(Graphics2D g2){

	}
}
