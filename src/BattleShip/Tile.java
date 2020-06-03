package BattleShip;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle {
	private boolean hasHit = false;
	
	public Tile(int x, int y, double tileSize, boolean hasHit) {
		this.hasHit = hasHit;
		
		setFill(Color.LIGHTGREY);
		setStroke(Color.BLACK);
		
		setWidth(tileSize);
		setHeight(tileSize);
		relocate(x*tileSize, y*tileSize);
	}
	
	public void setHit(boolean hit) {
		this.hasHit = hit;
	}
}
