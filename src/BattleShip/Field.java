package BattleShip;

import javafx.scene.Group;
import javafx.scene.layout.StackPane;

public class Field extends StackPane {
	public final static int TILE_SIZE = 50;
	// 10x10 board
	private final int HEIGHT = 10;
	private final int WIDTH = 10;
	
	private Group tileGroup = new Group();
	
	public Field() {
		setPrefSize(HEIGHT * TILE_SIZE, WIDTH * TILE_SIZE);
		getChildren().add(tileGroup);
		
		for(int y = 0; y < HEIGHT; y++) {
			for(int x = 0; x < WIDTH; x++) {
				Tile tile = new Tile(x, y, TILE_SIZE, false);
				
				tileGroup.getChildren().add(tile);
			}
		}
	}
}
