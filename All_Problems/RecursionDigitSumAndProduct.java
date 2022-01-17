package All_Problems;
public class RecursionDigitSumAndProduct {

    public static void main(String[] args) {
        int ans = product(505);

        System.out.println(ans);
    }

    public static int sum(int n) {
        // base case
        if (n == 0) {
            return 0;
        }

        return (n % 10) + sum(n / 10);
    }

    public static int product(int n) {
        if (n % 10 == n) {
            return n;
        }

        return (n % 10) * product(n / 10);
    }
}
