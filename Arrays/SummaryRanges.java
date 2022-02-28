// https://leetcode.com/problems/summary-ranges/
package Arrays;

import java.util.List;
import java.util.ArrayList;

public class SummaryRanges {

    public static void main(String[] args) {
         int[] nums = {0,1,2,4,5,7};
        System.out.println(summaryRanges(nums));
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(nums[i]);

            for (int j = i; j < nums.length; j++) {

                if (j == nums.length - 1 || nums[j] + 1 != nums[j + 1]) {

                    // if there is a range
                    if (i != j) {
                        sb.append("->");
                        sb.append(nums[j]);
                    }
                    i = j;
                    break;
                }
            }

            list.add(sb.toString());
        }

        return list;
    }
}
