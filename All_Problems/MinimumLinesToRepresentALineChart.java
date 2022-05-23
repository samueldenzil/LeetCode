// https://leetcode.com/problems/minimum-lines-to-represent-a-line-chart/
package All_Problems;

import java.util.Arrays;

public class MinimumLinesToRepresentALineChart {

    public static void main(String[] args) {
        int[][] stockPrices = {{1, 7}, {2, 6}, {3, 5}, {4, 4}, {5, 4}, {6, 3}, {7, 2}, {8, 1}};
        System.out.println(minimumLines(stockPrices));
    }

    public static int minimumLines(int[][] stockPrices) {
        Arrays.sort(stockPrices, (a, b) -> (a[0] - b[0]));
        int n = stockPrices.length;
        if (n == 1) {
            return 0;
        }
        int count = 1;

        for (int i = 2; i < n; i++) {
            int x1 = stockPrices[i][0];
            int y1 = stockPrices[i][1];
            int x2 = stockPrices[i - 1][0];
            int y2 = stockPrices[i - 1][1];
            int x3 = stockPrices[i - 2][0];
            int y3 = stockPrices[i - 2][1];

            /*
            (y2 - y1)       (y3 - y2)
            ---------   =   ---------
            (x2 - x1)       (x3 - x2)
            */

            double diff1 = (y2 - y1) * (x3 - x2);
            double diff2 = (x2 - x1) * (y3 - y2);

            if (diff1 != diff2) {
                count++;
            }
        }

        return count;
    }
}
