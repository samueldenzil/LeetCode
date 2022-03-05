// https://practice.geeksforgeeks.org/problems/51b7f8fb8b33d657a857f230361b7dad6565ce62/1
package All_Problems;

import java.util.Arrays;

public class CanMakeTriangle {

    public static void main(String[] args) {
        int[] A = {2, 10, 2, 10, 2};
        System.out.println(Arrays.toString(canMakeTriangle(A, A.length)));
    }

    static int[] canMakeTriangle(int[] A, int N) {
        // code here
        int[] ans = new int[N - 2];

        for (int i = 0; i < ans.length; i++) {
            if (isValid(A[i], A[i + 1], A[i + 2])) {
                ans[i] = 1;
            } else {
                ans[i] = 0;
            }
        }

        return ans;
    }

    static boolean isValid(int a, int b, int c) {
        return ((a + b > c) && (a + c > b) && (b + c > a));
    }
}
