package Searching;
// https://leetcode.com/problems/sqrtx/

public class Sqrt_x {

    public int mySqrt(int x) {
        if (x == 0) return 0;
        int start = 1, end = x;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid <= x / mid && (mid + 1) > x / (mid + 1)) {
                // you have found the approximate root
                return mid;
            } else if (mid > x / mid) {
                // Keep checking the left part
                end = mid - 1;
                // if the current mid * mid > x then all the current mid and all the numbers after mid will be greater than the target number
                // hence we are writing end = mid - 1
            } else {
                // if the current mid * mid < x then it can be the possibility that there is another number which is less than the target
                start = mid + 1;// Keep checking the right part
            }
        }
        return start;
    }
}
