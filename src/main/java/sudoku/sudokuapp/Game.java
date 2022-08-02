package sudoku.sudokuapp;

import java.util.ArrayList;
import java.util.Collections;

public class Game {
    int[][] board;
    int[] randomColumn = new int[9];

    public Game() {
        columnGenerator();
    }

    public int[] getRandomColumn(){
        return randomColumn;
    }

    public void columnGenerator(){
        int[] randomColumn = new int[9];
        ArrayList fifthColumn = new ArrayList();
        for (int i = 1; i < 10; i++) {
            fifthColumn.add(i);
        }
        Collections.shuffle(fifthColumn);
        for (int i = 0; i < 9; i++) {
            this.randomColumn[i] = (int) fifthColumn.get(i);
        }
    }


}
