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

        int k = 0;
        while (start <= end) {
            int currentSpeed = start + (end - start) / 2;
            int timeTakenToEatBananas = bananasEaten(piles, currentSpeed);

            if (timeTakenToEatBananas > h) {
                // Koko is eating slow, so you want Koko to eat fast
                start = currentSpeed + 1;
            } else {
                // timeTakenToEatBananas <= h
                // this could be the answer but, also check what happens when Koko eats slowly
                k = currentSpeed;
                end = currentSpeed - 1;
            }
        }

        return k;
    }

    public static int bananasEaten(int[] piles, int speed) {
        int time = 0;

        for (int pile : piles) {
            time += (int) Math.ceil((double) pile / speed);
        }

        return time;
    }
}
