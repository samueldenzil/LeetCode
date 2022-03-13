// https://leetcode.com/problems/find-all-k-distant-indices-in-an-array/
package All_Problems;

import java.util.List;
import java.util.ArrayList;

public class FindAllKDistantIndicesInAnArray {

    public static void main(String[] args) {
        int[] nums = {2,2,2,2,2};
        int key = 2;
        int k = 2;
        System.out.println(findKDistantIndices(nums, key, k));
    }

    public static List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> ans = new ArrayList<>();
        List<Integer> keyIndex = new ArrayList<>();

        // finding out all the key elements in the array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                keyIndex.add(i);
            }
        }

        // checking the keys Index with the other indexes
        for (int i = 0; i < nums.length; i++) {
            for (Integer j : keyIndex) {
                if (Math.abs(i - j) <= k) {
                    ans.add(i);
                    break;
                }
            }
        }

        return ans;
    }
}
