// https://leetcode.com/problems/sender-with-largest-word-count/
package All_Problems;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class SenderWithLargestWordCount {

    public static void main(String[] args) {
        String[] messages = {"How is leetcode for everyone", "Leetcode is useful for practice"};
        String[] senders = {"Bob", "Charlie"};
        System.out.println(largestWordCount(messages, senders));
    }


    public static String largestWordCount(String[] messages, String[] senders) {
        int n = messages.length;

        Map<String, Integer> hashMap = new HashMap<>();

        String ans = "";
        int max = 0;

        for (int i = 0; i < n; i++) {
            if (!hashMap.containsKey(senders[i])) {
                hashMap.put(senders[i], getWordCount(messages[i]));
            } else {
                hashMap.put(senders[i], hashMap.get(senders[i]) + getWordCount(messages[i]));
            }
            max = Math.max(max, hashMap.get(senders[i]));
        }

        TreeSet<String> treeSet = new TreeSet<>();
        for (String sender : hashMap.keySet()) {
            if (hashMap.get(sender) == max) {
                treeSet.add(sender);
            }
        }

        return treeSet.pollLast();
    }

    private static int getWordCount(String message) {
        int count = 0;
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (c == ' ') {
                count++;
            }
        }

        return count + 1;
    }
}
