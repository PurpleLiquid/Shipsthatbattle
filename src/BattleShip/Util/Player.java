package BattleShip.Util;

import BattleShip.BattleField;
import BattleShip.SetupField;
import javafx.scene.paint.Color;

public class Player {
	private SetupField setupField;
	private BattleField battleField;
	private Color playerColor;
	
	public Player(Color playerColor) {
		this.playerColor = playerColor;
		setupField = new SetupField(playerColor);
	}
	
	public Color getPlayerColor() {
		return this.playerColor;
	}
	
	public SetupField getSetupField() {
		return this.setupField;
	}
	
	public BattleField getBattleField() {
		if(battleField == null) {
			battleField = new BattleField(playerColor);
		}
		
		return battleField;
	}
}
