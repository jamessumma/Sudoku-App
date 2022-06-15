module sudoku.sudokuapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens sudoku.sudokuapp to javafx.fxml;
    exports sudoku.sudokuapp;
}