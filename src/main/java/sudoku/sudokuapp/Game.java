package sudoku.sudokuapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class Game {
    int[][] board = new int[9][9];

    public Game() {
        columnGenerator();

    }


    private void columnGenerator(){
        ArrayList firstColumn = new ArrayList();
        for (int i = 1; i < 10; i++) {
            firstColumn.add(i);
        }
        Collections.shuffle(firstColumn);
        for (int i = 0; i < 9; i++) {
            this.board[0][i] = (int) firstColumn.get(i);
        }
    }

    private void fullGenerator(){



        //int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);

    }

    private void gameValidation(){

    }



}
