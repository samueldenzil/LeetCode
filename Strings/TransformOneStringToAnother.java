// https://practice.geeksforgeeks.org/problems/b6b3297ccfb1ad5f66a9c2b92979170417adf114/1
package Strings;

public class TransformOneStringToAnother {

    public static void main(String[] args) {
        String A = "GEEKSFORGEEKS";
        String B = "FORGEEKSGEEKS";
        System.out.println(minOps(A, B));
    }


    static int minOps(String A, String B) {
        // Your code goes here.

        int sum = 0;
        for (int i = 0; i < A.length(); i++) {
            sum += A.charAt(i);
            sum -= B.charAt(i);
        }

        if (sum != 0) return -1;

        int count = 0;
        int i = A.length() - 1;
        int j = B.length() - 1;

        while (i >= 0 && j >= 0) {
            if (A.charAt(i) == B.charAt(j)) {
                i--;
                j--;
            } else {
                count++;
                i--;
            }
        }

        return count;
    }
}
