// https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/
package All_Problems;

import java.util.Arrays;

public class MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts {

    public static void main(String[] args) {
        int h = 5;
        int w = 4;
        int[] horizontalCuts = {1, 2, 4};
        int[] verticalCuts = {1, 3};
        System.out.println(maxArea(h, w, horizontalCuts, verticalCuts));
    }

    public static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        int hLength = horizontalCuts.length;
        int vLength = verticalCuts.length;

        // finding out the max height cut
        int maxHeight = Math.max(horizontalCuts[0] - 0, h - horizontalCuts[hLength - 1]);
        for (int i = 1; i < hLength; i++) {
            int currHeight = horizontalCuts[i] - horizontalCuts[i - 1];
            maxHeight = Math.max(maxHeight, currHeight);
        }

        // finding out the max width cut
        int maxWidth = Math.max(verticalCuts[0] - 0, w - verticalCuts[vLength - 1]);
        for (int i = 1; i < vLength; i++) {
            int currWidth = verticalCuts[i] - verticalCuts[i - 1];
            maxWidth = Math.max(maxWidth, currWidth);
        }

        long ans = (long) maxWidth * maxHeight;
        ans %= 1000000007;

        return (int) ans;
    }
}
