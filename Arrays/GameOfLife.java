// https://leetcode.com/problems/game-of-life/
package Arrays;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class GameOfLife {

    public static void main(String[] args) {
        int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        gameOfLife(board);

        for (int[] arr : board) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {
                checkNeighbors(board, i, j, list);
            }
        }

        for (int[] arr : list) {
            int x = arr[0];
            int y = arr[1];
            if (board[x][y] == 1) {
                board[x][y] = 0;
            } else {
                board[x][y] = 1;
            }
        }
    }

    public static void checkNeighbors(int[][] board, int x, int y, List<int[]> list) {
        int m = board.length;
        int n = board[0].length;

        int liveCellCount = 0;
        int[] neighbors = new int[8];

        // Getting the values present in the neighbors
        neighbors[0] = x - 1 >= 0 && y - 1 >= 0 ? board[x - 1][y - 1] : -1;
        neighbors[1] = x - 1 >= 0 ? board[x - 1][y] : -1;
        neighbors[2] = x - 1 >= 0 && y + 1 < n ? board[x - 1][y + 1] : -1;
        neighbors[3] = y - 1 >= 0 ? board[x][y - 1] : -1;
        neighbors[4] = y + 1 < n ? board[x][y + 1] : -1;
        neighbors[5] = x + 1 < m && y - 1 >= 0 ? board[x + 1][y - 1] : -1;
        neighbors[6] = x + 1 < m ? board[x + 1][y] : -1;
        neighbors[7] = x + 1 < m && y + 1 < n ? board[x + 1][y + 1] : -1;

        // Calculating the count of 1's
        for (int i = 0; i < neighbors.length; i++) {
            if (neighbors[i] == 1) {
                liveCellCount++;
            }
        }

        if (board[x][y] == 1) {
            if (liveCellCount < 2) {
                // Any live cell with fewer than two live neighbors dies as if caused by
                // under-population.
                list.add(new int[] { x, y });
            } else if (liveCellCount >= 2 && liveCellCount <= 3) {
                // Any live cell with two or three live neighbors lives on to the next
                // generation.
                // no need to do anything
            } else if (liveCellCount > 3) {
                // Any live cell with more than three live neighbors dies, as if by
                // over-population.
                list.add(new int[] { x, y });
            }
        } else {
            if (liveCellCount == 3) {
                // Any dead cell with exactly three live neighbors becomes a live cell, as if by
                // reproduction.
                list.add(new int[] { x, y });
            }
        }
    }
}
