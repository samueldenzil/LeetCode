// https://leetcode.com/problems/smallest-value-after-replacing-with-sum-of-prime-factors/
package Maths;

public class SmallestValueAfterReplacingWithSumOfPrimeFactors {

    public static void main(String[] args) {
        int n = 15;
        System.out.println(smallestValue(n));
    }

    public static int smallestValue(int n) {
        while (true) {
            int temp = primeFactorSum(n);
            if (temp == n) {
                break;
            }
            n = temp;
        }
        return n;
    }

    private static int primeFactorSum(int n) {
        int sum = 0;
        while (n % 2 == 0) {
            sum += 2;
            n /= 2;
        }
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                sum += i;
                n /= i;
            }
        }
        if (n > 2) {
            sum += n;
        }
        return sum;
    }
}
