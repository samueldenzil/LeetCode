// https://leetcode.com/problems/guess-number-higher-or-lower/

public class GuessNumberHigherOrLower {
    public static int guess(int num) {
        int pick = 6;
        if (pick == num) {
            return 0;
        } else if (pick > num) {
            return 1;
        } else {
            return -1;
        }
    }

    public static int guessNumber(int n) {
        int start = 1;
        int end = n;

        while (start <= end) {

            int mid = start + (end - start) / 2;
            int checkNum = guess(mid);

            if (checkNum == 0) {
                return mid;
            } else if (checkNum == 1) {
                start = mid + 1;
            } else if (checkNum == -1) {
                end = mid - 1;
            }
        }
        return start;
    }
}
