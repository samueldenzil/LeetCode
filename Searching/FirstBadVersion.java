package Searching;
// https://leetcode.com/problems/first-bad-version/

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class FirstBadVersion /* extends VersionControl */ {
    /* public int firstBadVersion(int n) {
        int start = 1;
        int end = n;

        while (start < end) {
            int mid = start + (end - start) / 2;
            boolean getBadVersion = isBadVersion(mid);

            if (getBadVersion) {
                // this may be the answer, but look at left
                // this is why end != mid - 1
                end = mid;
            } else if (!getBadVersion) {
                // it means you are in the good version and all the versions before the mid will also be good
                // so there is no point to check the left side
                start = mid + 1;
            }
        }
        // in the end, start == end and pointing to the first badVersion of the product
        return start;   // or return end; as both are same
    } */
}