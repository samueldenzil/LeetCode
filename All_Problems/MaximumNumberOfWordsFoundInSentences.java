// https://leetcode.com/problems/maximum-number-of-words-found-in-sentences/
package All_Problems;

public class MaximumNumberOfWordsFoundInSentences {

    public static void main(String[] args) {
        String[] sentences = {"alice and bob love leetcode", "i think so too", "this is great thanks very much"};
        System.out.println(mostWordsFound(sentences));
    }

    public static int mostWordsFound(String[] sentences) {
        int max = 0;

        for (String sentence : sentences) {
            int currWordCount = wordCount(sentence);
            max = Math.max(max, currWordCount);
        }

        return max;
    }

    private static int wordCount(String sentence) {
        int count = 0;
        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            if (c == ' ') {
                count++;
            }
        }

        return count + 1;
    }
}
