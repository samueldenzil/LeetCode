// https://leetcode.com/problems/add-digits/
package All_Problems;

public class AddDigits {

    public static void main(String[] args) {
        int num = 38;
        System.out.println(addDigits(num));
    }

    public static int addDigits(int num) {
        if (num >= 0 && num <= 9) {
            return num;
        }

        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        return addDigits(sum);
    }
}
