package BattleShip;

public class SetupField extends Field {
	public SetupField() {
		super(); // Build the tiles
		
		// 1.5 is just a modifier
		// without modifier, window will fit 10x10 tiles
		setPrefSize(super.HEIGHT*super.TILE_SIZE, super.WIDTH*super.TILE_SIZE);
	}
}
