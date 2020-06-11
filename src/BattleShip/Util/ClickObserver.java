package BattleShip.Util;

import BattleShip.Ship;
import BattleShip.ShipTile;
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
				ShipTile tile = (ShipTile) previousShip.getChildren().get(i);
				tile.setStroke(Color.BLACK);
			}
		}
		
		// Highlight selected ship
		size = selectedShip.getChildren().size();
		
		for(int i = 0; i < size; i++) {
			ShipTile tile = (ShipTile) selectedShip.getChildren().get(i);
			tile.setStroke(Color.YELLOW);
		}
		
		// Update
		this.previousShip = selectedShip;
		ShipSelector.getInstance().setSelected(selectedShip);
	}
	
	public void setPreShip(Ship ship) {
		this.previousShip = ship;
	}
}
