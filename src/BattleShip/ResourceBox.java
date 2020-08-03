package BattleShip;

import BattleShip.Util.ClickObserver;
import BattleShip.Util.ShipSelector;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;

public class ResourceBox extends FlowPane {
	
	// For Ships will refactor later
	public final static int TILE_SIZE = 50;
	protected final int HEIGHT = 10;
	protected final int WIDTH = 10;
	
	// Observer
	private ClickObserver selector = new ClickObserver();
	
	private boolean horizontal = true;
	
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
		
		// Rotate orientation of ships
		Label orientationLabel = new Label("Horizontal");
		getChildren().add(orientationLabel);
		
		EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				horizontal = !horizontal;
				
				if(horizontal) {
					orientationLabel.setText("Horizontal");
				} else {
					orientationLabel.setText("Vertical");
				}
				
				ShipSelector.getInstance().setHorizontal(horizontal);
			}
		};
		
		Button rotationButton = new Button();
		rotationButton.getStyleClass().add("arrow-button");
		rotationButton.setOnMouseClicked(eventHandler);
		getChildren().add(rotationButton);
	}
}
