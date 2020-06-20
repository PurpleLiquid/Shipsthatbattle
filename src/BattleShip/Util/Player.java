package BattleShip.Util;

import BattleShip.Field;
import BattleShip.SetupField;
import javafx.scene.paint.Color;

public class Player {
	private SetupField playerField;
	private Color playerColor;
	
	public Player(Color playerColor) {
		this.playerColor = playerColor;
		playerField = new SetupField(playerColor);
	}
	
	public Color getPlayerColor() {
		return this.playerColor;
	}
	
	public Field getField() {
		return this.playerField;
	}
}
