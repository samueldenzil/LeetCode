// https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/
package All_Problems;

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

    public static int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;

        boolean[][] vis = new boolean[m][n];

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(entrance[0], entrance[1], 0));
        vis[entrance[0]][entrance[1]] = true;

        while (!queue.isEmpty()) {
            int x = queue.peek().x;
            int y = queue.peek().y;
            int dist = queue.peek().dist;
            queue.poll();

            if ((x == 0 || x == m - 1 || y == 0 || y == n - 1) && (x != entrance[0] || y != entrance[1])) {
                return dist;
            }

            for (int i = 0; i < 4; i++) {
                int nX = x + dx[i];
                int nY = y + dy[i];
                if (isValid(nX, nY, maze, vis)) {
                    queue.add(new Pair(nX, nY, dist + 1));
                    vis[nX][nY] = true;
                }
            }
        }

        return -1;
    }

    private static boolean isValid(int x, int y, char[][] maze, boolean[][] vis) {
        int m = maze.length;
        int n = maze[0].length;
        return x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == '.' && !vis[x][y];
    }
}
