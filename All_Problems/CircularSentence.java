// https://leetcode.com/problems/circular-sentence/
package All_Problems;

public class CircularSentence {

    public static void main(String[] args) {
        String sentence = "leetcode exercises sound delightful";
        System.out.println(isCircularSentence(sentence));
    }

    public static boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");
        for (int i = 1; i < words.length; i++) {
            if (words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)) {
                return false;
            }
        }
        return words[0].charAt(0) == words[words.length - 1].charAt(words[words.length - 1].length() - 1);
    }
}
