// https://practice.geeksforgeeks.org/problems/word-ladder-ii/
package All_Problems;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;

public class WordLadderII {

    public static void main(String[] args) {
        String startWord = "bat", targetWord = "coz";
        String[] wordList = {"pat", "bot", "pot", "poz", "coz"};
        System.out.println(findSequences(startWord, targetWord, wordList));
    }

    public static List<List<String>> findSequences(String startWord, String targetWord, String[] wordList) {
        // Code here
        Set<String> set = new HashSet<>();
        for (String word : wordList) {
            set.add(word);
        }

        Queue<List<String>> queue = new LinkedList<>();
        List<String> ls = new ArrayList<>();
        ls.add(startWord);
        queue.add(ls);

        List<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(startWord);
        int level = 0;
        List<List<String>> ans = new ArrayList<>();

        while (!queue.isEmpty()) {
            List<String> list = queue.poll();
            // erase all words that has been
            // used in the previous levels to transform
            if (list.size() > level) {
                level++;
                for (String word : usedOnLevel) {
                    set.remove(word);
                }
                usedOnLevel = new ArrayList<>();
            }

            String word = list.get(list.size() - 1);

            if (word.equals(targetWord)) {
                if (ans.size() == 0) {
                    ans.add(new ArrayList<>(list));
                } else if (ans.get(0).size() == list.size()) {
                    ans.add(new ArrayList<>(list));
                }
            }

            for (int i = 0; i < word.length(); i++) {
                char[] charArr = word.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    charArr[i] = c;
                    String newWord = new String(charArr);
                    if (set.contains(newWord)) {
                        list.add(newWord);
                        ArrayList<String> temp = new ArrayList<>(list);
                        queue.add(temp);
                        // mark as visited on the level
                        usedOnLevel.add(newWord);
                        list.remove(list.size() - 1);
                    }
                }
            }
        }

        return ans;
    }
}
