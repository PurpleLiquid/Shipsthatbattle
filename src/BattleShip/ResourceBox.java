package BattleShip;

import BattleShip.Util.ClickObserver;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

public class ResourceBox extends FlowPane {
	
	// For Ships will refactor later
	public final static int TILE_SIZE = 50;
	protected final int HEIGHT = 10;
	protected final int WIDTH = 10;
	
	// Observer
	ClickObserver selector = new ClickObserver();
	
	public ResourceBox() {
		setStyle("-fx-border-color: black");
		getStylesheets().add("BattleShip/Styles/Buttons.css");
		setOrientation(Orientation.VERTICAL);
		setVgap(20);
		
		// Title for the box
		Label title = new Label("Available Ships");
		getChildren().add(title);
		
		// Carrier
		Ship carrier = new Ship("Carrier", TILE_SIZE, 5, 0);
		carrier.attach(selector);
		getChildren().add(carrier);
		
		// Battleship
		Ship battleship = new Ship("Battleship", TILE_SIZE, 4, 1);
		battleship.attach(selector);
		getChildren().add(battleship);
		
		// Cruiser
		Ship cruiser = new Ship("Cruiser", TILE_SIZE, 3, 2);
		cruiser.attach(selector);
		getChildren().add(cruiser);
		
		// Submarine?
		Ship sub = new Ship("Submarine", TILE_SIZE, 3, 3);
		sub.attach(selector);
		getChildren().add(sub);
		
		// Destroyer
		Ship destroyer = new Ship("Destroyer", TILE_SIZE, 2, 4);
		destroyer.attach(selector);
		getChildren().add(destroyer);
		
		// For later use
		// Rotate orientation of ships
		Button rotationButton = new Button();
		rotationButton.getStyleClass().add("arrow-button");
		getChildren().add(rotationButton);
	}
}
