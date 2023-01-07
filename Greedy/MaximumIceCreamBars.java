// https://leetcode.com/problems/maximum-ice-cream-bars/
package Greedy;

import java.util.Arrays;

public class MaximumIceCreamBars {

    public static void main(String[] args) {
        int[] costs = {1, 3, 2, 4, 1};
        int coins = 7;
        System.out.println(maxIceCream(costs, coins));
    }

    public static int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);

        int count = 0;
        for (int cost : costs) {
            if (coins < cost) {
                break;
            }
            count++;
            coins -= cost;
        }

        return count;
    }
}
