// https://leetcode.com/problems/data-stream-as-disjoint-intervals/
package Design;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class DataStreamAsDisjointIntervals {

    private boolean[] arr;

    public DataStreamAsDisjointIntervals() {
        arr = new boolean[10001];
    }

    public void addNum(int value) {
        arr[value] = true;
    }

    public int[][] getIntervals() {
        int n = arr.length;
        int start = 0;
        int end = 0;
        List<int[]> temp = new ArrayList<>();
        while (end < n) {
            while (start < n && !arr[start]) {
                start++;
            }
            end = start;
            while (end < n && arr[end]) {
                end++;
            }
            if (start <= end - 1) {
                temp.add(new int[]{start, end - 1});
            }
            start = end;
        }
        int[][] ans = new int[temp.size()][2];
        for (int i = 0; i < temp.size(); i++) {
            ans[i] = temp.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        DataStreamAsDisjointIntervals summaryRanges = new DataStreamAsDisjointIntervals();
        summaryRanges.addNum(1);      // arr = [1]
        System.out.println(Arrays.deepToString(summaryRanges.getIntervals())); // return [[1, 1]]
        summaryRanges.addNum(3);      // arr = [1, 3]
        System.out.println(Arrays.deepToString(summaryRanges.getIntervals())); // return [[1, 1], [3, 3]]
        summaryRanges.addNum(7);      // arr = [1, 3, 7]
        System.out.println(Arrays.deepToString(summaryRanges.getIntervals())); // return [[1, 1], [3, 3], [7, 7]]
        summaryRanges.addNum(2);      // arr = [1, 2, 3, 7]
        System.out.println(Arrays.deepToString(summaryRanges.getIntervals())); // return [[1, 3], [7, 7]]
        summaryRanges.addNum(6);      // arr = [1, 2, 3, 6, 7]
        System.out.println(Arrays.deepToString(summaryRanges.getIntervals())); // return [[1, 3], [6, 7]]
    }
}
