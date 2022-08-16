package sudoku.sudokuapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class Game {
    int[][] board = new int[9][9];

    public Game() {
        clearBoard();
        firstRowGenerator();
        fullGenerator();

    }
    private void clearBoard(){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = 0;
            }
        }
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
        ArrayList nums = new ArrayList();
        for (int i = 1; i < 10; i++) {
            nums.add(i);
        }
        int maxAttempts = 20000000;
        int tries = 0;
        while (maxAttempts > tries) {
            clearBoard();
            firstRowGenerator();
            for (int i = 1; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    Collections.shuffle(nums);
                    for (int k = 0; k < nums.size(); k++) {
                        if (!rowContains(i, (int) nums.get(k)) && !columnContains(j, (int) nums.get(k))) {
                            board[i][j] = (int) nums.get(k);
                            break;
                        }
                        if (k == nums.size() - 1) {
                            i = 8;
                            j = 8;
                            tries++;
                        }
                    }
                }
            }
        }
        //int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);

    }

    private boolean entryIsValid(int i, int j, int num){

        return true;
    }

    // box num is in order, left to right, top to bottom
    // box 1 is top left, box 9 is bottom right
    // box 3 is top right, box 7 is bottom left
    private int getBoxNum(int i, int j){
        if (i <= 3){
            if (j <= 3) return 1;
            if (j <= 6) return 2;
            else return 3;
        } else if (i <= 6){
            if (j <= 3) return 4;
            if (j <= 6) return 5;
            else return 6;
        } else {
            if (j <= 3) return 7;
            if (j <= 6) return 8;
            else return 9;
        }
    }

    // returns true if the box contains the number
    private boolean boxContains(int rowStart, int columnStart, int num){
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[rowStart + i][columnStart + j] == num) {
                    return true;
                }

        return false;
    }

    // returns true if the row contains the number
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
