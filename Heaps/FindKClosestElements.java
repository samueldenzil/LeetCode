// https://leetcode.com/problems/find-k-closest-elements/
package Heaps;

import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class FindKClosestElements {

    public static void main(String[] args) {

    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        // max heap
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]);

        for (int i = 0; i < arr.length; i++) {
            pq.add(new int[]{Math.abs(arr[i] - x), arr[i]});
            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int[] pair : pq) {
            ans.add(pair[1]);
        }

        ans.sort((a, b) -> (a - b));
        return ans;
    }
}
