// https://practice.geeksforgeeks.org/problems/9656e96f6eaee49e67400fa2aed7833c8d9846b8/1
package All_Problems;

import java.util.Arrays;
import java.util.Hashtable;

public class NextElementWithGreaterFrequency {

    public static void main(String[] args) {
        int[] arr = {5, 1, 2, 3, 2, 5, 5, 4, 5, 2};
        System.out.println(Arrays.toString(print_next_greater_freq(arr, arr.length)));
    }

    static int[] print_next_greater_freq(int[] arr, int n) {
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();

        for (int i = 0; i < n; i++) {
            if (hashtable.containsKey(arr[i])) {
                int currentFrequency = hashtable.get(arr[i]);
                hashtable.put(arr[i], currentFrequency + 1);
            } else {
                hashtable.put(arr[i], 1);
            }
        }

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int j = 1;
            while (i + j < n && hashtable.get(arr[i]) >= hashtable.get(arr[i + j])) {
                j++;
            }
            ans[i] = i + j < n ? arr[i + j] : -1;
        }

        return ans;
    }
}
