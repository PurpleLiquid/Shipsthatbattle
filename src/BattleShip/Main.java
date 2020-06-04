package BattleShip;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
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
		s.getStylesheets().add("BattleShip/Styles/MainMenu.css");
		s.getStylesheets().add("BattleShip/Styles/Misc.css");
		window.setTitle("Battle Ship");
		window.setResizable(false);
		
		// Add main menu
		window.setScene(s);
		
		window.show();
	}
	
	private StackPane buildMainMenu(Stage window) {
		StackPane mainMenu = new StackPane();
		Group group = new Group();
		
		// Title Header
		Text mainTitleHeader = new Text(0, 0, "BattleShip");
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
		playButton.setLayoutY(30);
		
		BorderPane border = new BorderPane();
		border.setLeft(buildSetupField());
		border.setRight(new ResourceBox());
		
		Scene setupScene = new Scene(border, 750, 750);
		setupScene.getStylesheets().add("BattleShip/Styles/Misc.css");
		playButton.setOnAction(e -> window.setScene(setupScene));
		
		// Exit Button
		Button exitButton = new Button("Exit");
		exitButton.getStyleClass().add("play-button");
		exitButton.setLayoutY(80);
		exitButton.setOnAction(e -> Platform.exit());
		
		// Adding all made components
		group.getChildren().add(mainTitleHeader);
		group.getChildren().add(playButton);
		group.getChildren().add(exitButton);
		
		mainMenu.getChildren().add(group);
		
		return mainMenu;
	}
	
	private StackPane buildSetupField() {
		SetupField sf = new SetupField();
		
		return sf;
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
