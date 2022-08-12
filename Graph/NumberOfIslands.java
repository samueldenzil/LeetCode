// https://leetcode.com/problems/number-of-islands/
package Graph;

import java.util.Queue;
import java.util.LinkedList;

class NumberOfIslands {

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        int count = 0;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == '1' && !visited[row][col]) {
                    dfs(row, col, grid, visited);
                    count++;
                }
            }
        }

        return count;
    }

    private static void dfs(int row, int col, char[][] grid, boolean[][] visited) {
        visited[row][col] = true;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int newRow = row + dx[i];
            int newCol = col + dy[i];
            if (isValid(newRow, newCol, grid, visited)) {
                dfs(newRow, newCol, grid, visited);
            }
        }
    }

    private static void bfs(int row, int col, char[][] grid, boolean[][] visited) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(row, col));
        visited[row][col] = true;

        while (!queue.isEmpty()) {
            Pair node = queue.poll();
            int[] dx = {1, 0, -1, 0};
            int[] dy = {0, 1, 0, -1};

            for (int i = 0; i < 4; i++) {
                int newRow = node.first + dx[i];
                int newCol = node.second + dy[i];

                if (isValid(newRow, newCol, grid, visited)) {
                    queue.add(new Pair(newRow, newCol));
                    visited[newRow][newCol] = true;
                }
            }
        }
    }

    private static boolean isValid(int row, int col, char[][] grid, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;
        if (row < 0 || col < 0 || row >= m || col >= n || grid[row][col] != '1' || visited[row][col]) {
            return false;
        }
        return true;
    }

    private static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}