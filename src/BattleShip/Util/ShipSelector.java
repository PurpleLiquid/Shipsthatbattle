package BattleShip.Util;

import BattleShip.Ship;

public class ShipSelector {
	private Ship selectedShip;
	private boolean horizontal = true;
	private static ShipSelector instance = null;

	private ShipSelector() {
		selectedShip = null;
	}

	public void setSelected(Ship ship) {
		selectedShip = ship;
	}

	public Ship getSelected() {
		return selectedShip;
	}
	
	public void setHorizontal(boolean isHorizontal) {
		this.horizontal = isHorizontal;
	}
	
	public boolean isHorizontal() {
		return horizontal;
	}

	public static ShipSelector getInstance() {
		if(instance == null) {
			instance = new ShipSelector();
		}

		return instance;
	} 
}