package BattleShip.Util;

import java.util.ArrayList;

import BattleShip.Ship;

/**
 * This observer is only used during setup
 *
 */
public abstract class Observer {
	protected ArrayList<Ship> subjects = new ArrayList<Ship>();
	
	public abstract void update(Ship ship);
}
