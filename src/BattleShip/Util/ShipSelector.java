package BattleShip.Util;

import BattleShip.Ship;

public class ShipSelector {
	private Ship selectedShip;
	private static ShipSelector instance = null;

	private ShipSelector() {
		selectedShip = null;
	}

	public void setSelected(Ship ship) {
		this.selectedShip = ship;
	}

	public Ship getSelected() {
		return selectedShip;
	}

	public static ShipSelector getInstance() {
		if(instance == null) {
			instance = new ShipSelector();
		}

		return instance;
	} 
}