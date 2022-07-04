// https://leetcode.com/problems/decode-the-message/
package Strings;

import java.util.Map;
import java.util.HashMap;

public class DecodeTheMessage {

    public static void main(String[] args) {
        String key = "the quick brown fox jumps over the lazy dog";
        String message = "vkbs bs t suepuv";

        System.out.println(decodeMessage(key, message));
    }

    public static String decodeMessage(String key, String message) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> keyMap = getKeyMap(key);

        for (char c : message.toCharArray()) {
            if (c == ' ') {
                sb.append(' ');
                continue;
            }

            int index = keyMap.get(c);
            sb.append((char) ('a' + index));
        }

        return sb.toString();
    }

    private static Map<Character, Integer> getKeyMap(String key) {
        Map<Character, Integer> map = new HashMap<>();
        int index = 0;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);

            if (!map.containsKey(c) && c != ' ') {
                map.put(c, index);
                index++;
            }
        }

        return map;
    }
}
