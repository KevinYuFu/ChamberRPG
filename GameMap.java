import java.awt.*;
import java.util.ArrayList;

public class GameMap{
	ArrayList<Region> walkableRegions;

	public GameMap(){
		walkableRegions = new ArrayList<Region>();
		// temporary static grid size
		walkableRegions.add(new Region(50, 50, 750, 550));
	}

	// return walkable Regions
	public ArrayList<Region> getWalkableRegions() { return walkableRegions; }

	// Checks co-ordinates for given points.
	// returns true if points are valid
	// // Probably want to add a radius check or something mroe than a point
	public boolean inBound(int x, int y){
		for (int i = 0; i < walkableRegions.size(); ++i){
			if (!walkableRegions.get(i).inRegion(x, y)){
				return false;
			}
		}
		return true;
	}

	public void drawWalkable(Graphics2D g2) {
		Stroke oldStroke = g2.getStroke();
		g2.setStroke(new BasicStroke(2));

		for (int i = 0; i < walkableRegions.size(); ++i) {
			walkableRegions.get(i).drawRegion(g2);
		}

		g2.setStroke(oldStroke);
	}

	public void drawMap(Graphics2D g2) {
		drawWalkable(g2);
	}
}
