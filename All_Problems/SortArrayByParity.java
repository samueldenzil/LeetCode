// https://leetcode.com/problems/sort-array-by-parity/
package All_Problems;

import java.util.Arrays;

public class SortArrayByParity {

    public static void main(String[] args) {
        int[] nums = {2,4,6};
        System.out.println(Arrays.toString(sortArrayByParity(nums)));
    }

    public static int[] sortArrayByParity(int[] nums) {        
        int i = 0;
        int j = nums.length - 1;
        
        /*
        (i, j)
        (even, odd)     then they are in proper place
        (odd, even)     then we need to swap nums[i] and nums[j]
        (even, even)    then nums[i] is in proper place we will i++ 
        (odd, odd)      then nums[j] is in proper place we will j--
        */

        while (i < j) {
            if (nums[i] % 2 == 1 && nums[j] % 2 == 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }

            if (nums[i] % 2 == 0) i++;
            if (nums[j] % 2 == 1) j--;
        }

        return nums;
    }
}
