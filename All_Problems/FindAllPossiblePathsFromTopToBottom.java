// https://practice.geeksforgeeks.org/problems/find-all-possible-paths-from-top-to-bottom/1
package All_Problems;

import java.util.ArrayList;

public class FindAllPossiblePathsFromTopToBottom {

    public static void main(String[] args) {
        int[][] grid = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int n = grid.length;
        int m = grid[0].length;

        ArrayList<ArrayList<Integer>> ans = findAllPossiblePaths(n, m, grid);
        for (ArrayList<Integer> list : ans) {
            System.out.println(list);
        }
    }

    public static ArrayList<ArrayList<Integer>> findAllPossiblePaths(int n, int m, int[][] grid) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        boolean[][] vis = new boolean[n][m];

        helper(0, 0, n, m, grid, vis, ans, new ArrayList<>());

        return ans;
    }

    private static void helper(int i, int j, int n, int m, int[][] grid, boolean[][] vis, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> curr) {
        if (i == n - 1 && j == m - 1) {
            curr.add(grid[i][j]);
            ans.add(new ArrayList<>(curr));
            curr.remove(curr.size() - 1);
            return;
        }

        if (!isValid(i, j, n, m, vis)) {
            return;
        }

        vis[i][j] = true;
        curr.add(grid[i][j]);

        helper(i + 1, j, n, m, grid, vis, ans, curr);
        helper(i, j + 1, n, m, grid, vis, ans, curr);

        curr.remove(curr.size() - 1);
        vis[i][j] = false;
    }

    private static boolean isValid(int i, int j, int n, int m, boolean[][] vis) {
        if (i >= n || j >= m || vis[i][j]) {
            return false;
        }
        return true;
    }
}
