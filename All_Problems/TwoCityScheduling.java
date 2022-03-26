// https://leetcode.com/problems/two-city-scheduling/
package All_Problems;

import java.util.Arrays;

public class TwoCityScheduling {

    public static void main(String[] args) {
        int[][] costs = {{515, 563}, {451, 713}, {537, 709}, {343, 819}, {855, 779}, {457, 60}, {650, 359}, {631, 42}};
        System.out.println(twoCitySchedCost(costs));
    }

    public static int twoCitySchedCost(int[][] costs) {
        // if we go from cityA to cityB & cost of cityA > cityB. Means, going to cityB is much better choice
        // if we go from cityA to cityB & cost of cityA < cityB. Means, this will give a loss of -ve which
        // means going to cityA is better choice

        Arrays.sort(costs, (a, b) -> {
            return (a[0] - a[1]) - (b[0] - b[1]);
        });

        int minimumCost = 0;
        for (int i = 0; i < costs.length / 2; i++) {
            minimumCost += costs[i][0];
        }
        for (int i = costs.length / 2; i < costs.length; i++) {
            minimumCost += costs[i][1];
        }

        return minimumCost;
    }
}
