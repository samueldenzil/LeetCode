// https://leetcode.com/problems/split-array-largest-sum/
package All_Problems;

public class SplitArrayLargestSum {

    public static void main(String[] args) {
        int[] nums = {7, 2, 5, 10, 8};
        int m = 2;
        System.out.println(splitArray(nums, m));
    }

    public static int splitArray(int[] nums, int m) {
        int maxElement = 0;
        int sum = 0;

        for (int i : nums) {
            maxElement = Math.max(maxElement, i);
            sum += i;
        }

        int start = maxElement; // if we split the array into nums.length parts
        int end = sum;  // if we split the array into 1

        int ans = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            int subArrayCount = getNumberOfSubArrays(nums, mid);

            if (subArrayCount <= m) {
                ans = mid;  // The current mid could be the ans but check left
                // there could be a better ans
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }

    public static int getNumberOfSubArrays(int[] nums, int currentMax) {
        int sum = 0;
        int count = 1;

        for (int i : nums) {
            if (i + sum <= currentMax) {
                sum += i;
            } else {
                count++;
                sum = i;
            }
        }

        return count;
    }
}
