// https://leetcode.com/problems/can-place-flowers/
package Greedy;

public class CanPlaceFlowers {

    public static void main(String[] args) {
        int[] flowerbed = {1, 0, 0, 0, 1};
        int n = 1;
        System.out.println(canPlaceFlowers(flowerbed, n));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int total = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                continue;
            }

            boolean isLeftEmpty = (i == 0) || (flowerbed[i - 1] == 0);
            boolean isRightEmpty = (i == flowerbed.length - 1) || (flowerbed[i + 1] == 0);

            if (isLeftEmpty && isRightEmpty) {
                flowerbed[i] = 1;
                total++;
            }
        }
        return total >= n;
    }
}
