package BattleShip;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Ship extends Rectangle {
	public Ship(int x, int y, double tileSize, int shipSize) {
		setFill(Color.LIGHTGREY);
		setStroke(Color.BLACK);
		
		setWidth(tileSize);
		setHeight(tileSize);
		relocate(x*tileSize, y*tileSize);
	}
}
