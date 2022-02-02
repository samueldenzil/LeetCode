// https://practice.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1
package Arrays;

import java.util.ArrayList;

public class LeadersInAnArray {

    public static void main(String[] args) {
        int[] arr = {16,17,4,3,5,2};
        System.out.println(leaders(arr, arr.length));
    }

    static ArrayList<Integer> leaders(int[] arr, int n){
        // Your code here
        ArrayList<Integer> ans = new ArrayList<>();
        int max = arr[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] >= max) {
                ans.add(arr[i]);
                max = arr[i];
            }
        }

        // reversing the array
        for (int i = 0; i < ans.size() / 2; i++) {
            int n1 = ans.get(i);
            int n2 = ans.get(ans.size() - i - 1);
            ans.set(i, n2);
            ans.set(ans.size() - i - 1, n1);
        }

        return ans;
    }
}
