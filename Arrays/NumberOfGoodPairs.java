package Arrays;

// required approach
class NumberOfGoodPairs {
    public int numIdenticalPairs(int[] nums) {
        int ans = 0;
        int[] temp = new int[101];

        for (int i = 0; i < nums.length; i++) {
            temp[nums[i]]++;
        }

        for (int i = 0; i < temp.length; i++) {
            ans = ans + temp[i] * (temp[i] - 1) / 2;
        }
        return ans;
    }
}

// my approach
/* class Solution {
    public int numIdenticalPairs(int[] nums) {
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && i < j) {
                    ans++;
                }
            }
        }

        return ans;
    }
} */