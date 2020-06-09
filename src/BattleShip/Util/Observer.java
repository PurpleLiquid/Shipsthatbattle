package BattleShip.Util;

import BattleShip.Ship;

/**
 * This observer is only used during setup
 *
 */
public abstract class Observer {
	protected Ship subject;
	
	public abstract void update();
}
