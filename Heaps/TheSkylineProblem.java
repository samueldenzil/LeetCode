// https://leetcode.com/problems/the-skyline-problem/
package Heaps;

import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class TheSkylineProblem {

    public static void main(String[] args) {
        int[][] buildings = {{1, 3, 5}, {2, 5, 10}, {4, 6, 7}};
        System.out.println(getSkyline(buildings));
    }

    public static List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<int[]> heights = new ArrayList<>();

        transformBuilding(buildings, heights);
        heights.sort((a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));

        pq.offer(0);
        int prevMax = 0;

        for (int[] height : heights) {
            if (height[1] < 0) {
                pq.offer(-height[1]);
            } else {
                pq.remove(height[1]);
            }
            int currMax = pq.peek();
            if (currMax != prevMax) {
                List<Integer> subRes = new ArrayList<>();
                subRes.add(height[0]);
                subRes.add(currMax);
                res.add(subRes);
                prevMax = currMax;
            }
        }

        return res;
    }

    private static void transformBuilding(int[][] buildings, List<int[]> heights) {
        for (int[] building : buildings) {
            heights.add(new int[]{building[0], -building[2]});  // start
            heights.add(new int[]{building[1], building[2]});   // end
        }
    }
}
