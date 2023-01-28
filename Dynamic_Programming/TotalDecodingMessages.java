// https://practice.geeksforgeeks.org/problems/total-decoding-messages1235/1
package Dynamic_Programming;

import java.util.Arrays;

class TotalDecodingMessages {
	
	public static void main(String[] args) {
		String str = "123";
		System.out.println(CountWays(str));
	}
	
	private static int MOD = (int) 1e9 + 7;
	
	// Memoization
	// TC: O(n * 2)
	// SC: O(n) + O(n)
    public static int CountWays(String str) {
        // code here
    	int n = str.length();
    	int[] dp = new int[n + 1];
    	Arrays.fill(dp, -1);
        return helper(0, str, n, dp);
    }
    
    private static int helper(int idx, String str, int n, int[] dp) {
        if (idx == n) {
            return 1;
        }
        
        if (dp[idx] != -1) {
        	return dp[idx];
        }
        
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = idx; i < Math.min(idx + 2, n); i++) {
            sb.append(str.charAt(i));
            if (isValid(sb)) {
                count += helper(i + 1, str, n, dp) % MOD;
            }
        }
        return dp[idx] = count % MOD;
    }
    
    // Tabulation
    // TC: O(n * 2)
    // SC: O(n)
    /* public static int CountWays(String str) {
        // code here
    	int n = str.length();
    	int[] dp = new int[n + 1];
    	
    	// base case
    	dp[n] = 1;
    
    	for (int idx = n - 1; idx >= 0; idx--) {
            int count = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = idx; i < Math.min(idx + 2, n); i++) {
                sb.append(str.charAt(i));
                if (isValid(sb)) {
                    count += dp[i + 1] % MOD;
                }
            }
            dp[idx] = count % MOD;
    	}
    	
        return dp[0];
    } */
    
    private static boolean isValid(StringBuilder sb) {
    	if (sb.charAt(0) == '0') {
    		return false;
    	}
    	int num = Integer.parseInt(sb.toString());
    	return num >= 1 && num <= 26;
    }
}