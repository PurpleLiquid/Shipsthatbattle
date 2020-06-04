package BattleShip;

import java.awt.Color;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

public class ResourceBox extends StackPane {
	public ResourceBox() {
		Label l = new Label("Test");
		setAlignment(Pos.BASELINE_RIGHT);
		setStyle("-fx-border-color: black");
		getChildren().add(l);
	}
}
