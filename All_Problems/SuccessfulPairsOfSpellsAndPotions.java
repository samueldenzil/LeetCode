// https://leetcode.com/problems/successful-pairs-of-spells-and-potions/
package All_Problems;

import java.util.Arrays;

public class SuccessfulPairsOfSpellsAndPotions {

    public static void main(String[] args) {
        int[] spells = {5, 1, 3};
        int[] potions = {1, 2, 3, 4, 5};
        int success = 7;

        System.out.println(Arrays.toString(successfulPairs(spells, potions, success)));
    }

    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;

        Arrays.sort(potions);

        for (int i = 0; i < n; i++) {
            int start = 0;
            int end = m - 1;

            int ind = -1;

            while (start <= end) {
                int mid = start + (end - start) / 2;

                long product = (long) spells[i] * potions[mid];

                if (product >= success) {
                    ind = mid;
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

            spells[i] = ind != -1 ? m - ind : 0;
        }

        return spells;
    }
}
