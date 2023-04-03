// https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions/
package Arrays;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class ConvertAnArrayIntoA2DArrayWithConditions {

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 1, 2, 3, 1};
        System.out.println(findMatrix(nums));
    }

    public static List<List<Integer>> findMatrix(int[] nums) {
        List<Set<Integer>> list = new ArrayList<>();

        for (int it : nums) {
            int i = 0;
            while (i < list.size() && list.get(i).contains(it)) {
                i++;
            }
            if (i == list.size()) {
                list.add(new HashSet<>());
            }
            list.get(i).add(it);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (Set<Integer> set : list) {
            ans.add(new ArrayList<>(set));
        }

        return ans;
    }
}
