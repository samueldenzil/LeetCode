// https://leetcode.com/problems/ransom-note/
package All_Problems;

public class RansomNote {

    public static void main(String[] args) {
        String ransomNote = "aa", magazine = "aab";
        System.out.println(canConstruct(ransomNote, magazine));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] letters = new int[26];

        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            letters[c - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if (letters[c - 'a'] == 0) {
                return false;
            }
            letters[c - 'a']--;
        }

        return true;
    }
}
