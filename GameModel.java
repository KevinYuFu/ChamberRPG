import java.util.ArrayList;
import java.util.Observable;

public class GameModel extends Observable {
	GameMap map;

	public GameModel(){
		this.map = new GameMap();
	}

	public GameMap getMap(){ return this.map; }
}
