// https://practice.geeksforgeeks.org/problems/knight-walk4521/1
package All_Problems;

import java.util.Queue;
import java.util.LinkedList;

public class KnightWalk {

    public static void main(String[] args) {
        int N = 6;
        int[] KnightPos = {4, 5};
        int[] TargetPos = {1, 1};
        System.out.println(minStepToReachTarget(KnightPos, TargetPos, N));
    }

    static class Pair {
        int first;
        int second;
        int dist;

        Pair(int first, int second, int dist) {
            this.first = first;
            this.second = second;
            this.dist = dist;
        }
    }

    public static int minStepToReachTarget(int[] KnightPos, int[] TargetPos, int N) {
        // Code here
        boolean[][] visited = new boolean[N + 1][N + 1];
        int[][] possibleMoves = {{-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}};
        return bfs(KnightPos, TargetPos, visited, possibleMoves, N);
    }

    private static int bfs(int[] start, int[] end, boolean[][] visited, int[][] possibleMoves, int N) {
        Queue<Pair> queue = new LinkedList<>();
        int row = start[0];
        int col = start[1];
        visited[row][col] = true;
        queue.add(new Pair(row, col, 0));

        while (!queue.isEmpty()) {
            row = queue.peek().first;
            col = queue.peek().second;
            int dist = queue.peek().dist;
            queue.poll();

            if (row == end[0] && col == end[1]) {
                return dist;
            }

            for (int i = 0; i < 8; i++) {
                int nrow = row + possibleMoves[i][0];
                int ncol = col + possibleMoves[i][1];

                if (isValid(nrow, ncol, visited, N)) {
                    visited[nrow][ncol] = true;
                    queue.add(new Pair(nrow, ncol, dist + 1));
                }
            }
        }

        return -1;
    }

    private static boolean isValid(int row, int col, boolean[][] visited, int N) {
        return row > 0 && row <= N && col > 0 && col <= N && !visited[row][col];
    }
}
