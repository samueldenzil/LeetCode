// https://leetcode.com/problems/counting-words-with-a-given-prefix/
package All_Problems;

public class CountingWordsWithAGivenPrefix {

    public static void main(String[] args) {
        String[] words = {"pay","attention","practice","attend"};
        String pref = "at";
        System.out.println(prefixCount(words, pref));
    }

    public static int prefixCount(String[] words, String pref) {
        int ans = 0;
        for (String word: words) {
            if (word.startsWith(pref)) ans++;
        }
        return ans;
    }
}
