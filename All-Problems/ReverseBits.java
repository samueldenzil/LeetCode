// https://leetcode.com/problems/reverse-bits/

// referred this solution
// https://leetcode.com/problems/reverse-bits/discuss/54738/Sharing-my-2ms-Java-Solution-with-Explanation

public class ReverseBits {

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = result << 1;
            if ((n & 1) == 1) {
                // if last digit is 0 then increment result
                result++;
            }
            // right shift n as the last bit was taken
            n = n >> 1;
        }
        return result;
    }
}
