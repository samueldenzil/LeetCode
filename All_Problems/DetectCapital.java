// https://leetcode.com/problems/detect-capital/
package All_Problems;

public class DetectCapital {

    public static void main(String[] args) {
        String word = "USA";
        System.out.println(detectCapitalUse(word));
    }

    public static boolean detectCapitalUse(String word) {
        int n = word.length();
        int capsCount = 0;
        int lastCapsPosition = -1;

        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            if (c - 'A' >= 0 && c - 'A' < 26) {
                capsCount++;
                lastCapsPosition = i;
            }
        }

        if (capsCount == n) {   // case 1
            return true;
        } else if (capsCount == 1 && lastCapsPosition == 0) {   // case 2
            return true;
        } else if (capsCount == 0 && lastCapsPosition == -1) {  // case 3
            return true;
        }

        return false;
    }
}
