package BattleShip;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * This class is purely for visuals
 * Needed to differentiate the ship tiles that are only visual and the basic tiles which are interactable
 */
public class ShipTile extends Rectangle {
	
	public ShipTile(int x, int y, double tileSize) {
		setFill(Color.BLUE);
		setStroke(Color.BLACK);
		
		setWidth(tileSize);
		setHeight(tileSize);
		relocate(x*tileSize, y*tileSize);
	}
}
