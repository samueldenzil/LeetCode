// https://leetcode.com/problems/maximum-matching-of-players-with-trainers/
package All_Problems;

import java.util.Arrays;

public class MaximumMatchingOfPlayersWithTrainers {

    public static void main(String[] args) {
        int[] players = {4, 7, 9}, trainers = {8, 2, 5, 8};
        System.out.println(matchPlayersAndTrainers(players, trainers));
    }

    public static int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int i = 0;
        int j = 0;

        int count = 0;

        while (i < players.length && j < trainers.length) {
            while (players[i] > trainers[j]) {
                j++;
                if (j == trainers.length) {
                    return count;
                }
            }
            count++;
            i++;
            j++;
        }

        return count;
    }
}
