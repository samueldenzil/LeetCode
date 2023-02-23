// https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
package Searching;

public class CapacityToShipPackagesWithinDDays {

    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;
        System.out.println(shipWithinDays(weights, days));
    }

    public static int shipWithinDays(int[] weights, int days) {
        int minCapacity = Integer.MIN_VALUE;
        int maxCapacity = 0;
        for (int it : weights) {
            minCapacity = Math.max(minCapacity, it);
            maxCapacity += it;
        }

        int start = minCapacity;
        int end = maxCapacity;
        int ans = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int d = getDaysWithCapacity(weights, mid);
            if (d <= days) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }

    private static int getDaysWithCapacity(int[] weights, int capacity) {
        int count = 1;
        int sum = 0;
        for (int it : weights) {
            sum += it;
            if (sum > capacity) {
                sum = it;
                count++;
            }
        }
        // System.out.println(capacity + " " + count);
        return count;
    }
}
