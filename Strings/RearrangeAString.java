package Strings;
// https://practice.geeksforgeeks.org/problems/rearrange-a-string4100/1

public class RearrangeAString {

    public static void main(String[] args) {
        String s = "ACCBA10D2EW30";
        System.out.println(arrangeString(s));
    }

    public static String arrangeString(String s) {
        //code here.
        int[] items = new int[128];
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            if ((int) c >= 48 && (int) c <= 57) {
                sum += (c - '0');
            }
            items[c]++;
        }

        StringBuilder str = new StringBuilder();
        for (int i = 65; i <= 90; i++) {
            for (int j = 0; j < items[i]; j++) {
                str.append((char) i);
            }
        }
        str.append(sum);

        return str.toString();
    }
}
