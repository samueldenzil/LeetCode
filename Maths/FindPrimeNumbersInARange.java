// https://practice.geeksforgeeks.org/problems/find-prime-numbers-in-a-range4718/1
package Maths;

import java.util.ArrayList;

public class FindPrimeNumbersInARange {

    public static void main(String[] args) {
        int M = 1;
        int N = 10;
        System.out.println(primeRange(M, N));
    }

    static ArrayList<Integer> primeRange(int M, int N) {
        // code here
        ArrayList<Integer> primeNums = new ArrayList<>();

        for (int i = M; i <= N; i++) {
            if (isPrimeNumber(i)) {
                primeNums.add(i);
            }
        }

        return primeNums;
    }

    static boolean isPrimeNumber(int n) {
        if (n == 1) return false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }

        return true;
    }
}
