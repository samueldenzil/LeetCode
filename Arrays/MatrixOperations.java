// https://practice.geeksforgeeks.org/problems/7d7f73a59ddc3f9c8046af6bd66ea67311bf877e/1
package Arrays;

import java.util.Arrays;

public class MatrixOperations {

    public static void main(String[] args) {
        int[][] matrix = {
            {0, 1},
            {1, 0}
        };
        System.out.println(Arrays.toString(endPoints(matrix, matrix.length, matrix[0].length)));
    }

    static int [] endPoints(int [][]arr,int n, int m) {
        // code here
        int[] ans = new int[2];

        int i = 0;
        int j = 0;

        // direction = 1 => move Up
        // direction = 2 => move Right
        // direction = 3 => move Down
        // direction = 4 => move Left

        // initially start moving right
        int direction = 2;

        while (i < n && j < m && i >= 0 && j >= 0) {
            if (arr[i][j] == 1) {
                // changing the direction if arr[i][j] == 1
                direction = (direction + 1) % 4;
                arr[i][j] = 0;
            }
            // updating the direction
            if (direction == 1) {
                i--;
            } else if (direction == 2) {
                j++;
            } else if (direction == 3) {
                i++;
            } else {
                j--;
            }
        }

        if (i >= n) {
            i--;
        } else if (i < 0) {
            i++;
        }

        if (j >= m) {
            j--;
        } else if (j < 0) {
            j++;
        }

        ans[0] = i;
        ans[1] = j;

        return ans;
    }
}