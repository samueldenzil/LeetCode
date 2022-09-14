// https://practice.geeksforgeeks.org/problems/x-total-shapes3617/1
package All_Problems;

public class XTotalShapes {

    public static void main(String[] args) {
        char[][] grid = {
                {'X', 'O', 'X'},
                {'O', 'X', 'O'},
                {'X', 'X', 'X'}
        };
        System.out.println(xShape(grid));
    }

    public static int xShape(char[][] grid) {
        // code here
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        int count = 0;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && grid[i][j] == 'X') {
                    dfs(i, j, grid, vis, dx, dy);
                    count++;
                }
            }
        }

        return count;
    }

    private static void dfs(int row, int col, char[][] grid, boolean[][] vis, int[] dx, int[] dy) {
        vis[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int nrow = row + dx[i];
            int ncol = col + dy[i];

            if (isValid(nrow, ncol, grid, vis)) {
                dfs(nrow, ncol, grid, vis, dx, dy);
            }
        }
    }

    private static boolean isValid(int row, int col, char[][] grid, boolean[][] vis) {
        int n = grid.length;
        int m = grid[0].length;
        return row >= 0 && row < n && col >= 0 && col < m && grid[row][col] == 'X' && !vis[row][col];
    }
}
