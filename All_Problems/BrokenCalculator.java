// https://leetcode.com/problems/broken-calculator/
package All_Problems;

public class BrokenCalculator {

    public static void main(String[] args) {
        int startValue = 2, target = 3;
        System.out.println(brokenCalc(startValue, target));
    }

    public static int brokenCalc(int startValue, int target) {
        int count = 0;

        while (target > startValue) {
            if (target % 2 == 0) {
                // it means to get the current value we had to multiply by 2,
                // but we are moving backwards so divide by 2
                target /= 2;
            } else {
                target += 1;
            }
            count++;
        }

        return count + (startValue - target);
    }
}
