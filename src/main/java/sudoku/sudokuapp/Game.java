package sudoku.sudokuapp;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Game {
    int[][] board = new int[9][9];

    public Game() {
        clearBoard();
        fullGenerator();

    }
    private void clearBoard(){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = 0;
            }
        }
    }


    private void fullGenerator(){
        fillDiagonal();
        fillRemaining(0, 3);
    }

    void fillDiagonal() {
        fillBox(0, 0);
        fillBox(3, 3);
        fillBox(6, 6);
    }

    boolean fillRemaining(int i, int j) {

        int N = 9;
        int SRN = 3;
        if (j>=N && i<N-1)
        {
            i = i + 1;
            j = 0;
        }
        if (i>=N && j>=N)
            return true;

        if (i < SRN)
        {
            if (j < SRN)
                j = SRN;
        }
        else if (i < N-SRN)
        {
            if (j==(int)(i/SRN)*SRN)
                j =  j + SRN;
        }
        else
        {
            if (j == N-SRN)
            {
                i = i + 1;
                j = 0;
                if (i>=N)
                    return true;
            }
        }

        for (int num = 1; num <= N; num++) {
            if (entryIsValid(i, j, num)) {
                board[i][j] = num;
                if (fillRemaining(i, j+1)) {
                    return true;
                }
                board[i][j] = 0;
            }
        }
        return false;
    }

    //Fill a 3 x 3 box
    private void fillBox(int row,int column)
    {
        LinkedList<Integer> nums = randomGenerator();
        int maxAttempts = 81;
        int numTries = 0;
        int num = nums.pop();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                while (true){
                    numTries++;
                    if (entryIsValid(row + i, column + j, num)){
                        board[row + i][column + j] = num;
                        break;
                    }
                    else{
                        nums.add(num);
                        num = nums.pop();
                    }
                }
            }
        }
    }

    // generates a randomized list of numbers 1-9
    private LinkedList<Integer> randomGenerator(){
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i < 10; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        return list;
    }


    // if the specified entry has no row, column, or box duplicates, return true
    private boolean entryIsValid(int i, int j, int num){
        if (boxContains(i - i % 3, j - j % 3, num)
                || rowContains(i, num)
                || columnContains(j, num) ){
            return false;
        }
        return true;
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

    // returns true if the row contains duplicates
    private Boolean rowContainsDuplicates(int rowIndex){
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < 9; i++) {
            if (map.containsValue(board[rowIndex][i])) return true;
            else map.put(i, board[rowIndex][i]);
        }
        return false;
    }

    // returns true if the column contains the number
    private Boolean columnContains(int columnIndex, int num){
        for (int i = 0; i < 9; i++) {
            if (board[i][columnIndex] == num) return true;
        }
        return false;
    }

    // returns true if the column contains duplicates
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
