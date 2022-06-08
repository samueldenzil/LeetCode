// https://leetcode.com/problems/pascals-triangle/
package All_Problems;

import java.util.List;
import java.util.ArrayList;

public class PascalsTriangle {

    public static void main(String[] args) {
        int numRows = 4;
        List<List<Integer>> ans = generate(numRows);

        for (List<Integer> row : ans) {
            System.out.println(row);
        }
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> prev = null;

        for (int i = 0; i < numRows; i++) {
            List<Integer> curr = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    curr.add(1);
                } else {
                    int temp = prev.get(j - 1) + prev.get(j);
                    curr.add(temp);
                }
            }
            prev = curr;
            ans.add(curr);
        }

        return ans;
    }
}