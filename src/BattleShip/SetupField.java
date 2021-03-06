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
	            boolean horizontal = ShipSelector.getInstance().isHorizontal();
	            int originX = tile.getPlacementX();
	            int originY = tile.getPlacementY();
	            
	            if(ship == null) {
	            	return;
	            }
	            
	            // Clean up previous placement
	            if(ship.isPlaced && ship.getShipName() == ShipSelector.getInstance().getSelected().getShipName()) {
	            	cleanPlacement(ship);
	            }
	            
	            // Place Horizontal
	            if(ship != null && ship.isPlaced == false && horizontal) {
	            	placeShipHorizontal(ship, tile, playerColor, originX, originY, horizontal);
	            	updateList(ship);
	            }
	            // Place Vertical
	            else if(ship != null && ship.isPlaced == false && horizontal == false) {
	            	placeShipVertical(ship, tile, playerColor, originX, originY, horizontal);
	            	updateList(ship);
	            } 
	         } 
		};
		
		placeTiles(eventHandler);
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
	
	private void cleanPlacement(Ship ship) {
		// All ship variables should have been saved from previous
    	InteractableTile prevOrigin = (InteractableTile) tileGroup.getChildren().get((ship.getOriginY()*10) + ship.getOriginX());
    	
    	if(ship.isHorizontal()) { // Horizontal
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
    	} else { // Vertical
    		for(int i = 0; i < ship.getShipSize(); i++) {
    			prevOrigin.setFill(Color.LIGHTGREY);
        		
        		if(ship.getOriginY() <= 5) {
        			int incIndex = ((ship.getOriginY()*10) + (i * 10)) + ship.getOriginX();
        			prevOrigin = (InteractableTile) tileGroup.getChildren().get(incIndex);
        		} else {
        			int decIndex = ((ship.getOriginY()*10) - (i * 10)) + ship.getOriginX();
        			prevOrigin = (InteractableTile) tileGroup.getChildren().get(decIndex);
        		}
        	}
    	}
    	
    	prevOrigin.setFill(Color.LIGHTGREY); // For last tile
    	ship.isPlaced = false;
	}
	
	private void placeShipHorizontal(Ship ship, InteractableTile tile, Color playerColor, int X, int Y, boolean horizontal) {
		for(int i = 1; i < ship.getShipSize(); i++) {
    		tile.setFill(playerColor);
    		
    		if(X <= 5) {
    			int incIndex = ((Y*10) + X) + i;
    			tile = (InteractableTile) tileGroup.getChildren().get(incIndex);
    		} else {
    			int decIndex = ((Y*10) + X) - i;
    			tile = (InteractableTile) tileGroup.getChildren().get(decIndex);
    		}
    	}
		
		// For last tile
    	tile.setFill(playerColor);
    	
    	// Setting variables
    	ship.setOriginX(X);
        ship.setOriginY(Y);
    	ship.isPlaced = true;
    	ship.setHorizontal(horizontal);
	}
	
	private void placeShipVertical(Ship ship, InteractableTile tile, Color playerColor, int X, int Y, boolean horizontal) {
		for(int i = 0; i < ship.getShipSize(); i++) {
    		tile.setFill(playerColor);
    		
    		if(Y <= 5) {
    			int incIndex = ((Y*10) + (i * 10)) + X;
    			tile = (InteractableTile) tileGroup.getChildren().get(incIndex);
    		} else {
    			int decIndex = ((Y*10) - (i * 10)) + X;
    			tile = (InteractableTile) tileGroup.getChildren().get(decIndex);
    		}
    	}
    	
    	// For last tile
    	tile.setFill(playerColor);
    	
    	// Setting variables
    	ship.setOriginX(X);
        ship.setOriginY(Y);
    	ship.isPlaced = true;
    	ship.setHorizontal(horizontal);
	}
	
	private void updateList(Ship ship) {
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
	
	private void placeTiles(EventHandler<MouseEvent> event) {
		for(int y = 0; y < HEIGHT; y++) {
			for(int x = 0; x < WIDTH; x++) {
				InteractableTile tile = new InteractableTile(x, y, TILE_SIZE);
				tile.setOnMouseClicked(event);
				
				tileGroup.getChildren().add(tile);
			}
		}
	}
}
