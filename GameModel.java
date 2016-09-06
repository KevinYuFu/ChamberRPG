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

	public void step(){
		player.move();
	}
}
