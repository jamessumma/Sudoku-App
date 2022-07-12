package sudoku.sudokuapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PrimaryController {
    @FXML
    private Label title;

    @FXML
    private TextField name;

    @FXML
    private Button startButton;

    public void startGame(ActionEvent e){
        System.out.println("starting game");
    }

}
