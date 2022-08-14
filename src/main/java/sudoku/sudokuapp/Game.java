package sudoku.sudokuapp;

import java.util.ArrayList;
import java.util.Collections;

public class Game {
    int[][] board = new int[9][9];

    public Game() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = 0;
            }
        }
        firstRowGenerator();

    }


    private void firstRowGenerator(){
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

    private Boolean rowContains(int rowIndex, int num){
        for (int i = 0; i < 9; i++) {
            if (board[rowIndex][i] == num) return true;
        }
        return false;
    }

    private Boolean columnContains(int columnIndex, int num){
        for (int i = 0; i < 9; i++) {
            if (board[columnIndex][i] == num) return true;
        }
        return false;
    }

    private void gameValidation(){

    }



}
