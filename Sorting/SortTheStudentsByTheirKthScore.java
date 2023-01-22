// https://leetcode.com/problems/sort-the-students-by-their-kth-score/
package Sorting;

import java.util.Arrays;

public class SortTheStudentsByTheirKthScore {

    public static void main(String[] args) {
        int[][] score = {
                {10, 6, 9, 1},
                {7, 5, 11, 2},
                {4, 8, 3, 15}
        };
        int k = 2;
        int[][] ans = sortTheStudents(score, k);
        for (int[] row : ans) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score, (a, b) -> (b[k] - a[k]));
        return score;
    }
}
