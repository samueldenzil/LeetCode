// https://leetcode.com/problems/alternating-digit-sum/
package Maths;

public class AlternatingDigitSum {

    public static void main(String[] args) {
        int n = 521;
        System.out.println(alternateDigitSum(n));
    }

    public static int alternateDigitSum(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(n);
        int sum = 0;
        boolean flag = true;
        for (int i = 0; i < sb.length(); i++) {
            int digit = sb.charAt(i) - '0';
            if (flag) {
                sum += digit;
            } else {
                sum -= digit;
            }
            flag = !flag;
        }
        return sum;
    }
}
