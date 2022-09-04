// https://leetcode.com/problems/minimum-amount-of-time-to-collect-garbage/
package Arrays;

public class MinimumAmountOfTimeToCollectGarbage {

    public static void main(String[] args) {
        String[] garbage = {"G", "P", "GP", "GG"};
        int[] travel = {2, 4, 3};
        System.out.println(garbageCollection(garbage, travel));
    }

    public static int garbageCollection(String[] garbage, int[] travel) {
        int time = 0;
        int metalIndex = -1;
        int plasticIndex = -1;
        int glassIndex = -1;

        for (int i = 0; i < garbage.length; i++) {
            if (garbage[i].indexOf('M') != -1) {
                metalIndex = i;
            }
            if (garbage[i].indexOf('P') != -1) {
                plasticIndex = i;
            }
            if (garbage[i].indexOf('G') != -1) {
                glassIndex = i;
            }
            time += garbage[i].length();
        }

        // prefix array
        for (int i = 1; i < travel.length; i++) {
            travel[i] += travel[i - 1];
        }

        time += metalIndex <= 0 ? 0 : travel[metalIndex - 1];
        time += plasticIndex <= 0 ? 0 : travel[plasticIndex - 1];
        time += glassIndex <= 0 ? 0 : travel[glassIndex - 1];

        return time;
    }
}
