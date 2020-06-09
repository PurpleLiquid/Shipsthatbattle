package BattleShip;

import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

public class ResourceBox extends FlowPane {
	
	// For Ships will refactor later
	public final static int TILE_SIZE = 50;
	protected final int HEIGHT = 10;
	protected final int WIDTH = 10;
	
	public ResourceBox() {
		setStyle("-fx-border-color: black");
		setOrientation(Orientation.VERTICAL);
		setVgap(20);
		
		// Title for the box
		Label title = new Label("Available Ships");
		getChildren().add(title);
		
		// Carrier
		Ship carrier = new Ship(TILE_SIZE, 5, 0);
		getChildren().add(carrier);
		
		// Battleship
		Ship battleship = new Ship(TILE_SIZE, 4, 1);
		getChildren().add(battleship);
		
		// Cruiser
		Ship cruiser = new Ship(TILE_SIZE, 3, 2);
		getChildren().add(cruiser);
		
		// Submarine?
		Ship sub = new Ship(TILE_SIZE, 3, 3);
		getChildren().add(sub);
		
		// Destroyer
		Ship destroyer = new Ship(TILE_SIZE, 2, 4);
		getChildren().add(destroyer);
	}
}
