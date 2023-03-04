// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
package All_Problems;

public class FindTheIndexOfTheFirstOccurrenceInAString {

    public static void main(String[] args) {
        String haystack = "sadbutsad", needle = "sad";
        System.out.println(strStr(haystack, needle));
    }

    public static int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();

        for (int h = 0; h <= m - n; h++) {
            int i = h;
            boolean foundNeedle = true;
            for (int j = 0; j < n; j++) {
                if (haystack.charAt(i) != needle.charAt(j)) {
                    foundNeedle = false;
                    break;
                }
                i++;
            }
            if (foundNeedle) {
                return h;
            }
        }

        return -1;
    }
}
