// https://practice.geeksforgeeks.org/problems/length-of-largest-region-of-1s-1587115620/1
package All_Problems;

public class UnitAreaOfLargesRegionOf1s {

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };
        System.out.println(findMaxArea(grid));
    }

    public static int findMaxArea(int[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int area = dfs(i, j, 0, grid, visited, n, m);
                    max = Math.max(max, area);
                }
            }
        }
        return max;
    }

    private static int dfs(int row, int col, int dist, int[][] grid, boolean[][] visited, int n, int m) {
        visited[row][col] = true;

        int count = dist;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int nrow = row + i;
                int ncol = col + j;

                if (isValid(nrow, ncol, grid, visited, n, m)) {
                    count += dfs(nrow, ncol, dist, grid, visited, n, m);
                }
            }
        }

        return count + 1;
    }

    private static boolean isValid(int row, int col, int[][] grid, boolean[][] visited, int n, int m) {
        return row >= 0 && row < n && col >= 0 && col < m && grid[row][col] == 1 && !visited[row][col];
    }
}
