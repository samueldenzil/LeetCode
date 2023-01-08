// https://leetcode.com/problems/gas-station/
package All_Problems;

public class GasStation {

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(canCompleteCircuit(gas, cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        if (getArraySum(gas) < getArraySum(cost)) {
            return -1;
        }

        int total = 0;
        int result = 0;
        for (int i = 0; i < n; i++) {
            total += (gas[i] - cost[i]);
            if (total < 0) {
                total = 0;
                result = i + 1;
            }
        }

        return result;
    }

    private static int getArraySum(int[] arr) {
        int sum = 0;
        for (int it : arr) {
            sum += it;
        }
        return sum;
    }
}
