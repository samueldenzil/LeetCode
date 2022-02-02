// https://practice.geeksforgeeks.org/problems/find-position-of-set-bit3706/1
package All_Problems;

public class FindPositionOfSetBit {

    public static void main(String[] args) {
        int N = 2;
        System.out.println(findPosition(N));
    }

    static int findPosition(int N) {
        // code here
        int index = 0;

        if (!isPowerOf2(N)) return -1;

        for (int i = 0; i < 32; i++) {

            int lastElement = N & 1;
            if (lastElement == 1) {
                index = i;
            }

            N = N >> 1;
        }

        return index + 1;
    }

    static boolean isPowerOf2(int N) {
        if (N == 0) return false;

        return (N & (N - 1)) == 0;
    }
}
