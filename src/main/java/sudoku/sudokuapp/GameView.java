package sudoku.sudokuapp;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GameView {
    String playerName;
    String difficulty;
    Stage stage;
    Scene scene;
    Game game;

    public GameView(String playerName, String difficulty, Stage stage) {
        this.playerName = playerName;
        this.difficulty = difficulty;
        this.stage = stage;
        Group root = new Group();
        Scene scene = new Scene(root, Color.gray(.3));
        this.scene = scene;
        sceneBuilder();
        this.game = new Game();
    }

    private void sceneBuilder(){

    }
}
