package BattleShip;

import BattleShip.Util.ShipSelector;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class SetupField extends Field {
	private int prevX, prevY;
	
	public SetupField() {
		super(); 
		
		// For ship placement
		EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
			 @Override 
	         public void handle(MouseEvent e) { 
	            InteractableTile tile = (InteractableTile) e.getSource();
	            Ship ship = ShipSelector.getInstance().getSelected();
	            int originX = tile.getPlacementX();
	            int originY = tile.getPlacementY();
	            
	            // Clean up previous placement
	            if(ship.isPlaced) {
	            	InteractableTile prevOrigin = (InteractableTile) tileGroup.getChildren().get((prevY*10) + prevX);
	            	
	            	for(int i = 1; i < ship.getShipSize(); i++) {
	            		prevOrigin.setFill(Color.LIGHTGREY);
	            		if(prevX <= 5) {
	            			int incIndex = ((prevY*10) + prevX) + i;
	            			prevOrigin = (InteractableTile) tileGroup.getChildren().get(incIndex);
	            		} else {
	            			int decIndex = ((prevY*10) + prevX) - i;
	            			prevOrigin = (InteractableTile) tileGroup.getChildren().get(decIndex);
	            		}
	            	}
	            	
	            	prevOrigin.setFill(Color.LIGHTGREY); // For last tile
	            	ship.isPlaced = false;
	            }
	            
	            // Place Horizontal
	            if(ship != null && ship.isPlaced == false) {
	            	
	            	for(int i = 1; i < ship.getShipSize(); i++) {
	            		tile.setFill(Color.BLUE);
	            		if(originX <= 5) {
	            			int incIndex = ((originY*10) + originX) + i;
	            			tile = (InteractableTile) tileGroup.getChildren().get(incIndex);
	            		} else {
	            			int decIndex = ((originY*10) + originX) - i;
	            			tile = (InteractableTile) tileGroup.getChildren().get(decIndex);
	            		}
	            	}
	            	
	            	ship.isPlaced = true;
	            	tile.setFill(Color.BLUE); // For last tile
	            }
	            
	            prevX = originX;
	            prevY = originY;
	         } 
		};
		
		for(int y = 0; y < HEIGHT; y++) {
			for(int x = 0; x < WIDTH; x++) {
				InteractableTile tile = new InteractableTile(x, y, TILE_SIZE);
				tile.setOnMouseClicked(eventHandler);
				
				tileGroup.getChildren().add(tile);
			}
		}
	}
}
