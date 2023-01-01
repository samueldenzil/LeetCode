// https://leetcode.com/problems/unique-paths-iii/
package All_Problems;

public class UniquePathsIII {

    public static void main(String[] args) {
        int[][] grid = {
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 2, -1}
        };
        System.out.println(uniquePathsIII(grid));
    }

    public static int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int nonObstacles = 0;
        int startX = -1;
        int startY = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 || grid[i][j] == 1) {
                    nonObstacles++;
                }
                if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                }
            }
        }

        boolean[][] vis = new boolean[m][n];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        return helper(startX, startY, 0, nonObstacles, grid, vis, dx, dy, m, n);
    }

    private static int helper(int x, int y, int count, int nonObstacles, int[][] grid, boolean[][] vis, int[] dx, int[] dy, int m, int n) {
        // base case
        if (grid[x][y] == 2) {
            if (count == nonObstacles) {
                return 1;
            }
            return 0;
        }

        int sum = 0;
        vis[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (isValid(newX, newY, grid, vis, m, n)) {
                sum += helper(newX, newY, count + 1, nonObstacles, grid, vis, dx, dy, m, n);
            }
        }
        vis[x][y] = false;
        return sum;
    }

    private static boolean isValid(int x, int y, int[][] grid, boolean[][] vis, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n && grid[x][y] != -1 && !vis[x][y];
    }
}
