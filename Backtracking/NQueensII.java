// https://leetcode.com/problems/n-queens-ii/
package Backtracking;

import java.util.Arrays;

public class NQueensII {

    public static void main(String[] args) {
        int n = 4;
        System.out.println(totalNQueens(n));
    }

    public static int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        int[] count = new int[1];
        helper(0, board, count);
        return count[0];
    }

    private static void helper(int col, char[][] board, int[] count) {
        // Base case
        if (col == board.length) {
            count[0]++;
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (isSafe(row, col, board)) {
                board[row][col] = 'Q';
                helper(col + 1, board, count);
                board[row][col] = '.';
            }
        }
    }

    private static boolean isSafe(int row, int col, char[][] board) {
        int tempRow = row;
        int tempCol = col;

        // checking the left diagonal
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            row--;
            col--;
        }

        // checking the left side
        row = tempRow;
        col = tempCol;
        while (col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            col--;
        }

        // checking the right diagonal
        row = tempRow;
        col = tempCol;
        while (row < board.length && col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            row++;
            col--;
        }

        return true;
    }
}
