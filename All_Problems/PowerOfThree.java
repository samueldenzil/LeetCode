// https://leetcode.com/problems/power-of-three/
package All_Problems;

class PowerOfThree {

    // Iterative Solution
    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }
        while (n > 1) {
            int remainder = n % 3;
            if (remainder != 0) {
                return false;
            }
            n /= 3;
        }
        return true;
    }


    // Recursive Solution
    public boolean isPowerOfThreeRecursive(int n) {
        if (n == 1) {
            return true;
        }
        if (n % 3 == 0 && n != 0) {
            return isPowerOfThreeRecursive(n / 3);
        } else {
            return false;
        }
    }
}

