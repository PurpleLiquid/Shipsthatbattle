package BattleShip;

public class SetupField extends Field {
	
	
	public SetupField() {
		super(); // Build the tiles
		
		setPrefSize(super.HEIGHT*super.TILE_SIZE, super.WIDTH*super.TILE_SIZE);
	}
}
