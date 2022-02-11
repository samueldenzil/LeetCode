// https://practice.geeksforgeeks.org/problems/remove-leading-zeros-from-an-ip-address3530/1

package Strings;

public class RemoveLeadingZerosFromAnIPAddress {

    public static void main(String[] args) {
        String S = "100.020.003.400";
        System.out.println(newIPAdd(S));
    }

    public static String newIPAdd(String S) {
        // your code here
        StringBuilder str = new StringBuilder();

        int i = 0;
        int prev = 0;
        while (i < S.length()) {
            if (S.charAt(i) == '.') {
                while (S.charAt(prev) == '0') {
                    prev++;
                }
                if (prev == i)
                    str.append('0');
                else
                    str.append(S, prev, i);
                str.append('.');
                prev = i + 1;
            }
            i++;
        }

        while (prev < S.length() && S.charAt(prev) == '0') {
            prev++;
        }

        if (prev == i)
            str.append('0');
        else
            str.append(S, prev, S.length());

        return str.toString();
    }
}