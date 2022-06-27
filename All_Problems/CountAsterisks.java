// https://leetcode.com/problems/count-asterisks/
package All_Problems;

public class CountAsterisks {

    public static void main(String[] args) {
        String s = "l|*e*et|c**o|*de|";
        System.out.println(countAsterisks(s));
    }

    public static int countAsterisks(String s) {
        int count = 0;
        boolean insidePair = false;

        for (char c : s.toCharArray()) {
            if (c == '|') {
                if (insidePair) {
                    insidePair = false;
                } else {
                    insidePair = true;
                }
            } else if (c == '*') {
                if (!insidePair) {
                    count++;
                }
            }
        }

        return count;
    }
}
