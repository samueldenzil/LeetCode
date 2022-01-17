package Recursion;


public class RecursionCountZeros {


    public static void main(String[] args) {
        int n = 30204;
        int ans = countZero(n, 0);
        System.out.println(ans);
    }

    // special pattern, how to pass a value to above calls
    public static int countZero(int n, int count) {
        // base condition
        if (n == 0) {
            return count;
        }

        int remainder = n % 10;
        if (remainder == 0) {
            return countZero(n / 10, count + 1);
        } else {
            return countZero(n / 10, count);
        }
    }
}
