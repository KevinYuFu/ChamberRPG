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

	// Checks is x co-ordinate is in x bound
	// returns int of bound if points are valid
	public int inXBound(int x, int rad){
		for (int i = 0; i < walkableRegions.size(); ++i){
			if (walkableRegions.get(i).inRegionXBound(x, 0) == -1){
				return walkableRegions.get(i).inRegionXBound(x, rad);
			}
		}
		return -2;
	}

	// Checks is x co-ordinate is in x bound
	// returns int of bound if points are valid
	public int inYBound(int y, int rad){
		for (int i = 0; i < walkableRegions.size(); ++i){
			if (walkableRegions.get(i).inRegionYBound(y, 0) == -1){
				return walkableRegions.get(i).inRegionYBound(y, rad);
			}
		}
		return -2;
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
