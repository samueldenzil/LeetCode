// https://practice.geeksforgeeks.org/problems/word-search/1
package All_Problems;

public class WordSearch {

    public static void main(String[] args) {
        char[][] board = {
                {'a', 'g', 'b', 'c'},
                {'q', 'e', 'e', 'l'},
                {'g', 'b', 'k', 's'}
        };
        String word = "geeks";
        System.out.println(isWordExist(board, word));
    }

    public static boolean isWordExist(char[][] board, String word) {
        // Code here
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean result = helper(i, j, 1, board, vis, word, dx, dy, "" + board[i][j]);
                    if (result) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean helper(int row, int col, int ind, char[][] board, boolean[][] vis, String word, int[] dx, int[] dy, String curr) {
        if (ind == word.length()) {
            return true;
        }
        vis[row][col] = true;
        char c = word.charAt(ind);
        for (int i = 0; i < 4; i++) {
            int nrow = row + dx[i];
            int ncol = col + dy[i];
            if (isValid(nrow, ncol, board, vis, c)) {
                boolean result = helper(nrow, ncol, ind + 1, board, vis, word, dx, dy, curr + c);
                if (result) {
                    return true;
                }
            }
        }
        vis[row][col] = false;
        return false;
    }

    private static boolean isValid(int row, int col, char[][] board, boolean[][] vis, char c) {
        int n = vis.length;
        int m = vis[0].length;
        return row >= 0 && row < n && col >= 0 && col < m && board[row][col] == c && !vis[row][col];
    }
}
