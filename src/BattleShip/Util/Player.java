package BattleShip.Util;

import BattleShip.Battlefield;
import BattleShip.Field;
import BattleShip.SetupField;
import javafx.scene.paint.Color;

public class Player {
	private SetupField setupField;
	private Battlefield battleField;
	private Color playerColor;
	
	public Player(Color playerColor) {
		this.playerColor = playerColor;
		setupField = new SetupField(playerColor);
	}
	
	public Color getPlayerColor() {
		return this.playerColor;
	}
	
	public Field getSetupField() {
		return this.setupField;
	}
	
	public Field getBattleField() {
		if(battleField == null) {
			battleField = new Battlefield(playerColor);
			battleField.setCarrier(setupField.getCarrier());
			battleField.setBattleship(setupField.getBattleship());
			battleField.setCruiser(setupField.getCruiser());
			battleField.setSubmarine(setupField.getSubmarine());
			battleField.setDestroyer(setupField.getDestroyer());
		}
		
		return battleField;
	}
}
