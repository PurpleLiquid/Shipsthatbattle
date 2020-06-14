package BattleShip;

public class Battlefield extends Field {
	public Battlefield() {
		
		
		// Place Tiles
		for(int y = 0; y < HEIGHT; y++) {
			for(int x = 0; x < WIDTH; x++) {
				InteractableTile tile = new InteractableTile(x, y, TILE_SIZE);
				
				tileGroup.getChildren().add(tile);
			}
		}
	}
}
