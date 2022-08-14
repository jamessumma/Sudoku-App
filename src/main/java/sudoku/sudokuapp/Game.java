package sudoku.sudokuapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class Game {
    int[][] board = new int[9][9];

    public Game() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = 0;
            }
        }
        firstRowGenerator();
        fullGenerator();

    }


    private void firstRowGenerator(){
        ArrayList firstRow = new ArrayList();
        for (int i = 1; i < 10; i++) {
            firstRow.add(i);
        }
        Collections.shuffle(firstRow);
        for (int i = 0; i < 9; i++) {
            this.board[0][i] = (int) firstRow.get(i);
        }
    }

    private void fullGenerator(){
        int maxAttempts = 1000;
        int min = 1;
        int max = 9;
        int randomNum;

        for (int i = 1; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int k = 0;
                while (maxAttempts > k){
                    randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
                    if (!rowContains(i, randomNum) && !columnContains(j, randomNum)){
                        board[i][j] = randomNum;
                        break;
                    }
                    k++;
                }
            }
        }

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
            if (board[i][columnIndex] == num) return true;
        }
        return false;
    }

    private void gameValidation(){

    }



}
