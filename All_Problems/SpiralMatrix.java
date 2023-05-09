// https://leetcode.com/problems/spiral-matrix/
package All_Problems;

import java.util.List;
import java.util.ArrayList;

public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        // directions
        // 0 = left -> right
        // 1 = top -> down
        // 2 = right -> left
        // 3 = down -> top

        List<Integer> ans = new ArrayList<>();

        int top = 0, down = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        int directionPointer = 0;

        while (top <= down && left <= right) {
            if (directionPointer == 0) {
                // from left to right
                // here the row is fixed but the columns are changing
                for (int i = left; i <= right; i++) {
                    ans.add(matrix[top][i]);
                }
                // after going from left to right i want to go to the next row
                top++;
            } else if (directionPointer == 1) {
                // from top to bottom
                // here the column is fixed but the rows are changing
                for (int i = top; i <= down; i++) {
                    ans.add(matrix[i][right]);
                }
                // after going from top to bottom i want to go to the previous column
                right--;
            } else if (directionPointer == 2) {
                // from right to left
                // here the row is fixed but the columns are changing
                for (int i = right; i >= left; i--) {
                    ans.add(matrix[down][i]);
                }
                // after going from right to left i want to go to the above row
                down--;
            } else if (directionPointer == 3) {
                // from down to top
                // here the column if fixed but the rows are changing
                for (int i = down; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
                // after going from down to top i want to go to the next column
                left++;
            }
            directionPointer += 1;
            directionPointer %= 4;
        }

        return ans;
    }
}
