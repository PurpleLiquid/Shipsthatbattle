package BattleShip.Exceptions;

public class InvalidShipAmount extends Exception {

	private static final long serialVersionUID = 1L;
	
	public InvalidShipAmount(String msg) {
		super(msg);
	}
}
