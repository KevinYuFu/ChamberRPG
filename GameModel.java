import java.util.ArrayList;
import java.util.Observable;

public class GameModel extends Observable {
	GameMap map;
	PlayerUnit player;

	public GameModel(){
		this.map = new GameMap();
		this.player = new PlayerUnit(this.map);
	}

	public GameMap getMap(){ return this.map; }
	public PlayerUnit getPlayer() { return this.player; }

	public void setCursorCoordinate(int x, int y){
		this.player.setCursorCoordinate(x, y);
	}

	public void setPlayerDir(int direction) {	//(char keyCode) {
		switch ( direction ) {
			case 0: //
				player.setDirN();
				break;
			case 1: //
				player.setDirNE();
				break;
			case 2: //
				player.setDirE();
				break;
			case 3: //
				player.setDirSE();
				break;
			case 4: //
				player.setDirS();
				break;
			case 5: //
				player.setDirSW();
				break;
			case 6: //
				player.setDirW();
				break;
			case 7: //
				player.setDirNW();
				break;
			case 8: //
				player.setDirNull();
				break;
		}
	}

	public void step(){
		player.move();
	}
}
