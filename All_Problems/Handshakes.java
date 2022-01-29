// https://practice.geeksforgeeks.org/problems/handshakes1303/1
package All_Problems;

public class Handshakes {

    public static void main(String[] args) {
        int N = 8;
        System.out.println(count(N));
    }

    static int count(int N) {
        // code here
        int[] dp = new int[N + 1];

        dp[0] = 1;

        for (int n = 2; n <= N; n += 2) {

            for (int i = 0; i <= n - 2; i += 2) {

                dp[n] += dp[i] * dp[n - 2 - i];
            }
        }

        return dp[N];
    }
}
