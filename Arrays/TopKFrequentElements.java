// https://leetcode.com/problems/top-k-frequent-elements/
package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];

        // Min Heap
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        // Finding out the frequency of the elements
        for (int num : nums) {
            if (hashMap.containsKey(num)) {
                hashMap.put(num, hashMap.get(num) + 1);
            } else {
                hashMap.put(num, 1);
            }
        }

        // Storing the frequency inside the min heap
        for (int i : hashMap.keySet()) {
            pq.add(new int[]{i, hashMap.get(i)});
            if (pq.size() > k) pq.poll();
        }

        for (int i = 0; i < ans.length; i++) {
            ans[i] = pq.poll()[0];
        }

        return ans;
    }
}
