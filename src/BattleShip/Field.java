package BattleShip;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.paint.Color;

public class Field extends Parent {
	public final static int TILE_SIZE = 50;
	
	// 10x10 board
	protected final int HEIGHT = 10;
	protected final int WIDTH = 10;
	
	protected Group tileGroup = new Group();
	
	public Field(Color playerColor) {
		getChildren().add(tileGroup);
		setStyle("-fx-border-color: black");
	}
}
