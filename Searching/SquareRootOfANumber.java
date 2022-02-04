package Searching;

public class SquareRootOfANumber {

    public static void main(String[] args) {
        long x = 2;
        System.out.println(floorSqrt(x));
    }

    static long floorSqrt(long x)
    {
        // Your code here
        if (x == 1) return 1;


        long start = 1;
        long end = x;

        while (start < end) {
            long mid = start + (end - start) / 2;

            if (mid <= x / mid && (mid + 1) > x / (mid + 1)) {
                return mid;
            }

            if (mid > x / mid) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }
}
