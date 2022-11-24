// https://leetcode.com/problems/valid-sudoku/
package All_Problems;

import java.util.Set;
import java.util.HashSet;

public class ValidSudoku {

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'}, 
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, 
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, 
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, 
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, 
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, 
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, 
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, 
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(isValidSudoku(board));
    }

    // Approach 1
    public static boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }

                if (set.contains(c + "_row_" + i) || set.contains(c + "_col_" + j) || set.contains(c + "_box_" + i / 3 + "_" + j / 3)) {
                    return false;
                }
                set.add(c + "_row_" + i);
                set.add(c + "_col_" + j);
                set.add(c + "_box_" + i / 3 + "_" + j / 3);
            }
        }

        return true;
    }

    // Approach 2
    /* public static boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<>();
        // check for all rows
        for (int row = 0; row < 9; row++) {
            boolean result = checkRow(row, board, set);
            if (!result) {
                return false;
            }
            set.clear();
        }

        // check for all cols
        for (int col = 0; col < 9; col++) {
            boolean result = checkCol(col, board, set);
            if (!result) {
                return false;
            }
            set.clear();
        }

        // check for all sub-boxes
        for (int row = 0; row < 9 - 2; row += 3) {
            for (int col = 0; col < 9 - 2; col += 3) {
                boolean result = checkSubBox(row, col, board, set);
                if (!result) {
                    return false;
                }
                set.clear();
            }
        }
        return true;
    }

    private static boolean checkRow(int row, char[][] board, Set<Character> set) {
        for (int col = 0; col < 9; col++) {
            char c = board[row][col];
            if (c == '.') {
                continue;
            }
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }

    private static boolean checkCol(int col, char[][] board, Set<Character> set) {
        for (int row = 0; row < 9; row++) {
            char c = board[row][col];
            if (c == '.') {
                continue;
            }
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }

    private static boolean checkSubBox(int row, int col, char[][] board, Set<Character> set) {
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                if (set.contains(c)) {
                    return false;
                }
                set.add(c);
            }
        }
        return true;
    } */
}
