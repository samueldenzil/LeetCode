// https://practice.geeksforgeeks.org/problems/anagram-of-string/1
package Strings;

public class AnagramOfString {

    public static void main(String[] args) {
        String s = "bcadeh";
        String s1 = "hea";
        System.out.println(remAnagrams(s, s1));
    }

    public static int remAnagrams(String s,String s1) {
        //add code here.
        int ans = 0;
        int[] letters = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            letters[c - 'a']++;
        }

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            letters[c - 'a']--;
        }

        for (int i = 0; i < letters.length; i++) {
            ans += Math.abs(letters[i]);
        }

        return ans;
    }
}
