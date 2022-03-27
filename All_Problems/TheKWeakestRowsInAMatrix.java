// https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
package All_Problems;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class TheKWeakestRowsInAMatrix {

    public static void main(String[] args) {
        int[][] mat = {
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}
        };
        int k = 3;
        System.out.println(Arrays.toString(kWeakestRows(mat, k)));
    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        int n = mat.length;

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int soldierCount = getLastIndex(mat[i]) + 1;
            list.add(new int[] {soldierCount, i});
        }

        list.sort((a, b) -> {
            return a[0] - b[0];
        });

        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            ans[i] = list.get(i)[1];
        }

        return ans;
    }

    // this will give the index of last soldier
    public static int getLastIndex(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == 1) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }
}
