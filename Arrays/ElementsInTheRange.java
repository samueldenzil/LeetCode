// https://practice.geeksforgeeks.org/problems/elements-in-the-range2834/1
package Arrays;

import java.util.Set;
import java.util.HashSet;

public class ElementsInTheRange {

    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 2, 7, 8, 3};
        int A = 2, B = 5;
        System.out.println(checkElements(arr, arr.length, A, B));
    }

    public static boolean checkElements(int[] arr, int n, int A, int B) {
        Set<Integer> set = new HashSet<>();

        for (int num : arr) {
            if (num >= A && num <= B) {
                set.add(num);
            }
        }

        int requiredNums = B - A + 1;

        return set.size() == requiredNums;
    }
}
