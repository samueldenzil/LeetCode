// https://practice.geeksforgeeks.org/problems/subsets-1587115621/1
package All_Problems;

import java.util.Arrays;
import java.util.ArrayList;

public class UniqueSubsets {

    public static void main(String[] args) {
        int[] arr = {2, 1, 2};
        int n = arr.length;
        System.out.println(AllSubsets(arr, n));
    }

    public static ArrayList<ArrayList<Integer>> AllSubsets(int[] arr, int n) {
        // your code here
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        helper(ans, arr, n, 0, new ArrayList<>());
        return ans;
    }

    private static void helper(ArrayList<ArrayList<Integer>> ans, int[] arr, int length, int index, ArrayList<Integer> currentList) {
        // Adding all the possible subsets
        if (!ans.contains(currentList))
            ans.add(new ArrayList<>(currentList));

        // Base case
        if (index == length) {
            return;
        }

        for (int i = index; i < length; i++) {
            currentList.add(arr[i]);
            helper(ans, arr, length, i + 1, currentList);
            currentList.remove(currentList.size() - 1);
        }
    }
}
