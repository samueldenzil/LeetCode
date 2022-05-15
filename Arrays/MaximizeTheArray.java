// https://practice.geeksforgeeks.org/problems/maximize-the-array3340/1
package Arrays;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MaximizeTheArray {

    public static void main(String[] args) {
        int[] arr1 = {7, 4, 8, 0, 1};
        int[] arr2 = {9, 7, 2, 3, 6};
        System.out.println(maximizeArray(arr1, arr2, arr1.length));
    }

    public static ArrayList<Integer> maximizeArray(int[] arr1, int[] arr2, int n) {
        // code here
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!pq.contains(arr1[i])) {
                pq.add(arr1[i]);
            }
            if (!pq.contains(arr2[i])) {
                pq.add(arr2[i]);
            }

            while (pq.size() > n) {
                pq.poll();
            }
        }

        // first adding all the greatest elements from arr2
        for (int i = 0; i < n; i++) {
            if (pq.contains(arr2[i])) {
                ans.add(arr2[i]);
                pq.remove(arr2[i]);
            }
        }
        // adding all the greatest elements from arr1
        for (int i = 0; i < n; i++) {
            if (pq.contains(arr1[i])) {
                ans.add(arr1[i]);
                pq.remove(arr1[i]);
            }
        }

        return ans;
    }
}
