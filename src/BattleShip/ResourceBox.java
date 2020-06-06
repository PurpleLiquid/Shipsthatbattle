package BattleShip;

import javafx.scene.control.Label;
import javafx.scene.layout.*;

public class ResourceBox extends StackPane {
	public final static int TILE_SIZE = 50;
	
	// For Ships will refactor later
	protected final int HEIGHT = 10;
	protected final int WIDTH = 10;
	
	public ResourceBox() {
		Label l = new Label("Ship Information will go here");
		setStyle("-fx-border-color: black");
		getChildren().add(l);
	}
}
