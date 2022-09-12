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
        int count = 1;
        for (int i = 0; i < s.length(); i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if (set.contains(c)) {
                    i = j - 1;
                    count++;
                    break;
                }
                set.add(c);
            }
        }
        return count;
    }
}
