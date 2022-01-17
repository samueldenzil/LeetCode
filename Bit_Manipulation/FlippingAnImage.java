package Bit_Manipulation;
// https://leetcode.com/problems/flipping-an-image
// Google Interview Question

public class FlippingAnImage {

    public int[][] flipAndInvertImage(int[][] image) {
        for (int[] row : image) {
            for (int i = 0; i < (row.length + 1) / 2; i++) {
                int temp = row[i] ^ 1;  // flipping the bit
                row[i] = row[row.length - i - 1] ^ 1;   // flipping the bit
                row[row.length - i - 1] = temp;
            }
        }
        return image;
    }
}