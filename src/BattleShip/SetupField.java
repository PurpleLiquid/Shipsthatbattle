package BattleShip;

import java.util.ArrayList;

import BattleShip.Util.ShipSelector;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class SetupField extends Pane {
	// 10x10 board
	private final int HEIGHT = 10;
	private final int WIDTH = 10;
	public final static int TILE_SIZE = 50;
	
	private Group tileGroup = new Group();
	
	private ArrayList<Ship> shipList = new ArrayList<Ship>();

	public SetupField(Color playerColor) {
		getChildren().add(tileGroup);
		setStyle("-fx-border-color: black");
		
		// For ship placement
		EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
			 @Override 
	         public void handle(MouseEvent e) { 
	            InteractableTile tile = (InteractableTile) e.getSource();
	            Ship ship = ShipSelector.getInstance().getSelected();
	            int originX = tile.getPlacementX();
	            int originY = tile.getPlacementY();
	            
	            if(ship == null) {
	            	return;
	            }
	            
	            // Clean up previous placement
	            if(ship.isPlaced && ship.getShipName() == ShipSelector.getInstance().getSelected().getShipName()) {
	            	InteractableTile prevOrigin = (InteractableTile) tileGroup.getChildren().get((ship.getOriginY()*10) + ship.getOriginX());
	            	
	            	for(int i = 1; i < ship.getShipSize(); i++) {
	            		prevOrigin.setFill(Color.LIGHTGREY);
	            		if(ship.getOriginX() <= 5) {
	            			int incIndex = ((ship.getOriginY()*10) + ship.getOriginX()) + i;
	            			prevOrigin = (InteractableTile) tileGroup.getChildren().get(incIndex);
	            		} else {
	            			int decIndex = ((ship.getOriginY()*10) + ship.getOriginX()) - i;
	            			prevOrigin = (InteractableTile) tileGroup.getChildren().get(decIndex);
	            		}
	            	}
	            	
	            	prevOrigin.setFill(Color.LIGHTGREY); // For last tile
	            	ship.isPlaced = false;
	            }
	            
	            // Place Horizontal
	            if(ship != null && ship.isPlaced == false) {
	            	
	            	for(int i = 1; i < ship.getShipSize(); i++) {
	            		tile.setFill(playerColor);
	            		if(originX <= 5) {
	            			int incIndex = ((originY*10) + originX) + i;
	            			tile = (InteractableTile) tileGroup.getChildren().get(incIndex);
	            		} else {
	            			int decIndex = ((originY*10) + originX) - i;
	            			tile = (InteractableTile) tileGroup.getChildren().get(decIndex);
	            		}
	            	}
	            	
	            	
	            	// Set new placement
	            	ship.setOriginX(originX);
		            ship.setOriginY(originY);
	            	ship.isPlaced = true;
	            	
	            	// For last tile
	            	tile.setFill(playerColor);
	            	
	            	// Check if ship was already set and update
	            	for(int i = 0; i < shipList.size(); i++) {
	            		if(ship.getShipName() == shipList.get(i).getShipName()) {
	            			shipList.set(i, ship);
	            			return;
	            		}
	            	}
	            	
	            	// if it doesn't exist yet
	            	addShip(ship);
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
	
	public void addShip(Ship ship) {
		shipList.add(ship);
	}
	
	public void setShips(ArrayList<Ship> ships) {
		shipList = ships;
	}
	
	public ArrayList<Ship> getShips() {
		return shipList;
	}
}
