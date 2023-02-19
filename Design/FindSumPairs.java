// https://leetcode.com/problems/finding-pairs-with-a-certain-sum/
package Design;

import java.util.HashMap;
import java.util.Map;

public class FindSumPairs {

    private Map<Integer, Integer> map;    // element, frequency
    private int[] nums1;
    private int[] nums2;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;

        map = new HashMap<>();
        for (int it : nums2) {
            updateFrequency(it, 1);
        }
    }

    public void add(int index, int val) {
        updateFrequency(nums2[index], -1);
        nums2[index] += val;
        updateFrequency(nums2[index], 1);
    }

    public int count(int tot) {
        int ans = 0;
        for (int it : nums1) {
            if (map.containsKey(tot - it)) {
                ans += map.get(tot - it);
            }
        }
        return ans;
    }

    private void updateFrequency(int key, int inc) {
        map.put(key, map.getOrDefault(key, 0) + inc);
    }

    public static void main(String[] args) {
        FindSumPairs findSumPairs = new FindSumPairs(new int[]{1, 1, 2, 2, 2, 3}, new int[]{1, 4, 5, 2, 5, 4});
        System.out.println(findSumPairs.count(7));  // return 8; pairs (2,2), (3,2), (4,2), (2,4), (3,4), (4,4) make 2 + 5 and pairs (5,1), (5,5) make 3 + 4
        findSumPairs.add(3, 2); // now nums2 = [1,4,5,4,5,4]
        System.out.println(findSumPairs.count(8));  // return 2; pairs (5,2), (5,4) make 3 + 5
        System.out.println(findSumPairs.count(4));  // return 1; pair (5,0) makes 3 + 1
        findSumPairs.add(0, 1); // now nums2 = [2,4,5,4,5,4]
        findSumPairs.add(1, 1); // now nums2 = [2,5,5,4,5,4]
        System.out.println(findSumPairs.count(7));  // return 11; pairs (2,1), (2,2), (2,4), (3,1), (3,2), (3,4), (4,1), (4,2), (4,4) make 2 + 5 and pairs (5,3), (5,5) make 3 + 4
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */