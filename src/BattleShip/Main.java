package BattleShip;

import BattleShip.AI.PlayerBot;
import BattleShip.Exceptions.InvalidShipAmount;
import BattleShip.Util.Player;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
	private Player player1 = new Player(Color.BLUE);
	
	// For now till I decide to add multiplayer functionality
	private Player player2 = new PlayerBot(Color.RED);
	
	@Override
	public void start(Stage window) {
		Scene s = new Scene(buildMainMenu(window));
		s.getStylesheets().add("BattleShip/Styles/Buttons.css");
		window.setTitle("Battle Ship");
		window.setResizable(false);; 
		
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
		border.setLeft(player1.getSetupField());
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
		
		EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				if(player1.getSetupField().getShips().size() == 5) {
					try {
						player1.getBattleField().setShips(player1.getSetupField().getShips());
						player2.getBattleField().setShips(player2.getSetupField().getShips());
					} catch (InvalidShipAmount e) {
						e.printStackTrace();
					};
					
					window.setScene(battleScene);
				}
			} 
		};
		
		readyButton.setOnMouseClicked(eventHandler);
		
		border.setBottom(readyButton);
		
		return border;
	}
	
	private BorderPane buildBattleField() {
		BorderPane border = new BorderPane();
		FlowPane leftPane = new FlowPane();
		FlowPane rightPane = new FlowPane();
		
		Label leftLabel = new Label("You");
		leftPane.getChildren().add(leftLabel);
		leftPane.getChildren().add(player1.getBattleField());
		border.setLeft(leftPane);
		
		Label rightLabel = new Label("Opponent");
		rightPane.getChildren().add(rightLabel);
		rightPane.getChildren().add(player2.getBattleField());
		border.setRight(rightPane);
		
		border.getStylesheets().add("BattleShip/Styles/Buttons.css");
		
		Label header = new Label("Battle Field");
		FlowPane headerPane = new FlowPane();
		headerPane.setStyle("-fx-border-color: black");
		headerPane.getChildren().add(header);
		border.setTop(headerPane);
		
		Button turnButton = new Button("End Turn");
		turnButton.getStyleClass().add("button");
		border.setBottom(turnButton);
		
		// Filler
		Label filler = new Label("      ");
		border.setCenter(filler);
		
		return border;
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
