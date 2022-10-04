// https://leetcode.com/problems/minimum-time-to-make-rope-colorful/
package Greedy;

public class MinimumTimeToMakeRopeColorful {

    public static void main(String[] args) {
        String colors = "abaac";
        int[] neededTime = {1, 2, 3, 4, 5};
        System.out.println(minCost(colors, neededTime));
    }

    public static int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        int time = 0;

        for (int i = 1; i < n; i++) {
            if (colors.charAt(i) == colors.charAt(i - 1)) {
                if (neededTime[i] < neededTime[i - 1]) {
                    time += neededTime[i];
                    neededTime[i] = neededTime[i - 1];
                } else {
                    time += neededTime[i - 1];
                }
            }
        }

        return time;
    }
}
