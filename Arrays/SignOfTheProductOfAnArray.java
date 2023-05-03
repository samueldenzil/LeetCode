// https://leetcode.com/problems/sign-of-the-product-of-an-array/
package Arrays;

public class SignOfTheProductOfAnArray {

    public static void main(String[] args) {
        int[] nums = {-1, -2, -3, -4, 3, 2, 1};
        System.out.println(arraySign(nums));
    }

    public static int arraySign(int[] nums) {
        int signProd = 1;

        for (int it : nums) {
            if (it > 0) {
                signProd *= 1;
            } else if (it < 0) {
                signProd *= -1;
            } else {
                signProd *= 0;
            }
        }

        return signProd;
    }
}
