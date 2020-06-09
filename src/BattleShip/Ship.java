package BattleShip;

import java.util.ArrayList;

import BattleShip.Util.ClickObserver;
import BattleShip.Util.Observer;
import javafx.scene.Group;
import javafx.scene.paint.Color;

public class Ship extends Group {
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	
	public Ship(double tileSize, int shipSize, int shipNum) {
		// Build Ship model
		for(int x = 0; x < shipSize; x++) {
			Tile tile = new Tile(x, shipNum, tileSize);
			tile.setFill(Color.BLUE);
			
			getChildren().add(tile);
		}
		
		ClickObserver obs = new ClickObserver(this);
		this.observers.add(obs);
		
		setOnMousePressed(e->{
			notifyAllObservers();
		});
	}
	
	public void attach(Observer observer) {
		observers.add(observer);
	}
	
	public void notifyAllObservers() {
		for(Observer observer : observers) {
			observer.update();
		}
	}
}
