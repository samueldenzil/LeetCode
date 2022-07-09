// https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/
package All_Problems;

public class PartitioningIntoMinimumNumberOfDeciBinaryNumbers {

    public static void main(String[] args) {
        String n = "32";
        System.out.println(minPartitions(n));
    }

    public static int minPartitions(String n) {
        int max = 0;

        for (int i = 0; i < n.length(); i++) {
            int digit = n.charAt(i) - '0';
            max = Math.max(max, digit);
            if (max == 9) {
                break;
            }
        }

        return max;
    }
}
