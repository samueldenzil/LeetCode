// https://leetcode.com/problems/bulb-switcher/
package All_Problems;

public class BulbSwitcher {

    public static void main(String[] args) {
        int n = 3;
        System.out.println(bulbSwitch(n));
    }

    public static int bulbSwitch(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            double sqrt = Math.sqrt(i);
            // check if the square root is an integer
            if (sqrt == (int) sqrt) {
                count++;
            }
        }
        return count;
    }
}
