package BattleShip;

import javafx.scene.paint.Color;

public class Battlefield extends Field {

	public Battlefield(Color playerColor) {
		super(playerColor);
		
		
		// Place Tiles
		for(int y = 0; y < HEIGHT; y++) {
			for(int x = 0; x < WIDTH; x++) {
				InteractableTile tile = new InteractableTile(x, y, TILE_SIZE);
				//tile.setOnMouseClicked(eventHandler);
				
				tileGroup.getChildren().add(tile);
			}
		}
	}

}
