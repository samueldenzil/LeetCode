// https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
package Arrays;

public class MinimumDominoRotationsForEqualRow {

    public static void main(String[] args) {
        int[] tops = {1, 2, 1, 1, 1, 2, 2, 2};
        int[] bottoms = {2, 1, 2, 2, 2, 2, 2, 2};
        System.out.println(minDominoRotations(tops, bottoms));
    }

    public static int minDominoRotations(int[] tops, int[] bottoms) {
        int length = tops.length;
        int[][] frequencyMatrix = new int[6][2];

        for (int i = 0; i < length; i++) {
            frequencyMatrix[tops[i] - 1][0]++;
            frequencyMatrix[bottoms[i] - 1][1]++;
        }
        int mostOccurred = -1;
        int tempSum = 0;
        for (int i = 0; i < frequencyMatrix.length; i++) {
            int temp = frequencyMatrix[i][0] + frequencyMatrix[i][1];
            if (temp > tempSum) {
                mostOccurred = i + 1;
                tempSum = temp;
            }
        }

        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < length; i++) {
            if (tops[i] != bottoms[i]) {
                if (tops[i] == mostOccurred) {
                    count1++;
                }
                if (bottoms[i] == mostOccurred) {
                    count2++;
                }
            }
        }

        for (int i = 0; i < length; i++) {
            if (count1 > count2) {
                // count1 > count2, if we swap tops number with bottom then we will need more swaps
                // which is more costly
                if (bottoms[i] == mostOccurred) {
                    int temp = tops[i];
                    tops[i] = bottoms[i];
                    bottoms[i] = temp;
                }
            } else {
                // count1 < count2, if we swap bottoms number with tops then we will need more swaps
                // which is more costly
                if (tops[i] == mostOccurred) {
                    int temp = tops[i];
                    tops[i] = bottoms[i];
                    bottoms[i] = temp;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < length; i++) {
            if (count1 > count2) {
                if (tops[i] == mostOccurred) count++;
            } else {
                if (bottoms[i] == mostOccurred) count++;
            }
        }

        return count == length ? Math.min(count1, count2) : -1;
    }
}
