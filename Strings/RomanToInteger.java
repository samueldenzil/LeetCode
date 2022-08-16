// https://leetcode.com/problems/roman-to-integer/
package Strings;

import java.util.Map;
import java.util.HashMap;

public class RomanToInteger {

    public static void main(String[] args) {
        String s = "DCXXI";
        System.out.println(romanToInt(s));
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int num = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);

            if (i - 1 >= 0 && s.charAt(i - 1) == 'I' && (c == 'V' || c == 'X')) {
                // if 'I' is placed before 'V' (5) and 'X' (10) we can get 4 and 9 respectively
                num += (map.get(c) - map.get(s.charAt(i - 1)));
                i--;
            } else if (i - 1 >= 0 && s.charAt(i - 1) == 'X' && (c == 'L' || c == 'C')) {
                // if 'X' is placed before 'L' (50) and 'C' (100) we can get 40 and 90 respectively
                num += (map.get(c) - map.get(s.charAt(i - 1)));
                i--;
            } else if (i - 1 >= 0 && s.charAt(i - 1) == 'C' && (c == 'D' || c == 'M')) {
                // if 'C' is placed before 'D' (500) and 'M' (1000) we can get 400 and 900 respectively
                num += (map.get(c) - map.get(s.charAt(i - 1)));
                i--;
            } else {
                num += map.get(c);
            }
        }

        return num;
    }
}
