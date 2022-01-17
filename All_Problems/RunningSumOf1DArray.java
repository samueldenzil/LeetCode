package All_Problems;
// my approach
/* class RunningSumOf1DArray {
    public int[] runningSum(int[] nums) {
        int[] runningSum = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= i; j++) {
                runningSum[i] += nums[j];
            }
        }

        return runningSum;
    }
} */

// required approach
class RunningSumOf1DArray {
    public int[] runningSum(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }

        return nums;
    }
}
