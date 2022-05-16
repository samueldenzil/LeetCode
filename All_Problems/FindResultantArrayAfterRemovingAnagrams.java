// https://leetcode.com/problems/find-resultant-array-after-removing-anagrams/
package All_Problems;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FindResultantArrayAfterRemovingAnagrams {

    public static void main(String[] args) {
        String[] words = {"abba","baba","bbaa","cd","cd"};
        System.out.println(removeAnagrams(words));
    }

    public static List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < words.length; i++) {
            if (stack.isEmpty() || !getAnagram(words[i]).equals(getAnagram(stack.peek()))) {
                stack.add(words[i]);
            } else {
                words[i] = "";
            }
        }

        for (String word : words) {
            if (!word.equals("")) {
                ans.add(word);
            }
        }
        return ans;
    }

    private static String getAnagram(String s) {
        char[] charStr = s.toCharArray();
        Arrays.sort(charStr);
        return new String(charStr);
    }
}
