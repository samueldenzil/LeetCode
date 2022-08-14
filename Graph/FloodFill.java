// https://leetcode.com/problems/flood-fill/
package Graph;

import java.util.Arrays;

public class FloodFill {

    public static void main(String[] args) {
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int sr = 1, sc = 1, color = 2;
        int[][] ans = floodFill(image, sr, sc, color);
        for (int[] row : ans) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int iniColor = image[sr][sc];
        int[][] ans = image.clone();
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        dfs(sr, sc, color, iniColor, image, ans, dx, dy, m, n);
        return ans;
    }

    private static void dfs(int row, int col, int color, int iniColor, int[][] image, int[][] ans, int[] dx, int[] dy, int m, int n) {
        ans[row][col] = color;

        for (int i = 0; i < 4; i++) {
            int nrow = row + dx[i];
            int ncol = col + dy[i];
            if (isValid(nrow, ncol, color, iniColor, image, ans, n, m)) {
                dfs(nrow, ncol, color, iniColor, image, ans, dx, dy, m, n);
            }
        }
    }

    private static boolean isValid(int row, int col, int color, int iniColor, int[][] image, int[][] ans, int n, int m) {
        if (row < 0 || row >= m || col < 0 || col >= n || image[row][col] != iniColor || ans[row][col] == color) {
            return false;
        }
        return true;
    }
}
