// https://leetcode.com/problems/jump-game-iii/
package All_Problems;

public class JumpGameIII {

    public static void main(String[] args) {
        int[] arr = {3, 0, 2, 1, 2};
        int start = 2;
        System.out.println(canReach(arr, start));
    }

    public static boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        return helper(start, arr, visited);
    }

    private static boolean helper(int ind, int[] arr, boolean[] visited) {
        int n = arr.length;
        if (arr[ind] == 0) {
            return true;
        }

        boolean forward = false;
        if (!visited[ind] && ind + arr[ind] < n) {
            visited[ind] = true;
            forward = helper(ind + arr[ind], arr, visited);
            visited[ind] = false;
        }
        boolean backward = false;
        if (!visited[ind] && !forward && ind - arr[ind] >= 0) {
            visited[ind] = true;
            backward = helper(ind - arr[ind], arr, visited);
            visited[ind] = false;
        }

        return forward || backward;
    }
}
