// https://leetcode.com/problems/find-the-k-beauty-of-a-number/
package All_Problems;

public class FindTheKBeautyOfANumber {

    public static void main(String[] args) {
        int num = 430043, k = 2;
        System.out.println(divisorSubstrings(num, k));
    }

    public static int divisorSubstrings(int num, int k) {
        String n = num + "";
        int count = 0;

        for (int i = 0; i < n.length() - k + 1; i++) {
            int sub = Integer.parseInt(n.substring(i, i + k));
            if (sub != 0 && num % sub == 0) {
                count++;
            }
        }

        return count;
    }
}
