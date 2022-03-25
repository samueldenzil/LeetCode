// https://leetcode.com/problems/boats-to-save-people/
package All_Problems;

import java.util.Arrays;

public class BoatsToSavePeople {

    public static void main(String[] args) {
        int[] people = {3, 2, 2, 1};
        int limit = 3;
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
