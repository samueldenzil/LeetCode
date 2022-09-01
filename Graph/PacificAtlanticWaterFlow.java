// https://leetcode.com/problems/pacific-atlantic-water-flow/
package Graph;

import java.util.List;
import java.util.ArrayList;

public class PacificAtlanticWaterFlow {

    public static void main(String[] args) {
        int[][] heights = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };

        System.out.println(pacificAtlantic(heights));
    }

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int j = 0; j < n; j++) {
            if (!pacific[0][j]) {
                dfs(0, j, heights, pacific, dx, dy);
            }
            if (!atlantic[m - 1][j]) {
                dfs(m - 1, j, heights, atlantic, dx, dy);
            }
        }

        for (int i = 0; i < m; i++) {
            if (!pacific[i][0]) {
                dfs(i, 0, heights, pacific, dx, dy);
            }
            if (!atlantic[i][n - 1]) {
                dfs(i, n - 1, heights, atlantic, dx, dy);
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> cell = new ArrayList<>();
                    cell.add(i);
                    cell.add(j);
                    ans.add(cell);
                }
            }
        }

        return ans;
    }

    private static void dfs(int row, int col, int[][] heights, boolean[][] vis, int[] dx, int[] dy) {
        vis[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int newRow = row + dx[i];
            int newCol = col + dy[i];

            if (isValid(newRow, newCol, vis) && heights[newRow][newCol] >= heights[row][col]) {
                dfs(newRow, newCol, heights, vis, dx, dy);
            }
        }
    }

    private static boolean isValid(int row, int col, boolean[][] vis) {
        int m = vis.length;
        int n = vis[0].length;
        return row >= 0 && row < m && col >= 0 && col < n && !vis[row][col];
    }
}
