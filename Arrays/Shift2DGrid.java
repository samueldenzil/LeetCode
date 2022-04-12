// https://leetcode.com/problems/shift-2d-grid/
package Arrays;

import java.util.List;
import java.util.ArrayList;

public class Shift2DGrid {

    public static void main(String[] args) {
        int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int k = 1;
        List<List<Integer>> ans = shiftGrid(grid, k);
        for (List<Integer> row : ans) {
            System.out.println(row);
        }
    }

    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        List<List<Integer>> ans = new ArrayList<>();

        // Creating a 2D List and initializing the value as 0
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(0);
            }
            ans.add(row);
        }

        // Iterating the list and setting the index after k shifts
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int currentNum = grid[i][j];
                int y = (j + k) % n;
                int incrementI = (j + k) / n;
                int x = (i + incrementI) % m;
                ans.get(x).set(y, currentNum);
            }
        }

        return ans;
    }
}
