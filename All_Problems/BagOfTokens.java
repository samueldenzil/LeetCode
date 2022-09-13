// https://leetcode.com/problems/bag-of-tokens/
package All_Problems;

import java.util.Arrays;

public class BagOfTokens {

    public static void main(String[] args) {
        int[] tokens = {100, 200, 300, 400};
        int power = 200;
        System.out.println(bagOfTokensScore(tokens, power));
    }

    public static int bagOfTokensScore(int[] tokens, int power) {
        int score = 0;
        int maxScore = 0;

        // sort tokens in ascending order
        Arrays.sort(tokens);

        int i = 0;
        int j = tokens.length - 1;

        while (i <= j) {
            if (power >= tokens[i]) {
                power -= tokens[i];
                score++;
                maxScore = Math.max(maxScore, score);
                i++;
            } else if (i != j && score >= 1) {
                power += tokens[j];
                score--;
                j--;
            } else {
                break;
            }
        }

        return maxScore;
    }
}
