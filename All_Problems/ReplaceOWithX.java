// https://practice.geeksforgeeks.org/problems/replace-os-with-xs0052/1
package All_Problems;

import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

public class ReplaceOWithX {

    public static void main(String[] args) {
        char[][] mat = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'X', 'O', 'O'}
        };
        int n = mat.length;
        int m = mat[0].length;
        char[][] ans = fill(n, m, mat);

        for (char[] row : ans) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static char[][] fill(int n, int m, char[][] mat) {
        // code here
        boolean[][] vis = new boolean[n][m];

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        // traverse first row and last row
        for (int j = 0; j < m; j++) {
            // first row
            if (!vis[0][j] && mat[0][j] == 'O') {
                dfs(0, j, mat, vis, dx, dy);
                // bfs(0, j, mat, vis, dx, dy);
            }
            // last row
            if (!vis[n - 1][j] && mat[n - 1][j] == 'O') {
                dfs(n - 1, j, mat, vis, dx, dy);
                // bfs(n - 1, j, mat, vis, dx, dy);
            }
        }

        for (int i = 0; i < n; i++) {
            // first col
            if (!vis[i][0] && mat[i][0] == 'O') {
                dfs(i, 0, mat, vis, dx, dy);
                // bfs(i, 0, mat, vis, dx, dy);
            }
            // last col
            if (!vis[i][m - 1] && mat[i][m - 1] == 'O') {
                dfs(i, m - 1, mat, vis, dx, dy);
                // bfs(i, m - 1, mat, vis, dx, dy);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 'O' && !vis[i][j]) {
                    mat[i][j] = 'X';
                }
            }
        }

        return mat;
    }

    private static void dfs(int row, int col, char[][] mat, boolean[][] vis, int[] dx, int[] dy) {
        vis[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int nrow = row + dx[i];
            int ncol = col + dy[i];
            if (isValid(nrow, ncol, mat, vis)) {
                dfs(nrow, ncol, mat, vis, dx, dy);
            }
        }
    }

    private static void bfs(int row, int col, char[][] mat, boolean[][] vis, int[] dx, int[] dy) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(row, col));
        vis[row][col] = true;

        while (!queue.isEmpty()) {
            row = queue.peek().row;
            col = queue.peek().col;
            queue.poll();
            for (int i = 0; i < 4; i++) {
                int nrow = row + dx[i];
                int ncol = col + dy[i];
                if (isValid(nrow, ncol, mat, vis)) {
                    queue.add(new Pair(nrow, ncol));
                    vis[nrow][ncol] = true;
                }
            }
        }
    }

    private static boolean isValid(int row, int col, char[][] mat, boolean[][] vis) {
        int n = mat.length;
        int m = mat[0].length;
        return row >= 0 && row < n && col >= 0 && col < m && mat[row][col] == 'O' && !vis[row][col];
    }

    static class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
