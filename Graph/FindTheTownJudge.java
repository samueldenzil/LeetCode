// https://leetcode.com/problems/find-the-town-judge/
package Graph;

public class FindTheTownJudge {

    public static void main(String[] args) {
        int n = 3;
        int[][] trust = {{1, 3}, {2, 3}};
        System.out.println(findJudge(n, trust));
    }

    public static int findJudge(int n, int[][] trust) {
        int[] trustCount = new int[n + 1];

        for (int[] edge : trust) {
            int u = edge[0];
            int v = edge[1];
            trustCount[v]++;
            trustCount[u]--;
        }

        int ans = -1;
        for (int i = 1; i < n + 1; i++) {
            if (trustCount[i] == n - 1) {
                ans = i;
            }
        }

        return ans;
    }
}
