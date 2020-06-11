package BattleShip;

import java.util.ArrayList;

import BattleShip.Util.Observer;

public class SetupField extends Field {
	// Should have ShipSelector in observers list
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	
	public SetupField() {
		super(); // Build the tiles
		
		setPrefSize(super.HEIGHT*super.TILE_SIZE, super.WIDTH*super.TILE_SIZE);
	}
}
