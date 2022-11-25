// https://leetcode.com/problems/word-search/
package All_Problems;

public class WordSearch {

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }

    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] vis = new boolean[m][n];

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean result = helper(i, j, 1, board, vis, word, dx, dy);
                    if (result) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static boolean helper(int i, int j, int ind, char[][] board, boolean[][] vis, String word, int[] dx, int[] dy) {
        if (ind == word.length()) {
            return true;
        }

        vis[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int nI = i + dx[k];
            int nJ = j + dy[k];

            if (isValid(nI, nJ, board, vis) && board[nI][nJ] == word.charAt(ind)) {
                boolean result = helper(nI, nJ, ind + 1, board, vis, word, dx, dy);
                if (result) {
                    return true;
                }
            }
        }
        vis[i][j] = false;
        return false;
    }

    private static boolean isValid(int i, int j, char[][] board, boolean[][] vis) {
        int m = board.length;
        int n = board[0].length;
        return i >= 0 && i < m && j >= 0 && j < n && !vis[i][j];
    }
}
