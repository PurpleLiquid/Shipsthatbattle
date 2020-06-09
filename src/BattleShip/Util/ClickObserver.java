package BattleShip.Util;

import BattleShip.Ship;
import BattleShip.Tile;
import javafx.scene.paint.Color;

public class ClickObserver extends Observer {
	// For ships when clicked on during setup
	public ClickObserver(Ship ship) {
		this.subject = ship;
	}

	@Override
	public void update() {
		int size = this.subject.getChildren().size();
		
		for(int i = 0; i < size; i++) {
			Tile tile = (Tile) this.subject.getChildren().get(i);
			tile.setStroke(Color.YELLOW);
		}
	}
	
}
