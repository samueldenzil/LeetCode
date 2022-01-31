// https://practice.geeksforgeeks.org/problems/print-anagrams-together/1/
package Strings;

import java.util.*;

public class PrintAnagramsTogether {

    public static void main(String[] args) {
        String[] words = {"act", "god", "cat", "dog", "tac"};
        System.out.println(Anagrams(words));
    }

    public static List<List<String>> Anagrams(String[] string_list) {
        // Code here
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < string_list.length; i++) {
            String temp = string_list[i];
            temp = sortString(temp);

            if (!map.containsKey(temp)) {
                map.put(temp, new ArrayList<>());
            }
            map.get(temp).add(string_list[i]);
        }

        List<List<String>> list = new ArrayList<>();

        for (String name : map.keySet()) {
            List<String> row = new ArrayList<>(map.get(name));
            list.add(row);
        }

        return list;
    }

    public static String sortString(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}
