import java.awt.*;

public class PlayerUnit extends Unit {

	public PlayerUnit(GameMap map) {
		// Static Test values
		super(200, 200, 30, 5, map);
		this.abilityKit = new AbilityKit(new AimedAbility(this, 5, 100),
										new AimedAbility(this, 5, 100));
	}

	public void drawUnit(Graphics2D g2) {
		super.drawUnit(g2);
		this.abilityKit.drawTargetIndicator(g2);
	}
}
