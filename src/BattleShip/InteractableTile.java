package BattleShip;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class InteractableTile extends Rectangle {
	// Rectangle already has an x and y but I need this for board placement
	private int x, y;
	private boolean alive = true;
	private boolean isShipTile = false;
	
	public InteractableTile(int x, int y, double tileSize) {
		setFill(Color.LIGHTGREY);
		setStroke(Color.BLACK);
		
		setWidth(tileSize);
		setHeight(tileSize);
		relocate(x*tileSize, y*tileSize);
		
		this.x = x;
		this.y = y;
	}
	
	public int getPlacementX() {
		return this.x;
	}
	
	public int getPlacementY() {
		return this.y;
	}
	
	public void isShipTile(boolean isShipTile) {
		this.isShipTile = isShipTile;
	}
	
	public boolean hasShip() {
		return isShipTile;
	}
	
	// For battlefield use
	public boolean isAlive() {
		return alive;
	}
	
	public void kill() {
		alive = false;
	}
}