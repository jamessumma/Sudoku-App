package sudoku.sudokuapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
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

    private Boolean rowContainsDuplicates(int rowIndex){
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < 9; i++) {
            if (map.containsValue(board[rowIndex][i])) return true;
            else map.put(i, board[rowIndex][i]);
        }
        return false;
    }

    private Boolean columnContains(int columnIndex, int num){
        for (int i = 0; i < 9; i++) {
            if (board[i][columnIndex] == num) return true;
        }
        return false;
    }

    private Boolean columnContainsDuplicates(int columnIndex){
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < 9; i++) {
            if (map.containsValue(board[i][columnIndex])) return true;
            else map.put(i, board[i][columnIndex]);
        }
        return false;
    }

    // check rows and columns for duplicates and make sure there are no zeros on the board
    private boolean gameIsValid(){
        int num;
        for (int i = 0; i < 9; i++) {
            if (rowContainsDuplicates(i) || columnContainsDuplicates(i)) return false;
            for (int j = 0; j < 9; j++) {
                num = board[i][j];
                if (num == 0) return false;
            }
        }
        return true;
    }



}
