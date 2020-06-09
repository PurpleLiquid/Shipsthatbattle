package BattleShip.Util;

import BattleShip.Ship;
import BattleShip.Tile;
import javafx.scene.paint.Color;

public class ClickObserver extends Observer {
	private Ship previousShip;
	
	// For ships when clicked on during setup
	public ClickObserver() {
	}

	@Override
	public void update(Ship selectedShip) {
		// Reset previously selected ship to un-selected
		int size;
		
		if(previousShip != null) {
			size = previousShip.getChildren().size();
			
			for(int i = 0; i < size; i++) {
				Tile tile = (Tile) previousShip.getChildren().get(i);
				tile.setStroke(Color.BLACK);
			}
		}
		
		// Highlight selected ship
		size = selectedShip.getChildren().size();
		
		for(int i = 0; i < size; i++) {
			Tile tile = (Tile) selectedShip.getChildren().get(i);
			tile.setStroke(Color.YELLOW);
		}
		
		// Update
		this.previousShip = selectedShip;
	}
	
	public void addShip(Ship ship) {
		subjects.add(ship);
	}
	
	public void setPreShip(Ship ship) {
		this.previousShip = ship;
	}
}
