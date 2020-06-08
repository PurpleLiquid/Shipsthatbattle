package BattleShip;

import javafx.scene.Group;
import javafx.scene.paint.Color;

public class Ship extends Group {
	public Ship(double tileSize, int shipSize, int shipNum) {
		// Build Ship model
		for(int x = 0; x < shipSize; x++) {
			Tile tile = new Tile(x, shipNum, tileSize);
			tile.setFill(Color.BLUE);
			
			getChildren().add(tile);
		}
	}
}
