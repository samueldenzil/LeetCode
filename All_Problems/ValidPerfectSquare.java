package All_Problems;
// https://leetcode.com/problems/valid-perfect-square/

class ValidPerfectSquare {

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(1));
    }

    static boolean isPerfectSquare(int num) {
        int start = 1;
        int end = num / 2;

        if (num == 1) { // edge case
            return true;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if ((double) mid == (double) num / mid) {
                return true;
            }

            if (mid < num / mid) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}