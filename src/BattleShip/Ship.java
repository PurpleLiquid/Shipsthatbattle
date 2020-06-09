package BattleShip;

import java.util.ArrayList;

import BattleShip.Util.Observer;
import javafx.scene.Group;
import javafx.scene.paint.Color;

public class Ship extends Group {
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	private String shipName;
	
	public Ship(String shipName, double tileSize, int shipSize, int shipNum) {
		this.shipName = shipName;
		
		// Build Ship model
		for(int x = 0; x < shipSize; x++) {
			Tile tile = new Tile(x, shipNum, tileSize);
			tile.setFill(Color.BLUE);
			
			getChildren().add(tile);
		}
		
		setOnMousePressed(e->{
			notifyAllObservers();
		});
	}
	
	public void attach(Observer observer) {
		observers.add(observer);
	}
	
	public void notifyAllObservers() {
		for(Observer observer : observers) {
			observer.update(this);
		}
	}
	
	// Might be useful later
	public String getShipName() {
		return this.shipName;
	}
	
//	public int getShipId() {
//		return this.shipId;
//	}
}
