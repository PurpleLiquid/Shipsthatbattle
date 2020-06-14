package BattleShip;

import java.util.ArrayList;

import BattleShip.Util.Observer;
import javafx.scene.Group;
import javafx.scene.paint.Color;

public class Ship extends Group {
	// Should have ClickObserver and ShipSelector in observers list
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	private String shipName;
	private int shipSize;
	public boolean isPlaced = false;
	private int originX, originY;
	
	public Ship(String shipName, double tileSize, int shipSize, int shipNum) {
		this.shipName = shipName;
		this.shipSize = shipSize;
		
		// Build Ship model
		for(int x = 0; x < shipSize; x++) {
			ShipTile tile = new ShipTile(x, shipNum, tileSize);
			
			getChildren().add(tile);
		}
		
		setOnMousePressed(e->{
			notifyAllObservers();
		});
	}
	
	public void setOriginX(int x) {
		originX = x;
	}
	
	public void setOriginY(int y) {
		originY = y;
	}
	
	public int getOriginX() {
		return originX;
	}
	
	public int getOriginY() {
		return originY;
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
	
	public int getShipSize() {
		return this.shipSize;
	}
	
//	public int getShipId() {
//		return this.shipId;
//	}
}
