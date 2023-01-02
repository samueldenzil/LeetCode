// https://leetcode.com/problems/count-the-digits-that-divide-a-number/
package All_Problems;

public class CountTheDigitsThatDivideANumber {

    public static void main(String[] args) {
        int num = 1248;
        System.out.println(countDigits(num));
    }

    public static int countDigits(int num) {
        int temp = num;
        int ans = 0;
        while (temp > 0) {
            int digit = temp % 10;
            if (num % digit == 0) {
                ans++;
            }
            temp /= 10;
        }
        return ans;
    }
}
