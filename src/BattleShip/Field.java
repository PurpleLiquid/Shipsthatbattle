package BattleShip;

import javafx.scene.Group;
import javafx.scene.layout.FlowPane;

public class Field extends FlowPane {
	public final static int TILE_SIZE = 50;
	
	// 10x10 board
	protected final int HEIGHT = 10;
	protected final int WIDTH = 10;
	
	private Group tileGroup = new Group();
	
	public Field() {
		getChildren().add(tileGroup);
		setStyle("-fx-border-color: black");
		
		for(int y = 0; y < HEIGHT; y++) {
			for(int x = 0; x < WIDTH; x++) {
				InteractableTile tile = new InteractableTile(x, y, TILE_SIZE);
				
				tileGroup.getChildren().add(tile);
			}
		}
	}
}
