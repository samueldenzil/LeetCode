// https://leetcode.com/problems/power-of-four/
package All_Problems;

class PowerOfFour {

    public static void main(String[] args) {
        int n = 16;
        System.out.println(isPowerOfFour(n));
    }

    public static boolean isPowerOfFour(int n) {
        if (n == 1) {
            return true;
        }
        if (n % 4 == 0 && n != 0) {
            return isPowerOfFour(n / 4);
        } else {
            return false;
        }
    }
}


