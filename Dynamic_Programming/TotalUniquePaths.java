// https://www.codingninjas.com/codestudio/problems/total-unique-paths_1081470
package Dynamic_Programming;

public class TotalUniquePaths {

	public static void main(String[] args) {
		int m = 3;
		int n = 3;
		System.out.println(uniquePaths(m, n));
	}

	// TC: O(m * n)
	// SC: O(n)
	public static int uniquePaths(int m, int n) {
		int[] prevRow = new int[n];

		for (int i = 0; i < m; i++) {
			int[] curr = new int[n];

			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0) {
					curr[j] = 1;
					continue;
				}
				int up = 0;
				int left = 0;

				if (i - 1 >= 0)
					up = prevRow[j];
				if (j - 1 >= 0)
					left = curr[j - 1];

				curr[j] = up + left;
			}

			prevRow = curr;
		}

		return prevRow[n - 1];
	}


	// TC: O(m * n)
	// SC: O(m * n)
	/* public static int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];

		// Base case
		dp[0][0] = 1;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0) {
					continue;
				}
				int up = 0;
				int left = 0;

				if (i - 1 >= 0)
					up = dp[i - 1][j];
				if (j - 1 >= 0)
					left = dp[i][j - 1];

				dp[i][j] = up + left;
			}
		}

		return dp[m - 1][n - 1];
	} */


	// TC: O(m * n)
	// SC: O((m - 1) + (n - 1) + (m * n))
	/* public static int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}

		return helper(m - 1, n - 1, dp);
	}

	private static int helper(int i, int j, int[][] dp) {
		// Base case
		if (i == 0 && j == 0) {
			return 1;
		}
		// If we go outside the grid
		if (i < 0 || j < 0) {
			return 0;
		}

		if (dp[i][j] != -1) {
			return dp[i][j];
		}

		int up = helper(i - 1, j, dp);
		int left = helper(i, j - 1, dp);

		return dp[i][j] = up + left;
	} */
}
