// https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
package All_Problems;

import java.util.ArrayList;

public class RatInAMazeProblem1 {

    public static void main(String[] args) {
        int[][] m = {{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1}};
        System.out.println(findPath(m, m.length));
    }

    public static ArrayList<String> ans;

    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ans = new ArrayList<>();
        func(m, n, 0, 0, "");

        return ans;
    }

    public static void func(int[][] m, int n, int i, int j, String current) {
        // Base case
        if (i == n - 1 && j == n - 1) {

            if (m[i][j] == 1) {
                ans.add(current);
                return;
            }
        }

        if (i < 0 || j < 0 || i >= n || j >= n || m[i][j] == 0) {
            return;
        }

        // setting the current position to zero so that we don't go into infinite loop
        m[i][j] = 0;

        // for right
        func(m, n, i, j + 1, current + "R");
        // for up
        func(m, n, i - 1, j, current + "U");
        // for left
        func(m, n, i, j - 1, current + "L");
        // for down
        func(m, n, i + 1, j, current + "D");

        m[i][j] = 1;
    }
}
