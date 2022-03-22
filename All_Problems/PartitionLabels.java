// https://leetcode.com/problems/partition-labels/
package All_Problems;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(s));
    }

    public static List<Integer> partitionLabels(String s) {
        int[] first = new int[26];
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            if (first[s.charAt(i) - 'a'] == 0)
                first[s.charAt(i) - 'a'] = i;
            last[s.charAt(i) - 'a'] = i;
        }

        List<Integer> ans = new ArrayList<>();
        int prev = 0;
        int partitionEnd = last[s.charAt(0) - 'a'];

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            // the occurrence of current element is not in the partition space, so it is better
            // to create a new partition for the current element
            if (first[c - 'a'] > partitionEnd) {
                ans.add(partitionEnd + 1 - prev);
                prev = partitionEnd + 1;
                partitionEnd = last[c - 'a'];
            } else if (last[c - 'a'] > partitionEnd) {
                // trying to increase the partition space
                partitionEnd = last[c - 'a'];
            }
        }
        ans.add(partitionEnd + 1 - prev);

        return ans;
    }
}