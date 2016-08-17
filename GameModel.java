import java.util.ArrayList;
import java.util.Observable;

public class GameModel extends Observable {
	GameMap map;
	PlayerUnit player;

	public GameModel(){
		this.map = new GameMap();
		this.player = new PlayerUnit();
	}

	public GameMap getMap(){ return this.map; }
	public PlayerUnit getPlayer() { return this.player; }

	public void setPlayerDir(char keyCode) {
		switch( keyCode ) {
			case 'w': // up
				player.setDirUp();
				break;
			case 's': // down
				player.setDirDown();
				break;
			case 'a': // left
				player.setDirLeft();
				break;
			case 'd': // right
				player.setDirRight();
				break;
			case 'v': // right
				player.setDirVerticalNull();
				break;
			case 'h': // right
				player.setDirHorizontalNull();
				break;
		}
	}

	public void step(){
		player.move();
	}
}
