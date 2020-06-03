package BattleShip;

import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class MainMenu extends Pane {
	public MainMenu() {
		setPrefSize(1000, 1000);
		getChildren().add(buildMainMenu());
	}
	
	private Group buildMainMenu() {
		Group group = new Group();
		
		// Title Header
		Text mainTitleHeader = new Text(150, 100, "BattleShip");
		Font titleFont = Font.font("Verdana", FontWeight.BOLD, 30);
		mainTitleHeader.setFont(titleFont);
		mainTitleHeader.setWrappingWidth(200);
		mainTitleHeader.setFill(Color.AQUA);
		mainTitleHeader.setStroke(Color.DARKBLUE);
		mainTitleHeader.setStrokeWidth(2);
		mainTitleHeader.setLineSpacing(3);
		
		// Play Button
		Button playButton = new Button("Play");
		playButton.getStyleClass().add("play-button");
		playButton.setLayoutX(205);
		playButton.setLayoutY(120);
		
		// Exit Button
		Button exitButton = new Button("Exit");
		exitButton.getStyleClass().add("play-button");
		exitButton.setLayoutX(205);
		exitButton.setLayoutY(170);
		exitButton.setOnAction(e -> Platform.exit());
		
		// Adding all made components
		group.getChildren().add(mainTitleHeader);
		group.getChildren().add(playButton);
		group.getChildren().add(exitButton);
		
		return group;
	}
}
