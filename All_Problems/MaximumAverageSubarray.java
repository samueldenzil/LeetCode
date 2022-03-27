// https://practice.geeksforgeeks.org/problems/maximum-average-subarray5859/1
package All_Problems;

public class MaximumAverageSubarray {

    public static void main(String[] args) {
        int[] arr = {1, 12, -5, -6, 50, 3};
        int k = 4;
        System.out.println(findMaxAverage(arr, arr.length, k));
    }

    static int findMaxAverage(int[] arr, int n, int k) {
        // code here
        int sum = 0;
        int start = 0;

        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        int tempSum = sum;
        for (int i = k; i < n; i++) {
            tempSum += (arr[i] - arr[i - k]);
            if (tempSum > sum) {
                sum = tempSum;
                start = i - k + 1;
            }
        }

        return start;
    }
}
