// https://leetcode.com/problems/time-needed-to-rearrange-a-binary-string/
package Strings;

public class TimeNeededToRearrangeABinaryString {

    public static void main(String[] args) {
        String s = "0110101";
        System.out.println(secondsToRemoveOccurrences(s));
    }

    public static int secondsToRemoveOccurrences(String s) {
        StringBuilder sb = new StringBuilder(s);
        int count = 0;
        while (true) {
            boolean flag = false;
            for (int i = 1; i < sb.length(); i++) {
                if (sb.charAt(i - 1) == '0' && sb.charAt(i) == '1') {
                    sb.replace(i - 1, i + 1, "10");
                    flag = true;
                    i++;
                }
            }
            if (!flag) {
                break;
            }
            count++;
        }

        return count;
    }
}
