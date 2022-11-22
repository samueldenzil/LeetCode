// https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/
package Graph;

import java.util.Queue;
import java.util.LinkedList;

public class NearestExitFromEntranceInMaze {

    public static void main(String[] args) {
        char[][] maze = {
                {'+', '+', '.', '+'},
                {'.', '.', '.', '+'},
                {'+', '+', '+', '.'}
        };
        int[] entrance = {1, 2};
        System.out.println(nearestExit(maze, entrance));
    }

    public static int nearestExit(char[][] maze, int[] entrance) {
        int startX = entrance[0];
        int startY = entrance[1];
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] vis = new boolean[m][n];

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(startX, startY, 0));
        vis[startX][startY] = true;

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        while (!queue.isEmpty()) {
            int x = queue.peek().x;
            int y = queue.peek().y;
            int dist = queue.peek().dist;
            queue.poll();

            if ((x == 0 || x == m - 1 || y == 0 || y == n - 1) && (x != startX || y != startY)) {
                return dist;
            }

            for (int i = 0; i < 4; i++) {
                int nX = x + dx[i];
                int nY = y + dy[i];
                if (isValid(nX, nY, maze, vis, m, n)) {
                    queue.add(new Pair(nX, nY, dist + 1));
                    vis[nX][nY] = true;
                }
            }
        }

        return -1;
    }

    private static boolean isValid(int x, int y, char[][] maze, boolean[][] vis, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == '.' && !vis[x][y];
    }

    static class Pair {
        int x;
        int y;
        int dist;

        Pair(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
