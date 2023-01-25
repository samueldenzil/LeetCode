package Graph;

import java.util.Queue;
import java.util.LinkedList;

public class BoardGame {

    public static void main(String[] args) {
        int[][] board = {
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}
        };
        System.out.println(game(board));
    }

    public static int game(int[][] board) {
        int n = board.length;
        boolean[][] vis = new boolean[n][n];
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(1, 0));
        vis[n - 1][0] = true;

        while (!queue.isEmpty()) {
            int num = queue.peek().num;
            int moves = queue.peek().moves;
            queue.poll();

            if (num == n * n) {
                return moves;
            }

            for (int k = 1; k <= 6; k++) {
                int nextNum = num + k;
                if (nextNum > n * n) {
                    break;
                }

                int[] pos = getPos(nextNum, n);
                int row = pos[0];
                int col = pos[1];
                if (vis[row][col]) {
                    continue;
                }

                if (board[row][col] != -1) {
                    nextNum = board[row][col];
                }

                queue.add(new Pair(nextNum, moves + 1));
                vis[row][col] = true;
            }
        }

        return -1;
    }

    private static int[] getPos(int num, int n) {
        int row = n - 1 - ((num - 1) / n);
        int col = (num - 1) % n;
        if ((n % 2 == 0 && row % 2 == 0) || (n % 2 == 1 && row % 2 == 1)) {
            col = n - 1 - col;
        }
        return new int[]{row, col};
    }

    private static class Pair {
        int num;
        int moves;

        Pair(int num, int moves) {
            this.num = num;
            this.moves = moves;
        }
    }
}
