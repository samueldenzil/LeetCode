package Strings;
// https://leetcode.com/problems/shuffle-string/

class ShuffleString {

    public String restoreString(String s, int[] indices) {
        StringBuilder str = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            int newIndex = indices[i];
            str.replace(newIndex, newIndex + 1, String.valueOf(s.charAt(i)));
        }
        return str.toString();
    }
}