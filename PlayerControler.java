import javax.swing.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// Player Controler is a controler for key input
// Move units with wasd
//
// will hardcode ability hotkeys but should be adjustable
public class PlayerControler implements KeyListener {
	GameModel model;
	boolean up;
	boolean down;
	boolean left;
	boolean right;

	public PlayerControler(GameModel m){
		this.model = m;
		this.up = false;
		this.down = false;
		this.left = false;
		this.right = false;
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

	private void updatePlayer(){
		int c = 8;
		if (up == down) { 
			if (left == right) { c = 8; }
			else if (left) { c = 6; }
			else { c = 2; }
		} else if (up) {
			if (left == right) { c = 0; }
			else if (left) { c = 7; }
			else { c = 1; }
		} else {
			if (left == right) { c = 4; }
			else if (left) { c = 5; }
			else { c = 3; }
		}
		model.setPlayerDir(c);
	}
	
}
