package All_Problems;
class HowManyNumbersAreSmallerThantheCurrentNumber {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] ans = new int[nums.length];
        int count;
        for (int i = 0; i < nums.length; i++) {
            count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                if (nums[i] > nums[j]) {
                    count++;
                }
            }
            ans[i] = count;
        }
        return ans;
    }
}