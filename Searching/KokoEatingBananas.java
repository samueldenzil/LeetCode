// https://leetcode.com/problems/koko-eating-bananas/
package Searching;

public class KokoEatingBananas {

    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        System.out.println(minEatingSpeed(piles, h));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        // According to the constraints, Koko should eat at least 1 banana every hour
        int start = 1;
        int end = max;
        int k = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (timeTakenToEatBananasWithSpeedK(piles, mid) <= h) {
                // this could be the answer but, also check what happens when Koko eats slowly
                k = mid;
                end = mid - 1;
            } else {
                // Koko is eating slow, so you want Koko to eat fast
                start = mid + 1;
            }
        }

        return k;
    }

    private static long timeTakenToEatBananasWithSpeedK(int[] piles, int k) {
        long count = 0;
        for (long pile : piles) {
            count += Math.ceil((double) pile / k);
        }
        return count;
    }
}
