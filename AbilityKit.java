import java.awt.*;

// Class that holds all abilities that a unit possesses
public class AbilityKit {
	UnitAbility selectedAbility;

	UnitAbility primaryAbility;
	UnitAbility secondaryAbility;

	// add a dictionary structure to hold additional abilities
	
	// abiltyKit constructor sets a primary and secondary ability
	public AbilityKit(UnitAbility prime, UnitAbility secondary) {
		this.primaryAbility = prime;
		this.secondaryAbility = secondary;
	}

	// adds aditional abilities to kit
	// each ability is asigned to a char c that activates the ability\
	// Note that the char should not be w,a,s,d would conflict with movement
	public void addAbility(char c, UnitAbility ability){
		// add ability to structure
	}

	// Sets an ability as current selected ability
	public void selectAbility(char c){
		// set an ability as Selected
		if (c == 'a') {
			selectedAbility = primaryAbility;
		} else if (c == 's') {
			selectedAbility = secondaryAbility;
		}
	}

	// deselects Ability
	public void deselectAbility(){
		selectedAbility = null;
	}

	// Activates selected ability
	public void activateAbility(){
		// activate selected ability
		deselectAbility();
	}

	// Draw current selected ability
	public void drawAbilities(Graphics2D g2) {
		if (selectedAbility != null) {
			this.selectedAbility.drawAbility(g2);
		}
	}

	// Draw target indicator of selected ability
	public void drawTargetIndicator(Graphics2D g2) {
		if (selectedAbility != null) {
			this.selectedAbility.drawTargetIndicator(g2);
		}
	}
}
