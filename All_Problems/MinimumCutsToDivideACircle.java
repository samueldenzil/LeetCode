// https://leetcode.com/problems/minimum-cuts-to-divide-a-circle/
package All_Problems;

public class MinimumCutsToDivideACircle {

    public static void main(String[] args) {
        int n = 4;
        System.out.println(numberOfCuts(n));
    }

    public static int numberOfCuts(int n) {
        if (n == 1) {
            return 0;
        }
        if (n % 2 == 0) {
            return n / 2;
        } else {
            return n;
        }
    }
}
