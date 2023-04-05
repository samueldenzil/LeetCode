// https://leetcode.com/problems/optimal-partition-of-string/
package All_Problems;

import java.util.Set;
import java.util.HashSet;

public class OptimalPartitionOfString {

    public static void main(String[] args) {
        String s = "abacaba";
        System.out.println(partitionString(s));
    }

    public static int partitionString(String s) {
        Set<Character> set = new HashSet<>();
        int count = 1;

        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                count++;
                set.clear();
            }
            set.add(c);
        }

        return count;
    }
}
