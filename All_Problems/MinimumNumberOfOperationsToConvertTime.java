// https://leetcode.com/problems/minimum-number-of-operations-to-convert-time/
package All_Problems;

public class MinimumNumberOfOperationsToConvertTime {

    public static void main(String[] args) {
        String current = "02:30", correct = "04:35";
        System.out.println(convertTime(current, correct));
    }

    public static int convertTime(String current, String correct) {
        int h1 = Integer.parseInt(current.substring(0, 2));
        int m1 = Integer.parseInt(current.substring(3, current.length()));
        int totalMins1 = (h1 * 60) + m1;

        int h2 = Integer.parseInt(correct.substring(0, 2));
        int m2 = Integer.parseInt(correct.substring(3, current.length()));
        int totalMins2 = (h2 * 60) + m2;

        int count = 0;

        while (totalMins1 < totalMins2) {
            if (totalMins2 - totalMins1 >= 60) {
                int temp = (totalMins2 - totalMins1) / 60;
                count += temp;
                totalMins1 += (60 * temp);
            } else if (totalMins2 - totalMins1 >= 15) {
                int temp = (totalMins2 - totalMins1) / 15;
                count += temp;
                totalMins1 += (15 * temp);
            } else if (totalMins2 - totalMins1 >= 5) {
                int temp = (totalMins2 - totalMins1) / 5;
                count += temp;
                totalMins1 += (5 * temp);
            } else {
                count++;
                totalMins1++;
            }
        }

        return count;
    }
}
