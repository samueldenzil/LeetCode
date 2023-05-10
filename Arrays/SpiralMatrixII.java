// https://leetcode.com/problems/spiral-matrix-ii/
package Arrays;

import java.util.Arrays;

public class SpiralMatrixII {

    public static void main(String[] args) {
        int n = 3;
        int[][] matrix = generateMatrix(n);
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int counter = 1;

        // Initially we set 4 pointers left, right, top, down as 0, n - 1, 0, n - 1
        // respectively

        int left = 0, right = n - 1;
        int top = 0, down = n - 1;

        // 0 = left -> right
        // 1 = top -> down
        // 2 = right -> left
        // 3 = down -> top

        int direction = 0; // Initially we are staring from left to right

        while (left <= right && top <= down) {
            if (direction == 0) {
                // Going from left to right
                for (int i = left; i <= right; i++) {
                    ans[top][i] = counter++;
                }
                // After going from left to right I want to go one step down
                top += 1;
            } else if (direction == 1) {
                // Going from top to down
                for (int i = top; i <= down; i++) {
                    ans[i][right] = counter++;
                }
                // After going from top to down I want to go one step left
                right -= 1;
            } else if (direction == 2) {
                // Going from right to left
                for (int i = right; i >= left; i--) {
                    ans[down][i] = counter++;
                }
                // After going from right to left I want to go one step top
                down -= 1;
            } else {
                // Going from down to top
                for (int i = down; i >= top; i--) {
                    ans[i][left] = counter++;
                }
                // After going from down to top I want to go one step right
                left += 1;
            }

            direction += 1;
            direction %= 4;
        }

        return ans;
    }
}
