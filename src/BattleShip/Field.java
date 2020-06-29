package BattleShip;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Field extends Pane {
	// 10x10 board
	protected final int HEIGHT = 10;
	protected final int WIDTH = 10;
	public final static int TILE_SIZE = 50;
	
	protected Group tileGroup = new Group();
	
	protected Ship carrier;
	protected Ship battleship;
	protected Ship cruiser;
	protected Ship submarine;
	protected Ship destroyer;
	
	public Field(Color playerColor) {
		getChildren().add(tileGroup);
		setStyle("-fx-border-color: black");
	}
	
	public void setCarrier(Ship carrier) {
		this.carrier = carrier;
	}
	
	public void setBattleship(Ship battleship) {
		this.battleship = battleship;
	}
	
	public void setCruiser(Ship cruiser) {
		this.cruiser = cruiser;
	}
	
	public void setSubmarine(Ship submarine) {
		this.submarine = submarine;
	}
	
	public void setDestroyer(Ship destroyer) {
		this.destroyer = destroyer;
	}
	
	public Ship getCarrier() {
		return carrier;
	}
	
	public Ship getBattleship() {
		return battleship;
	}
	
	public Ship getCruiser() {
		return cruiser;
	}
	
	public Ship getSubmarine() {
		return submarine;
	}
	
	public Ship getDestroyer() {
		return destroyer;
	}
}
