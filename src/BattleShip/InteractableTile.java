package BattleShip;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class InteractableTile extends Rectangle {
	
	public InteractableTile(int x, int y, double tileSize) {
		setFill(Color.LIGHTGREY);
		setStroke(Color.BLACK);
		
		setWidth(tileSize);
		setHeight(tileSize);
		relocate(x*tileSize, y*tileSize);
	}
}
