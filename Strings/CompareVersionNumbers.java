// https://leetcode.com/problems/compare-version-numbers/
package Strings;

public class CompareVersionNumbers {

    public static void main(String[] args) {
        String version1 = "1.01", version2 = "1.001";
        System.out.println(compareVersion(version1, version2));
    }

    public static int compareVersion(String version1, String version2) {
        int i = 0;
        int j = 0;

        while (i < version1.length() || j < version2.length()) {
            int v1Dot = getDotIndex(version1, i);
            int v2Dot = getDotIndex(version2, j);

            int revision1 = v1Dot != -1 ? Integer.parseInt(version1.substring(i, v1Dot)) : 0;
            int revision2 = v2Dot != -1 ? Integer.parseInt(version2.substring(j, v2Dot)) : 0;

            if (revision1 < revision2) {
                return -1;
            } else if (revision1 > revision2) {
                return 1;
            }

            if (i < version1.length()) i = v1Dot + 1;
            if (j < version2.length()) j = v2Dot + 1;
        }

        return 0;
    }

    public static int getDotIndex(String s, int start) {
        if (start >= s.length()) return -1;
        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) == '.') return i;
        }
        return s.length();
    }
}
