// https://leetcode.com/problems/boats-to-save-people/
package Arrays;

import java.util.Arrays;

public class BoatsToSavePeople {

    public static void main(String[] args) {
        int[] people = {5, 1, 4, 2};
        int limit = 6;
        System.out.println(numRescueBoats(people, limit));
    }

    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int boatCount = 0;

        int i = 0;
        int j = people.length - 1;

        while (i <= j) {
            int totalWeight = people[i] + people[j];
            if (totalWeight <= limit) {
                boatCount++;
                i++;
                j--;
            } else {
                boatCount++;
                j--;
            }
        }

        return boatCount;
    }
}
