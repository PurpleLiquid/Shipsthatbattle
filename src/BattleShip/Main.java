package BattleShip;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage stage) {
		MainMenu mm = new MainMenu();
		
		Scene s = new Scene(mm);
		s.getStylesheets().add("BattleShip/Styles/MainMenu.css");
		stage.setTitle("Battle Ship");
		stage.setResizable(false);
		
		// Add main menu
		stage.setScene(s);
		
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
