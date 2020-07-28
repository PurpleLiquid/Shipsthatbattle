package BattleShip;

import java.util.ArrayList;

import BattleShip.Exceptions.InvalidShipAmount;
import BattleShip.Util.ShipSelector;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class BattleField extends Pane {
	// 10x10 board
	protected final int HEIGHT = 10;
	protected final int WIDTH = 10;
	public final static int TILE_SIZE = 50;
	
	protected Group tileGroup = new Group();
	
	private ArrayList<Ship> shipList = new ArrayList<Ship>();
	Color playerColor;

	public BattleField(Color playerColor) {
		getChildren().add(tileGroup);
		setStyle("-fx-border-color: black");
		this.playerColor = playerColor;
		
		// For "attacking" tiles
		EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
			 @Override 
	         public void handle(MouseEvent e) { 
				 InteractableTile tile = (InteractableTile) e.getSource();
				 
				 if(tile.isAlive()) {
					 // Marking whether tile has enemy ship or not
					 if(playerColor == Color.BLUE && tile.hasShip()) { // Player 1 hit
						 tile.setFill(Color.RED);
					 } else if(playerColor == Color.RED && tile.hasShip()) { // Player 2 hit
						 tile.setFill(Color.BLUE);
					 } else { // Miss
						 tile.setFill(Color.BLACK);
					 }
					 
					 tile.kill();
				 }
	         } 
		};
		
		// Place Tiles
		for(int y = 0; y < HEIGHT; y++) {
			for(int x = 0; x < WIDTH; x++) {
				InteractableTile tile = new InteractableTile(x, y, TILE_SIZE);
				
				tile.setOnMouseClicked(eventHandler);
				tileGroup.getChildren().add(tile);
			}
		}
	}
	
	public void setShips(ArrayList<Ship> ships) throws InvalidShipAmount {
		if(ships.size() < 5 || ships.size() > 5) {
			throw new InvalidShipAmount("There is an incorrect number of ships");
		}
		
		shipList = ships;
		
		// Placing ships in BattleField obtained from SetupField
		for(int i = 0; i < shipList.size(); i++) {
			Ship ship = shipList.get(i);
			InteractableTile tile = (InteractableTile) tileGroup.getChildren().get((ship.getOriginY()*10) + ship.getOriginX());
			
			for(int j = 1; j < ship.getShipSize(); j++) {
        		tile.isShipTile(true);
        		
        		if(ship.getOriginX() <= 5) {
        			int incIndex = ((ship.getOriginY()*10) + ship.getOriginX()) + j;
        			tile = (InteractableTile) tileGroup.getChildren().get(incIndex);
        		} else {
        			int decIndex = ((ship.getOriginY()*10) + ship.getOriginX()) - j;
        			tile = (InteractableTile) tileGroup.getChildren().get(decIndex);
        		}
        	}
			
			// For last tile
			tile.isShipTile(true);
		}
	}
}
