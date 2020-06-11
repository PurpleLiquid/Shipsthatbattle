package BattleShip.Util;

import BattleShip.Ship;

public class ShipSelector extends Observer {
	private Ship selectedShip;
	
	private ShipSelector() {
		this.selectedShip = null;
	}
	
	public Ship getSelected() {
		return selectedShip;
	}

	@Override
	public void update(Ship ship) {
		this.selectedShip = ship;
		
	} 
}
