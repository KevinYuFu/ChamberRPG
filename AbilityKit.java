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
	public void selectAbiltiy(char c){
		// set an ability as Selected
	}

	// deselects Ability
	public void deselectAbiltiy(){
		selectedAbility = null;
	}

	// Activates selected ability
	public void activateAbility(){
		// activate selected ability
	}

	// Draws current selected ability
	public void drawAbilities(Graphics2D g2) {
		if (selectedAbility != null) {
			this.selectedAbility.drawAbility(g2);
		}
	}
}
