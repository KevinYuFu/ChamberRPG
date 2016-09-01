import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// Player Controller is a controler for key input
// Move units with wasd
//
// will hardcode ability hotkeys but should be adjustable
public class PlayerController extends UnitController implements KeyListener {
	// The Controled Unit
	Unit unit;

	// Mouse Variables
	int mx;
	int my;

	// Movement Boolean Variables
	boolean up;
	boolean down;
	boolean left;
	boolean right;

	public PlayerController(Unit u){
		this.unit = u;
		this.up = false;
		this.down = false;
		this.left = false;
		this.right = false;
	}

	public void updateCursorCoord(int x, int y){
		this.mx = x;
		this.my = y;
	}

	public void leftMousePress(){
		//do something
	}

	public void leftMouseRelease(){
		//do something
	}

	public void keyPressed(KeyEvent e){
		if (e.getKeyChar() == 'w') { this.up = true; }
		if (e.getKeyChar() == 'a') { this.left = true; }
		if (e.getKeyChar() == 's') { this.down = true; }
		if (e.getKeyChar() == 'd') { this.right = true; }
		updatePlayer();
	}

	public void keyTyped(KeyEvent e){}

	public void keyReleased(KeyEvent e){
		if (e.getKeyChar() == 'w') { this.up = false; }
		if (e.getKeyChar() == 'a') { this.left = false; }
		if (e.getKeyChar() == 's') { this.down = false; }
		if (e.getKeyChar() == 'd') { this.right = false; }
		updatePlayer();
	}

	// calculate direction the intended direction and tells the unit
	private void updatePlayer(){
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
