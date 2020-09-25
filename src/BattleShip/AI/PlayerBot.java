package BattleShip.AI;

import BattleShip.Util.Player;
import javafx.scene.paint.Color;

public class PlayerBot extends Player {
	private ShipSetup ss = new ShipSetup();

	public PlayerBot(Color playerColor) {
		super(playerColor);
		setupField.setShips(ss.getShips());
	}
}
