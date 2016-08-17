import javax.swing.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
		if (up == down) { model.setPlayerDir('v'); }
		else if (up) {model.setPlayerDir('w'); }
		else if (down) {model.setPlayerDir('s'); }

		if (left == right) { model.setPlayerDir('h'); }
		else if (left) { model.setPlayerDir('a'); }
		else if (right) { model.setPlayerDir('d'); }
	}
	
}
