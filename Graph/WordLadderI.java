// https://practice.geeksforgeeks.org/problems/word-ladder/1
package Graph;

import java.util.Set;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;

public class WordLadderI {

    public static void main(String[] args) {
        String[] wordList = {"des", "der", "dfr", "dgt", "dfs"};
        String startWord = "der", targetWord = "dfs";
        System.out.println(wordLadderLength(startWord, targetWord, wordList));
    }

    public static int wordLadderLength(String startWord, String targetWord, String[] wordList) {
        // Code here
        Set<String> set = new HashSet<>();
        for (String word : wordList) {
            set.add(word);
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(startWord, 1));
        set.remove(startWord);

        while (!queue.isEmpty()) {
            String word = queue.peek().word;
            int length = queue.peek().length;
            queue.poll();

            if (word.equals(targetWord)) {
                return length;
            }

            for (int i = 0; i < word.length(); i++) {
                char[] wordChars = word.toCharArray();
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    wordChars[i] = ch;
                    String newWord = new String(wordChars);
                    if (set.contains(newWord)) {
                        queue.add(new Pair(newWord, length + 1));
                        set.remove(newWord);
                    }
                }
            }
        }

        return 0;
    }

    static class Pair {
        String word;
        int length;

        Pair(String word, int length) {
            this.word = word;
            this.length = length;
        }
    }
}
