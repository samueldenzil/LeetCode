// https://leetcode.com/problems/find-players-with-zero-or-one-losses/
package Arrays;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;

public class FindPlayersWithZeroOrOneLosses {

    public static void main(String[] args) {
        int[][] matches = {
                {1, 3},
                {2, 3},
                {3, 6},
                {5, 6},
                {5, 7},
                {4, 5},
                {4, 8},
                {4, 9},
                {10, 4},
                {10, 9}
        };
        System.out.println(findWinners(matches));
    }

    public static List<List<Integer>> findWinners(int[][] matches) {
        Set<Integer> winners = new HashSet<>();
        Set<Integer> lossOnce = new HashSet<>();
        Set<Integer> lossMore = new HashSet<>();

        for (int[] match : matches) {
            int win = match[0];
            int loss = match[1];

            // handling winners condition
            if (!lossMore.contains(win) && !lossOnce.contains(win)) {   // first win
                winners.add(win);
            }

            // handling losers condition
            if (winners.contains(loss)) {    // the player lost this time
                winners.remove(loss);
                lossOnce.add(loss);
            } else if (!lossMore.contains(loss) && !lossOnce.contains(loss)) { // first loss
                lossOnce.add(loss);
            } else if (lossOnce.contains(loss)) {   // the player lost more than one time
                lossOnce.remove(loss);
                lossMore.add(loss);
            }
        }

        List<List<Integer>> ans = Arrays.asList(new ArrayList<>(), new ArrayList<>());
        ans.get(0).addAll(winners);
        ans.get(1).addAll(lossOnce);
        Collections.sort(ans.get(0));
        Collections.sort(ans.get(1));
        return ans;
    }
}
