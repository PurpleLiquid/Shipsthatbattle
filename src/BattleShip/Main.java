package BattleShip;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage window) {
		Scene s = new Scene(buildMainMenu(window));
		s.getStylesheets().add("BattleShip/Styles/Buttons.css");
		window.setTitle("Battle Ship");
		
		// Add main menu
		window.setScene(s);
		
		window.show();
	}
	
	private Pane buildMainMenu(Stage window) {
		Pane mainMenu = new Pane();
		Group group = new Group();
		
		// Title Header
		Text mainTitleHeader = new Text("BattleShip");
		Font titleFont = Font.font("Verdana", FontWeight.BOLD, 30);
		mainTitleHeader.setFont(titleFont);
		mainTitleHeader.setWrappingWidth(200);
		mainTitleHeader.setFill(Color.AQUA);
		mainTitleHeader.setStroke(Color.DARKBLUE);
		mainTitleHeader.setStrokeWidth(2);
		mainTitleHeader.setLineSpacing(3);
		mainTitleHeader.setLayoutY(30);
		
		// Play Button
		Button playButton = new Button("Play");
		playButton.getStyleClass().add("button");
		playButton.setLayoutY(60);
		Scene setupScene = new Scene(buildSetupField(window));
		playButton.setOnAction(e -> window.setScene(setupScene));
		
		// Exit Button
		Button exitButton = new Button("Exit");
		exitButton.getStyleClass().add("button");
		exitButton.setLayoutY(110);
		exitButton.setOnAction(e -> Platform.exit());
		
		// Adding all made components
		group.getChildren().add(mainTitleHeader);
		group.getChildren().add(playButton);
		group.getChildren().add(exitButton);
		
		mainMenu.getChildren().add(group);
		
		return mainMenu;
	}
	
	private BorderPane buildSetupField(Stage window) {
		BorderPane border = new BorderPane();
		border.setLeft(new SetupField());
		border.setRight(new ResourceBox());
		border.getStylesheets().add("BattleShip/Styles/Buttons.css");
		
		Label header = new Label("Setup Ships");
		StackPane headerPane = new StackPane();
		headerPane.setStyle("-fx-border-color: black");
		headerPane.getChildren().add(header);
		border.setTop(headerPane);
		
		Button readyButton = new Button("Ready!");
		readyButton.getStyleClass().add("button");
		Scene battleScene = new Scene(buildBattleField());
		readyButton.setOnAction(e -> window.setScene(battleScene));
		border.setBottom(readyButton);
		
		return border;
	}
	
	private BorderPane buildBattleField() {
		BorderPane border = new BorderPane();
		border.setCenter(new Battlefield());
		border.getStylesheets().add("BattleShip/Styles/Buttons.css");
		
		Label header = new Label("Battle");
		StackPane headerPane = new StackPane();
		headerPane.setStyle("-fx-border-color: black");
		headerPane.getChildren().add(header);
		border.setTop(headerPane);
		
		Button turnButton = new Button("End Turn");
		turnButton.getStyleClass().add("button");
		border.setBottom(turnButton);
		
		return border;
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
