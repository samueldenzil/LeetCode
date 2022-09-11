// https://leetcode.com/problems/the-number-of-weak-characters-in-the-game/
package All_Problems;

import java.util.Arrays;

public class TheNumberOfWeakCharactersInTheGame {

    public static void main(String[] args) {
        int[][] properties = {{5, 5}, {6, 3}, {3, 6}};
        System.out.println(numberOfWeakCharacters(properties));
    }

    public static int numberOfWeakCharacters(int[][] properties) {
        int n = properties.length;
        // sorting attack in ascending order and defence descending
        Arrays.sort(properties, (a, b) -> (a[0] != b[0]) ? (a[0] - b[0]) : (b[1] - a[1]));
        int currMax = properties[n - 1][1];

        int count = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (currMax > properties[i][1]) {
                count++;
            } else {
                currMax = properties[i][1];
            }
        }

        return count;
    }
}
