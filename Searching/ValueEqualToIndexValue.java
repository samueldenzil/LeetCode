// https://practice.geeksforgeeks.org/problems/value-equal-to-index-value1330/1/
package Searching;

import java.util.ArrayList;

public class ValueEqualToIndexValue {

    ArrayList<Integer> valueEqualToIndex(int[] arr, int n) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (arr[i] == i + 1) {
                ans.add(arr[i]);
            }
        }

        return ans;
    }
}
