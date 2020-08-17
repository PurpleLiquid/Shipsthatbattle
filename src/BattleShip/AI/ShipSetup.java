package BattleShip.AI;

import BattleShip.Ship;

/*
 * This class is only to setup ships for AI
 */
public class ShipSetup {
	public final static int TILE_SIZE = 50;
	
	private Ship carrier;
	private Ship battleship;
	private Ship cruiser;
	private Ship sub;
	private Ship destroyer;
	
	public ShipSetup() {
		carrier = new Ship("Carrier", TILE_SIZE, 5, 0);
		battleship = new Ship("Battleship", TILE_SIZE, 4, 1);
		cruiser = new Ship("Cruiser", TILE_SIZE, 3, 2);
		sub = new Ship("Submarine", TILE_SIZE, 3, 3);
		destroyer = new Ship("Destroyer", TILE_SIZE, 2, 4);
	}
	
	public ArrayList<Ship> getShips() {
		
		return null;
	}
}
