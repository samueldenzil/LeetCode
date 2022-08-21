// https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/
package SlidingWindow;

public class MinimumRecolorsToGetKConsecutiveBlackBlocks {

    public static void main(String[] args) {
        String blocks = "WBBWWBBWBW";
        int k = 7;
        System.out.println(minimumRecolors(blocks, k));
    }

    public static int minimumRecolors(String blocks, int k) {
        int n = blocks.length();

        int min = Integer.MAX_VALUE;
        int count = 0;

        for (int i = 0; i < k; i++) {
            char c = blocks.charAt(i);
            if (c == 'W') {
                count++;
            }
        }

        min = Math.min(min, count);

        for (int i = k; i < n; i++) {
            char c = blocks.charAt(i);
            if (c == 'W') {
                count++;
            }
            if (blocks.charAt(i - k) == 'W') {
                count--;
            }
            min = Math.min(min, count);
        }

        return min;
    }
}
