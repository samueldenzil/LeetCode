// https://practice.geeksforgeeks.org/problems/broken-blocks0022/1
package All_Problems;

import java.util.Arrays;

public class BrokenBlocks {

	public static void main(String[] args) {
		int[][] matrix = {
				{2, 5, 6},
				{ -1, 3, 2},
				{4, -1, 5}
		};

		System.out.println(MaxGold(matrix));
	}

	// Tabulation + Space Optimization
	public static int MaxGold(int[][] matrix) {
		// Code here
		int m = matrix.length;
		int n = matrix[0].length;

		int[] front = new int[n];

		for (int i = 0; i < n; i++) {
			if (matrix[m - 1][i] == -1) {
				front[i] = (int) - 1e9;
			} else {
				front[i] = matrix[m - 1][i];
			}
		}

		for (int i = m - 2; i >= 0; i--) {
			int[] curr = new int[n];
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == -1) {
					continue;
				}
				int leftDiagonal = 0;
				if (j - 1 >= 0) {
					leftDiagonal = front[j - 1];
				} else {
					leftDiagonal = (int) - 1e9;
				}

				int down = front[j];

				int rightDiagonal = 0;
				if (j + 1 < n) {
					rightDiagonal = front[j + 1];
				} else {
					rightDiagonal = (int) - 1e9;
				}

				if (leftDiagonal == -1e9 && down == -1e9 && rightDiagonal == -1e9) {
					curr[j] = matrix[i][j];
					continue;
				}

				leftDiagonal += matrix[i][j];
				down += matrix[i][j];
				rightDiagonal += matrix[i][j];

				curr[j] = Math.max(leftDiagonal, Math.max(down, rightDiagonal));
			}
			front = curr;
		}

		int max = front[0];
		for (int i = 1; i < n; i++) {
			max = Math.max(max, front[i]);
		}

		return max;
	}


	// Tabulation
	/* public static int MaxGold(int[][] matrix) {
		// Code here
		int m = matrix.length;
		int n = matrix[0].length;

		int[][] dp = new int[m][n];

		for (int i = 0; i < n; i++) {
			if (matrix[m - 1][i] == -1) {
				dp[m - 1][i] = (int) - 1e9;
			} else {
				dp[m - 1][i] = matrix[m - 1][i];
			}
		}

		for (int i = m - 2; i >= 0; i--) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == -1) {
					continue;
				}
				int leftDiagonal = 0;
				if (j - 1 >= 0) {
					leftDiagonal = dp[i + 1][j - 1];
				} else {
					leftDiagonal = (int) - 1e9;
				}

				int down = dp[i + 1][j];

				int rightDiagonal = 0;
				if (j + 1 < n) {
					rightDiagonal = dp[i + 1][j + 1];
				} else {
					rightDiagonal = (int) - 1e9;
				}

				if (leftDiagonal == -1e9 && down == -1e9 && rightDiagonal == -1e9) {
					dp[i][j] = matrix[i][j];
					continue;
				}

				leftDiagonal += matrix[i][j];
				down += matrix[i][j];
				rightDiagonal += matrix[i][j];

				dp[i][j] = Math.max(leftDiagonal, Math.max(down, rightDiagonal));
			}
		}

		int max = dp[0][0];
		for (int i = 1; i < n; i++) {
			max = Math.max(max, dp[0][i]);
		}

		return max;
	} */


    // Memoization
    /* public static int MaxGold(int[][] matrix) {
        // Code here
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            int curr = helper(0, i, matrix, m, n, dp);
            max = Math.max(max, curr);
        }

        return max;
    }

    private static int helper(int i, int j, int[][] matrix, int m, int n, int[][] dp) {
        // If we go outside the matrix or there is a wooden block
        if (i < 0 || j < 0 || i >= m || j >= n || matrix[i][j] == -1) {
            return (int) -1e9;
        }

        // Base case
        if (i == m - 1) {
            return matrix[i][j];
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int leftDiagonal = helper(i + 1, j - 1, matrix, m, n, dp);
        int down = helper(i + 1, j, matrix, m, n, dp);
        int rightDiagonal = helper(i + 1, j + 1, matrix, m, n, dp);

        // If we are not able to move further level because all blocks are wooden block
        if (leftDiagonal == -1e9 && down == -1e9 && rightDiagonal == -1e9) {
            return matrix[i][j];
        }

        leftDiagonal += matrix[i][j];
        down += matrix[i][j];
        rightDiagonal += matrix[i][j];

        return dp[i][j] = Math.max(leftDiagonal, Math.max(down, rightDiagonal));
    } */
}