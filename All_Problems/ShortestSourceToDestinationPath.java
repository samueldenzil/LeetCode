// https://practice.geeksforgeeks.org/problems/shortest-source-to-destination-path3544/1
package All_Problems;

import java.util.Queue;
import java.util.LinkedList;

public class ShortestSourceToDestinationPath {

    static class Pair {
        int row;
        int col;
        int dist;

        Pair(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

    public static void main(String[] args) {
        int[][] A = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 1, 1}
        };
        int X = 2;
        int Y = 3;
        System.out.println(shortestDistance(A.length, A[0].length, A, X, Y));
    }

    public static int shortestDistance(int N, int M, int A[][], int X, int Y) {
        // code here
        if (A[0][0] == 0 || A[X][Y] == 0) {
            return -1;
        }

        boolean[][] visited = new boolean[N][M];
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(0, 0, 0));
        visited[0][0] = true;

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            int row = queue.peek().row;
            int col = queue.peek().col;
            int dist = queue.peek().dist;
            queue.poll();

            if (row == X && col == Y) {
                return dist;
            }

            for (int i = 0; i < 4; i++) {
                int nrow = row + dx[i];
                int ncol = col + dy[i];

                if (isValid(nrow, ncol, A, visited, N, M)) {
                    queue.add(new Pair(nrow, ncol, dist + 1));
                    visited[nrow][ncol] = true;
                }
            }
        }

        return -1;
    }

    private static boolean isValid(int row, int col, int[][] A, boolean[][] visited, int N, int M) {
        return row >= 0 && row < N && col >= 0 && col < M && A[row][col] == 1 && !visited[row][col];
    }
}