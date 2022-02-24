// https://practice.geeksforgeeks.org/problems/return-two-prime-numbers2509/1
package All_Problems;

import java.util.ArrayList;
import java.util.List;

public class ReturnTwoPrimeNumbers {

    public static void main(String[] args) {
        int N = 74;
        System.out.println(primeDivision(N));
    }

    static List<Integer> primeDivision(int N){
        // code here
        List<Integer> ans = new ArrayList<>();

        for (int i = 2; i <= N / 2; i++) {
            if (isPrime(i) && isPrime(N - i)) {
                ans.add(i);
                ans.add(N - i);

                return ans;
            }
        }

        return ans;
    }

    static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }

        return true;
    }
}
