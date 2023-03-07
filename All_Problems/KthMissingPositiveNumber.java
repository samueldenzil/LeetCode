// https://leetcode.com/problems/kth-missing-positive-number/
package All_Problems;

public class KthMissingPositiveNumber {

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 7, 11};
        int k = 5;
        System.out.println(findKthPositive(arr, k));
    }

    public static int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int noOfSkips = 0;
        int i = 0;

        for (i = 0; i < n; i++) {
            int add = 0;
            if (i == 0) {
                add += arr[i] - 0 - 1;
            } else {
                add += arr[i] - arr[i - 1] - 1;
            }

            if (noOfSkips + add >= k) {
                break;
            }
            noOfSkips += add;
        }


        int ans = 0;
        if (i - 1 >= 0) {
            ans = arr[i - 1];
        }
        ans += k - noOfSkips;
        return ans;
    }
}
