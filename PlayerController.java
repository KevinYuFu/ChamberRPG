import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// Player Controller is a controler for key input
// Move units with wasd
//
// will hardcode ability hotkeys but should be adjustable
public class PlayerController extends UnitController implements KeyListener {
	// The Controller Unit
	PlayerUnit unit;

	// Mouse Variables
	int mx;
	int my;

	// Movement Boolean Variables
	boolean up;
	boolean down;
	boolean left;
	boolean right;

	public PlayerController(PlayerUnit u){
		this.unit = u;
		this.up = false;
		this.down = false;
		this.left = false;
		this.right = false;
	}

	public void updateCursorLocation(int x, int y){
		this.mx = x;
		this.my = y;

		unit.setTargetLocation(x, y);
		//System.out.println("x: " + x);
		//System.out.println("y: " + y);
	}

	public void leftMousePress(){
		//do something
		selectAbility('a');
	}

	public void leftMouseRelease(){
		//do something
		activateAbility();
	}

	public void rightMousePress(){
		//do something
	}

	public void rightMouseRelease(){
		//do something
	}

	public void keyPressed(KeyEvent e){
		if (e.getKeyChar() == 'w') { this.up = true; }
		if (e.getKeyChar() == 'a') { this.left = true; }
		if (e.getKeyChar() == 's') { this.down = true; }
		if (e.getKeyChar() == 'd') { this.right = true; }
		updateUnitDir();
	}

	public void keyTyped(KeyEvent e){}

	public void keyReleased(KeyEvent e){
		if (e.getKeyChar() == 'w') { this.up = false; }
		if (e.getKeyChar() == 'a') { this.left = false; }
		if (e.getKeyChar() == 's') { this.down = false; }
		if (e.getKeyChar() == 'd') { this.right = false; }
		updateUnitDir();
	}

	// Tell unit which ability to select
	// 		'a' => Primary skill
	// 		's' => Seconday skill
	private void selectAbility(char c){
		unit.selectAbility(c);
	}

	private void activateAbility(){
		unit.activateAbility();
	}

	// calculate direction the intended direction and tells the unit
	private void updateUnitDir(){
		char dir = 's';
		if (up == down) { 
			if (left == right) { dir = 's'; }
			else if (left) { dir = 'a'; }
			else { dir = 'd'; }
		} else if (up) {
			if (left == right) { dir = 'w'; }
			else if (left) { dir = 'q'; }
			else { dir = 'e'; }
		} else {
			if (left == right) { dir = 'x'; }
			else if (left) { dir = 'z'; }
			else { dir = 'c'; }
		}
		unit.setDir(dir);
	}
	
}
