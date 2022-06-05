// https://leetcode.com/problems/n-queens/
package All_Problems;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class NQueens {

    public static void main(String[] args) {
        int N = 4;
        List<List<String>> queen = solveNQueens(N);
        int i = 1;
        for (List<String> it : queen) {
            System.out.println("Arrangement " + i);
            for (String s : it) {
                System.out.println(s);
            }
            System.out.println();
            i += 1;
        }
    }

    public static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        List<List<String>> ans = new ArrayList<>();
        helper(0, board, ans);
        return ans;
    }

    private static void helper(int col, char[][] board, List<List<String>> ans) {
        if (col == board.length) {
            ans.add(construct(board));
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (isSafe(row, col, board)) {
                board[row][col] = 'Q';
                helper(col + 1, board, ans);
                board[row][col] = '.';
            }
        }
    }

    private static boolean isSafe(int row, int col, char[][] board) {
        int tempRow = row;
        int tempCol = col;

        // Checking the left-diagonal
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            row--;
            col--;
        }

        row = tempRow;
        col = tempCol;
        // Checking the left side
        while (col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            col--;
        }

        row = tempRow;
        col = tempCol;
        // Checking the right-diagonal
        while (row < board.length && col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            row++;
            col--;
        }
        return true;
    }

    private static List<String> construct(char[][] board) {
        List<String> curr = new ArrayList<>();
        for (char[] row : board) {
            String s = new String(row);
            curr.add(s);
        }
        return curr;
    }
}
