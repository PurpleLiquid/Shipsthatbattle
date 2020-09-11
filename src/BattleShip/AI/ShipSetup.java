package BattleShip.AI;

import java.util.ArrayList;

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
		
		placeShips();
	}
	
	public ArrayList<Ship> getShips() {
		ArrayList<Ship> ships = new ArrayList<Ship>();
		
		ships.add(carrier);
		ships.add(battleship);
		ships.add(cruiser);
		ships.add(sub);
		ships.add(destroyer);
		
		return ships;
	}
	
	private void placeShips()
	{
		// This is meant to just set ship's origin x and y placement
		// As well as whether they will be vertical or horizontal
		
		// Carrier
		carrier.setOriginX(2);
		carrier.setOriginY(0);
		
		// Battleship
		battleship.setOriginX(9);
		battleship.setOriginY(2);
		
		// cruiser
		cruiser.setOriginX(3);
		cruiser.setOriginY(3);
		cruiser.setHorizontal(true);
		
		// sub
		sub.setOriginX(5);
		sub.setOriginY(3);
		sub.setHorizontal(true);
		
		// destroyer
		destroyer.setOriginX(8);
		destroyer.setOriginY(2);
	}
}
