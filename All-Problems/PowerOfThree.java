// https://leetcode.com/problems/power-of-three/

class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        if (n == 1) {
            return true;
        }
        if (n % 3 == 0 && n != 0) {
            return isPowerOfThree(n / 3);
        }
        else {
            return false;
        }
    }
}

