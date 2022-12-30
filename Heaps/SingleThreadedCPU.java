// https://leetcode.com/problems/single-threaded-cpu/
package Heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SingleThreadedCPU {

    public static void main(String[] args) {
        int[][] tasks = {{1, 2}, {2, 4}, {3, 2}, {4, 1}};
        System.out.println(Arrays.toString(getOrder(tasks)));
    }

    public static int[] getOrder(int[][] tasks) {
        int n = tasks.length;

        int[][] sortedTasks = new int[n][3];    // enqueueTime, processingTime, index
        for (int i = 0; i < n; i++) {
            sortedTasks[i][0] = tasks[i][0];
            sortedTasks[i][1] = tasks[i][1];
            sortedTasks[i][2] = i;
        }

        Arrays.sort(sortedTasks, (a, b) -> (a[0] - b[0]));  // sorting according to enqueueTime
        int[] ans = new int[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]));    // min heap

        int currTime = 0;

        int i = 0;
        int it = 0;
        while (i < n || !pq.isEmpty()) {
            if (pq.isEmpty() && currTime < sortedTasks[i][0]) {
                currTime = sortedTasks[i][0];
            }

            while (i < n && sortedTasks[i][0] <= currTime) {
                pq.add(new int[]{sortedTasks[i][1], sortedTasks[i][2]});
                i++;
            }

            int[] task = pq.poll();
            currTime += task[0];
            ans[it++] = task[1];
        }

        return ans;
    }
}
