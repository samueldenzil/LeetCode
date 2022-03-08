// https://leetcode.com/problems/sliding-window-median/
package All_Problems;

import java.util.Arrays;

public class SlidingWindowMedian {

    public static void main(String[] args) {
        int[] nums = {2147483647,2147483647};
        int k = 2;
        System.out.println(Arrays.toString(medianSlidingWindow(nums, k)));
    }

    public static double[] medianSlidingWindow(int[] nums, int k) {
        double[] ans = new double[nums.length - k + 1];

        for (int i = 0; i < nums.length - k + 1; i++) {
            int[] temp = copyArrayAndSort(nums, i, i + k - 1);
            if (k % 2 != 0) {
                ans[i] = (long) temp[k / 2];
            } else {
                ans[i] = ((long) temp[(k - 1) / 2] + (long) temp[k / 2]) / 2.0;
            }
        }

        return ans;
    }

    public static int[] copyArrayAndSort(int[] arr, int start, int end) {
        int[] newArray = new int[end - start + 1];
        int j = 0;
        for (int i = start; i < end + 1; i++) {
            newArray[j] = arr[i];
            j++;
        }
        Arrays.sort(newArray);
        return newArray;
    }
}
